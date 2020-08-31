package com.pattern.creational.abstractfactory;

/*
 *The client is independent of how we create and compose the objects in the system
 *The system consists of multiple families of objects, and these families are designed to be used together
 *We need a run-time value to construct a particular dependency
 */
public class FactoryProvider {
    public static AbstractFactory getFactory(String choice){

        if("Animal".equalsIgnoreCase(choice)){
            return new AnimalFactory();
        }
        else if("Color".equalsIgnoreCase(choice)){
            return new ColorFactory();
        }

        return null;
    }
}
