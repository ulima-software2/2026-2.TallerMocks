# Especificación Semiformal de Operaciones

Este documento detalla el comportamiento esperado de las operaciones principales del sistema de ventas de videojuegos.

---

## 1. Repositorio de Videojuegos (`VideoGameRepository`)

### Operación: `save`
*   **Descripción:** Registra un nuevo videojuego o guarda cambios en uno existente.
*   **Inputs:** `VideoGame videoGame` (Objeto con los datos del juego).
*   **Precondiciones:** El objeto `videoGame` no debe ser nulo.
*   **Output:** `VideoGame` (El objeto guardado, incluyendo el ID generado si era nuevo).
*   **Postcondiciones:** El videojuego queda almacenado en la colección persistente (memoria).
*   **Errores:** No definidos explícitamente, pero puede fallar si la memoria está llena.

### Operación: `findById`
*   **Descripción:** Busca un videojuego por su identificador único.
*   **Inputs:** `Long id` (Identificador único).
*   **Precondiciones:** El `id` debe ser positivo.
*   **Output:** `Optional<VideoGame>` (Contiene el juego si se encuentra, de lo contrario está vacío).
*   **Postcondiciones:** Ninguna (Operación de solo lectura).
*   **Errores:** Ninguno.

### Operación: `findAll`
*   **Descripción:** Recupera todos los videojuegos registrados.
*   **Inputs:** Ninguno.
*   **Precondiciones:** Ninguna.
*   **Output:** `List<VideoGame>` (Lista de todos los juegos en el sistema).
*   **Postcondiciones:** Ninguna (Operación de solo lectura).
*   **Errores:** Ninguno.

### Operación: `update`
*   **Descripción:** Actualiza los datos de un videojuego existente.
*   **Inputs:** `VideoGame videoGame` (Objeto con los datos actualizados).
*   **Precondiciones:** El `id` del objeto `videoGame` debe existir en el repositorio.
*   **Output:** `VideoGame` (El objeto actualizado).
*   **Postcondiciones:** Los datos previos del videojuego con ese ID son reemplazados por los nuevos.
*   **Errores:** Lanza `RuntimeException` si el ID no se encuentra en el repositorio.

### Operación: `deleteById`
*   **Descripción:** Elimina un videojuego del sistema.
*   **Inputs:** `Long id` (Identificador único).
*   **Precondiciones:** Ninguna.
*   **Output:** Vacío (`void`).
*   **Postcondiciones:** El videojuego con el ID especificado ya no existe en el repositorio.
*   **Errores:** Ninguno (Si el ID no existe, simplemente no hace nada).

---

## 2. Servicio de Ventas (`SalesService`)

### Operación: `processSale`
*   **Descripción:** Procesa la venta de una cantidad de unidades de un videojuego.
*   **Inputs:** 
    *   `Long videoGameId`: ID del juego a vender.
    *   `Integer quantity`: Cantidad de unidades a vender.
*   **Precondiciones:** 
    *   `videoGameId` debe existir.
    *   `quantity` debe ser mayor a cero.
    *   El stock actual del juego debe ser mayor o igual a `quantity`.
*   **Output:** `Double` (Monto total de la venta).
*   **Postcondiciones:** 
    *   El stock del videojuego en el repositorio se reduce en `quantity` unidades.
*   **Errores:** 
    *   Lanza `RuntimeException("Game not found")` si el ID no existe.
    *   Lanza `RuntimeException("Insufficient stock...")` si no hay suficientes unidades.
