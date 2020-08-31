package com.pattern.creational.singleton;

/*
 * For resources that are expensive to create (like database connection objects)
 * It's good practice to keep all loggers as Singletons which increases performance
 * Classes which provide access to configuration settings for the application
 * Classes that contain resources that are accessed in shared mode
 */
public class Singleton {
    private Singleton() {
    }

    private static class SingletonHolder {
        public static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
