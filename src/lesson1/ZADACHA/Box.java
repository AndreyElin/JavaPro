package lesson1.ZADACHA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {

    private List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public Box(T... fruits) {
        this.list = new ArrayList(Arrays.asList(fruits));
    }


    public boolean compare(Box<?> another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.0001;
    }

    public void addFruit(T fruit) {
        list.add(fruit);
    }

    public float getWeight() {
        float a = 0.0f;
        for (T fruit : list) {
            a += fruit.getWeight();
        }
        return a;
    }

    public void transfer(Box<? super T> another) {
        if (another == this) {
            return;
        }
        another.list.addAll(this.list);
        this.list.clear();
    }
}
