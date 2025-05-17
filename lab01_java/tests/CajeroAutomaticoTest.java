import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class CajeroAutomaticoTest {
    @Test
    public void testSaldoInicial() {
        CajeroAutomatico cajero = new CajeroAutomatico(1000);
        assertThat(cajero.consultarSaldo(), is(1000.0));
    }

    @Test
    public void testDepositarValido() {
        CajeroAutomatico cajero = new CajeroAutomatico(100);
        assertThat(cajero.depositar(50), is(true));
        assertThat(cajero.consultarSaldo(), is(150.0));
    }

    @Test
    public void testDepositarCero() {
        CajeroAutomatico cajero = new CajeroAutomatico(100);
        assertThat(cajero.depositar(0), is(false));
        assertThat(cajero.consultarSaldo(), is(100.0));
    }

    @Test
    public void testDepositarNegativo() {
        CajeroAutomatico cajero = new CajeroAutomatico(100);
        assertThat(cajero.depositar(-10), is(false));
        assertThat(cajero.consultarSaldo(), is(100.0));
    }

    @Test
    public void testRetirarValido() {
        CajeroAutomatico cajero = new CajeroAutomatico(200);
        assertThat(cajero.retirar(50), is(true));
        assertThat(cajero.consultarSaldo(), is(150.0));
    }

    @Test
    public void testRetirarCero() {
        CajeroAutomatico cajero = new CajeroAutomatico(200);
        assertThat(cajero.retirar(0), is(false));
        assertThat(cajero.consultarSaldo(), is(200.0));
    }

    @Test
    public void testRetirarNegativo() {
        CajeroAutomatico cajero = new CajeroAutomatico(200);
        assertThat(cajero.retirar(-5), is(false));
        assertThat(cajero.consultarSaldo(), is(200.0));
    }

    @Test
    public void testRetirarMayorQueSaldo() {
        CajeroAutomatico cajero = new CajeroAutomatico(100);
        assertThat(cajero.retirar(200), is(false));
        assertThat(cajero.consultarSaldo(), is(100.0));
    }
}
