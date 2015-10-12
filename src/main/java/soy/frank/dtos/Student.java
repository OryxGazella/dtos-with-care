package soy.frank.dtos;


public class Student {
    private final String firstName;
    @Nullable
    private final String lastName;

    private Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static Student create(String firstName, String lastName) {
        if (firstName == null) throw new IllegalArgumentException("Null firstName");
        return new Student(firstName, lastName);
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }
}
