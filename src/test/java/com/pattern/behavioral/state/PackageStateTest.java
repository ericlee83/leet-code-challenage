package com.pattern.behavioral.state;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PackageStateTest {

    @Test
    public void givenNewPackage_whenPackageReceived_thenStateReceived() {
        Package pkg = new Package();

        assertThat(pkg.getState(), instanceOf(OrderedState.class));
        pkg.nextState();

        assertThat(pkg.getState(), instanceOf(DeliveredState.class));
        pkg.nextState();

        assertThat(pkg.getState(), instanceOf(ReceivedState.class));
    }

    @Test
    public void givenDeliveredPackage_whenPrevState_thenStateOrdered() {
        Package pkg = new Package();
        pkg.setState(new DeliveredState());
        pkg.previousState();

        assertThat(pkg.getState(), instanceOf(OrderedState.class));
    }

}