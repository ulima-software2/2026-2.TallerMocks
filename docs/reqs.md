# Software Requirements Specification (SRS) - Sistema de Ventas de Videojuegos

## 1. Introducción
Este documento describe los requerimientos funcionales para la simulación del sistema de ventas de videojuegos. El objetivo es proporcionar una plataforma básica para la gestión de inventario y procesamiento de transacciones.

## 2. Requerimientos Funcionales

### RF-01: Gestión de Videojuegos (CRUD)
El sistema debe permitir realizar las operaciones básicas de administración sobre el catálogo de videojuegos.

*   **RF-01.1: Registrar Videojuego:** El sistema debe permitir la creación de nuevos registros de videojuegos con título, plataforma, precio y stock inicial.
*   **RF-01.2: Consultar Catálogo:** El sistema debe permitir visualizar la lista completa de videojuegos registrados.
*   **RF-01.3: Buscar Videojuego:** El sistema debe permitir la búsqueda de un videojuego específico mediante su identificador único (ID).
*   **RF-01.4: Actualizar Videojuego:** El sistema debe permitir la modificación de los datos de un videojuego existente (ej. cambio de precio o stock).
*   **RF-01.5: Eliminar Videojuego:** El sistema debe permitir la eliminación de un videojuego del catálogo por su ID.

### RF-02: Procesamiento de Ventas
El sistema debe gestionar las transacciones de venta de videojuegos.

*   **RF-02.1: Validar Stock:** Antes de procesar una venta, el sistema debe verificar que existe stock suficiente para la cantidad solicitada.
*   **RF-02.2: Calcular Total:** El sistema debe calcular el monto total de la venta multiplicando el precio unitario por la cantidad vendida.
*   **RF-02.3: Actualizar Inventario:** Tras una venta exitosa, el sistema debe disminuir el stock del videojuego vendido de forma automática.
*   **RF-02.4: Manejo de Errores de Venta:** El sistema debe lanzar una excepción o mensaje de error si el videojuego no existe o si el stock es insuficiente.

## 3. Requerimientos No Funcionales

*   **RNF-01: Persistencia en Memoria:** Por simplicidad, los datos se mantendrán en memoria durante la ejecución del programa.
*   **RNF-02: Pruebas Unitarias:** La lógica de negocio del servicio de ventas debe estar validada mediante pruebas automatizadas con mocks.
