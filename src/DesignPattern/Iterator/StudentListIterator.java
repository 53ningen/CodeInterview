package DesignPattern.Iterator;

public class StudentListIterator implements Iterator {
    private StudentList studentList;
    private int index;

    public StudentListIterator(StudentList studentList) {
        this.studentList = studentList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if(index < studentList.getNumberOfStudents())
            return true;
        else
            return false;
    }

    @Override
    public Object next() {
        Student student = studentList.getStudent(index);
        index++;
        return student;
    }
}
