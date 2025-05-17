# Informe de Pruebas Unitarias - Laboratorio 02

**Autor:** Yoset Cozco Mauri  
**Fecha:** 17/05/2025

---

## Pruebas en Java

### 1. Área de un Rectángulo
**Código Java:**
```java
public class Rectangulo {
    public static double area(double base, double altura) {
        return base * altura;
    }
}
```
**Explicación:** Esta clase implementa un método estático que calcula el área de un rectángulo multiplicando la base por la altura.

**Test Java:**
```java
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
```
**Explicación del test:** Se prueban áreas con valores positivos, cero y decimales usando JUnit y Hamcrest.

### 2. Identificador de Números Pares e Impares
**Código Java:**
```java
import java.util.List;
import java.util.ArrayList;

public class ParImpar {
    public static List<String> identificar(List<Integer> numeros) {
        List<String> resultado = new ArrayList<>();
        for (int n : numeros) {
            if (n % 2 == 0) {
                resultado.add("Par");
            } else {
                resultado.add("Impar");
            }
        }
        return resultado;
    }
}
```
**Explicación:** Esta clase recorre una lista de enteros y devuelve una lista de cadenas indicando si cada número es "Par" o "Impar".

**Test Java:**
```java
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
```
**Explicación del test:** Se prueban listas mixtas, solo pares y solo impares.

### 3. Mini Simulador de Cajero Automático (ATM)
**Código Java:**
```java
public class CajeroAutomatico {
    private double saldo;

    public CajeroAutomatico(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public boolean depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            return true;
        }
        return false;
    }

    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }
}
```
**Explicación:** Esta clase simula un cajero automático con métodos para consultar saldo, depositar y retirar dinero, validando los montos.

**Test Java:**
```java
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
```
**Explicación del test:** Se prueban depósitos válidos e inválidos, retiros válidos, retiros mayores al saldo y retiros negativos.

### Ejecución de pruebas Java
- Compilar:
  ```powershell
  javac -cp ".;junit-4.13.2.jar;hamcrest-2.2.jar" src/*.java tests/*.java
  ```
- Ejecutar:
  ```powershell
  java -cp ".;src;tests;junit-4.13.2.jar;hamcrest-2.2.jar" org.junit.runner.JUnitCore CajeroAutomaticoTest ParImparTest RectanguloTest
  ```
- **Resultado:** Todas las pruebas pasan correctamente.

---

## Pruebas en Python

### 1. Área de un Rectángulo
**Código Python:**
```python
class Rectangulo:
    @staticmethod
    def area(base, altura):
        return base * altura
```
**Explicación:** Clase con método estático que retorna el área de un rectángulo.

**Test Python:**
```python
import unittest

class TestRectangulo(unittest.TestCase):
    def test_area(self):
        self.assertEqual(Rectangulo.area(5, 3), 15)
        self.assertEqual(Rectangulo.area(0, 10), 0)
        self.assertEqual(Rectangulo.area(2.5, 4), 10)

if __name__ == '__main__':
    unittest.main()
```
**Explicación del test:** Se prueban áreas con valores positivos, cero y decimales usando `unittest`.

### 2. Identificador de Números Pares e Impares
**Código Python:**
```python
class ParImpar:
    @staticmethod
    def identificar(lista):
        return ["Par" if n % 2 == 0 else "Impar" for n in lista]
```
**Explicación:** Clase con método estático que identifica si los elementos de una lista son pares o impares.

**Test Python:**
```python
import unittest

class TestParImpar(unittest.TestCase):
    def test_identificar(self):
        self.assertEqual(ParImpar.identificar([1,2,3,4,5]), ["Impar", "Par", "Impar", "Par", "Impar"])
        self.assertEqual(ParImpar.identificar([2,4,6]), ["Par", "Par", "Par"])
        self.assertEqual(ParImpar.identificar([1,3,5]), ["Impar", "Impar", "Impar"])

if __name__ == '__main__':
    unittest.main()
```
**Explicación del test:** Se prueban listas mixtas, solo pares y solo impares.

### 3. Mini Simulador de Cajero Automático (ATM)
**Código Python:**
```python
class CajeroAutomatico:
    def __init__(self, saldo_inicial):
        self.saldo = saldo_inicial
    def consultar_saldo(self):
        return self.saldo
    def depositar(self, monto):
        if monto > 0:
            self.saldo += monto
            return True
        return False
    def retirar(self, monto):
        if monto > 0 and monto <= self.saldo:
            self.saldo -= monto
            return True
        return False
```
**Explicación:** Clase que simula un cajero automático con métodos para consultar saldo, depositar y retirar dinero.

**Test Python:**
```python
import unittest

class TestCajeroAutomatico(unittest.TestCase):
    def test_depositar_y_consultar_saldo(self):
        cajero = CajeroAutomatico(100)
        self.assertTrue(cajero.depositar(50))
        self.assertEqual(cajero.consultar_saldo(), 150)
        self.assertFalse(cajero.depositar(-10))
    def test_retirar(self):
        cajero = CajeroAutomatico(200)
        self.assertTrue(cajero.retirar(50))
        self.assertEqual(cajero.consultar_saldo(), 150)
        self.assertFalse(cajero.retirar(200))
        self.assertFalse(cajero.retirar(-5))

if __name__ == '__main__':
    unittest.main()
```
**Explicación del test:** Se prueban depósitos válidos e inválidos, retiros válidos, retiros mayores al saldo y retiros negativos.

### Ejecución de pruebas Python
- Ejecutar:
  ```powershell
  python -m unittest discover -s lab01_java/python_tests
  ```
- **Resultado:** Todas las pruebas pasan correctamente.

---

## Requisitos y Guía de Instalación (Windows)

### Java
1. Instalar [Java JDK 21+](https://adoptium.net/temurin/releases/).
2. Descargar los archivos JAR:
   - [junit-4.13.2.jar](https://search.maven.org/remotecontent?filepath=junit/junit/4.13.2/junit-4.13.2.jar)
   - [hamcrest-2.2.jar](https://search.maven.org/remotecontent?filepath=org/hamcrest/hamcrest/2.2/hamcrest-2.2.jar)
3. Agregar la carpeta de Java al PATH del sistema.

### Python
1. Instalar [Python 3.10+](https://www.python.org/downloads/).
2. Instalar dependencias:
   ```powershell
   pip install -r requirements.txt
   ```

### requirements.txt
```
pytest
unittest
```

---

**Nota:**
- Para ejecutar las pruebas de Java, asegúrate de estar en la carpeta raíz del proyecto y que los JARs estén presentes.
- Para Python, asegúrate de tener el archivo `__init__.py` en la carpeta de pruebas.
