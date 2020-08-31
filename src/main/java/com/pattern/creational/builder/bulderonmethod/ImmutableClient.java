package com.pattern.creational.builder.bulderonmethod;

import lombok.Builder;
import lombok.Value;

@Value
public final class ImmutableClient {
    private int id;
    private String name;

    @Builder(builderMethodName = "builder")
    public ImmutableClient(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
