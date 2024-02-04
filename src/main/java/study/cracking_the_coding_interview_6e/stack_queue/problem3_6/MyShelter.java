package study.cracking_the_coding_interview_6e.stack_queue.problem3_6;

import java.util.LinkedList;
import java.util.Queue;

abstract class Animal {
    protected final String name;
    private int order = -1;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isOlderThat(Animal other) {
        return this.order < other.order;
    }
}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("Cat(%s)", this.name);
    }
}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("Dog(%s)", this.name);
    }
}

public class MyShelter {

    private final Queue<Animal> cats = new LinkedList<>(), dogs = new LinkedList<>();
    private int order = 0;

    public void enqueue(Animal animal) {
        animal.setOrder(order++);
        if (animal instanceof Cat) cats.add(animal);
        else dogs.add(animal);
    }

    public Animal dequeueAny() {
        if (!cats.isEmpty() && !dogs.isEmpty()) {
            Animal cat = cats.peek();
            Animal dog = dogs.peek();
            return cat.isOlderThat(dog) ? dequeueCat() : dequeueDog();
        }
        return cats.isEmpty() ? dequeueDog() : dequeueCat();
    }

    public Animal dequeueCat() {
        return cats.poll();
    }

    public Animal dequeueDog() {
        return dogs.poll();
    }
}
