package Structures;
public class Stack<T> implements Sequence<T> {
    private static final int NMAX = 100;
    private Object[] data;
    private int i;

    public Stack(){
        data = new Object[NMAX];
        i = -1;
    }

    @Override
    public void add(T obj){
        if (i < NMAX) {
            i++;
            data[i] = obj;
        }
    }

    @Override
    public T pop() {
        T obj = (T)data[i];
        i--;
        return obj;
    }

    @Override
    public T peak(){
        T obj = (T)data[i];
        return obj;
    }

    @Override
    public int size() {
        return i + 1;
    }
}
