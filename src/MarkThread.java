import java.util.Random;

public class MarkThread extends Thread {
    private final Journal journal;

    public MarkThread(Journal journal) {
        this.journal = journal;
    }

    @Override
    public void run() {
        for (var group : journal.groups) {
            for (var student : group.students) {
                Random rand = new Random();
                int mark = rand.nextInt(100) + 1;
                journal.addMark(student, mark);
            }
        }
    }
}
