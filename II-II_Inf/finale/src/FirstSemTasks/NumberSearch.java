package FirstSemTasks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NumberSearch {
    public static void main(String[] args) {
        int[] array = new int[]{232,435,11,234, 11111, 222, 234213};
        List<Integer> newar = new ArrayList();
        for(int number : array) {
            if(getCountOfDigits(number) == 3 | getCountOfDigits(number) == 5){
                newar.add(number);
            }
        }
        Iterator<Integer> iterator = newar.iterator();
        while (iterator.hasNext()){

            Integer current_n = iterator.next();
            if(isFullyEven(current_n) | isFullyOdd(current_n)) {
                System.out.println(current_n);
            }
        }


    }

    private static int getCountOfDigits(Integer n) {
        int count = (n == 0) ? 1 : 0;
        while (n != 0) {
            count ++;
            n /= 10;
        }
        return count;
    }

    private static boolean isFullyEven(int n) {
        while (n != 0) {
            if((n%10)%2 != 0){
                return false;
            }
            n /= 10;

        }
        return true;
    }

    private static boolean isFullyOdd(int n) {
        while (n != 0) {
            if((n%10)%2 == 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
