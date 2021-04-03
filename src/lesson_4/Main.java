package lesson_4;

import lesson_4.chat.ChatWindow;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
//        doTask1();
//        doTask2();
//        doTask3();
//        doTask4();
        new ChatWindow();
    }

    public static void doTask1() {
        List<Integer> list = (List.of(1, 2, 3, 4, 5));
        list.forEach(integer -> System.out.print(integer + " | "));
        System.out.println();
    }

    public static void doTask2() {
        Set<String> setForTask2 = Set.of("one", "tree", "cat", "mushroom");
        forItem(setForTask2, s -> System.out.println(s));
    }

    public static void doTask3() {
        int number = 10;
        System.out.printf("doubling %d = %d%n", number, doubleUp(number, () -> 2));
    }

    public static void doTask4() {
        System.out.println(findAllChars("elephant", 'e').get());
    }

    public static int doubleUp(int integer, Supplier<Integer> supplier) {
        return integer * supplier.get();
    }

    public static void forItem(Set<String> set, Consumer<String> consumer) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    public static Optional<String> findAllChars(String target, char toFind) {
        char[] ch = target.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (toFind == ch[i]) {
                sb.append(ch[i]);
            }
        }
        if (sb.length() != 0) {
            return Optional.of(sb.toString());
        } else {
            return Optional.empty();
        }
    }
}
