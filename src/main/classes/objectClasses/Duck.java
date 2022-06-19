package main.classes.objectClasses;

import main.classes.abstractClasses.Animal;
import main.interfaces.Flying;

public class Duck extends Animal implements Flying {
    public Duck(String name, int age, float weight, String color) {
        super(name, age, weight, color);
    }

    @Override
    public void fly() {
        System.out.println("Я лечу");
    }
    @Override
    public void say() {
        System.out.println("Кря");
    }
}
