
---

## Resolución del Cuestionario

### 1. ¿Qué rol cumplen las anotaciones en JUnit como @BeforeEach, @Test, @DisplayName, y cómo se comparan con los métodos especiales setUp() y tearDown() en unittest de Python?
Las anotaciones en JUnit indican cómo y cuándo ejecutar métodos de prueba. `@Test` marca un método como caso de prueba, `@BeforeEach` ejecuta código antes de cada test, y `@DisplayName` permite dar nombres descriptivos a los tests. En Python, `setUp()` y `tearDown()` cumplen funciones similares a `@BeforeEach` y `@AfterEach`, ejecutándose antes y después de cada método de prueba respectivamente.

### 2. Investiga el uso de "matchers" con la librería Hamcrest en JUnit: ¿qué ventajas aporta frente a los métodos de aserción tradicionales? ¿Existe un enfoque equivalente en unittest o en otras librerías de Python como pytest?
Hamcrest permite escribir aserciones más expresivas y legibles usando "matchers" como `is()`, `equalTo()`, `not()`, etc. Esto facilita entender el propósito de la prueba y mejora los mensajes de error. En Python, `unittest` tiene aserciones tradicionales, pero librerías como `pytest` permiten usar expresiones más legibles y plugins similares a Hamcrest (`pytest-hamcrest`).

### 3. ¿Cómo se pueden estructurar pruebas unitarias reutilizables que capturen datos de entrada externos (por ejemplo, archivos CSV o JSON) en JUnit y en unittest? ¿Qué patrón de diseño se recomienda aplicar en ambos casos?
Se pueden usar métodos parametrizados o cargar datos desde archivos externos en los métodos de prueba. En JUnit, se puede usar `@ParameterizedTest` (JUnit 5) o leer archivos en el método de prueba. En Python, se pueden usar `@ddt` o cargar datos en `setUp()`. El patrón recomendado es el de "Data-Driven Testing".

### 4. En el contexto de un sistema con interfaz gráfica o entrada de usuario, ¿cómo se puede integrar el uso de pruebas unitarias con mocks y stubs utilizando JUnit (por ejemplo, con Mockito) y unittest (por ejemplo, con unittest.mock)?
En JUnit se puede usar Mockito para crear mocks y stubs de objetos o dependencias, permitiendo simular comportamientos y aislar la unidad bajo prueba. En Python, `unittest.mock` permite crear objetos simulados y controlar su comportamiento durante la prueba.

---
## Conclusión

La práctica permitió comprender y aplicar pruebas unitarias en Java y Python, usando frameworks modernos y buenas prácticas. Las pruebas automatizadas facilitan la detección temprana de errores y mejoran la calidad del software. Considero que dominar estas herramientas es fundamental para el desarrollo profesional y la entrega de software confiable.
