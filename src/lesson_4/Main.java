package lesson_4;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        doTask1();
        doTask2();
        doTask3();
    }

    public static void doTask1() {
        List<Integer> list = (List.of(1, 2, 3, 4, 5));
        list.forEach(integer -> System.out.print(integer + " | "));
        System.out.println();
    }

    public static void doTask2(){
        Set<String> setForTask2 = Set.of("one", "tree", "cat", "mushroom");
        forItem(setForTask2, s -> System.out.println(s));
    }

    public static void doTask3(){
        int number = 10;
        System.out.printf("doubling %d = %d", number, doubleUp(number, () -> 2));
    }

    public static int doubleUp(int integer, Supplier<Integer> supplier){
        return integer* supplier.get();
    }

    public static void forItem(Set<String> set, Consumer<String> consumer) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    public static void findAllChars(String target, char toFind){
        char[] ch = target.toCharArray();
        ArrayList<Character> arrayList = new ArrayList<Character>(Arrays.asList());

    }
}
