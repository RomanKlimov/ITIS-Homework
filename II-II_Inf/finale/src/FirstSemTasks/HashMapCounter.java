package FirstSemTasks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class HashMapCounter {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("resources/in.txt"));
        String str = "";
        while(sc.hasNextLine()) {
            str += sc.nextLine();
        }
        String[] arr = str.split(",");
        List<String> list = Arrays.asList(arr);
        Stream<String> stream = list.stream();
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        int frequency = 0;
        for(String s : arr) {
            hashMap.put(s, frequency);
        }
        for(String s : arr) {
            if(hashMap.containsKey(s)){

                Integer val = hashMap.get(s);
                val++;
                hashMap.put(s, val);
            }
        }
        System.out.println(hashMap.toString());
        FileWriter fileWriter = new FileWriter(new File("resources/out.txt"));
//        Set<String> keySet = hashMap.keySet();
//        Iterator<String> iterator = keySet.iterator();
//        List<St>
//        while(iterator.hasNext()){
//
//        }

        for (Map.Entry<String, Integer> map: hashMap.entrySet()){
            String key = map.getKey();
            Integer value = map.getValue();

            fileWriter.write(key + " : " + value + "\n");
        }
        fileWriter.flush();
        fileWriter.close();




    }
}
