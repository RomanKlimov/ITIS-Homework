package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Executable;
import java.util.Scanner;
import java.util.Arrays;



public class InternalDataStorage implements DataStorage {
    private final int MAX_NUMBER_OF_FILES = 1000;
    private File storage;
    private Object[] fileArray;
    private static int i = -1;

    public InternalDataStorage(){
        storage = new File("D://code//ITIS-Homework//I-II_Informatics//#2-3_MusicPlayer//src//data.txt");
        fileArray = new Object[MAX_NUMBER_OF_FILES];
    }


    @Override
    public Object[] getFiles() throws DbException {
        try {
            if (i != -1) {
                Object[] copy = Arrays.copyOf(fileArray, i + 1);
                return copy;
            } else throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new DbException("Нет ни одного файла");
        }
    }

    @Override
    public void deleteFile(int index) throws DbException {
        try {
            if(index <= i ) {
                for(int j = index; j < i; j++) {
                    fileArray[j] = fileArray[j+1];
                }
                i--;
            } else throw new ArrayIndexOutOfBoundsException();

        } catch (Exception ex) {
            throw new DbException("Ошибка при удалении файла, проверьте данные!");
        }
    }

    @Override
    public void setPath(String path) throws DbException {
        storage = new File(path);
    }

    @Override
    public void scanFiles() throws DbException {
        i = 0;
        try {
            String file;
            Scanner sc = new Scanner(storage);
            while (! (file = sc.nextLine()).equals("0")) {
                i++;
                fileArray[i] = file;
            }
        } catch (FileNotFoundException ex) {
            throw new DbException("Ошибка пути к файлам");
        } catch (Exception ex) {
            throw new DbException("Ошибка в структуре файлов");
        }
    }

}
