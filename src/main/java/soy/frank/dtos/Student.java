package soy.frank.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Student {
    public static final Student invalidStudent = new Student("Invalid", "Invalid");

    private final String firstName;
    @Nullable
    private final String lastName;

    @JsonCreator
    public static Student create(@JsonProperty("firstName") String firstName,
                                 @JsonProperty("lastName") String lastName) {
        if (firstName == null) return invalidStudent;
        return new Student(firstName, lastName);
    }
}
