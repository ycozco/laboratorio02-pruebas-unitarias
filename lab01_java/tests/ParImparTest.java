import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import java.util.Arrays;
import java.util.List;

public class ParImparTest {
    @Test
    public void testIdentificarMixto() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        List<String> esperado = Arrays.asList("Impar", "Par", "Impar", "Par", "Impar");
        assertThat(ParImpar.identificar(numeros), is(esperado));
    }

    @Test
    public void testIdentificarSoloPares() {
        List<Integer> numeros = Arrays.asList(2, 4, 6);
        List<String> esperado = Arrays.asList("Par", "Par", "Par");
        assertThat(ParImpar.identificar(numeros), is(esperado));
    }

    @Test
    public void testIdentificarSoloImpares() {
        List<Integer> numeros = Arrays.asList(1, 3, 5);
        List<String> esperado = Arrays.asList("Impar", "Impar", "Impar");
        assertThat(ParImpar.identificar(numeros), is(esperado));
    }

    @Test
    public void testIdentificarConCero() {
        List<Integer> numeros = Arrays.asList(0, 1, 2);
        List<String> esperado = Arrays.asList("Par", "Impar", "Par");
        assertThat(ParImpar.identificar(numeros), is(esperado));
    }

    @Test
    public void testIdentificarNegativos() {
        List<Integer> numeros = Arrays.asList(-2, -3, -4);
        List<String> esperado = Arrays.asList("Par", "Impar", "Par");
        assertThat(ParImpar.identificar(numeros), is(esperado));
    }

    @Test
    public void testIdentificarListaVacia() {
        List<Integer> numeros = Arrays.asList();
        List<String> esperado = Arrays.asList();
        assertThat(ParImpar.identificar(numeros), is(esperado));
    }
}
