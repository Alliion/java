package factory.method;

public class FactoryMethodExample {
    public static void main(String[] args) {
        CoffeeCreator[] coffeeCreators = {
                new AmericanoCreator()
        };

        for(CoffeeCreator coffeeCreator: coffeeCreators) {
            Coffee coffee = coffeeCreator.factoryMethod();
            coffee.makeCoffee();
        }
    }
}
