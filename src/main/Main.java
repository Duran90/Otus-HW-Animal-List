package main;

import main.classes.abstractClasses.Animal;
import main.classes.enumClasses.Animals;
import main.classes.enumClasses.Commands;
import main.classes.objectClasses.Cat;
import main.classes.objectClasses.Dog;
import main.classes.objectClasses.Duck;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Animal> animalsList = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);
    private static boolean exit = false;


    public static void main(String[] args) {
        while (!exit){
            processCommand();
        }
    }


    public static void processCommand() {
        System.out.println("Введите комманду из списска:\nADD - добавить животное.\nLIST - получить список животных.\nEXIT - выйти из программы");
        String input = sc.next().trim();
        switch (mapToCommands(input)){
            case ADD:
                System.out.println("Какой тип животного вы хотите добавить?\n(Cat,Dog,Duck)");
                String animalType = sc.next().trim();
                addAnimalToList(animalType.toUpperCase());
                break;
            case LIST:

                for (Animal a: animalsList) {
                    System.out.println(a);
                }

                break;
            case EXIT:
                exit = false;
                System.out.println("Досвидания!");
                break;
            default:
                System.out.println("Введена не верная комманда");
                break;
        }
    }
    
    private static Commands mapToCommands(String cmd) {
        try {
            return Commands.valueOf(cmd.toUpperCase());
        } catch (IllegalArgumentException ex) {
            return Commands.WRONG;
        }
    }

    public static void addAnimalToList(String animalType){
        switch (Animals.valueOf(animalType)) {
            case CAT -> {
                // TODO: 17.06.2022 переделать строки SC в методы 
                System.out.println("Введите кличку кота.");
                String name = sc.next();
                System.out.println("Введите возраст.");
                int year = sc.nextInt();
                System.out.println("Введите вес.");
                int weight = sc.nextInt();
                System.out.println("Введите цвет.");
                String color = sc.next();
                Cat cat = new Cat(name, year, weight, color);
                animalsList.add(cat);
            }
            case DOG -> {
                System.out.println("Введите кличку собаки.");
                String name = sc.next();
                System.out.println("Введите возраст.");
                int year = sc.nextInt();
                System.out.println("Введите вес.");
                int weight = sc.nextInt();
                System.out.println("Введите цвет.");
                String color = sc.next();
                Dog dog = new Dog(name, year, weight, color);
                animalsList.add(dog);
            }
            case DUCK -> {
                System.out.println("Введите кличку кота.");
                String name = sc.next();
                System.out.println("Введите возраст.");
                int year = sc.nextInt();
                System.out.println("Введите вес.");
                int weight = sc.nextInt();
                System.out.println("Введите цвет.");
                String color = sc.next();
                Duck duck = new Duck(name, year, weight, color);
                animalsList.add(duck);
            }
            default -> System.out.println("Введен не корректный тип животного");
        }
    }

    public static void getAnimalFromList(){

    }
}