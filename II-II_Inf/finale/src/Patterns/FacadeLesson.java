package Patterns;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//фасад - предоставляет простой интерфейс к сложной системе классов.(пример выноса чтения из файла в метод)
public class FacadeLesson {
    public static void main(String[] args) throws IOException {
        FileReaderFacade fileReaderFacade = new FileReaderFacade();
        System.out.println(fileReaderFacade.readFile("text.txt"));
    }

}

class FileReaderFacade {
    String readFile(String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        StringBuilder stringBuilder = new StringBuilder();
        int j = 0;
        while ((j = bufferedReader.read()) != -1) {
            stringBuilder.append((char)j);

        }
        return stringBuilder.toString();
    }
}
