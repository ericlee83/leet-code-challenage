package com.pattern.behavioral.observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsChannelTest {

    @Test
    void Test(){
        NewsChannel observer = new NewsChannel();
        NewsAgency observable = new NewsAgency();
        observable.addObserver(observer);
        observable.setNews("news");
        assertEquals("news",observer.getNews());
    }

    @Test
    void ObserverTest(){
        ONewsAgency observable = new ONewsAgency();
        ONewsChannel observer = new ONewsChannel();
        observable.addObserver(observer);
        observable.setNews("news");
        assertEquals("news",observer.getNews());
    }

    @Test
    void PCLTest(){
        PCLNewAgency observable = new PCLNewAgency();
        PCLNewsChannel observer = new PCLNewsChannel();

        observable.addPropertyChangeListener(observer);
        observable.setNews("news");

        assertEquals("news",observer.getNews());
    }

}