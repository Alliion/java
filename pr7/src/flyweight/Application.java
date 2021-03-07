package flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract class Animal {
    public abstract void say();
}

class Dog extends Animal {
    @Override
    public void say() {
        System.out.println("гав");
    }
}


enum TYPE_ANIMAL {
    DOG
}

class FlyweightFactory {
    private Map<TYPE_ANIMAL, Animal> animalMap = new HashMap();

    public Animal getAnimal(TYPE_ANIMAL typeAnimal){
        Animal animal = animalMap.get(typeAnimal);
        if (animal == null){
            switch (typeAnimal){
                case DOG: {
                    animal = new Dog();
                    break;
                }
            }
            animalMap.put(typeAnimal, animal);
        }
        return animal;
    }

}

/*
 * Класс, показывающий работу шаблона проектирования "Приспособленец".
 * */

public class Application {

    public static void main (String [] args){
        FlyweightFactory factory = new FlyweightFactory();

        TYPE_ANIMAL [] typeAnimals = {TYPE_ANIMAL.DOG};
        for (TYPE_ANIMAL typeAnimal : typeAnimals){
            Animal animal = factory.getAnimal(typeAnimal);
            animal.say();
        }
    }

}