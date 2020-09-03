package com.pattern.behavioral.observer;

import lombok.Data;

import java.util.Observable;
import java.util.Observer;

@Data
public class ONewsChannel implements Observer {
    private String news;
    @Override
    public void update(Observable o, Object arg) {
        this.setNews((String) arg);
    }
}
