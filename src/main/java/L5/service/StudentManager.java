package L5.service;

import L5.exception.WrongDateException;
import L5.model.student.Student;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class StudentManager {

    private static final Pattern DATE_PATTERN =
            Pattern.compile("[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])");

    public void setDateOfReception(Student student, String date) {
        checkCorrectData(date);

        student.setBirthday(LocalDate.parse(date));
    }

    private void checkDataValid(String data) {
        if (!DATE_PATTERN.matcher(data).matches()) {
            throw new WrongDateException("Формат даты: YYYY-MM-DD");
        }
    }

    private void checkCorrectData(String data) {
        if (!DATE_PATTERN.matcher(data).matches()) {
            throw new WrongDateException("Формат даты: YYYY-MM-DD");
        }
        LocalDate dateNow = LocalDate.now();
        if (dateNow.isAfter(LocalDate.parse(data))) {
            throw new WrongDateException("Нельзя записаться на прошедший приём.");
        }
    }
}