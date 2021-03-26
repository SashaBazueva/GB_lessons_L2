package lesson_4;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Set<String> setForTask2 = Set.of("one", "tree", "cat", "mushroom");

        doTask1();
        doTask2(setForTask2, s -> System.out.println(s));
    }

    public static void doTask1() {
        List<Integer> list = (List.of(1, 2, 3, 4, 5));
        list.forEach(integer -> System.out.print(integer + " | "));
        System.out.println();
    }

    public static void doTask2(Set<String> set, Consumer<String> consumer) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }
    
}
