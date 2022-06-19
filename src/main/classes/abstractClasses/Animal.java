package main.classes.abstractClasses;

public abstract class Animal {
       String name;
       int age;
       float weight;
       private final String color;

    //Конструктор
    public Animal(String name, int age, float weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    //Сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }



    // Методы
    public void say(){
        System.out.println("Я говорю");
    }
    public void go(){
        System.out.println("Я иду");
    }
    public void drink(){
        System.out.println("Я пью");
    }
    public void eat(){System.out.println("Я ем");}

    @Override
    public String toString() {
        String[] year = {"год", "года", "лет"};
        String hello;

        if (age == 1 ) {
            hello = ("Привет! меня зовут " + name + ", мне " + age + " " + year[0] + ", я вешу - " + weight + " кг, мой цвет - " + color);
        } else if (age > 1 & age < 5) {
            hello = ("Привет! меня зовут " + name + ", мне " + age + " " + year[1] + ", я вешу - " + weight + " кг, мой цвет - " + color);
        } else {
            hello = ("Привет! меня зовут " + name + ", мне " + age + " " + year[2] + ", я вешу - " + weight + " кг, мой цвет - " + color);
        }
        return hello;
    }

}
