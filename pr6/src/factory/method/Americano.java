package factory.method;

public class Americano implements Coffee {
    @Override
    public void makeCoffee() {
        System.out.println("Делаем кофе");
    }
}
