package com.speedfast.app;

import com.speedfast.model.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Clase principal que demuestra la ejecucion concurrente de repartidores
 * usando Thread, Runnable y ExecutorService en SpeedFast.
 * 
 * Simula un entorno multitarea donde varios repartidores procesan
 * sus pedidos de forma simultanea, cada uno como un hilo independiente.
 * 
 * @author Fuad Onate
 * @version 1.0 - Semana 4 DOO II (Concurrencia con Hilos)
 */
public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("================================================================");
        System.out.println("     SPEEDFAST - Simulacion de Entregas Concurrentes           ");
        System.out.println("     Desarrollo Orientado a Objetos II - Semana 4              ");
        System.out.println("     Ejecutando Tareas en Paralelo con Hilos en Java           ");
        System.out.println("================================================================");
        
        // ==============================================================
        // PARTE 1: Creacion de pedidos variados
        // ==============================================================
        System.out.println("\n>>> PARTE 1: Creacion de Pedidos");
        System.out.println("----------------------------------------------------------------");
        
        // Pedidos para Repartidor 1 (Carlos)
        PedidoComida pc1 = new PedidoComida(101, "Av. Providencia 1234", 4.5, "Sushi");
        PedidoExpress pe1 = new PedidoExpress(102, "Los Leones 567", 3.0, true);
        PedidoEncomienda pen1 = new PedidoEncomienda(103, "Vitacura 890", 7.0, 2.5);
        
        // Pedidos para Repartidor 2 (Maria)
        PedidoComida pc2 = new PedidoComida(201, "Las Condes 456", 6.0, "Pizza");
        PedidoEncomienda pen2 = new PedidoEncomienda(202, "Apoquindo 789", 10.0, 5.0);
        
        // Pedidos para Repartidor 3 (Pedro)
        PedidoExpress pe2 = new PedidoExpress(301, "Tobalaba 321", 2.0, false);
        PedidoComida pc3 = new PedidoComida(302, "Ossa 654", 8.0, "Hamburguesa");
        PedidoEncomienda pen3 = new PedidoEncomienda(303, "Irarrazazaval 987", 12.0, 3.0);
        
        System.out.println("Se crearon 8 pedidos de diferentes tipos.");
        
        // ==============================================================
        // PARTE 2: Creacion de repartidores y asignacion de pedidos
        // ==============================================================
        System.out.println("\n>>> PARTE 2: Creacion de Repartidores y Asignacion");
        System.out.println("----------------------------------------------------------------");
        
        // Repartidor 1: Carlos - 3 pedidos
        Repartidor rep1 = new Repartidor("Carlos");
        rep1.agregarPedido(pc1);
        rep1.agregarPedido(pe1);
        rep1.agregarPedido(pen1);
        System.out.println("Repartidor Carlos: 3 pedidos asignados (Comida, Express, Encomienda)");
        
        // Repartidor 2: Maria - 2 pedidos
        Repartidor rep2 = new Repartidor("Maria");
        rep2.agregarPedido(pc2);
        rep2.agregarPedido(pen2);
        System.out.println("Repartidor Maria: 2 pedidos asignados (Comida, Encomienda)");
        
        // Repartidor 3: Pedro - 3 pedidos
        Repartidor rep3 = new Repartidor("Pedro");
        rep3.agregarPedido(pe2);
        rep3.agregarPedido(pc3);
        rep3.agregarPedido(pen3);
        System.out.println("Repartidor Pedro: 3 pedidos asignados (Express, Comida, Encomienda)");
        
        // ==============================================================
        // PARTE 3: Ejecucion concurrente con ExecutorService
        // ==============================================================
        System.out.println("\n>>> PARTE 3: Ejecucion Concurrente con ExecutorService");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Iniciando pool de hilos con 3 repartidores...");
        System.out.println("Cada repartidor es un hilo independiente (Runnable).");
        System.out.println("Los pedidos se procesan en paralelo.\n");
        
        // Crear ExecutorService con pool fijo de 3 hilos
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        try {
            // Ejecutar los 3 repartidores como hilos concurrentes
            executor.execute(rep1);
            executor.execute(rep2);
            executor.execute(rep3);
            
            // No aceptar mas tareas
            executor.shutdown();
            
            // Esperar a que todos los repartidores terminen (maximo 60 segundos)
            boolean terminaron = executor.awaitTermination(60, TimeUnit.SECONDS);
            
            if (terminaron) {
                System.out.println("\n================================================================");
                System.out.println("     TODAS LAS ENTREGAS FUERON COMPLETADAS                    ");
                System.out.println("================================================================");
            } else {
                System.out.println("\nADVERTENCIA: Tiempo de espera agotado. Algunas entregas pendientes.");
                executor.shutdownNow();
            }
            
        } catch (InterruptedException e) {
            System.out.println("ERROR: La simulacion fue interrumpida.");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.out.println("ERROR inesperado: " + e.getMessage());
            executor.shutdownNow();
        }
        
        // ==============================================================
        // PARTE 4: Resumen final de entregas
        // ==============================================================
        System.out.println("\n>>> PARTE 4: Resumen Final de Entregas");
        System.out.println("----------------------------------------------------------------");
        
        System.out.println("+----------------+----------+----------+");
        System.out.println("| Repartidor     | Pedidos  | Entregas |");
        System.out.println("+----------------+----------+----------+");
        System.out.printf("| %-14s | %8d | %8d |\n", 
            rep1.getNombre(), rep1.getPedidosAsignados().size(), rep1.getEntregasCompletadas());
        System.out.printf("| %-14s | %8d | %8d |\n", 
            rep2.getNombre(), rep2.getPedidosAsignados().size(), rep2.getEntregasCompletadas());
        System.out.printf("| %-14s | %8d | %8d |\n", 
            rep3.getNombre(), rep3.getPedidosAsignados().size(), rep3.getEntregasCompletadas());
        System.out.println("+----------------+----------+----------+");
        
        int totalPedidos = rep1.getPedidosAsignados().size() 
            + rep2.getPedidosAsignados().size() 
            + rep3.getPedidosAsignados().size();
        int totalEntregas = rep1.getEntregasCompletadas() 
            + rep2.getEntregasCompletadas() 
            + rep3.getEntregasCompletadas();
        
        System.out.println("Total: " + totalEntregas + "/" + totalPedidos + " entregas completadas");
        
        // ==============================================================
        // PARTE 5: Historial de pedidos (Interface Rastreable)
        // ==============================================================
        System.out.println("\n>>> PARTE 5: Historial de Pedidos (Interface Rastreable)");
        System.out.println("----------------------------------------------------------------");
        
        // Mostrar historial de un pedido de cada repartidor
        System.out.println(pc1.verHistorial());
        System.out.println(pc2.verHistorial());
        System.out.println(pe2.verHistorial());
        
        System.out.println("================================================================");
        System.out.println("       Fin de la simulacion SpeedFast S4 - Concurrencia         ");
        System.out.println("================================================================");
    }
}
