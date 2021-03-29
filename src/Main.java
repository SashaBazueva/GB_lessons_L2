import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        oneThread();
        twoThread();
    }

    public static void oneThread() {
        float[] array = new float[10000000];
        Arrays.fill(array, 1);
        long time = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        time = System.currentTimeMillis() - time;
        System.out.printf("1 поток -  %s сек%n", (double) time / 1000);
    }

    public static void twoThread() {
        float[] array = new float[10000000];
        int h = array.length/2;
        Arrays.fill(array, 1);
        long time = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(array, 0, a1, 0, h);
        System.arraycopy(array, h, a2, 0, h );
        new Thread(() -> {
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        new Thread(() -> {
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        System.arraycopy(a1, 0, array, 0, h);
        System.arraycopy(a2, 0, array, h , h );

        time = System.currentTimeMillis() - time;
        System.out.printf("2 потокa -  %s сек%n", (double) time / 1000);
    }
}
