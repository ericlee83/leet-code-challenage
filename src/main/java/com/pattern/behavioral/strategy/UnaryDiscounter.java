package com.pattern.behavioral.strategy;

import java.math.BigDecimal;
import java.util.function.UnaryOperator;

public interface UnaryDiscounter extends UnaryOperator<BigDecimal> {
    default UnaryDiscounter combine(UnaryDiscounter discounter){
        return value -> discounter.apply(this.apply(value));
    }
     static UnaryDiscounter christmas(){
        return amount -> amount.multiply(BigDecimal.valueOf(0.5));
     }

     static UnaryDiscounter nationalDay(){
         return amount -> amount.multiply(BigDecimal.valueOf(0.9));
     }

    static UnaryDiscounter birthDay(){
        return amount -> amount.multiply(BigDecimal.valueOf(0.7));
    }
}
