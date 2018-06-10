package Patterns;

//порождающий паттерн, позволяет копировать объекты не вдаваясьв  подробности их реализации.

public class PrototypeLesson {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student();
        CopyPastMachine cpm = new CopyPastMachine(student);
        Student twin = cpm.copyPaste();

    }
}

class Student implements Cloneable {
    public Student clone() throws CloneNotSupportedException {
        return (Student)super.clone();
    }

}

class CopyPastMachine {
    private Student student;
    public CopyPastMachine(Student student) {
        this.student = student;
    }

    public Student copyPaste() throws CloneNotSupportedException {
        return this.student.clone();
    }

}