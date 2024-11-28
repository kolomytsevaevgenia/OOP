package L5.model.teacher;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import L5.model.Specialize;
import L5.model.student.Student;

import java.util.List;

@Slf4j
@Getter
@NoArgsConstructor
public abstract class Teacher {

    public abstract Specialize getSpecializeType();
    public abstract void addStudentToTeacher(Student student);
    public abstract void deleteStudentFromTeacher(Student student);
    public abstract List<Student> getStudents();
    public abstract void clearTeacher();

    public void log(String message) {
       /// log.info(message);
    }
}