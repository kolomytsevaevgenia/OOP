package L5;

import L5.exception.WrongDateException;
import L5.model.Specialize;
import L5.model.student.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import L5.service.StudentManager;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class StudentManagerTest {
    private static final LocalDate birthday = LocalDate.of(2000, 8, 10);
    private static final LocalDate date = LocalDate.of(2024, 11, 10);
    private static final Student student = new Student("FIO", Specialize.PHISICSTEACHER, birthday, date);
    private static final String VALID_DATE = "2024-11-10";
    private static final String INVALID_DATE = "2024/08/10";
    private static final String INVALID_DATE2 = "1999-08-10";
    private final StudentManager studentManager = new StudentManager();

    @Test
    @DisplayName("Ошибка валидации формата даты записи")
    void setDateOfReceptionInValid() {
        assertThrows(WrongDateException.class,
                () -> studentManager.setDateOfReception(student, INVALID_DATE));
    }

    @Test
    @DisplayName("Ошибка валидации даты записи")
    void setDateOfReceptionInvalidPast() {
        assertThrows(WrongDateException.class,
                () -> studentManager.setDateOfReception(student, INVALID_DATE2));
    }
}