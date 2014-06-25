package DesignPattern.Iterator;

public class StudentList implements Aggregate {
    private Student[] students;
    private int last = 0;
    public StudentList(int numOfStudents) {
        this.students = new Student[numOfStudents];
    }
    public Student getStudent(int number) {
        return students[number];
    }
    public void addStudent(Student student) {
        this.students[last] = student;
        last++;
    }
    public int getNumberOfStudents() {
        return this.last;
    }
    @Override
    public Iterator iterator() {
        return new StudentListIterator(this);
    }
}
