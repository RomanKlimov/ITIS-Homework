import sun.swing.CachedPainter;

import javax.naming.SizeLimitExceededException;
import java.util.*;

public class Collection<T> extends AbstractCollection<T> {

    private static int MAXLENGTH = 10000;
    private Object[] array;
    private int size;
    private int index;

    public Collection(){
         this(10);
    }

    public Collection(int k){
        array = new Object[k];
        size = 0;
        index = -1;
    }

    public Collection(Collection<T> collection){
        this.array = collection.toArray();
        this.size = collection.size();
        this.index = this.size - 1;
        lengthOptimizer();
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements java.util.Iterator<T> {
       private int ind = -1;
       private int nOfElements = 0;

        @Override
        public boolean hasNext() {
            if (nOfElements < size) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            ind++;
            if(hasNext()) {
                while (array[ind] == null && ind < index) {
                    ind++;
                }
            } else {
                throw new NoSuchElementException();
            }
            nOfElements++;
            return (T) array[ind];
        }

        @Override
        public void remove(){
            array[ind] = null;
            size--;
            nOfElements--;
        }

    }

    @Override
    public boolean add(T element) {
        if(element != null) {
            if (index > array.length - 2 && array.length < MAXLENGTH * 3 / 2 + 1) {
                lengthOptimizer();
            }

            if (index < array.length && index < MAXLENGTH) {
                index++;
                array[index] = element;
                size++;
                return true;
            }
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean addAll(Collection<? extends T> collection){

        while(index + collection.size() > array.length - 2 && array.length < MAXLENGTH * 3 / 2) {
            lengthOptimizer();
        }

        if(index + collection.size() < array.length - 2) {
            Iterator<? extends T> iterator = collection.iterator();
            while (iterator.hasNext()) {
                add(iterator.next());
            }
            return true;
        }
        return false;

    }

    @Override
    public void clear(){
        array = new Object[10];
        size = 0;
        index = -1;
    }

    @Override
    public boolean contains(Object obj) {
        T t;
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            t = iterator.next();
            if (t.equals(obj)){
                return true;
            }
        }
        return false;
    }


    public boolean containsAll(Collection<?> collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            if(!contains(iterator.next())){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public boolean remove(Object obj){
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            if(obj.equals(iterator.next())){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean removeAll(Collection<?> collection){
        Iterator iterator = collection.iterator();
        boolean q = false;
        while (iterator.hasNext()){
            if(remove(iterator.next())){
                q = true;
            }
        }

        return q;

    }


    public boolean retainAll(Collection<?> collection){
        Iterator<T> iterator = iterator();
        boolean q = false;
        while (iterator.hasNext()){
            T t = iterator.next();
            if(!collection.contains(t)){
                iterator.remove();
                q = true;
            }
        }
        return q;

    }

    @Override
    public Object[] toArray(){
        Object[] newArray = new Object[size];
        int i = 0;
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()){
            newArray[i] = iterator.next();
            i++;
        }
        return newArray;
    }

    @Override
    public <E> E[] toArray(E[] a) {
        Object[] newArray = new Object[size];
        int i = 0;
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()){
            newArray[i] = iterator.next();
            i++;
        }
        return (E[]) newArray;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof Collection)) {
            return false;
        }
        if(Arrays.deepEquals(array, ((Collection) obj).array)){
            if(size == ((Collection) obj).size) {
                if(index == ((Collection) obj).index){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode(){
        int q = 0;
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()){
            T t = (T) iterator.next();
            q = t.hashCode();
        }
        return index * 17 + size * 23 + q;
    }

    private void lengthOptimizer() {
        Object[] nAr = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            nAr[i] = array[i];
        }
        array = new Object[array.length * 3 / 2 + 1];
        for (int i = 0; i < nAr.length; i++) {
            array[i] = nAr[i];
        }
    }

}
