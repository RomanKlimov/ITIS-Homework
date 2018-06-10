package FirstSemTasks;

import java.util.Arrays;

public class ArrayFlip {
    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5};
        for(int i = 0; i < array.length/2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        System.out.println(Arrays.asList(array).toString());
    }
}
