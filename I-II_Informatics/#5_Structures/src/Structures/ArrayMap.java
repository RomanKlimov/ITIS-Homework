package Structures;

import java.util.NoSuchElementException;
public class ArrayMap<T> implements Map<T>{
    private static final int N = 10;


    private String[] keyArray;
    private Object[] ObjectArray;

    public ArrayMap() {

        keyArray = new String[N];
        ObjectArray = new Object[N];

    }

    public void add(String key, T value) {

        if (value == null) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < keyArray.length; i++) {
            if(keyArray[i].equals(key)) {
                throw new IllegalArgumentException();
            }
        }

        for (int i = 0; i < keyArray.length; i++) {
            if(keyArray.length  - i < 5) {
                String[] keys = new String[keyArray.length * 2];
                Object[] Objects = new Object[ObjectArray.length * 2];
                for (int j = 0; j < keyArray.length; j++) {
                    keys[i] = keyArray[i];
                    Objects[i] = ObjectArray[i];
                }
                keyArray = keys;
                ObjectArray = Objects;
            }


            if (keyArray[i] == null) {
                keyArray[i] = key;
                ObjectArray[i] = value;
            }

        }

    }


    public T remove(String key){

        int q = -1;
        for(int i = 0; i < keyArray.length; i++){
            if (keyArray[i].equals(key)) {
                keyArray[i] = null;
                q = i;
            }
        }
        if(q != -1) {
            return (T)ObjectArray[q];
        } else {
            throw new NoSuchElementException();
        }

    }

    public T get(String key){

        for(int i = 0; i < keyArray.length; i++){
            if (keyArray[i].equals(key)) {
                return (T) ObjectArray[i];
            }
        }
        throw new NoSuchElementException();

    }

    public void set(String key, T object){

        boolean q = false;
        for(int i = 0; i < keyArray.length; i++){
            if (keyArray[i].equals(key)) {
                ObjectArray[i] = object;
                q = true;
                break;
            }
        }
        if (!q) throw new NoSuchElementException();
    }

}