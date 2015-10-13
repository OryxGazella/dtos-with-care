package soy.frank.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.immutables.value.Value;

@Value.Immutable
public interface Student {
    String firstName();

    @Nullable
    String lastName();

    @JsonCreator
    static Student create(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName) {
        if (firstName == null) return invalidStudent;
        return ImmutableStudent.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }

    Student invalidStudent = ImmutableStudent
            .builder()
            .firstName("Invalid")
            .build();
}
