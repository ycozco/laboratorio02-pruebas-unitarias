import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class RectanguloTest {
    @Test
    public void testAreaEnterosPositivos() {
        assertThat(Rectangulo.area(5, 3), is(15.0));
        assertThat(Rectangulo.area(10, 2), is(20.0));
    }

    @Test
    public void testAreaDecimales() {
        assertThat(Rectangulo.area(2.5, 4), is(10.0));
        assertThat(Rectangulo.area(1.1, 2.2), closeTo(2.42, 0.01));
    }

    @Test
    public void testAreaCero() {
        assertThat(Rectangulo.area(0, 10), is(0.0));
        assertThat(Rectangulo.area(10, 0), is(0.0));
        assertThat(Rectangulo.area(0, 0), is(0.0));
    }

    @Test
    public void testAreaNegativos() {
        // El método permite negativos, pero en la app interactiva no se aceptan
        assertThat(Rectangulo.area(-5, 3), is(-15.0));
        assertThat(Rectangulo.area(5, -3), is(-15.0));
        assertThat(Rectangulo.area(-5, -3), is(15.0));
    }
}
