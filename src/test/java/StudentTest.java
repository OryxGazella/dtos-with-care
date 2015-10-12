import org.junit.Test;
import soy.frank.dtos.Student;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StudentTest {

    @Test
    public void should_be_able_to_create_student() {
        Student student = new Student("Frank", "Smith");
        assertThat(student.firstName(), is("Frank"));
        assertThat(student.lastName(), is("Smith"));
    }

}
