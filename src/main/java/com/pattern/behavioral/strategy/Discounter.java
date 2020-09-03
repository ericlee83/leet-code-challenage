package com.pattern.behavioral.strategy;

import java.math.BigDecimal;

public interface Discounter {
    BigDecimal applyDiscount(BigDecimal amount);
}
