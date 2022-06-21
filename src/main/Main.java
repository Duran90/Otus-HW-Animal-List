package main;

import main.classes.abstractClasses.MyAnimalFactory;
import main.classes.abstractClasses.Animal;
import main.classes.enumClasses.AnimalType;
import main.classes.enumClasses.Commands;

import java.util.*;

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
        String input = scanString().trim();
        switch (mapToCommands(input)){
            case ADD:
                AnimalType animal = scanAnimalType();
                addAnimalToList(animal);
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

    /**
     * Exceptions
     */
    private static Commands mapToCommands(String cmd) {
        try {
            return Commands.valueOf(cmd.toUpperCase());
        } catch (IllegalArgumentException ex) {
            return Commands.WRONG;
        }
    }

    private static AnimalType mapToAnimals (String type){
        try {
            return AnimalType.valueOf(type.toUpperCase());
        }catch (IllegalArgumentException ex){
            return null;
        }
    }

    /**
     *  Scan methods
     */
    public static String scanString(){
           return sc.next();
    }
    public static int scanInt(){

        while (true) {
            if(sc.hasNextInt()){
                return sc.nextInt();
            }else {
                System.out.println("Введите число!!!");
                sc.next();

            }
        }
    }


    public static AnimalType scanAnimalType(){
        System.out.println("Какой тип животного вы хотите добавить?\n(Cat,Dog,Duck)");
        String animalType = scanString().trim();
        AnimalType type = mapToAnimals(animalType);
        while (true){
            if(type != null){
                return type;
            }else {
                System.out.println("Введите еще раз");
                type = mapToAnimals(sc.next());

            }
        }
    }

    public static void addAnimalToList(AnimalType animalType){
               System.out.println("Введите кличку.");
               String name = scanString();
               System.out.println("Введите возраст.");
               int year = scanInt();
               System.out.println("Введите вес.");
               int weight = scanInt();
               System.out.println("Введите цвет.");
               String color = scanString();
               Animal animal = MyAnimalFactory.createAnimal(animalType,name,year,weight,color);
               animalsList.add(animal);
               animal.say();
           }




//        switch (animalType) {
//            case CAT -> {
//                System.out.println("Введите кличку кота.");
//                String name = scanString();
//                System.out.println("Введите возраст.");
//                int year = scanInt();
//                System.out.println("Введите вес.");
//                int weight = scanInt();
//                System.out.println("Введите цвет.");
//                String color = scanString();
//                Cat cat = new Cat(name, year, weight, color);
//                animalsList.add(cat);
//            }
//            case DOG -> {
//                System.out.println("Введите кличку собаки.");
//                String name = sc.next();
//                System.out.println("Введите возраст.");
//                int year = sc.nextInt();
//                System.out.println("Введите вес.");
//                int weight = sc.nextInt();
//                System.out.println("Введите цвет.");
//                String color = sc.next();
//                Dog dog = new Dog(name, year, weight, color);
//                animalsList.add(dog);
//            }
//            case DUCK -> {
//                System.out.println("Введите кличку кота.");
//                String name = sc.next();
//                System.out.println("Введите возраст.");
//                int year = sc.nextInt();
//                System.out.println("Введите вес.");
//                int weight = sc.nextInt();
//                System.out.println("Введите цвет.");
//                String color = sc.next();
//                Duck duck = new Duck(name, year, weight, color);
//                animalsList.add(duck);
//            }
//            default -> System.out.println("Введен не корректный тип животного");
//        }
    }

