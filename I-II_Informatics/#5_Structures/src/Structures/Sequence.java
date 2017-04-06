package Structures;
public interface Sequence<T> {
    void add(T obj);
    T pop();
    T peak();
    int size();
}
