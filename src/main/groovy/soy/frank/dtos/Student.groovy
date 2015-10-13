package soy.frank.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.Immutable

@Immutable
class Student {
    String firstName
    String lastName

    @JsonCreator
    static Student create(@JsonProperty("firstName") String firstName,
                          @JsonProperty("lastName") String lastName) {
        if (firstName == null) return invalidStudent
        new Student(firstName, lastName)
    }

    static Student invalidStudent = new Student("Invalid", "Invalid")
}
