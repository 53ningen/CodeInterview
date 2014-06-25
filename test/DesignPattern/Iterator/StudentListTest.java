package DesignPattern.Iterator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StudentListTest {
    @Test
    public void イテレータテスト() {
        StudentList studentList = new StudentList(3);

        Student taro = new Student("taro");
        Student jiro = new Student("jiro");
        Student saburo = new Student("saburo");

        studentList.addStudent(taro);
        studentList.addStudent(jiro);
        studentList.addStudent(saburo);

        Iterator iterator = studentList.iterator();
        assertThat((Student) iterator.next(), is(taro));
        assertThat((Student) iterator.next(), is(jiro));
        assertThat((Student) iterator.next(), is(saburo));
    }

}