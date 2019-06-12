package scb;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Function;


//This class should receive ticks from IMarketDataFeed
//• This class should notify any listeners when it has performed its calculation
//• The calculation should be optimal in speed

// There are no unit tests

// Thread safety
// LOGGING
// Any reference, make it immutable
// Check atomacity


public class AverageHalfSpreadIndicator implements IIndicator{

    private IMarketDataFeed marketDataFeed;

    private List<Function<BigDecimal, BigDecimal>> listeners;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    private final BigDecimal FIFTY = new BigDecimal("50");

    private final Queue<MarketTick> lastTicks;
    public AverageHalfSpreadIndicator(IMarketDataFeed marketDataFeed) {
        // Register to Imarket DataFeed
        registerToIMarketDataFeed();

        // lastTicks CopyOnWriteArrayList
        lastTicks = new LinkedBlockingQueue<>(1000);
        listeners = new CopyOnWriteArrayList<>();
    }

    private void registerToIMarketDataFeed() {
        marketDataFeed.addListener(this::onTick);
    }

    private double onTick(MarketTick tick)  {

        synchronized (lastTicks) {
            lastTicks.offer(tick);
            if (lastTicks.size() == 1000) {
                lastTicks.poll();
            }
        }
        long start = System.currentTimeMillis();

        // Do you think it is worth switching to BigDecimal for calculation
        // Explicitly
        BigDecimal calc = lastTicks.stream().parallel()
                .map((x) -> x.getAsk().subtract(x.getBid().multiply(FIFTY)))
                .reduce(BigDecimal::add)
                .map(x -> x.divide(BigDecimal.valueOf(lastTicks.size()), RoundingMode.HALF_UP))
                .orElse(BigDecimal.ZERO);

        // NOT AN ERROR
        System.err.println("Time (computing spreads): " + String.valueOf(System.currentTimeMillis() - start) + " ms");

        indicatorUpdated(calc);
        return calc.doubleValue();
    }

    /*
    private double onTick(MarketTick tick)  {
        lastTicks.add(tick);
        if (lastTicks.size() == 1000) {
            lastTicks.remove(0);
        }
        long start = System.currentTimeMillis();
        List<Double> spreads = lastTicks.stream().map((x) -> 100 * (x.getMid() - x.getBid()) / x.getBid())
                .collect(Collectors.toList());
        System.err.println("Time (computing spreads): " + String.valueOf(System.currentTimeMillis() - start) + " ms");
        double averageHalfSpread = spreads.stream().mapToDouble((x) -> x).average().getAsDouble();

        indicatorUpdated(averageHalfSpread);
        return averageHalfSpread;
    }
*/

    // changed
    public void addListener(Function<BigDecimal, BigDecimal> indicatorListener) {
        listeners.add(indicatorListener);
    }
/*
    public void indicatorUpdated(double calcValue){
//    public void indicatorUpdated(int calcValue){
        listeners.forEach(x -> executorService.execute());
    }
    */
    public void indicatorUpdated(BigDecimal calcValue){
        executorService.execute(() -> listeners.forEach(x -> x.apply(calcValue)));
//        listeners.forEach(x -> x.apply(calcValue));
    }

}
