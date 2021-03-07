import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Задание 10

public class Main {
    public static void main(String[] args) {
        List<Human> humanList = Arrays.asList(
                new Human(19, "Савин", "Константин", LocalDate.now(), 55),
                new Human(20, "Акимова", "Мария", LocalDate.now(), 56),
                new Human(21, "Ильин", "Тимур", LocalDate.now(), 75),
                new Human(22, "Харитонова", "Дарья", LocalDate.now(), 60),
                new Human(23, "Гончарова", "Виктория", LocalDate.now(), 65)
        );

        System.out.println("Список после сортировки по второй букве имени в обратном порядке");

        humanList = humanList.stream()
                .sorted((h1, h2) -> {
                    String name1 = h1.getFirstName();
                    String name2 = h2.getFirstName();
                    return Character.codePointAt(name2, 1) - Character.codePointAt(name1, 1);
                })
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("\nСписок после фильтрации по весу больше, чем 60");

        humanList = humanList.stream()
                .filter(human -> human.getWeight() > 60)
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("\nСписок после сортировки по возрасту");

        humanList = humanList.stream()
                .sorted(Comparator.comparingInt(Human::getAge))
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("\nСписок после произведения всех возрастов");

        Optional<Integer> multiplication = humanList.stream()
                .map(Human::getAge)
                .reduce((age1, age2) -> age1 * age2);

        humanList.forEach(System.out::println);

        System.out.println("Произведение: " + multiplication.get());
    }
}
