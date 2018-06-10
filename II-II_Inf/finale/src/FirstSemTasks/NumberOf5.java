package FirstSemTasks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class NumberOf5 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("resources/in.txt"));
        List<Integer> ints = new ArrayList<>();
        while (in.hasNext()) {
            ints.add(in.nextInt());
        }

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int count1 = 0;
                int count2 = 0;

                while (o1 > 0) {
                    if(o1 % 10 == 5) {
                        count1 ++;
                    }
                    o1 /= 10;
                }

                while (o2 > 2) {
                    if(o2 % 10 == 5) {
                        count2 ++;
                    }
                    o2 /= 10;
                }

                return (count1 > count2) ? 1 : -1;
            }
        };

        Collections.sort(ints, comparator);
        FileWriter fileWriter = new FileWriter(new File("resources/out.txt"));
        for(Integer i : ints){
            fileWriter.write(i + " ");
        }
        fileWriter.flush();
    }
}
