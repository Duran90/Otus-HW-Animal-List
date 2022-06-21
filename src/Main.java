import animals.factory.MyAnimalFactory;
import animals.Animal;
import animals.data.AnimalType;
import data.Commands;

import java.util.*;

public class Main {
    private static final ArrayList<Animal> animalsList = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        while (true) {
            processCommand();
        }
    }


    public static void processCommand() {
        System.out.println("Введите комманду из списска:\nADD - добавить животное.\nLIST - получить список животных.\nEXIT - выйти из программы");
        String input = scanString().trim();
        switch (mapToCommands(input)) {
            case ADD:
                AnimalType animal = scanAnimalType();
                addAnimalToList(animal);
                break;
            case LIST:

                for (Animal a : animalsList) {
                    System.out.println(a);
                }

                break;
            case EXIT:
                System.out.println("Досвидания!");
                System.exit(0);
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

    private static AnimalType mapToAnimals(String type) {
        try {
            return AnimalType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }


    public static String scanString() {
        return sc.next();
    }

    public static int scanInt() {

        while (true) {
            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                System.out.println("Введите число!!!");
                sc.next();

            }
        }
    }


    public static AnimalType scanAnimalType() {
        System.out.println("Какой тип животного вы хотите добавить?\n(Cat,Dog,Duck)");
        String animalType = scanString().trim();
        AnimalType type = mapToAnimals(animalType);
        while (true) {
            if (type != null) {
                return type;
            } else {
                System.out.println("Введите еще раз");
                type = mapToAnimals(sc.next());

            }
        }
    }

    public static void addAnimalToList(AnimalType animalType) {
        System.out.println("Введите кличку.");
        String name = scanString();
        System.out.println("Введите возраст.");
        int year = scanInt();
        System.out.println("Введите вес.");
        int weight = scanInt();
        System.out.println("Введите цвет.");
        String color = scanString();
        Animal animal = MyAnimalFactory.createAnimal(animalType, name, year, weight, color);
        animalsList.add(animal);
        animal.say();
    }

}

