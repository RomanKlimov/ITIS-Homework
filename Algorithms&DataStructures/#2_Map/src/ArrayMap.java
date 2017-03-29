import sun.security.util.Length;

import java.util.Arrays;
import java.util.NoSuchElementException;
public class ArrayMap implements Map{
    private static final int N = 10;


    String[] keyArray;
    Object[] ObjectArray;

    ArrayMap() {
        keyArray = new String[N];
        ObjectArray = new Object[N];
    }

    @Override
    public void add(String key, Object value) {

        for (int i = 0; i < keyArray.length; i++) {
            if(keyArray[i].equals(key)) {
                throw new IllegalArgumentException();
            }
        }

        for (int i = 0; i < keyArray.length; i++) {
            if(keyArray.length  - i < 5) {
                String[] keys = new String[keyArray.length];
                Object[] Objects = new Object[ObjectArray.length];
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

    @Override
    public Object remove(String key){
        int q = -1;
        for(int i = 0; i < keyArray.length; i++){
            if (keyArray[i].equals(key)) {
                keyArray[i] = null;
                q = i;
            }
        }
        if(q != -1) {
            return ObjectArray[q];
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Object get(String key){
        for(int i = 0; i < keyArray.length; i++){
            if (keyArray[i].equals(key)) {
                return ObjectArray[i];
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public void set(String key, Object object){
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

    @Override
    public void removeAll(){
        for(int i = 0; i < keyArray.length; i++){
            keyArray[i] = null;
        }
    }


    @Override
    public String[] getKeys() {
        String[] newKeyArray = new String[keyArray.length];
        newKeyArray = Arrays.copyOf(keyArray, keyArray.length);
        return  newKeyArray;
    }

    @Override
    public Object[] getValues() {
        Object[] newValueArray = new Object[keyArray.length];
        newValueArray = Arrays.copyOf(ObjectArray, keyArray.length);
        return  newValueArray;
    }

    public int size(){
        int k = 0;
        for(int i = 0; i < keyArray.length; i++ ){
            if (keyArray[i] != null) {
                k++;
            }
        }
        return k;
    }
}











