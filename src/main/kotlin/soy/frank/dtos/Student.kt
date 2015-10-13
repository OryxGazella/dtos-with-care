package soy.frank.dtos

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class Student(val firstName: String, val lastName: String?) {
    companion object {
        @JsonCreator
        fun create(
                @JsonProperty("firstName") firstName: String?,
                @JsonProperty("lastName") lastName: String?): Student {
            if (firstName == null) return invalidStudent
            return Student(firstName, lastName)
        }

        val invalidStudent = Student("Invalid", "Invalid")
    }
}