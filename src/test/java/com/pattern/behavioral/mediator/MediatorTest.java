package com.pattern.behavioral.mediator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediatorTest {

    private Button button;
    private Fan fan;
    private Mediator mediator;
    private PowerSupplier powerSupplier;

    @BeforeEach
    void setUp() {
        mediator = new Mediator();
        button = new Button(mediator);
        fan = new Fan(mediator);
        powerSupplier = new PowerSupplier();
        mediator.setButton(button);
        mediator.setFan(fan);
        mediator.setPowerSupplier(powerSupplier);
    }

    @Test
    public void givenTurnedOffFan_whenPressingButtonTwice_fanShouldTurnOnAndOff() {
        assertFalse(fan.isOn());

        button.press();
        assertTrue(fan.isOn());

        button.press();
        assertFalse(fan.isOn());
    }
}