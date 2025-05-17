import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class CajeroAutomaticoTest {
    @Test
    public void testDepositarYConsultarSaldo() {
        CajeroAutomatico cajero = new CajeroAutomatico(100);
        assertThat(cajero.depositar(50), is(true));
        assertThat(cajero.consultarSaldo(), is(150.0));
        assertThat(cajero.depositar(-10), is(false));
    }

    @Test
    public void testRetirar() {
        CajeroAutomatico cajero = new CajeroAutomatico(200);
        assertThat(cajero.retirar(50), is(true));
        assertThat(cajero.consultarSaldo(), is(150.0));
        assertThat(cajero.retirar(200), is(false));
        assertThat(cajero.retirar(-5), is(false));
    }
}
