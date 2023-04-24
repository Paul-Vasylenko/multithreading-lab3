import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Journal {
    public final List<Group> groups;
    private final ConcurrentMap<Student, List<Integer>> hashMap;
    private final Lock lock;
    public Journal() {
        groups = new ArrayList<>();
        hashMap = new ConcurrentHashMap<>();
        lock = new ReentrantLock();
    }

    public static Journal generateJournal(int size, int[] groupSizes) {
        if (size != groupSizes.length) return null;
        Journal journal = new Journal();
        for (int i = 0; i < size; i++) {
            journal.groups.add(Group.generateGroup(groupSizes[i]));
        }

        return journal;
    }
}
