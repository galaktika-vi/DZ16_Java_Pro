import java.util.*;
import java.util.function.*;

public class Main {

    public static int method1(Function<Integer, Integer> function, Integer value) {
        return Optional.ofNullable(value)
                .map(function)
                .orElse(0);
    }

    public static int method2(Function<Integer, Integer> function, Integer value) {
        return Optional.ofNullable(value)
                .filter(v -> v > 4)
                .map(function)
                .orElse(0);
    }

    public static int method3(Function<Integer, Integer> function, Integer value) {
        return Optional.ofNullable(value)
                .map(v -> v > 6 ? function.apply(v - 6) : v * v)
                .orElse(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<Integer, Integer> formula = x -> x * 2 + 1;

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Применить формулу (если null, то 0)");
            System.out.println("2. Применить формулу, если число > 4 (иначе 0)");
            System.out.println("3. Применить формулу, если число > 6 (иначе квадрат числа)");
            System.out.println("4. Выход из программы");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Введите число (или введите 'null' без кавычек для null):");
                    String input1 = scanner.next();
                    Integer value1 = input1.equals("null") ? null : Integer.parseInt(input1);
                    System.out.println("Результат: " + method1(formula, value1));
                    break;

                case 2:
                    System.out.println("Введите число:");
                    Integer value2 = scanner.nextInt();
                    System.out.println("Результат: " + method2(formula, value2));
                    break;

                case 3:
                    System.out.println("Введите число:");
                    Integer value3 = scanner.nextInt();
                    System.out.println("Результат: " + method3(formula, value3));
                    break;

                case 4:
                    System.out.println("Выход из программы.");
                    return;

                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }
}
