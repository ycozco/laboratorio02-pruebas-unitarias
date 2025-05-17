import org.junit.Test;
import static org.junit.Assert.*;

public class CajeroAutomaticoTest {
    @Test
    public void testSaldoInicial() {
        CajeroAutomatico cajero = new CajeroAutomatico(1000);
        assertEquals(1000.0, cajero.consultarSaldo(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaldoInicialNegativo() {
        new CajeroAutomatico(-100);
    }

    @Test
    public void testDepositarValido() {
        CajeroAutomatico cajero = new CajeroAutomatico(100);
        cajero.depositar(50);
        assertEquals(150.0, cajero.consultarSaldo(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositarCero() {
        CajeroAutomatico cajero = new CajeroAutomatico(100);
        cajero.depositar(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositarNegativo() {
        CajeroAutomatico cajero = new CajeroAutomatico(100);
        cajero.depositar(-10);
    }

    @Test
    public void testRetirarValido() {
        CajeroAutomatico cajero = new CajeroAutomatico(200);
        cajero.retirar(50);
        assertEquals(150.0, cajero.consultarSaldo(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRetirarCero() {
        CajeroAutomatico cajero = new CajeroAutomatico(200);
        cajero.retirar(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRetirarNegativo() {
        CajeroAutomatico cajero = new CajeroAutomatico(200);
        cajero.retirar(-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRetirarMayorQueSaldo() {
        CajeroAutomatico cajero = new CajeroAutomatico(100);
        cajero.retirar(200);
    }
}
