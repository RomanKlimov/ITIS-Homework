import java.util.Objects;
public class Queue implements Sequence {
    private static final int NMAX = 100;
    private Object[] data;
    private int i;

    public Queue(){
        data = new Object[NMAX];
        i = -1;
    }

    @Override
    public void add(Object obj){
        if (i < NMAX) {
            i++;
            data[i] = obj;
        }
    }

    @Override
    public Object pop() {
        Object obj = data[0];
        for (int i = 0; i < NMAX -1; i++) {
            data[i] = data[i + 1];
        }
        i--;
        return obj;
    }

    @Override

    public Object peak(){
        Object obj = data[0];
        return obj;
    }

    @Override
    public int size() {
        return i + 1;
    }
}
