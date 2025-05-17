import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import java.util.Arrays;
import java.util.List;

public class ParImparTest {
    @Test
    public void testIdentificar() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        List<String> esperado = Arrays.asList("Impar", "Par", "Impar", "Par", "Impar");
        assertThat(ParImpar.identificar(numeros), is(esperado));
    }
}
