package scb;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Function;

public interface IIndicator {
    void addListener(Function<BigDecimal,BigDecimal> indicatorListener);

    // CHANGE TO BD
    void indicatorUpdated(BigDecimal value);
}
