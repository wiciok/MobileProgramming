package example.apackage.student.lab01.Model;

public class Student{
    public String name;
    public String surname;

    public Student(String name, String surname) {
        this.name=name;
        this.surname=surname;
    }

    @Override
    public String toString(){
        return name + " " + surname;
    };

}