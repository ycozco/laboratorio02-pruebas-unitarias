# Informe de Pruebas Unitarias - Laboratorio 02

**Autor:** Yoset Cozco Mauri  
**Fecha:** 17/05/2025

---

## Pruebas en Java

### 1. Área de un Rectángulo
- **Archivo:** `src/Rectangulo.java`
- **Descripción:** Clase con método estático `area(base, altura)` que retorna el área de un rectángulo.
- **Pruebas:**
  - **Archivo:** `tests/RectanguloTest.java`
  - Se prueban casos con valores positivos, cero y decimales usando JUnit y Hamcrest (`assertThat`).
  - **Ejemplo de prueba:**
    ```java
    assertThat(Rectangulo.area(5, 3), is(15.0));
    assertThat(Rectangulo.area(0, 10), is(0.0));
    assertThat(Rectangulo.area(2.5, 4), is(10.0));
    ```

### 2. Identificador de Números Pares e Impares
- **Archivo:** `src/ParImpar.java`
- **Descripción:** Clase con método estático `identificar(List<Integer>)` que retorna una lista de "Par" o "Impar" según corresponda.
- **Pruebas:**
  - **Archivo:** `tests/ParImparTest.java`
  - Se prueban listas mixtas, solo pares y solo impares.
  - **Ejemplo de prueba:**
    ```java
    assertThat(ParImpar.identificar(Arrays.asList(1,2,3,4,5)), is(Arrays.asList("Impar", "Par", "Impar", "Par", "Impar")));
    ```

### 3. Mini Simulador de Cajero Automático (ATM)
- **Archivo:** `src/CajeroAutomatico.java`
- **Descripción:** Clase con métodos para depositar, retirar y consultar saldo.
- **Pruebas:**
  - **Archivo:** `tests/CajeroAutomaticoTest.java`
  - Se prueban depósitos válidos e inválidos, retiros válidos, retiros mayores al saldo y retiros negativos.
  - **Ejemplo de prueba:**
    ```java
    CajeroAutomatico cajero = new CajeroAutomatico(100);
    assertThat(cajero.depositar(50), is(true));
    assertThat(cajero.consultarSaldo(), is(150.0));
    assertThat(cajero.depositar(-10), is(false));
    ```

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
- **Archivo:** `python_tests/test_rectangulo.py`
- **Descripción:** Clase `Rectangulo` con método estático `area(base, altura)`.
- **Pruebas:**
  - Se prueban áreas con valores positivos, cero y decimales usando `unittest`.

### 2. Identificador de Números Pares e Impares
- **Archivo:** `python_tests/test_parimpar.py`
- **Descripción:** Clase `ParImpar` con método estático `identificar(lista)`.
- **Pruebas:**
  - Se prueban listas mixtas, solo pares y solo impares.

### 3. Mini Simulador de Cajero Automático (ATM)
- **Archivo:** `python_tests/test_cajero.py`
- **Descripción:** Clase `CajeroAutomatico` con métodos para depositar, retirar y consultar saldo.
- **Pruebas:**
  - Se prueban depósitos válidos e inválidos, retiros válidos, retiros mayores al saldo y retiros negativos.

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
