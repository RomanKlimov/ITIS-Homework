package Structures;
public class FillArray <T> {

    public  FillArray(){

    }

    public void fill(T[] arr, T obj){
        for(int i = 0; i < arr.length; i++) {
            arr[i] = obj;
        }
    }

    public void fillByNull(T[] arr){
        for(int i = 0; i < arr.length; i++) {
            arr[i] = null;
        }
    }

    public void fillFromTo(T[] arr, T obj, int startI, int endI){
        if(endI - startI > 0 && endI < arr.length && startI > -1) {
            for (int i = startI; i < endI; i++) {
                arr[i] = obj;
          }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

}
