package lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(convertArrayToArrayList(5, 6, 8, 9));
        System.out.println(convertArrayToArrayList("ddd", "yy", "rrr"));

//        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        String[] array = {"aaa", "bbb", "ccc", "ddd", "eee"};

        swapTwoElement(1, 2, array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    public static <T> T[] swapTwoElement(int i, int j, T[] arr) {
        try {
            if (i != j) {
                T a = arr[i];
                arr[i] = arr[j];
                arr[j] = a;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        return arr;
    }

    public static <T> List<T> convertArrayToArrayList(T... arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

}
