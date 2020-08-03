package com.util.annotation.rangesrouce;

import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ArgumentsSource(RangeArgumentsProvider.class)
public @interface RangeSource {
    int min() default 1;

    int max() default 100;

    int step() default 1;
}
