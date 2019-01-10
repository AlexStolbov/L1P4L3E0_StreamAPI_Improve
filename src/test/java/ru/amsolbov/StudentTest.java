package ru.amsolbov;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StudentTest {
    @Test
    public void whenCallLevelOffThenGetResult() {
        List<Student> students = List.of(
                new Student("Alex", 15),
                new Student("Dmitry", 10),
                new Student("Peter", 12));
        List<Student> test = List.of(
                students.get(0),
                students.get(2));
        assertThat(Student.levelOf(students, 11), is(test));
    }

}