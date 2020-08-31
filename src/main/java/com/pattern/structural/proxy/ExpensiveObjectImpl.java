package com.pattern.structural.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExpensiveObjectImpl implements ExpensiveObject{

    public ExpensiveObjectImpl() {
        heavyInitialConfiguration();
    }

    private void heavyInitialConfiguration() {
        log.info("heavy initial configuration");
    }

    @Override
    public void process() {
        log.info("process");
    }
}
