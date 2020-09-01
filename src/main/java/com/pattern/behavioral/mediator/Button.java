package com.pattern.behavioral.mediator;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Button {
    private Mediator mediator;
    public void press() {
        mediator.press();
    }
}
