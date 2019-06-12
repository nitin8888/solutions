package scb;


// Immutable
// Avoid public access
// Remove setter
// Actual values as arguments
// Change to BigDecimal (Check with BigDecimal immutable)

import java.math.BigDecimal;

public class MarketTick {

    private final BigDecimal bid;
    private final BigDecimal ask;
    private final BigDecimal last;

    public MarketTick(BigDecimal bid, BigDecimal ask, BigDecimal last){
        this.bid = bid;
        this.ask = ask;
        this.last = last;
    }

    BigDecimal getBid() {
        return bid;
    }

    BigDecimal getAsk() {
        return ask;
    }

    /*
    public void setBid(double bid){
        this.bid = bid;
    }
    public void setAsk(double ask){
        this.ask = ask;
    }
    public void setLast(double last){
        this.last = last;
    }
    public double getBid() {
        return bid;
    }
    public double getAsk() {
        return ask;
    }
    public double getLast() {
        return last;
    }
    public double getMid() {
        return (bid + ask) / 2;
    }
        */

}
