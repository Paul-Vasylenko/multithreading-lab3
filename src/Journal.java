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
            Group group = Group.generateGroup(groupSizes[i]);
            journal.groups.add(group);
            for (var student : group.students) {
                if(journal.hashMap.containsKey(student)) continue;
                journal.hashMap.put(student, new ArrayList<>());
            }
        }

        return journal;
    }

    public void addMark(Student student, int mark) {
        hashMap.get(student).add(mark);
    }

    public String toString() {
        String result = "";

        for (var group : groups) {
            result += group.groupName + "\n";

            for (var student : group.students) {
                result += student.getFullName() + ": " + hashMap.get(student).toString() + "\n";
            }

            result += "\n";
        }

        return result;
    }
}
