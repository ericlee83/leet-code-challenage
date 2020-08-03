package com.util.annotation.rangesrouce;

import com.util.annotation.rangesrouce.RangeSource;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RangeArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<RangeSource> {

    private int start;
    private int stop;
    private int step;

    public RangeArgumentsProvider() {
    }

    public void accept(RangeSource source) {
        start = source.min();
        stop = source.max();
        step = source.step();
    }

    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return IntStream.range(start, stop)
                .filter(i -> (i - start) % step == 0)
                .mapToObj(i -> Arguments.of(i));
    }
}
