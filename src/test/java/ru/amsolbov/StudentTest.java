package ru.amsolbov;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StudentTest {
    @Test
    public void whenCallLevelOffThenGetResult() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alex", 15));
        students.add(new Student("Dmitry", 10));
        students.add(null);
        students.add(new Student("Piter", 12));
        students.add(null);
        List<Student> test = new ArrayList<>();
        test.add(students.get(0));
        test.add(students.get(3));
        assertThat(Student.levelOf(students, 11), is(test));
    }

}