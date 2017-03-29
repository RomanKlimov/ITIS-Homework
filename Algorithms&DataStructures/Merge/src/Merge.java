import java.util.Arrays;
import java.util.Scanner;

public class Merge {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }

        mergeSort(array);

        for (int i = 0; i < n; i++){
            System.out.print(array[i] + " ");
        }

    }


    public static int[] mergeSort(int[] ar){

        if(ar.length == 1) {
            return ar;
        }

        int[] ar1 = mergeSort(Arrays.copyOf(ar, ar.length / 2));
        int[] ar2 = mergeSort(Arrays.copyOfRange(ar, ar.length / 2, ar.length));

        int i = 0, j = 0, i1 = 0;
        while(i < ar1.length || j < ar2.length){
            while (i < ar1.length && j < ar2.length){
                if( ar1[i] <= ar2[j]){
                    ar[i1] = ar1[i];
                    i++;
                    i1++;
                }
                else {
                    ar[i1] = ar2[j];
                    j++;
                    i1++;
                }
            }
            if(i == ar1.length){
                ar[i1] = ar2[j];
                j++;
                i1++;
            }
            else {
                ar[i1] = ar1[i];
                i++;
                i1++;
            }
        }
        return ar;
    }

}
