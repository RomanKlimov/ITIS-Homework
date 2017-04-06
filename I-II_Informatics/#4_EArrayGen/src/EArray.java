import org.omg.CORBA.INTERNAL;

public class EArray<T> {
    private final int INITIAL_CAPACITY = 10;
    private int j;
    Object[] ar;

    EArray(){
        j = 0;
        ar = new Object[INITIAL_CAPACITY];
    }

    private void biggerSize(int l) {

        Object[] nAr = new Object[ar.length * 2 + 1];

        for (int i = 0; i < ar.length; i++) {
            nAr[i] = ar[i];
        }

        ar = nAr;

    }

    public void addElement(T p) {

        if (j >= ar.length - 1) {
            biggerSize(j);
        }

        ar[j] = p;
        j++;

    }

    public void removeT(int numb) {
        if(numb > -1 && numb < j) {
            ar[numb] = null;
        }
    }


    public T getElement(int numb) throws ArrayIndexOutOfBoundsException {
        if(numb < j || numb > -1) {
            return (T) ar[numb];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

}
