package Patterns;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

//позволяет сгруппировать множество объектов в древовидную структуру, а потом работать с ней так, как будто это
//единичный объект
public class CompositeLesson {
    public static void main(String[] args) {

    }
}

class File {
    String fileName;
}

class Folder {
    String name;
    Data creationDate;
    List<Folder> folders = new ArrayList<>();
    List<File> files = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    void addFolder(Folder folder) {
        folders.add(folder);
    }

    void removeFolder(Folder folder) {
        folders.remove(folder);
    }

    void addFile(File file) {
        files.add(file);
    }

}

