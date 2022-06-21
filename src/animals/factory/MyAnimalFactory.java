package animals.factory;

import animals.Animal;
import animals.data.AnimalType;
import animals.Cat;
import animals.Dog;
import animals.Duck;

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
