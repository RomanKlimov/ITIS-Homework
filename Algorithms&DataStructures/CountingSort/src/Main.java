import java.util.Arrays;


/**
 * Created by klimo on 19.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        int length = (int) (Math.random() * 10 + 1);
        int unsortedArray[] = new int[length];
        int max = 0;

        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = (int) (Math.random() * 20);

            if (unsortedArray[i] > max) {
                max = unsortedArray[i];
            }
        }

        int[] amountOfEntries = new int[max + 1];
        int value;

        for (int i = 0; i < unsortedArray.length; i++) {
            value = unsortedArray[i];

            if (amountOfEntries[value] != 0) {
                amountOfEntries[value] += 1;
            }
            else {
                amountOfEntries[value] = 1;
            }
        }

        int[] sortedArray = new int[unsortedArray.length];
        int counter = 0;

        for (int i = 0; i < amountOfEntries.length; i++) {
            value = amountOfEntries[i];

            for (int j = 0; j < value; j++) {
                sortedArray[counter] = i;
                counter++;
            }
        }

        System.out.println(Arrays.toString(unsortedArray));
        System.out.println(Arrays.toString(sortedArray));
    }
}
