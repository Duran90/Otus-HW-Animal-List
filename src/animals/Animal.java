package animals;

public abstract class Animal {
       private final String name;
       private final int age;
       private final float weight;
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
        String path1 = "Привет! меня зовут " + name + ", мне " + age + " ";
        String path2 = ", я вешу - " + weight + " кг, мой цвет - " + color;
        if (age % 10 == 1 && age != 11) {
            hello = (path1 + year[0] + path2);
        } else if (age > 1 & age < 5) {
            hello = (path1 + year[1] + path2);
        } else {
            hello = (path1 + year[2] + path2);
        }
        return hello;
    }

}
