package com.pattern.behavioral.mediator;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Fan {
    private Mediator mediator;
    private boolean on = false;

    Fan(Mediator mediator){
        this.mediator = mediator;
    }

    public void turnOn() {
        mediator.start();
        on = true;
    }

    public void turnOff() {
        on = false;
        mediator.stop();
    }
}
