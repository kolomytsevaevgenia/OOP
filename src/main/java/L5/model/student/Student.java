package L5.model.student;

import L5.model.Specialize;
import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Setter
@Getter
public class Student {
    private String FIO; // ФИО студента
    private Specialize direction; // Направление обучения
    private LocalDate birthday; // Дата рождения
    private LocalDate reception; // Дата зачисления

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Specialize getDirection() {
        return direction;
    }

    public void setDirection(Specialize direction) {
        this.direction = direction;
    }
}
