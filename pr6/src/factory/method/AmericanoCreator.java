package factory.method;

public class AmericanoCreator extends CoffeeCreator {
    @Override
    public Coffee factoryMethod() {
        return new Americano();
    }
}
