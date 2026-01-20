# SpeedFast - Sistema de Cálculo de Tiempos de Entrega

## Desarrollo Orientado a Objetos II - Semana 2
### Actividad Formativa: Definiendo una clase abstracta y su jerarquía

---

## Descripción

Sistema de gestión de pedidos para la empresa SpeedFast que demuestra el uso de **clases abstractas** y **jerarquías de herencia** en Java. El proyecto modela diferentes tipos de pedidos, cada uno con su propia lógica de cálculo de tiempo de entrega.

## Estructura del Proyecto

```
SpeedFast/
├── src/main/java/com/speedfast/
│   ├── model/
│   │   ├── Pedido.java           ← Clase abstracta base
│   │   ├── PedidoComida.java     ← Subclase: 15 min + 2 min/km
│   │   ├── PedidoEncomienda.java ← Subclase: 20 min + 1.5 min/km
│   │   └── PedidoExpress.java    ← Subclase: 10 min (+5 si >5km)
│   └── app/
│       └── Main.java             ← Demostración de la jerarquía
└── README.md
```

## Jerarquía de Clases

```
           +------------------+
           |     Pedido       |  ← CLASE ABSTRACTA
           |------------------|
           | - idPedido       |
           | - direccionEntrega|
           | - distanciaKm    |
           |------------------|
           | + mostrarResumen()|  ← Método implementado
           | + calcularTiempoEntrega()| ← Método ABSTRACTO
           +------------------+
                    △
                    |
       +------------+------------+
       |            |            |
+------+------+ +---+---+ +------+------+
|PedidoComida | |Pedido | |PedidoExpress|
|             | |Encomi.| |             |
|-------------|----------|--------------| 
| tipoComida  | pesoKg   | esUrgente    |
|-------------|----------|--------------| 
| 15 + 2*km   | 20+1.5*km| 10 (+5 >5km) |
+-------------+----------+--------------+
```

## Fórmulas de Cálculo de Tiempo

| Tipo de Pedido | Fórmula | Ejemplo (8 km) |
|----------------|---------|----------------|
| **Comida** | 15 min + 2 min × km | 15 + 16 = 31 min |
| **Encomienda** | 20 min + 1.5 min × km (entero) | 20 + 12 = 32 min |
| **Express** | 10 min base (+5 min si > 5 km) | 10 + 5 = 15 min |

## Cómo Ejecutar

1. Abrir el proyecto en IntelliJ IDEA o NetBeans
2. Ejecutar la clase `Main.java` ubicada en `com.speedfast.app`
3. Observar la salida en consola que demuestra:
   - Creación de pedidos de cada tipo
   - Método `mostrarResumen()` heredado/sobrescrito
   - Método `calcularTiempoEntrega()` implementado en cada subclase
   - Tabla comparativa usando polimorfismo

## Conceptos Aplicados

| Concepto | Implementación |
|----------|----------------|
| **Clase Abstracta** | `Pedido` no puede instanciarse directamente |
| **Método Abstracto** | `calcularTiempoEntrega()` declarado sin cuerpo |
| **Herencia** | Subclases extienden de `Pedido` con `extends` |
| **Sobrescritura** | `@Override` en métodos de subclases |
| **Polimorfismo** | Arreglo `Pedido[]` con objetos de subclases |
| **Encapsulamiento** | Atributos protected + getters/setters |

## Repositorio GitHub

[Enlace al repositorio](https://github.com/fos-duoc/SpeedFast)

---

**Autor:** Fuad Oñate  
**Asignatura:** Desarrollo Orientado a Objetos II  
**Semana:** 2 - Experiencia 1  
**Fecha:** Enero 2026
