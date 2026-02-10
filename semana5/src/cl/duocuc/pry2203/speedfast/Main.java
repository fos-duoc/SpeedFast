package cl.duocuc.pry2203.speedfast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Clase principal del sistema de entregas SpeedFast.
 * Demuestra concurrencia con multiples repartidores accediendo a una zona de carga compartida.
 *
 * Conceptos aplicados:
 * - Thread / Runnable
 * - ExecutorService (pool de hilos)
 * - BlockingQueue como mecanismo de sincronizacion
 * - Condiciones de carrera prevenidas con estructuras thread-safe
 * - Separacion de responsabilidades (POO)
 *
 * @author Fuad
 * @version 1.0 - Semana 5 - PRY2203
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=".repeat(70));
        System.out.println("  SPEEDFAST - Sistema de Coordinacion de Entregas Concurrente");
        System.out.println("  PRY2203 - POO II | Semana 5: Sincronizando procesos concurrentes");
        System.out.println("=".repeat(70));
        System.out.println();

        // --- Paso 1: Crear la zona de carga (recurso compartido) ---
        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        // --- Paso 2: Agregar 7 pedidos a la zona de carga ---
        String[] direcciones = {
            "Av. Providencia 1234, Santiago",
            "Calle Los Leones 567, Providencia",
            "Gran Avenida 890, San Miguel",
            "Av. Irarrazaval 321, Nunoa",
            "Paseo Ahumada 100, Santiago Centro",
            "Av. Concha y Toro 456, Puente Alto",
            "Camino El Alba 789, Las Condes"
        };

        System.out.println("[SISTEMA] Cargando pedidos en la zona de carga...");
        System.out.println("-".repeat(50));

        for (int i = 0; i < direcciones.length; i++) {
            zonaDeCarga.agregarPedido(new Pedido(i + 1, direcciones[i]));
        }

        System.out.println("-".repeat(50));
        System.out.println("[SISTEMA] Total pedidos cargados: " + zonaDeCarga.cantidadPedidos());
        System.out.println();

        // --- Paso 3: Crear 3 repartidores ---
        Repartidor rep1 = new Repartidor("Carlos", zonaDeCarga);
        Repartidor rep2 = new Repartidor("Maria", zonaDeCarga);
        Repartidor rep3 = new Repartidor("Diego", zonaDeCarga);

        // --- Paso 4: Ejecutar con ExecutorService (pool de 3 hilos) ---
        System.out.println("[SISTEMA] Iniciando repartidores con ExecutorService...");
        System.out.println("=".repeat(70));
        System.out.println();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(rep1);
        executor.submit(rep2);
        executor.submit(rep3);

        // No aceptar mas tareas
        executor.shutdown();

        // --- Paso 5: Esperar finalizacion con timeout ---
        try {
            boolean terminado = executor.awaitTermination(60, TimeUnit.SECONDS);
            System.out.println();
            System.out.println("=".repeat(70));

            if (terminado) {
                System.out.println("[SISTEMA] Todos los repartidores finalizaron correctamente.");
            } else {
                System.out.println("[SISTEMA] ADVERTENCIA: Timeout alcanzado. Forzando cierre...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println("[SISTEMA] Error al esperar finalizacion: " + e.getMessage());
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        // --- Paso 6: Resumen final ---
        System.out.println();
        System.out.println("-".repeat(50));
        System.out.println("  RESUMEN DE ENTREGAS");
        System.out.println("-".repeat(50));
        System.out.println("  " + rep1.getNombre() + ": " + rep1.getEntregasRealizadas() + " entregas");
        System.out.println("  " + rep2.getNombre() + ": " + rep2.getEntregasRealizadas() + " entregas");
        System.out.println("  " + rep3.getNombre() + ": " + rep3.getEntregasRealizadas() + " entregas");
        int totalEntregas = rep1.getEntregasRealizadas() + rep2.getEntregasRealizadas() + rep3.getEntregasRealizadas();
        System.out.println("-".repeat(50));
        System.out.println("  TOTAL: " + totalEntregas + " pedidos entregados");
        System.out.println("  Pedidos restantes en zona de carga: " + zonaDeCarga.cantidadPedidos());
        System.out.println("=".repeat(70));
    }
}
