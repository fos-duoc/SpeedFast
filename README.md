# SpeedFast - Sistema de Asignación de Repartidores

## Desarrollo Orientado a Objetos II - Semana 1
**Actividad Formativa 1:** Explorando la sobrecarga y sobrescritura en clases derivadas

**Autor:** Fuad Oñate

---

## Descripción

Sistema para SpeedFast, empresa de reparto a domicilio que implementa polimorfismo mediante:
- **Sobrescritura (Override):** Método `asignarRepartidor()` personalizado en cada subclase
- **Sobrecarga (Overload):** Método `asignarRepartidor(String nombreRepartidor)` con parámetro

## Jerarquía de Clases

```
Pedido (clase base)
├── PedidoComida      -> Requiere mochila térmica
├── PedidoEncomienda  -> Valida peso y embalaje
└── PedidoExpress     -> Asigna repartidor más cercano
```

## Estructura del Proyecto

```
SpeedFast/
├── src/main/java/com/speedfast/
│   ├── model/
│   │   ├── Pedido.java           (clase base)
│   │   ├── PedidoComida.java     (subclase)
│   │   ├── PedidoEncomienda.java (subclase)
│   │   └── PedidoExpress.java    (subclase)
│   └── app/
│       └── Main.java             (demostración)
├── SpeedFast.iml
└── README.md
```

## Instrucciones de Ejecución

1. Abrir el proyecto en IntelliJ IDEA
2. Ejecutar la clase `Main.java` ubicada en `com.speedfast.app`
3. Observar la salida en consola que demuestra:
   - Sobrescritura con lógica diferenciada por tipo
   - Sobrecarga con nombre de repartidor
   - Polimorfismo con arreglo de tipo Pedido

## Conceptos Aplicados

| Concepto | Implementación |
|----------|----------------|
| Herencia | Subclases extienden de `Pedido` |
| Encapsulamiento | Atributos privados/protected + getters/setters |
| Sobrescritura | `@Override` en `asignarRepartidor()` |
| Sobrecarga | `asignarRepartidor(String nombre)` |
| Polimorfismo | Arreglo `Pedido[]` con objetos de subclases |

## Repositorio GitHub

[Enlace al repositorio](https://github.com/FuadOonate/SpeedFast)
