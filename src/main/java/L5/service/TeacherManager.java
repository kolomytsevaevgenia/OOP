package L5.service;

import L5.exception.TeacherIsBusyException;
import L5.model.teacher.Teacher;
import L5.exception.WrongTeacherTypeException;
import lombok.extern.slf4j.Slf4j;
import L5.model.Specialize;
import L5.model.student.Student;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TeacherManager {

    private final Map<Specialize, Teacher> teachers;

    public TeacherManager() {
        this.teachers = new HashMap<>();
    }

    public void addStudentToTeacher(Teacher teacher, Student student ) {
        try {
            isRightSpecialize(teacher.getSpecializeType(), student.getDirection());
            teachers.putIfAbsent(teacher.getSpecializeType(), teacher);
            teacher.addStudentToTeacher(student);
        } catch (WrongTeacherTypeException e) {
            log.info(e.getMessage());
        } finally {
            if (teachers.containsKey(student.getDirection())) {
                if (!teachers.get(student.getDirection()).getStudents().contains(student)) {
                    Teacher correct = teachers.get(student.getDirection());
                    correct.addStudentToTeacher(student);
                    log.info("Студент учится у правильного учителя");
                }
            } else {
                throw new TeacherIsBusyException("Сейчас данный учитель занят");
            }
        }
    }

    private void isRightSpecialize(Specialize teacherType, Specialize studentType) throws WrongTeacherTypeException {
        if (teacherType != studentType) {
            throw new WrongTeacherTypeException("Студенту нужен учитель не по данному предмету!");
        }
    }
}


