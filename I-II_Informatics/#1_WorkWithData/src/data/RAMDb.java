package data;

import java.util.Arrays;



public class RAMDb implements Db {
    private final int MAX_NUMBER_OF_STRINGS = 1000;
    private String[] memArray;
    private static int i = 0;

    public RAMDb(){
        memArray = new String[MAX_NUMBER_OF_STRINGS];
    }

    @Override
    public void save(Object obj) throws DbException {
        try {
            if(obj instanceof String) {
                memArray[i] = (String)obj;
                i++;
            } else throw new DbException();
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new DbException("Превышено допустимое кол-во строк");
        } catch (DbException ex) {
            throw new DbException("Не строка");
        };

    }

    @Override
    public Object[] findAll() throws DbException {
        try {
            if (i < 1) {
                return new String[0];
            }
            String[] str = new String[i];
            str = Arrays.copyOf(memArray, i);
            return str;
        } catch (Exception ex) {
            throw new DbException("Something wrong");
        }
    }


}
