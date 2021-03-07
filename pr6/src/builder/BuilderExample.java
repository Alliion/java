package builder;

class Coffee {
    private String roasting = "";

    public void setRoasting(String roasting) {
        this.roasting = roasting;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "roasting='" + roasting + '\'' +
                '}';
    }
}


/** "Abstract Builder" */
abstract class CoffeeBuilder {
    protected Coffee coffee;

    public Coffee getCoffee() { return coffee; }
    public void createNewCoffeeProduct() { coffee = new Coffee(); }

    public abstract void buildRoasting();
}

/** "ConcreteBuilder" */
class ConcreteCoffeeBuilder1 extends CoffeeBuilder {
    public void buildRoasting()   { coffee.setRoasting("скандинавская"); }
}

/** "ConcreteBuilder" */
class ConcreteCoffeeBuilder2 extends CoffeeBuilder {
    public void buildRoasting()   { coffee.setRoasting("венская"); }
}


class Waiter {
    private CoffeeBuilder coffeeBuilder;

    public Coffee getCoffee() {
        return coffeeBuilder.coffee;
    }

    public void setCoffeeBuilder(CoffeeBuilder coffeeBuilder) {
        this.coffeeBuilder = coffeeBuilder;
    }

    public void constructCoffee() {
        coffeeBuilder.createNewCoffeeProduct();
        coffeeBuilder.buildRoasting();
    }
}


public class BuilderExample {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        CoffeeBuilder hawaiianPizzaBuilder = new ConcreteCoffeeBuilder1();
        waiter.setCoffeeBuilder(hawaiianPizzaBuilder);
        waiter.constructCoffee();

        System.out.println(waiter.getCoffee());
    }
}

