package scb;

import java.util.function.Function;

// Do not implement
public interface IMarketDataFeed {
    String getStock();
    void tick(double tick);
    void addListener(Function<MarketTick,Double> tick);
}
