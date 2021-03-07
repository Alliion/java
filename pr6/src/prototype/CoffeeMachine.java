package prototype;

class Coffee implements Cloneable {

    private int temperature;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public Coffee clone() throws CloneNotSupportedException {
        return (Coffee) super.clone();
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "temperature='" + temperature + '\'' +
                '}';
    }
}

/**
 * Concrete Prototypes to clone
 */
class AmericanoCoffee extends Coffee {
    private String name = "Американо";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AmericanoCookie{" +
                "temperature='" + super.getTemperature() + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
/**
 * Client Class
 */
public class CoffeeMachine {

    private Coffee coffee;

    public CoffeeMachine(Coffee coffee) {
        this.coffee = coffee;
    }

    public Coffee makeCoffee() throws CloneNotSupportedException {
        return (Coffee) this.coffee.clone();
    }

    public static void main(String args[]) throws CloneNotSupportedException {
        Coffee tempCoffee = null;
        Coffee prot = new AmericanoCoffee();
        CoffeeMachine cm = new CoffeeMachine(prot);
        for (int i = 0; i < 5; i++) {
            tempCoffee = cm.makeCoffee();
            System.out.println(tempCoffee);
        }
    }
}
