class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }
    void makeSound() {
        System.out.println(name + " (Dog): Woof! Woof!");
    }
}

class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }
    void makeSound() {
        System.out.println(name + " (Cat): Meow~");
    }
}

class Bird extends Animal {
    Bird(String name, int age) {
        super(name, age);
    }
    void makeSound() {
        System.out.println(name + " (Bird): Tweet tweet!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
            new Dog("Buddy", 3),
            new Cat("Whiskers", 2),
            new Bird("Chirpy", 1)
        };
        for (Animal a : animals) {
            a.makeSound();
        }
    }
}
