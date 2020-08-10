package lesson6;

import java.util.Arrays;

public class MyClass {

    public static void main(String[] args) {

//        System.out.println(Arrays.toString(arrayAfter4(new int[]{1, 3, 4, 5, 6, 8})));
//        System.out.println(Arrays.toString(arrayAfter4(new int[]{1, 3, 4, 5, 6, 8, 4})));
//        System.out.println(Arrays.toString(arrayAfter4(new int[]{1, 3, 5, 6, 8})));

        System.out.println(arrayContainsOnly1and4(new int[]{1, 3, 4, 5}));
        System.out.println(arrayContainsOnly1and4(new int[]{1, 4, 4, 4}));
        System.out.println(arrayContainsOnly1and4(new int[]{1, 1}));
        System.out.println(arrayContainsOnly1and4(new int[]{4, 4}));

    }

    public static int[] arrayAfter4(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                return Arrays.copyOfRange(arr, i + 1, arr.length);
            }
        }
        throw new RuntimeException("Массив без 4");
    }

    public static boolean arrayContainsOnly1and4(int[] arr) {
        boolean h1 = false;
        boolean h4 = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1 && arr[i] != 4) {
                return false;
            }
            if (arr[i] == 1) {
                h1 = true;
            }
            if (arr[i] == 4) {
                h4 = true;
            }
        }
        return h1 && h4;
    }
}
