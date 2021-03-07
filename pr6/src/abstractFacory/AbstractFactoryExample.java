package abstractFacory;

public class AbstractFactoryExample {

    public static void main(String[] args) {
        AbstractFactory factory1 = new ConcreteFactory1();
        Client client1 = new Client(factory1);
        client1.execute();

        AbstractFactory factory2 = new ConcreteFactory2();
        Client client2 = new Client(factory2);
        client2.execute();
    }
}

class Client {
    private AbstractAmericano americano;
    private AbstractCappuccino cappuccino;

    Client(AbstractFactory factory) {
        americano = factory.createAmericano();
        cappuccino = factory.createCappuccino();
    }

    void execute() {
        americano.make();
        cappuccino.drink();
    }
}

interface AbstractFactory {
    AbstractAmericano createAmericano();
    AbstractCappuccino createCappuccino();
}

interface AbstractAmericano {
    void make();
}

interface AbstractCappuccino {
    void drink();
}

class ConcreteFactory1 implements AbstractFactory {

    @Override
    public AbstractAmericano createAmericano() {
        return new Americano1();
    }

    @Override
    public AbstractCappuccino createCappuccino() {
        return new Cappuccino1();
    }
}

class ConcreteFactory2 implements AbstractFactory {
    @Override
    public AbstractAmericano createAmericano() {
        return new Americano2();
    }

    @Override
    public AbstractCappuccino createCappuccino() {
        return new Cappuccino2();
    }
}

class Americano1 implements AbstractAmericano {
    @Override
    public void make() {
        System.out.println("make " + this.getClass().getName());
    }
}

class Cappuccino1 implements AbstractCappuccino {

    @Override
    public void drink() {
        System.out.println("drink " + this.getClass().getName());
    }
}

class Americano2 implements AbstractAmericano {
    @Override
    public void make() {
        System.out.println("make " + this.getClass().getName());
    }
}

class Cappuccino2 implements AbstractCappuccino {

    @Override
    public void drink() {
        System.out.println("drink " + this.getClass().getName());
    }
}