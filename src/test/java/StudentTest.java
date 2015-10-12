import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import soy.frank.dtos.Student;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StudentTest {

    @Rule
    public ExpectedException expectedExceptionRule = ExpectedException.none();

    @Test
    public void should_be_able_to_create_student() {
        Student student = Student.create("Frank", "Smith");
        assertThat(student.firstName(), is("Frank"));
        assertThat(student.lastName(), is("Smith"));
    }

    @Test
    public void should_not_allow_us_to_create_a_student_with_a_null_name() {
        expectedExceptionRule.expect(IllegalArgumentException.class);
        Student.create(null, "Dracula");
    }

}
