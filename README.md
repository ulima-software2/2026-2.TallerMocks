# Sistema de Ventas de Videojuegos (Ejemplo Mocks)

Este proyecto es una simulación de un sistema de ventas de una empresa de videojuegos, desarrollado en Java utilizando Maven. Implementa un CRUD básico para gestionar videojuegos y un servicio de ventas con lógica de negocio.

## Estructura del Proyecto

*   **`model`**: Contiene la clase `VideoGame` que representa la entidad del juego (ID, título, plataforma, precio, stock).
*   **`repository`**: Define la interfaz `VideoGameRepository` y su implementación en memoria `InMemoryVideoGameRepository`.
*   **`service`**: Contiene `SalesService`, que maneja la lógica de procesamiento de ventas (verificando stock y actualizando el repositorio).
*   **`Main`**: Clase principal que demuestra el funcionamiento del CRUD y la simulación de ventas.

## Requisitos

*   Java 17 o superior (probado con Java 25).
*   Maven 3.9 o superior.

## Cómo Ejecutar el Proyecto

Para compilar y ejecutar la demostración del sistema, utiliza el siguiente comando en la raíz del proyecto:

```bash
mvn compile exec:java -Dexec.mainClass="pe.edu.ulima.is2.Main"
```

## Cómo Ejecutar las Pruebas

El proyecto está preparado para escribir pruebas unitarias con **JUnit 5** y **Mockito** (para simular el repositorio y aislar la lógica de `SalesService`). Las pruebas deben ubicarse en `src/test/java`, siguiendo el mismo paquete de la clase a probar (por ejemplo, `src/test/java/pe/edu/ulima/is2/service/SalesServiceTest.java`).

Para ejecutar las pruebas:

```bash
mvn test
```

## Pruebas de Mutación (PIT)

El proyecto está configurado con [PIT (pitest)](https://pitest.org/) para evaluar la calidad de las pruebas. PIT introduce pequeños cambios (*mutantes*) en el código fuente —por ejemplo, cambiar `<` por `<=` o `*` por `/`— y vuelve a ejecutar las pruebas. Si alguna prueba falla, el mutante queda **eliminado** (*killed*); si todas pasan, el mutante **sobrevive** (*survived*), lo que indica que las pruebas no detectan ese cambio.

Para ejecutar el análisis de mutación:

```bash
mvn test-compile org.pitest:pitest-maven:mutationCoverage
```

> Se requiere al menos una prueba en `src/test/java`; sin pruebas, PIT no tiene nada que evaluar.

El reporte se genera en `target/pit-reports/index.html` (también en XML en la misma carpeta). Ahí se muestra, por clase y por línea, qué mutantes fueron eliminados y cuáles sobrevivieron.

Estados más comunes en el reporte:

| Estado | Significado |
|---|---|
| `KILLED` | Alguna prueba detectó el mutante. |
| `SURVIVED` | Ninguna prueba falló: falta una aserción o un caso de prueba. |
| `NO_COVERAGE` | Ninguna prueba ejecuta esa línea. |
| `TIMED_OUT` | El mutante provocó un bucle infinito o demasiado lento (se cuenta como eliminado). |

Configuración (en `pom.xml`):

*   Plugin `pitest-maven` con `pitest-junit5-plugin` para soporte de JUnit 5.
*   Clases mutadas y pruebas: paquete `pe.edu.ulima.is2.*`.
*   Se excluye la clase `Main` del análisis.
*   Mutadores: conjunto `DEFAULTS`.

## Funcionalidades Demostradas

1.  **CRUD**: Creación, lectura, actualización y eliminación de videojuegos.
2.  **Validación de Stock**: El sistema impide realizar ventas si no hay suficiente stock disponible.
3.  **Cálculo de Precios**: Calcula el total de la venta basado en el precio unitario y la cantidad.
4.  **Mocks**: Uso de Mockito en las pruebas para aislar la lógica del servicio de la persistencia.
