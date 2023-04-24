public class Staff extends Person {
    private String title;

    public Staff(String firstName, String lastName, String title) {
        super(firstName, lastName);
        this.title = title;
    }

    public void addRandomMarks(Journal journal) throws InterruptedException {
        Thread thread = new MarkThread(journal);
        thread.start();
        thread.join();
    }


}
