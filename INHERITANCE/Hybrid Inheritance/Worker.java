
interface Worker {
    void performDuties();
}

class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

class Chef extends Person implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is preparing dishes specializing in " + specialty);
    }
}

class Waiter extends Person implements Worker {
    String section;

    Waiter(String name, int id, String section) {
        super(name, id);
        this.section = section;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is serving customers in section " + section);
    }
}

public class Main {
    public static void main(String[] args) {
        Worker w1 = new Chef("Alice", 101, "Italian Cuisine");
        Worker w2 = new Waiter("Bob", 102, "A1");

        ((Person) w1).displayInfo();
        w1.performDuties();
        System.out.println();
        ((Person) w2).displayInfo();
        w2.performDuties();
    }
}
```
