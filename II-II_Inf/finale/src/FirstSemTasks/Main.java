package FirstSemTasks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the array length: ");
        int length = scanner.nextInt();
        System.out.println("Fill the array: ");
        String[] array = new String[length];
        Character[] letters = new Character[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};
        List<Character> listOfLetters = Arrays.asList(letters);
        System.out.println(listOfLetters.toString());
        boolean flag2 = false;
        for (int i = 0; i < length; i++) {
            array[i] = scanner.next();
            int n = 0;

            for (int j = 0; j < array[i].length(); j++) {

                if(n==0 && listOfLetters.contains(array[i].charAt(j))) {
                    n = (int) array[i].charAt(j);
                } else if (listOfLetters.contains(array[i].charAt(j)) && (int) array[i].charAt(j) < n) {
                    flag2 = true;
                    break;
                } else if(listOfLetters.contains(array[i].charAt(j))) {
                    n = (int) array[i].charAt(j);
                }

            }
            if (flag2) {
                break;
            }

        }
        if (flag2) {
            System.out.println("Exist");
        }
        else System.out.println("Not Exist");
    }
}
//        System.out.println(Arrays.asList(array).toString());



