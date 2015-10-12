package soy.frank.dtos;


import java.util.Objects;

public class Student {
    private final String firstName;
    @Nullable
    private final String lastName;

    private Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static Student invalidStudent = new Student("Invalid", "Invalid");

    public static Student create(String firstName, String lastName) {
        if (firstName == null) return invalidStudent;
        return new Student(firstName, lastName);
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
