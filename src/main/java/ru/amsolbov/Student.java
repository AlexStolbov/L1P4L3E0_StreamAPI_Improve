package ru.amsolbov;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student implements Comparator<Student> {
    /**
     * ФИО студента
     */
    private String name;
    /**
     * Балл аттестата.
     */
    private int scope;

    Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    @Override
    public int compare(Student o1, Student o2) {
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return Integer.compare(o1.scope, o2.scope);
    }

    /**
     * Возвращает список студентов у которых балл аттестата больше bound (минимальной оценки).
     * @param students - полный (исходный) список студентов
     * @param bound минимальная оценка
     * @return список студентов
     */
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().sorted(new Student("none", 0).reversed()).flatMap(Stream::ofNullable).takeWhile(s -> s.scope > bound).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return name.concat(" : ").concat(Integer.toString(scope));
    }
}
