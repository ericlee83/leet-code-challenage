package com.pattern.behavioral.strategy;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static com.pattern.behavioral.strategy.UnaryDiscounter.*;
import static org.junit.jupiter.api.Assertions.*;

class StrategyTest {

    @Test
    void applyDiscount() {
        Discounter christmasDiscount = new ChristmasDiscounter();
        BigDecimal discountValue = christmasDiscount.applyDiscount(BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(50).stripTrailingZeros(),discountValue.stripTrailingZeros());
    }

    @Test
    void applyDiscountLambda() {
        Discounter birthDayDiscounter = amount -> amount.multiply(BigDecimal.valueOf(0.7));
        BigDecimal discountValue = birthDayDiscounter.applyDiscount(BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(70).stripTrailingZeros(),discountValue.stripTrailingZeros());
    }

    @Test
    void applyAllDiscounts() {
        List<UnaryDiscounter> discounters = Arrays.asList(christmas(),birthDay());
        BigDecimal amount = BigDecimal.valueOf(100);
        final UnaryDiscounter combinedDiscounter = discounters
                .stream()
                .reduce(v-> v,UnaryDiscounter::combine);
        BigDecimal value = combinedDiscounter.apply(amount);

        //chain
        final Function<BigDecimal,BigDecimal> comDiscounters = UnaryDiscounter.christmas().andThen(birthDay());
        BigDecimal value2 = comDiscounters.apply(amount);

        assertEquals(BigDecimal.valueOf(35).stripTrailingZeros(),value.stripTrailingZeros());
        assertEquals(BigDecimal.valueOf(35).stripTrailingZeros(),value2.stripTrailingZeros());
    }
}