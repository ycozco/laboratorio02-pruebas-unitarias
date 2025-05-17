import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class RectanguloTest {
    @Test
    public void testArea() {
        assertThat(Rectangulo.area(5, 3), is(15.0));
        assertThat(Rectangulo.area(0, 10), is(0.0));
        assertThat(Rectangulo.area(2.5, 4), is(10.0));
    }
}
