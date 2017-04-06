package Structures;

public class Queue<T> implements Sequence<T> {
    private static final int NMAX = 100;
    private Object[] data;
    private int i;

    public Queue(){
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
        T obj = (T) data[0];
        for (int i = 0; i < NMAX -1; i++) {
            data[i] = data[i + 1];
        }
        i--;
        return (T) obj;
    }

    @Override

    public T peak(){
        if(i > -1) {
            return (T) data[0];
        } else throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public int size() {
        return i + 1;
    }
}
