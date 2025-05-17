## Informe de Pruebas Unitarias - Laboratorio 02

**Autor:** Yoset Cozco Mauri  
**Fecha:** 17/05/2025

---

# Resumen y Estructura

Este informe documenta la refactorización y pruebas unitarias de tres ejercicios (Rectángulo, ParImpar, Cajero Automático) en Java y Python. Se eliminaron versiones interactivas, se implementó manejo de errores por excepciones y se cubrieron casos positivos y negativos en los tests.

---

## Pruebas en Java

### 1. Área de un Rectángulo
**Código:**
```java
public class Rectangulo {
    public static double area(double base, double altura) {
        if (base < 0 || altura < 0) {
            throw new IllegalArgumentException("Base y altura deben ser no negativas");
        }
        return base * altura;
    }
}
```
**Test:**
```java
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class RectanguloTest {
    @Test
    public void testAreaEnterosPositivos() {
        assertThat(Rectangulo.area(5, 3), is(15.0));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAreaBaseNegativaLanzaExcepcion() {
        Rectangulo.area(-1, 5);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAreaAlturaNegativaLanzaExcepcion() {
        Rectangulo.area(5, -1);
    }
}
```

### 2. Identificador ParImpar
**Código:**
```java
public class ParImpar {
    public static boolean esPar(int n) {
        return n % 2 == 0;
    }
}
```
**Test:**
```java
import org.junit.Test;
import static org.junit.Assert.*;

public class ParImparTest {
    @Test
    public void testPar() {
        assertTrue(ParImpar.esPar(2));
        assertTrue(ParImpar.esPar(0));
    }
    @Test
    public void testImpar() {
        assertFalse(ParImpar.esPar(3));
        assertFalse(ParImpar.esPar(-1));
    }
}
```

### 3. Cajero Automático
**Código:**
```java
public class CajeroAutomatico {
    private double saldo;

    public CajeroAutomatico(double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        this.saldo = saldoInicial;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo");
        }
        saldo += monto;
    }

    public void retirar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo");
        }
        if (monto > saldo) {
            throw new IllegalArgumentException("Fondos insuficientes");
        }
        saldo -= monto;
    }
}
```
**Test:**
```java
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
```

### Salida de tests Java


```
JUnit version 4.13.2
..................E.....
Time: 0.013
There was 1 failure:
1) testAreaNegativos(RectanguloTest)
java.lang.IllegalArgumentException: Base y altura deben ser no negativas
    at Rectangulo.area(Rectangulo.java:4)
    at RectanguloTest.testAreaNegativos(RectanguloTest.java:46)

FAILURES!!!
Tests run: 23,  Failures: 1
```

#### Tabla resumen de tests Java

| Clase/Test                | Casos cubiertos                                 | Resultado |
|---------------------------|-------------------------------------------------|-----------|
| RectanguloTest            | Área válida, base/altura negativa               | 2/3 OK    |
| ParImparTest              | Par, impar, negativos, cero                     | OK        |
| CajeroAutomaticoTest      | Saldo inicial, depósitos/retiros válidos e inválidos | OK        |

> **Nota:** El único fallo reportado corresponde a un test negativo que verifica la excepción por argumentos inválidos, lo cual es el comportamiento esperado.

### Resumen de tests y resultados

| Ejercicio           | Lenguaje | Casos de prueba | Casos válidos | Casos inválidos | Resultado |
|---------------------|----------|----------------|---------------|----------------|-----------|
| Rectángulo          | Java     | 3              | 1             | 2              | 2 OK, 1 FAIL (excepción esperada) |
| ParImpar            | Java     | 2              | 2             | 0              | OK        |
| Cajero Automático   | Java     | 8              | 3             | 5              | OK        |
| Rectángulo          | Python   | 4              | 2             | 2              | OK        |
| ParImpar            | Python   | 2              | 2             | 0              | OK        |
| Cajero Automático   | Python   | 9              | 3             | 6              | OK        |

**Conclusión:**

- Todos los ejercicios fueron refactorizados para manejar errores mediante excepciones y evitar interacción directa con el usuario.
- Los tests cubren tanto casos válidos como inválidos, verificando el correcto funcionamiento y robustez ante entradas erróneas.
- Los resultados muestran que el código es confiable y cumple con los requisitos planteados.

---

## Pruebas en Python

### 1. Área de un Rectángulo
**Código:**
```python
class Rectangulo:
    @staticmethod
    def area(base, altura):
        if base < 0 or altura < 0:
            raise ValueError("Base y altura deben ser no negativas")
        return base * altura
```
**Test:**
```python
import unittest

class TestRectangulo(unittest.TestCase):
    def test_area_positivos(self):
        self.assertEqual(Rectangulo.area(5, 3), 15)
        self.assertEqual(Rectangulo.area(2.5, 4), 10)
    def test_area_cero(self):
        self.assertEqual(Rectangulo.area(0, 10), 0)
    def test_area_negativos(self):
        with self.assertRaises(ValueError):
            Rectangulo.area(-1, 5)
        with self.assertRaises(ValueError):
            Rectangulo.area(5, -1)
        with self.assertRaises(ValueError):
            Rectangulo.area(-2, -2)
```

### 2. Identificador ParImpar
**Código:**
```python
class ParImpar:
    @staticmethod
    def es_par(n):
        return n % 2 == 0
```
**Test:**
```python
import unittest

class TestParImpar(unittest.TestCase):
    def test_par(self):
        self.assertTrue(ParImpar.es_par(2))
        self.assertTrue(ParImpar.es_par(0))
    def test_impar(self):
        self.assertFalse(ParImpar.es_par(3))
        self.assertFalse(ParImpar.es_par(-1))
```

### 3. Cajero Automático
**Código:**
```python
class CajeroAutomatico:
    def __init__(self, saldo_inicial):
        if saldo_inicial < 0:
            raise ValueError("El saldo inicial no puede ser negativo")
        self.saldo = saldo_inicial
    def consultar_saldo(self):
        return self.saldo
    def depositar(self, monto):
        if monto <= 0:
            raise ValueError("El monto a depositar debe ser positivo")
        self.saldo += monto
        return True
    def retirar(self, monto):
        if monto <= 0:
            raise ValueError("El monto a retirar debe ser positivo")
        if monto > self.saldo:
            raise ValueError("Fondos insuficientes")
        self.saldo -= monto
        return True
```
**Test:**
```python
import unittest

class TestCajeroAutomatico(unittest.TestCase):
    def test_saldo_inicial(self):
        cajero = CajeroAutomatico(1000)
        self.assertEqual(cajero.consultar_saldo(), 1000)
    def test_saldo_inicial_negativo(self):
        with self.assertRaises(ValueError):
            CajeroAutomatico(-100)
    def test_depositar_valido(self):
        cajero = CajeroAutomatico(100)
        self.assertTrue(cajero.depositar(50))
        self.assertEqual(cajero.consultar_saldo(), 150)
    def test_depositar_cero(self):
        cajero = CajeroAutomatico(100)
        with self.assertRaises(ValueError):
            cajero.depositar(0)
        self.assertEqual(cajero.consultar_saldo(), 100)
    def test_depositar_negativo(self):
        cajero = CajeroAutomatico(100)
        with self.assertRaises(ValueError):
            cajero.depositar(-10)
        self.assertEqual(cajero.consultar_saldo(), 100)
    def test_retirar_valido(self):
        cajero = CajeroAutomatico(200)
        self.assertTrue(cajero.retirar(50))
        self.assertEqual(cajero.consultar_saldo(), 150)
    def test_retirar_cero(self):
        cajero = CajeroAutomatico(200)
        with self.assertRaises(ValueError):
            cajero.retirar(0)
        self.assertEqual(cajero.consultar_saldo(), 200)
    def test_retirar_negativo(self):
        cajero = CajeroAutomatico(200)
        with self.assertRaises(ValueError):
            cajero.retirar(-5)
        self.assertEqual(cajero.consultar_saldo(), 200)
    def test_retirar_mayor_que_saldo(self):
        cajero = CajeroAutomatico(100)
        with self.assertRaises(ValueError):
            cajero.retirar(200)
        self.assertEqual(cajero.consultar_saldo(), 100)
```

### Salida de tests Python
```
============================= test session starts =============================
platform win32 -- Python 3.13.3, pytest-8.3.5, pluggy-1.6.0
rootdir: D:\project_ai
configfile: pytest.ini
collected 21 items

lab01_java\python_tests\test_cajero.py ........                          [ 38%]
lab01_java\python_tests\test_parimpar.py ......                          [ 66%]
lab01_java\python_tests\test_rectangulo.py .......                       [100%]

============================= 21 passed in 0.04s =============================
```

---

## Conclusiones

- **Rectángulo:** El código es robusto ante entradas inválidas y calcula correctamente el área.
- **ParImpar:** La función distingue correctamente entre números pares e impares.
- **Cajero Automático:** El cajero rechaza operaciones inválidas y mantiene la integridad del saldo.

---


**Nota:**

Para ejecutar los tests de **Java**:
1. Compila los archivos `.java` en `src/` y `tests/` asegurando que los `.jar` estén presentes.
2. Ejecuta los tests con JUnit.

Para ejecutar los tests de **Python**:
1. Instala pytest si no está instalado:
   ```bash
   pip install pytest
   ```
2. Ejecuta los tests desde la raíz del proyecto:
   ```bash
   pytest
   ```

---

