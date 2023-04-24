public class Main {
    public static void main(String[] args) {
        int[] sizes = { 10, 15, 20 };
        Journal journal = Journal.generateJournal(3, sizes);

        Staff teacher = new Staff("A", "A", "Lecturer");
        Staff assistant1 = new Staff("B", "B", "Assistant");
        Staff assistant2 = new Staff("C", "C", "Assistant");
        Staff assistant3 = new Staff("D", "D", "Assistant");

        try {
            for (int i = 0; i < 2; i++) {
                teacher.addRandomMarks(journal);
                assistant1.addRandomMarks(journal);
                assistant2.addRandomMarks(journal);
                assistant3.addRandomMarks(journal);
            }
        } catch(InterruptedException e) {

        }

        System.out.println(journal);
    }
}