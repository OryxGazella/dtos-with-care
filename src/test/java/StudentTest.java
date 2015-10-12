import org.junit.Test;
import soy.frank.dtos.Student;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StudentTest {

    @Test
    public void should_be_able_to_create_student() {
        Student student = new Student();
        student.setFirstName("Frank");
        student.setLastName("Smith");
        assertThat(student.getFirstName(), is("Frank"));
        assertThat(student.getLastName(), is("Smith"));
    }

}
