package FirstSemTasks;

import java.util.Arrays;
import java.util.Scanner;

public class StringSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] strings = new String[]{"hell","hello", "he", "hello"};

        for(int j = 0; j < strings.length; j++) {

            for (int i = 0; i < strings.length; i++) {
                if (strings.length > i + 1) {
                    if (compare(strings[i], strings[i + 1]) == 1) {
                        String temp = strings[i + 1];
                        strings[i + 1] = strings[i];
                        strings[i] = temp;
                    }

                }
            }
        }
        System.out.println(Arrays.asList(strings).toString());
    }

    private static int i = 0;
    private static int compare(String s1, String s2) {
        for(int i = 0; i < s1.length() && i < s2.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {

                return s1.charAt(i) < s2.length() ? -1 : 1;
            }
        }

        return s1.length() < s2.length() ? -1 : s1.length() == s2.length() ? 0 : 1;
    }

}
