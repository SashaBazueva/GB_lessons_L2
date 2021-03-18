package lesson_2;

import lesson_2.exception.MyArrayDataException;
import lesson_2.exception.MyArraySizeException;


/**
 * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
 * при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * <p>
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
 * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
 * должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
 * <p>
 * 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException
 * и MyArrayDataException, и вывести результат расчета.
 */

public class Main {
    public static void main(String[] args) {
        String[][] strings = {
                {"1", "2", "3", "4"},
                {"2", "4", "6", "8"},
                {"3", "6", "9", "12"},
                {"4", "8", "12", "16"},

        };

        System.out.println(checkArrayAndSumResult(strings));
    }

    public static int checkArrayAndSumResult(String[][] arrays) {
        try {
            if (arrays.length > 4)
                throw new MyArraySizeException("Неправильный размер массива: размер массива больше 4");

            for (int i = 0; i < 4; i++) {
                if (arrays[i].length < 4)
                    throw new MyArraySizeException("Неправильный размер массива: размер внутреннего массива меньше 4");
                if (arrays[i].length > 4)
                    throw new MyArraySizeException("Неправильный размер массива: размер внутреннего массива больше 4");
            }
        } catch (IndexOutOfBoundsException exception) {
            throw new MyArraySizeException("Неправильный размер массива: размер массива меньше 4", exception);
        }
        int sum = toInt(arrays);
        return sum;
    }

    public static int toInt(String[][] arrays) {
        try{
            int sum = 0;
            for (int i = 0; i < arrays.length; i++) {
                for (int j = 0; j < arrays[i].length; j++) {
                    sum += Integer.parseInt(arrays[i][j]);
                }
            }
            return sum;
        }catch(NumberFormatException exception){
            throw new MyArrayDataException("Проверьте заполнение массива: в массиве встретился набор букв", exception);
        }
    }
}

