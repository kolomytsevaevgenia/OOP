package L6.model.comparator;

import L6.model.Shedule;

import java.util.Comparator;

public class SheduleComparator implements Comparator<Shedule> {
    @Override
    public int compare(Shedule r1, Shedule r2) {
        return r1.getTitle().compareTo(r2.getTitle());
    }
}
