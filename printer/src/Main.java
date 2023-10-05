import java.util.*;
import java.util.function.*;

public class Main {

    public static void printer(Object obj) {
        System.out.println(obj);
    }

    public static <T> void deferredSort(List<T> list, Comparator<? super T> comparator) {
        Collections.sort(list, comparator);
    }

    public static String manipulateString(String input) {
        Function<String, String> function = s -> "Test" + s;
        function = function.andThen(s -> s.substring(0, 3));
        function = function.andThen(s -> s + ".");
        return function.apply(input);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> someList = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9));

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Вывод в консоль");
            System.out.println("2. Отложенная сортировка");
            System.out.println("3. Манипуляция со строкой");
            System.out.println("4. Получение случайного значения");
            System.out.println("5. Выход из программы");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    printer("Привет");
                    printer(42);
                    printer(3.14);
                    break;
                case 2:
                    System.out.println("До сортировки: " + someList);
                    deferredSort(someList, Integer::compareTo);
                    System.out.println("После сортировки: " + someList);
                    break;
                case 3:
                    System.out.println(manipulateString("ПримерСтроки"));
                    break;
                case 4:
                    BooleanSupplier booleanSupplier = () -> new Random().nextBoolean();
                    System.out.println(booleanSupplier.getAsBoolean());
                    break;
                case 5:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }
}
