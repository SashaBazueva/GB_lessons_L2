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

        calculateValues(array);

        time = System.currentTimeMillis() - time;
        System.out.printf("1 поток -  %s сек%n", (double) time / 1000);
    }

    public static void twoThread() {
        float[] array = new float[10000000];
        int h = array.length / 2;
        Arrays.fill(array, 1);
        long time = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(array, 0, a1, 0, h);
        System.arraycopy(array, h, a2, 0, h);

        Thread t1 = new Thread(() -> {
            calculateValues(a1);
            System.arraycopy(a1, 0, array, 0, h);
        });
        Thread t2 = new Thread(() -> {
            calculateValues(a2);
            System.arraycopy(a2, 0, array, h, h);
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        time = System.currentTimeMillis() - time;
        System.out.printf("2 потокa -  %s сек%n", (double) time / 1000);
    }

    public static void calculateValues(float[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
