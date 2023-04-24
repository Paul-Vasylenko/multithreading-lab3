import java.util.Random;

public class Student extends Person {
    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public static Student generateStudent() {
        var random = new Random();

        return new Student("Firstname" + random.nextInt(), "Lastname" + random.nextInt());
    }
}