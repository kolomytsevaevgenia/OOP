package L6;

import L6.model.Student;
import L6.model.Shedule;
import L6.model.comparator.SheduleComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class SheduleComparatorTest {

    private static Student student1 = new Student()
            .setFirstName("Mark")
            .setLastName("Vinson")
            .setStudentId("677");

    private static Student student2 = new Student()
            .setFirstName("Tom")
            .setLastName("Volkov")
            .setStudentId("987");

    private static Shedule request1 = new Shedule()
            .setId(1)
            .setTitle("Additional math classes")
            .setStudent(student1);

    private static Shedule request2 = new Shedule()
            .setId(2)
            .setTitle("Еxam preparation group")
            .setStudent(student2);

    @Test
    @DisplayName("Сортировка только по студенту")
    void sortByStudent() {
        List<Shedule> requests = new ArrayList<>();
        requests.add(request2);
        requests.add(request1);
        requests.sort(Comparator.comparing(Shedule::getStudent));
        Assertions.assertEquals(requests.get(0), request1);
        Assertions.assertEquals(requests.get(1), request2);
    }

    @Test
    @DisplayName("Сортировка только по id")
    void sortById() {
        List<Shedule> requests = new ArrayList<>();
        requests.add(request2);
        requests.add(request1);
        requests.sort(Comparator.comparing(Shedule::getId));
        Assertions.assertEquals(requests.get(0), request1);
        Assertions.assertEquals(requests.get(1), request2);
    }

    @Test
    @DisplayName("Сортировка только по названию")
    void sortByTitle() {
        List<Shedule> requests = new ArrayList<>();
        requests.add(request2);
        requests.add(request1);
        requests.sort(new SheduleComparator());
        Assertions.assertEquals(requests.get(0), request1);
        Assertions.assertEquals(requests.get(1), request2);
    }
}