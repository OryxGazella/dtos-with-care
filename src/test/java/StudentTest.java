import org.junit.Test;
import soy.frank.dtos.Student;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

public class StudentTest {

    @Test
    public void should_be_able_to_create_student() {
        Student student = Student.Companion.create("Frank", "Smith");
        assertThat(student.getFirstName(), is("Frank"));
        assertThat(student.getLastName(), is("Smith"));
    }

    @Test
    public void should_not_allow_us_to_create_a_student_with_a_null_name() {
        Student studentWithoutName = Student.Companion.create(null, "Dracula");
        assertThat(studentWithoutName, sameInstance(Student.invalidStudent));
    }

    @Test
    public void should_identify_invalid_data() {
        Collection<Student> students = simulateBadDataFromApi().stream()
                .filter(s -> s != Student.invalidStudent)
                .collect(Collectors.toSet());

        assertThat(students.size(), is(2));
        assertThat(students, containsInAnyOrder(
                Student.Companion.create("Fabio", null),
                Student.Companion.create("Frank", "Smith")));
    }

    private Collection<Student> simulateBadDataFromApi() {
        return Arrays.asList(
                Student.Companion.create("Fabio", null),
                Student.Companion.create(null, null),
                Student.Companion.create("Frank", "Smith"),
                Student.Companion.create("Fabio", null),
                Student.Companion.create(null, "Dracula"));
    }
}
