package lesson_4;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        doTask1();
        doTask2();
        doTask3();
        doTask4();
        //ChatWindow chat = new ChatWindow();
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
        System.out.println(findAllChars("elephant", 'e'));
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

    public static String findAllChars(String target, char toFind) {
        char[] ch = target.toCharArray();
        List<Character> chars = new ArrayList<>();
        String result ="";
        for (int i = 0; i < ch.length; i++) {
            chars.add(ch[i]);
        }
        Iterator<Character> iterator = chars.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == toFind) {
                result += toFind;
            }
        }
        return result;
    }
}
