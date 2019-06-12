package scb;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;
import java.util.stream.Collectors;


//This class should receive ticks from IMarketDataFeed
//• This class should notify any listeners when it has performed its calculation
//• The calculation should be optimal in speed

// There are no unit tests

// Thread safety
// LOGGING
// Any reference, make it immutable
// Check atomacity


public class AverageHalfSpreadIndicator2 {
//implements IIndicator
    // Should be interface
    private ArrayList<MarketTick> lastTicks;
    // MAY BE BETTER TO USE QUEUE, IMPLEMENTATION TYPE LinkedBlockingQueue with 1000

    // ADD NEW LIST FOR LISTENERS, WHICH IS COPYONWRITEARRAYLIST
    // FUNCTION BD
    // CREATE EXECUTOR SERVICE FOR EXECUTING ASYNCHRONOUSLY

    public AverageHalfSpreadIndicator2(IMarketDataFeed marketDataFeed) {
    }

    // ADD TO LISTERNER ON INSTANTIATION
    private double onTick(MarketTick tick)  {

        // SHOULD BE ATOMIC
        // IN SYNCHRONIZED BLOCK WITH LOCK ON lastTicks
        // USE OFFER TO ADD & POLL TO REMOVE
        lastTicks.add(tick);
        if (lastTicks.size() == 1000) {
            lastTicks.remove(0);
        }
        long start = System.currentTimeMillis();
        // CALCULATION SHOULD BE BD
        // SPREAD CALC SEEMS IN CORRECT
        /*
        List<Double> spreads = lastTicks.stream().map((x) -> 100 * (x.getMid() - x.getBid()) / x.getBid())
                .collect(Collectors.toList());
        */
        // PROPER LOGGING INSTEAD OF ERR
        // SEEMS ABOVE FINAL CALC
        System.err.println("Time (computing spreads): " + String.valueOf(System.currentTimeMillis() - start) + " ms");

        // IT CAN BE MOVED ABOVE
//        double averageHalfSpread = spreads.stream().mapToDouble((x) -> x).average().getAsDouble();
        double averageHalfSpread = 02;

//        indicatorUpdated(averageHalfSpread);
        return averageHalfSpread;
    }

    // ADD FUNCTION AS PARAMENTERS
    public void addListener(){
        // CREATE INSTANCE VARIABLE OF LISTENER
//        listeners.add();
    }

    // PARAMETER SHOULD BE BIGDECIMAL
    public void indicatorUpdated(int calcValue){
//        listeners.forEach(x -> x.apply(calcValue));
    }
}
