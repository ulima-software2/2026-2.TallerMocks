# Sistema de Ventas de Videojuegos (Ejemplo Mocks)

Este proyecto es una simulación de un sistema de ventas de una empresa de videojuegos, desarrollado en Java utilizando Maven. Implementa un CRUD básico para gestionar videojuegos y un servicio de ventas con lógica de negocio.

## Estructura del Proyecto

*   **`model`**: Contiene la clase `VideoGame` que representa la entidad del juego (ID, título, plataforma, precio, stock).
*   **`repository`**: Define la interfaz `VideoGameRepository` y su implementación en memoria `InMemoryVideoGameRepository`.
*   **`service`**: Contiene `SalesService`, que maneja la lógica de procesamiento de ventas (verificando stock y actualizando el repositorio).
*   **`Main`**: Clase principal que demuestra el funcionamiento del CRUD y la simulación de ventas.

## Requisitos

*   Java 17 o superior.
*   Maven.

## Cómo Ejecutar el Proyecto

Para compilar y ejecutar la demostración del sistema, utiliza el siguiente comando en la raíz del proyecto:

```bash
mvn compile exec:java -Dexec.mainClass="pe.edu.ulima.is2.Main"
```

## Cómo Ejecutar las Pruebas

El proyecto incluye pruebas unitarias para el `SalesService` utilizando **JUnit 5** y **Mockito** para simular el comportamiento del repositorio.

Para ejecutar las pruebas:

```bash
mvn test
```

## Funcionalidades Demostradas

1.  **CRUD**: Creación, lectura, actualización y eliminación de videojuegos.
2.  **Validación de Stock**: El sistema impide realizar ventas si no hay suficiente stock disponible.
3.  **Cálculo de Precios**: Calcula el total de la venta basado en el precio unitario y la cantidad.
4.  **Mocks**: Uso de Mockito en las pruebas para aislar la lógica del servicio de la persistencia.
