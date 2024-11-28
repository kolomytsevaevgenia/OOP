package L5;

import L5.exception.TeacherIsBusyException;
import L5.model.Specialize;
import L5.model.teacher.MathTeacher;
import L5.model.teacher.Teacher;
import L5.model.student.Student;
import org.junit.jupiter.api.*;
import L5.service.TeacherManager;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TeacherManagerTest {

    private static final Teacher mathTeacher = new MathTeacher(Specialize.MATHTEACHER);
    private static final Teacher computerscienceTeacher = new MathTeacher(Specialize.COMPUTERSCIENCETEACHER);
    private static final LocalDate birthday = LocalDate.of(2000, 8, 10);
    private static final LocalDate date = LocalDate.of(2024, 11, 10);
    private static final Student student1 = new Student("FIO", Specialize.PHISICSTEACHER, birthday, date);
    private static final Student student2 = new Student("FIO", Specialize.COMPUTERSCIENCETEACHER, birthday, date);
    private static final Student student3 = new Student("FIO", Specialize.MATHTEACHER, birthday, date);
    private static final TeacherManager teacherManager = new TeacherManager();
    List<Teacher> teachers = List.of(mathTeacher, computerscienceTeacher);

    @AfterEach
    void clearClasses() {
        teachers.forEach(Teacher::clearTeacher);
    }

    @Test
    @DisplayName("Проверим, у всех ли учителей те студенты")
    void allTeachersHaveCorrectStudents() {
        assertDoesNotThrow(() ->
                teacherManager.addStudentToTeacher(mathTeacher, student3));
        assertDoesNotThrow(() ->
                teacherManager.addStudentToTeacher(computerscienceTeacher, student2));
        for (Teacher teacher : teachers) {
            for (Student student : teacher.getStudents()) {
                Assertions.assertEquals(teacher.getSpecializeType(), student.getDirection());
            }
        }
    }

    @Test
    @DisplayName("Ошибка добавления студента к учителю")
    void teacherDoesNotExistsForStudent() {
        assertThrows(TeacherIsBusyException.class,
                () -> teacherManager.addStudentToTeacher(mathTeacher, student1));
    }

}