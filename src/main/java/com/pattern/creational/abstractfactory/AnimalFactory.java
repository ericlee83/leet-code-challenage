package com.pattern.creational.abstractfactory;

import com.pattern.creational.abstractfactory.animals.Cat;
import com.pattern.creational.abstractfactory.animals.Dog;

public class AnimalFactory implements AbstractFactory<Animal>{
    @Override
    public Animal create(String choice) {
        if("Dog".equalsIgnoreCase(choice)){
            return new Dog();
        }else if("Cat".equalsIgnoreCase(choice)){
            return new Cat();
        }
        return null;
    }
}
