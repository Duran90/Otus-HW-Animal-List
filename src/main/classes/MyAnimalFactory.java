package main.classes;

import main.classes.abstractClasses.Animal;
import main.classes.enumClasses.AnimalType;
import main.classes.objectClasses.Cat;
import main.classes.objectClasses.Dog;
import main.classes.objectClasses.Duck;

public class MyAnimalFactory {

    public static Animal createAnimal(AnimalType type, String name, int year, int weight, String color) {
        Animal animal = null;
        switch (type) {
            case CAT -> animal = new Cat(name, year, weight, color);
            case DOG -> animal = new Dog(name, year, weight, color);
            case DUCK -> animal = new Duck(name, year, weight, color);
        }

        return animal;
    }
}
