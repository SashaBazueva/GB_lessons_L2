package lesson_3;

import java.util.Arrays;
import java.util.HashSet;

public class Task1 {
    public static void main(String[] args) {

        String[] strings = {"magic", "alphabet", "pen", "umbrella", "pen", "cookie", "snack", "pen", "magic", "bet", "pen", "alphabet", "pen", "alphabet", "sun"};

        outputUniqueAndSameWords(strings);

    }

    public static void outputUniqueAndSameWords(String[] arrayOfStrings) {
        byte count;

        String[] uniqueStrings = createUniqueStringsArray(arrayOfStrings);

        System.out.print("[");

        for (int i = 0; i < uniqueStrings.length; i++) {
            count = 0;
            for (int j = 0; j < arrayOfStrings.length; j++) {
                if (uniqueStrings[i].equals(arrayOfStrings[j])) {
                    count++;
                }
            }

            if (i == uniqueStrings.length - 1) {
                if (count > 1) System.out.printf("%s(%d)", uniqueStrings[i], count);
                else System.out.printf("%s", uniqueStrings[i]);
            }else{
                if (count > 1) System.out.printf("%s(%d), ", uniqueStrings[i], count);
                else System.out.printf("%s, ", uniqueStrings[i]);
            }
        }
        System.out.print("]");
    }

    public static String[] createUniqueStringsArray(String[] arrayOfStrings) {
        HashSet<String> collectionSet = new HashSet<>();

        collectionSet.addAll(Arrays.asList(arrayOfStrings));

        String[] uniqueStrings = collectionSet.toArray(new String[0]);
        return uniqueStrings;
    }
}
