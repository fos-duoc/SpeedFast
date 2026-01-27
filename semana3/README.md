# SpeedFast - Sistema Integral de Gestión de Entregas

## Desarrollo Orientado a Objetos II - Semana 3

**Actividad Sumativa 1:** Diseñando un sistema orientado a objetos con clases abstractas, polimorfismo e interfaces

**Autor:** Fuad Oñate

---

## Descripción

Sistema integral para SpeedFast que integra los tres pilares de la POO avanzada:

- **Polimorfismo:** Sobrecarga y sobrescritura de métodos
- **Abstracción:** Clase abstracta con métodos implementados y abstractos
- **Interfaces:** Desacoplamiento de responsabilidades (Despachable, Cancelable, Rastreable)

## Estructura del Proyecto

```
semana3/
├── src/main/java/com/speedfast/
│   ├── model/
│   │   ├── Pedido.java             ← Clase abstracta base
│   │   ├── PedidoComida.java       ← Subclase (15 min + 2 min/km)
│   │   ├── PedidoEncomienda.java   ← Subclase (20 min + 1.5 min/km)
│   │   └── PedidoExpress.java      ← Subclase (10 min + 5 si >5km)
│   ├── interfaces/
│   │   ├── Despachable.java        ← Interface despachar()
│   │   ├── Cancelable.java         ← Interface cancelar()
│   │   └── Rastreable.java         ← Interface verHistorial()
│   ├── controller/
│   │   └── ControladorEnvios.java  ← Gestión centralizada
│   └── app/
│       └── Main.java               ← Demostración completa
└── README.md
```

## Jerarquía de Clases

```
                    <<interface>>         <<interface>>         <<interface>>
                    Despachable           Cancelable            Rastreable
                    +despachar()          +cancelar()           +verHistorial()
                         △                     △                     △
                         │                     │                     │
                         └─────────────────────┼─────────────────────┘
                                               │
                              +----------------+----------------+
                              |                                 |
                    +---------+---------+            +----------+----------+
                    |      Pedido       |            | ControladorEnvios   |
                    |    <<abstract>>   |            +---------------------+
                    +-------------------+            | - pedidosRegistrados|
                    | - idPedido        |            | - historialEntregas |
                    | - direccionEntrega|            +---------------------+
                    | - distanciaKm     |            | + registrarPedido() |
                    | - repartidor      |            | + despacharPedido() |
                    | - estado          |            | + cancelarPedido()  |
                    | - historial       |            | + verHistorial()    |
                    +-------------------+            +---------------------+
                    | + mostrarResumen()|
                    | + asignarRepartidor()|        ← sobrecarga
                    | + asignarRepartidor(String)|  ← sobrecarga
                    | + calcularTiempoEntrega()|   ← ABSTRACTO
                    | + despachar()     |
                    | + cancelar()      |
                    | + verHistorial()  |
                    +---------+---------+
                              △
           ┌──────────────────┼──────────────────┐
           │                  │                  │
+----------+-------+ +--------+--------+ +-------+---------+
|  PedidoComida    | | PedidoEncomienda| |  PedidoExpress  |
+------------------+ +-----------------+ +-----------------+
| - tipoComida     | | - pesoKg        | | - esUrgente     |
+------------------+ | - requiereEmbal.| +-----------------+
| @Override        | +-----------------+ | @Override       |
| asignarRepartidor| | @Override       | | asignarRepartidor|
| calcularTiempo   | | asignarRepartidor| | calcularTiempo |
| 15 + 2*km        | | calcularTiempo  | | 10 (+5 si >5km)|
+------------------+ | 20 + 1.5*km     | +-----------------+
                     +-----------------+
```

## Interfaces Implementadas

| Interface | Método | Propósito |
|-----------|--------|-----------|
| **Despachable** | `despachar()` | Envía el pedido al destino |
| **Cancelable** | `cancelar()` | Cancela el pedido |
| **Rastreable** | `verHistorial()` | Muestra historial de estados |

## Fórmulas de Cálculo de Tiempo

| Tipo de Pedido | Fórmula | Ejemplo (8 km) |
|----------------|---------|----------------|
| **Comida** | 15 min + 2 min × km | 15 + 16 = 31 min |
| **Encomienda** | 20 min + 1.5 min × km | 20 + 12 = 32 min |
| **Express** | 10 min (+5 si > 5 km) | 10 + 5 = 15 min |

## Funcionalidades del Main

1. ✅ Creación de pedidos diferenciados
2. ✅ Asignación automática de repartidores (sobrescritura)
3. ✅ Asignación manual de repartidores (sobrecarga)
4. ✅ Cálculo de tiempos de entrega (método abstracto)
5. ✅ Tabla comparativa de tiempos
6. ✅ Despacho de pedidos (interface Despachable)
7. ✅ Cancelación de pedidos (interface Cancelable)
8. ✅ Historial de pedido (interface Rastreable)
9. ✅ Historial global de entregas

## Cómo Ejecutar

1. Abrir el proyecto en IntelliJ IDEA o Apache NetBeans
2. Ejecutar la clase `Main.java` ubicada en `com.speedfast.app`
3. Observar la salida en consola con todas las demostraciones

## Conceptos Aplicados

| Concepto | Implementación |
|----------|----------------|
| Herencia | Subclases extienden `Pedido` |
| Encapsulamiento | Atributos protected + getters |
| Polimorfismo | Arreglo `Pedido[]` con objetos de subclases |
| Sobrescritura | `@Override` en `asignarRepartidor()` |
| Sobrecarga | `asignarRepartidor(String nombre)` |
| Abstracción | Clase abstracta + método `calcularTiempoEntrega()` |
| Interfaces | `Despachable`, `Cancelable`, `Rastreable` |
| Desacoplamiento | Responsabilidades separadas por interfaces |

## Repositorio GitHub

[https://github.com/fos-duoc/SpeedFast](https://github.com/fos-duoc/SpeedFast)
