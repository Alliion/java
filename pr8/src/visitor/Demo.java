package visitor;

public class Demo {
    public static void main ( String [] args ) {
        Animal animal = new Dog();
        Visitor visitor = new Client1();
        animal.accept( visitor );
    }
}

interface Visitor {
    void visit ( Dog a );
    void visit ( Cat a );
}

abstract class Animal {
    public abstract void accept ( Visitor v );
    abstract void say();
}

class Dog extends Animal {

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    void say() {
        System.out.println("гав");
    }
}

class Cat extends Animal {

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    void say() {
        System.out.println("мяу");
    }
}

class Client1 implements Visitor {

    @Override
    public void visit(Dog a) {
        a.say();
    }

    @Override
    public void visit(Cat a) {
        a.say();
    }
}