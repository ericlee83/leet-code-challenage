package com.challenage.junit.source;

import java.util.stream.Stream;

public class StringParams {
    static Stream<String> blankStrings() {
        return Stream.of(null, "", "  ");
    }
}
