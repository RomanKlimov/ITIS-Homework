import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by klimo on 29.03.2017.
 */

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++){
            array[i] = r.nextInt(100);
        }

        selectionSort(array);

        for (int i = 0; i < n; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++){
            array[i] = r.nextInt(100);
        }

        insertionSort(array);
        for (int i = 0; i < n; i++){
            System.out.print(array[i] + " ");
        }




    }

    public static void selectionSort(int[] arr) {
        int min = arr[0];
        int q = 0;
        int nElem;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    q = j;
                }
            }
            nElem = arr[i];
            arr[i] = arr[q];
            arr[q] = nElem;
        }
    }

    public static void insertionSort(int[] arr){
        int j;
        int arI;
        for(int i = 1; i < arr.length; i++) {
            j = Arrays.binarySearch(arr, 0, i, arr[i]);
            if(j < 0) {
                j = (j + 1) * -1;
            }
            arI = arr[i];
            for(int i1 = i; i1 > j; i1--) {
                arr[i1] = arr[i1 - 1];
            }
            arr[j] = arI;
        }
    }

}
