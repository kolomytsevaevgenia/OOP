package L6.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.util.Objects;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Student implements Comparable<Student> {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String studentId;

    @Override
    public int compareTo(Student o) {
        return lastName.compareTo(o.lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return firstName.equals(student.firstName) &&
                lastName.equals(student.lastName) &&
                studentId.equals(student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, studentId);
    }
}

