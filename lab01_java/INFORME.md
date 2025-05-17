### Código completo Python: CajeroAutomatico y su test
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

### Código completo Java: CajeroAutomatico y su test
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

```java
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
```
## Enfoque de pruebas unitarias en Java y Python: Casos positivos y negativos

En ambos lenguajes, la lógica de negocio está separada de la interacción con el usuario. Los métodos devuelven valores o lanzan excepciones ante entradas inválidas (casos negativos), y las pruebas unitarias verifican tanto los resultados esperados como el manejo correcto de errores.

### Ejemplo en Python (`Rectangulo`):
```python
class Rectangulo:
    @staticmethod
    def area(base, altura):
        if base < 0 or altura < 0:
            raise ValueError("Base y altura deben ser no negativas")
        return base * altura

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

### Ejemplo en Java (`Rectangulo`):
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

### Ejemplo en Python (`CajeroAutomatico`):
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

import unittest

class TestCajeroAutomatico(unittest.TestCase):
    def test_saldo_inicial(self):
        cajero = CajeroAutomatico(1000)
        self.assertEqual(cajero.consultar_saldo(), 1000)
    def test_depositar_valido(self):
        cajero = CajeroAutomatico(100)
        self.assertTrue(cajero.depositar(50))
        self.assertEqual(cajero.consultar_saldo(), 150)
    def test_depositar_cero(self):
        cajero = CajeroAutomatico(100)
        self.assertFalse(cajero.depositar(0))
        self.assertEqual(cajero.consultar_saldo(), 100)
    def test_depositar_negativo(self):
        cajero = CajeroAutomatico(100)
        self.assertFalse(cajero.depositar(-10))
        self.assertEqual(cajero.consultar_saldo(), 100)
    def test_retirar_valido(self):
        cajero = CajeroAutomatico(200)
        self.assertTrue(cajero.retirar(50))
        self.assertEqual(cajero.consultar_saldo(), 150)
    def test_retirar_cero(self):
        cajero = CajeroAutomatico(200)
        self.assertFalse(cajero.retirar(0))
        self.assertEqual(cajero.consultar_saldo(), 200)
    def test_retirar_negativo(self):
        cajero = CajeroAutomatico(200)
        self.assertFalse(cajero.retirar(-5))
        self.assertEqual(cajero.consultar_saldo(), 200)
    def test_retirar_mayor_que_saldo(self):
        cajero = CajeroAutomatico(100)
        self.assertFalse(cajero.retirar(200))
        self.assertEqual(cajero.consultar_saldo(), 100)
```

**Conclusión:**
Las pruebas unitarias en ambos lenguajes cubren tanto los casos positivos (funcionamiento esperado) como los negativos (errores, límites, entradas inválidas), asegurando robustez y calidad en el código.
# Informe de Pruebas Unitarias - Laboratorio 02

**Autor:** Yoset Cozco Mauri  
**Fecha:** 17/05/2025

---

## Pruebas en Java

### Modificaciones y Adaptaciones

Para transformar los programas interactivos originales en versiones aptas para pruebas unitarias y reutilización, se realizaron las siguientes modificaciones:

- **Rectángulo:** Se extrajo la lógica de cálculo del área a un método estático en una clase, eliminando la interacción directa con el usuario.
- **ParImpar:** Se encapsuló la lógica de identificación de paridad en un método estático que recibe una lista, en vez de leer valores uno a uno.
- **Cajero Automático:** Se encapsuló el estado y las operaciones en una clase, separando la lógica de negocio de la interacción por consola.

Estas adaptaciones permiten probar la lógica de manera automática y reutilizar el código en otros contextos.

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

### Modificaciones y Adaptaciones

Al igual que en Java, los programas interactivos originales en Python fueron refactorizados:

- **Rectángulo:** La función de cálculo de área se convirtió en un método estático dentro de una clase, eliminando la entrada por teclado.
- **ParImpar:** La lógica de paridad se encapsuló en un método estático que opera sobre listas.
- **Cajero Automático:** Se creó una clase que mantiene el saldo y expone métodos para depositar, retirar y consultar, facilitando la prueba unitaria.

Estas modificaciones permiten separar la lógica de negocio de la interacción con el usuario y facilitan la automatización de pruebas.

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

## Anexo: Programas Interactivos Originales en Python

### 1. Calcular el área de un rectángulo (versión interactiva)

**Enunciado:**
Escribe un programa que solicite al usuario ingresar la base y la altura de un rectángulo como números enteros o decimales. El programa debe calcular el área del rectángulo (Área = base * altura) e imprimir el resultado mostrando claramente cuál es la base, la altura y el área calculada.

**Código original:**
```python
def leer_numero_float(prompt):
    while True:
        try:
            valor = float(input(prompt))
            return valor
        except ValueError:
            print("Entrada invalida. Ingrese un numero entero o decimal.")

def main_rectangulo():
    # Leer base y validar que sea positiva
    while True:
        base = leer_numero_float("Ingrese la base del rectangulo: ")
        if base > 0:
            break
        print("La base debe ser un valor positivo.")

    # Leer altura y validar que sea positiva
    while True:
        altura = leer_numero_float("Ingrese la altura del rectangulo: ")
        if altura > 0:
            break
        print("La altura debe ser un valor positivo.")

    area = base * altura
    print(f"\nBase: {base}")
    print(f"Altura: {altura}")
    print(f"Area calculada: {area}")

if __name__ == "__main__":
    main_rectangulo()
```
**Explicación:**
Este programa interactivo solicita al usuario la base y la altura, valida que sean positivas y muestra el área calculada. Para pruebas unitarias, la lógica de cálculo se separó en una clase/método independiente.

---

### 2. Identificador de Números Pares e Impares (versión interactiva)

**Enunciado:**
Solicita al usuario una lista de números y muestra para cada uno si es par o impar.

**Código original:**
```python
def main_parimpar():
    n = int(input("¿Cuántos números desea ingresar?: "))
    numeros = []
    for i in range(n):
        while True:
            try:
                num = int(input(f"Ingrese el número {i+1}: "))
                numeros.append(num)
                break
            except ValueError:
                print("Entrada inválida. Ingrese un número entero.")
    for num in numeros:
        if num % 2 == 0:
            print(f"{num} es Par")
        else:
            print(f"{num} es Impar")

if __name__ == "__main__":
    main_parimpar()
```
**Explicación:**
El programa solicita una cantidad de números, los lee y muestra si cada uno es par o impar. Para pruebas unitarias, la lógica se encapsuló en un método que opera sobre listas.

---

### 3. Mini simulador de cajero automático (versión interactiva)

**Enunciado:**
Desarrolla un programa que simule las operaciones básicas de un cajero automático. El programa debe iniciar con un saldo fijo (por ejemplo, S/.1,000). Debe presentar un menú al usuario con las siguientes opciones: 1. Consultar Saldo 2. Depositar Dinero 3. Retirar Dinero 4. Salir. El menú debe mostrarse repetidamente hasta que el usuario elija la opción "Salir".

**Código original:**
```python
def leer_monto(prompt):
    while True:
        try:
            cantidad = float(input(prompt))
            return cantidad
        except ValueError:
            print("Entrada invalida. Ingrese un monto numerico.")

def main_cajero():
    saldo = 1000.0
    while True:
        print("\n--- Menu Cajero ---")
        print("1. Consultar Saldo")
        print("2. Depositar Dinero")
        print("3. Retirar Dinero")
        print("4. Salir")

        opcion = input("Seleccione una opcion (1-4): ").strip()
        if opcion == "1":
            print(f"Saldo actual: S/.{saldo:.2f}")
        elif opcion == "2":
            dep = leer_monto("Monto a depositar: S/.")
            if dep > 0:
                saldo += dep
                print(f"Deposito exitoso. Nuevo saldo: S/.{saldo:.2f}")
            else:
                print("Monto invalido. Debe ser mayor que cero.")
        elif opcion == "3":
            ret = leer_monto("Monto a retirar: S/.")
            if ret <= 0:
                print("Monto invalido. Debe ser mayor que cero.")
            elif ret > saldo:
                print("Fondos insuficientes.")
            else:
                saldo -= ret
                print(f"Retiro exitoso. Nuevo saldo: S/.{saldo:.2f}")
        elif opcion == "4":
            print("Gracias por usar el cajero. Hasta luego.")
            break
        else:
            print("Opcion no valida. Ingrese 1, 2, 3 o 4.")

if __name__ == "__main__":
    main_cajero()
```
**Explicación:**
Este programa interactivo permite consultar saldo, depositar y retirar dinero, validando los montos y mostrando un menú repetitivo. Para pruebas unitarias, la lógica se encapsuló en una clase con métodos independientes.

**Nota:**
- Para ejecutar las pruebas de Java, asegúrate de estar en la carpeta raíz del proyecto y que los JARs estén presentes.
- Para Python, asegúrate de tener el archivo `__init__.py` en la carpeta de pruebas.
