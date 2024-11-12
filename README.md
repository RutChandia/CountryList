# Proyecto: Listado de Países

### Descripción
Esta aplicación Android consume la API pública de [TheSportsDB](https://www.thesportsdb.com/api/v1/json/3/all_countries.php) para mostrar una lista de países que comienzan con la letra "C". El objetivo de este proyecto es mostrar un diseño limpio de arquitectura, uso de patrones de diseño, y una interfaz de usuario intuitiva.

### Tecnologías Utilizadas
- **Kotlin**
- **Jetpack Compose**
- **Hilt (inyección de dependencias)**
- **Retrofit (consumo de API)**
- **SOLID y Clean Architecture**

### Arquitectura
La aplicación sigue el patrón **Clean Architecture** y **MVVM** para garantizar una separación clara de responsabilidades y facilitar la escalabilidad. Las principales capas incluyen:

- **Capa de Datos**: Maneja la conexión con la API y el procesamiento de datos.
- **Capa de Dominio**: Contiene los casos de uso, que aplican la lógica de negocio.
- **Capa de Presentación**: Compuesta por el `ViewModel` y la UI en **Jetpack Compose**.

### Funcionalidades
1. **Consumo de la API**: Realiza una solicitud GET para obtener la lista completa de países.
2. **Filtrado de Datos**: Filtra los países que comienzan con la letra "C".
3. **Interfaz de Usuario**: Muestra los países en una lista sencilla y permite reintentar la carga en caso de error.

### Decisiones Técnicas
Consideré usar Room para almacenar los datos de países, pero opté por `StateFlow` para cachear en memoria, dado el alcance de la prueba. Esta solución permite una integración sencilla de Room en el futuro, si se requiere persistencia offline.

### Propuesta de Mejoras
- **Persistencia Local**: Implementar Room para almacenar los datos de países, permitiendo acceso offline y mejorando la experiencia del usuario en conexiones intermitentes.

