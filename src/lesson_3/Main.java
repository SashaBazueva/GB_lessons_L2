package lesson_3;

import java.util.Arrays;
import java.util.HashSet;

/*
        1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        Посчитать сколько раз встречается каждое слово.

        2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
         В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать
         номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
         (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
 */

public class Main {
    public static void main(String[] args) {
        String[] strings = {"magic", "alphabet", "pen", "umbrella", "pen", "cookie", "snack", "pen", "magic", "bet"};
        HashSet<String> collectionSet = new HashSet<>();

        collectionSet.addAll(Arrays.asList(strings));
        System.out.println(collectionSet.toString());


        for (int i = 0; i < strings.length; i++) {
            byte count = 0;
            String word = strings[i];
            for (int j = 0; j < strings.length; j++) {
                if (word.equals(strings[j])) {
                    count++;
                }

            }
        }
    }
}
