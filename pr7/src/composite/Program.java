package composite;

import java.util.ArrayList;
import java.util.List;

/** "Component" */
interface Animal {
    public void say();
}

/** "Composite" */
class CompositeAnimal implements Animal {
    private List<Animal> animals = new ArrayList<>();

    public void add(Animal animal) {
        animals.add(animal);
    }

    public void remove(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public void say() {
        for (Animal animal: animals) {
            animal.say();
        }
    }
}


class Dog implements Animal {
    @Override
    public void say() {
        System.out.println("гав");
    }
}


/** Client */
public class Program {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();

        CompositeAnimal compositeAnimal = new CompositeAnimal();

        compositeAnimal.add(dog1);
        compositeAnimal.add(dog2);

        compositeAnimal.say();
    }
}
