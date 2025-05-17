import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class RectanguloTest {
    @Test(expected = IllegalArgumentException.class)
    public void testAreaBaseNegativaLanzaExcepcion() {
        Rectangulo.area(-1, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAreaAlturaNegativaLanzaExcepcion() {
        Rectangulo.area(5, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAreaBaseYAlturaNegativaLanzaExcepcion() {
        Rectangulo.area(-2, -2);
    }
    @Test
    public void testAreaEnterosPositivos() {
        assertThat("Área de 5x3 debe ser 15", Rectangulo.area(5, 3), is(15.0));
        assertThat("Área de 10x2 debe ser 20", Rectangulo.area(10, 2), is(20.0));
        assertThat("Área de 1x1 debe ser 1", Rectangulo.area(1, 1), is(1.0));
        assertThat("Área de 100x100 debe ser 10000", Rectangulo.area(100, 100), is(10000.0));
    }

    @Test
    public void testAreaDecimales() {
        assertThat("Área de 2.5x4 debe ser 10.0", Rectangulo.area(2.5, 4), is(10.0));
        assertThat("Área de 1.1x2.2 debe ser aproximadamente 2.42", Rectangulo.area(1.1, 2.2), closeTo(2.42, 0.01));
        assertThat("Área de 0.5x0.5 debe ser 0.25", Rectangulo.area(0.5, 0.5), is(0.25));
        assertThat("Área de 3.3x3 debe ser 9.9", Rectangulo.area(3.3, 3), closeTo(9.9, 0.01));
    }

    @Test
    public void testAreaCero() {
        assertThat("Área de 0x10 debe ser 0", Rectangulo.area(0, 10), is(0.0));
        assertThat("Área de 10x0 debe ser 0", Rectangulo.area(10, 0), is(0.0));
        assertThat("Área de 0x0 debe ser 0", Rectangulo.area(0, 0), is(0.0));
    }

    @Test
    public void testAreaNegativos() {
        // El método permite negativos, pero en la app interactiva no se aceptan
        assertThat("Área de -5x3 debe ser -15", Rectangulo.area(-5, 3), is(-15.0));
        assertThat("Área de 5x-3 debe ser -15", Rectangulo.area(5, -3), is(-15.0));
        assertThat("Área de -5x-3 debe ser 15", Rectangulo.area(-5, -3), is(15.0));
        assertThat("Área de -1x0 debe ser 0", Rectangulo.area(-1, 0), is(0.0));
        assertThat("Área de 0x-1 debe ser 0", Rectangulo.area(0, -1), is(0.0));
    }

    @Test
    public void testAreaCasosLimite() {
        assertThat("Área de Double.MAX_VALUE x 1 debe ser Double.MAX_VALUE", Rectangulo.area(Double.MAX_VALUE, 1), is(Double.MAX_VALUE));
        assertThat("Área de Double.MIN_VALUE x 1 debe ser Double.MIN_VALUE", Rectangulo.area(Double.MIN_VALUE, 1), is(Double.MIN_VALUE));
        assertThat("Área de Double.MAX_VALUE x 0 debe ser 0", Rectangulo.area(Double.MAX_VALUE, 0), is(0.0));
        assertThat("Área de Double.MIN_VALUE x 0 debe ser 0", Rectangulo.area(Double.MIN_VALUE, 0), is(0.0));
    }
}
