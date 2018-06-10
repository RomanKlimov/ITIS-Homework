package FirstSemTasks;

import java.util.*;

public class UporPoUnic {
    public static void main(String[] args) {
        Integer[] arr = {222, 13, 644, 12345, 1, 11111};

        List<Integer> list = Arrays.asList(arr);

        Map<Character, Integer> hashMap = new HashMap<>();
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int count1 = 0;
                int count2 = 0;
                for(Character ch : o1.toString().toCharArray()) {
                    hashMap.put(ch, 0);
                }
                count1 = hashMap.size();

                hashMap.clear();

                for(Character ch : o2.toString().toCharArray()) {
                    hashMap.put(ch, 0);
                }

                count2 = hashMap.size();
                hashMap.clear();

                return (count1>count2) ? 1 : -1;

            }
        };

        Collections.sort(list, comparator);
        System.out.println(list.toString());
    }
}
