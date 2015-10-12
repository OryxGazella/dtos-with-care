package soy.frank.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Student {

    Student() {
    }

    public static Student invalidStudent = new AutoValue_Student("Invalid", "Invalid");

    @JsonCreator
    public static Student create(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName) {
        if (firstName == null) return invalidStudent;
        return new AutoValue_Student(firstName, lastName);
    }

    public abstract String firstName();

    @Nullable
    public abstract String lastName();
}
