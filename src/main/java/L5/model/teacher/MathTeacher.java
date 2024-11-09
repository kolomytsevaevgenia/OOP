package L5.model.teacher;

import L5.model.Specialize;
import L5.model.student.Student;

import java.util.ArrayList;
import java.util.List;

public class MathTeacher extends Teacher {

    Specialize specializeType;
    List<Student> students;

    public MathTeacher(Specialize specializeType) {
        this.specializeType = specializeType;
        this.students = new ArrayList<>();
    }

    @Override
    public Specialize getSpecializeType() { // Получение специализации
        return specializeType;
    }

    @Override
    public List<Student> getStudents() { // Получение списка студентов
        return students;
    }

    @Override
    public void clearTeacher() { // Очистка списка студентов
        students = new ArrayList<>();
    }

    @Override
    public void deleteStudentFromTeacher(Student student) {
        students.remove(student);
    }

    @Override
    public void addStudentToTeacher(Student student) { // Добавление студента
        students.add(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathTeacher mathTeacher = (MathTeacher) o;
        return specializeType == mathTeacher.specializeType;
    }
}