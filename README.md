
### Problema identificado

El código original presentaba dos problemas principales de diseño:

1. Cargaba todos los clientes en memoria utilizando listas.
2. Agrupaba campañas usando búsquedas lineales sobre listas.

Esto provocaba alto consumo de memoria y bajo rendimiento cuando el volumen de datos aumentaba.

### ¿Por qué cargar todos los clientes en memoria puede ser un problema?

Cuando un programa carga todos los registros del archivo CSV en memoria:

```java
List<Cliente> clientes = new ArrayList<>();
