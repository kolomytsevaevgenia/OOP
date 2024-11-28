package L6.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.util.Objects;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Shedule {
    @NonNull
    private int id;
    @NonNull
    private String title;
    @NonNull
    private Student student;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shedule that = (Shedule) o;
        return id == that.id &&
                title.equals(that.title) &&
                student.equals(that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, student);
    }
}

