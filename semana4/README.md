# SpeedFast - Semana 4: Ejecutando Tareas en Paralelo con Hilos en Java

Desarrollo Orientado a Objetos II - Experiencia 2

**Autor:** Fuad Onate

---

## Descripcion

Simulacion de entregas concurrentes en SpeedFast utilizando programacion multihilo.
Cada repartidor funciona como un hilo independiente que procesa sus pedidos de forma simultanea,
usando Thread, Runnable y ExecutorService.

## Estructura del Proyecto

```
semana4/
├── src/main/java/com/speedfast/
│   ├── model/
│   │   ├── Pedido.java             <- Clase abstracta base (implementa 3 interfaces)
│   │   ├── PedidoComida.java       <- Subclase (15 min + 2 min/km)
│   │   ├── PedidoEncomienda.java   <- Subclase (20 min + 1.5 min/km)
│   │   ├── PedidoExpress.java      <- Subclase (10 min + 5 si >5km)
│   │   └── Repartidor.java         <- NUEVO: Implementa Runnable (hilo)
│   ├── interfaces/
│   │   ├── Despachable.java        <- Interface despachar()
│   │   ├── Cancelable.java         <- Interface cancelar()
│   │   └── Rastreable.java         <- Interface verHistorial()
│   └── app/
│       └── Main.java               <- ExecutorService + 3 repartidores concurrentes
└── README.md
```

## Funcionalidades Implementadas

1. Reutilizacion de clases abstractas, subclases e interfaces (S2-S3)
2. Clase Repartidor implementando Runnable con lista de pedidos
3. Ejecucion concurrente con ExecutorService (pool de 3 hilos)
4. Simulacion de entregas con Thread.sleep() y valores aleatorios
5. Manejo de excepciones (InterruptedException + Exception general)
6. Mensajes de avance en consola con nombre de Thread
7. Resumen final con tabla de entregas por repartidor
8. Historial de pedidos (Interface Rastreable)

## Conceptos Aplicados

| Concepto | Implementacion |
|----------|----------------|
| Runnable | Clase Repartidor implementa Runnable con run() |
| Thread.sleep() | Simula tiempo de entrega con valores aleatorios |
| ExecutorService | Pool fijo de 3 hilos para ejecucion paralela |
| shutdown/awaitTermination | Control de finalizacion del pool |
| InterruptedException | Manejo de interrupciones en hilos |
| Herencia | Subclases extienden Pedido abstracto |
| Interfaces | Despachable, Cancelable, Rastreable |
| Polimorfismo | Lista de Pedido con objetos de subclases |

## Como Ejecutar

1. Abrir el proyecto en IntelliJ IDEA o Apache NetBeans
2. Ejecutar la clase `Main.java` ubicada en `com.speedfast.app`
3. Observar la salida concurrente en consola

## Testeo Imagenes Build y Run

<img width="1443" height="1095" alt="SpeedFast4_test_build" src="https://github.com/user-attachments/assets/75722976-1813-439a-a937-0c4a6f1582fa" />
<img width="1434" height="1111" alt="SpeedFast4_test" src="https://github.com/user-attachments/assets/2695d324-1b06-41b1-9e9f-847fbdd12e73" />
<img width="1442" height="1381" alt="SpeedFast4_test_2" src="https://github.com/user-attachments/assets/fb37a029-4d8c-48aa-8641-27debdf26a8b" />
<img width="1448" height="1379" alt="SpeedFast4_test_3" src="https://github.com/user-attachments/assets/87f7ac9c-e470-4aa5-b867-073eeb735f34" />


## Repositorio GitHub

[https://github.com/fos-duoc/SpeedFast](https://github.com/fos-duoc/SpeedFast)
