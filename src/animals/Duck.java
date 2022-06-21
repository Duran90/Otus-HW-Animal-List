package animals;

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
