package com.speedfast.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase que representa un repartidor de SpeedFast.
 * Implementa Runnable para ejecutarse como hilo independiente.
 * Cada repartidor procesa su lista de pedidos de forma secuencial,
 * simulando tiempos de entrega con Thread.sleep() y valores aleatorios.
 * 
 * @author Fuad Onate
 * @version 1.0 - Semana 4 DOO II (Concurrencia con Hilos)
 */
public class Repartidor implements Runnable {
    
    // Atributos del repartidor
    private String nombre;
    private List<Pedido> pedidosAsignados;
    private int entregasCompletadas;
    private Random random;
    
    /**
     * Constructor de Repartidor.
     * @param nombre nombre del repartidor
     */
    public Repartidor(String nombre) {
        this.nombre = nombre;
        this.pedidosAsignados = new ArrayList<>();
        this.entregasCompletadas = 0;
        this.random = new Random();
    }
    
    /**
     * Agrega un pedido a la lista del repartidor.
     * @param pedido pedido a asignar
     */
    public void agregarPedido(Pedido pedido) {
        pedido.asignarRepartidor(this.nombre);
        this.pedidosAsignados.add(pedido);
    }
    
    /**
     * Metodo run() que ejecuta la entrega secuencial de pedidos.
     * Por cada pedido:
     *   1. Informa inicio de entrega
     *   2. Despacha el pedido (interface Despachable)
     *   3. Simula tiempo de entrega con Thread.sleep() aleatorio
     *   4. Marca como entregado
     *   5. Informa finalizacion
     * 
     * Incluye manejo de excepciones para InterruptedException.
     */
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        
        System.out.println("\n[" + threadName + "] >>> " + nombre 
            + " inicia su ruta con " + pedidosAsignados.size() + " pedidos");
        System.out.println("[" + threadName + "] -----------------------------------------");
        
        for (int i = 0; i < pedidosAsignados.size(); i++) {
            Pedido pedido = pedidosAsignados.get(i);
            
            try {
                // Informar inicio de entrega
                System.out.println("[" + threadName + "] " + nombre 
                    + " -> Iniciando entrega " + (i + 1) + "/" + pedidosAsignados.size()
                    + ": Pedido #" + pedido.getIdPedido() 
                    + " (" + pedido.getTipo() + ")");
                
                // Despachar pedido (interface Despachable)
                String resultadoDespacho = pedido.despachar();
                System.out.println("[" + threadName + "] " + nombre 
                    + " -> " + resultadoDespacho);
                
                // Simular tiempo de entrega con Thread.sleep() aleatorio
                // Entre 1000ms (1 seg) y 3000ms (3 seg) para simular entregas
                int tiempoSimulado = 1000 + random.nextInt(2001);
                System.out.println("[" + threadName + "] " + nombre 
                    + " -> Entregando a " + pedido.getDireccionEntrega() 
                    + " (" + pedido.getDistanciaKm() + " km) - Tiempo simulado: " 
                    + tiempoSimulado + "ms");
                
                Thread.sleep(tiempoSimulado);
                
                // Marcar como entregado
                pedido.marcarEntregado();
                entregasCompletadas++;
                
                System.out.println("[" + threadName + "] " + nombre 
                    + " -> ENTREGADO Pedido #" + pedido.getIdPedido() 
                    + " | Tiempo estimado: " + pedido.calcularTiempoEntrega() + " min"
                    + " | Estado: " + pedido.getEstado());
                
            } catch (InterruptedException e) {
                System.out.println("[" + threadName + "] " + nombre 
                    + " -> ERROR: Entrega interrumpida para Pedido #" 
                    + pedido.getIdPedido());
                Thread.currentThread().interrupt();
                break;
            } catch (Exception e) {
                System.out.println("[" + threadName + "] " + nombre 
                    + " -> ERROR inesperado en Pedido #" + pedido.getIdPedido() 
                    + ": " + e.getMessage());
            }
        }
        
        // Resumen final del repartidor
        System.out.println("\n[" + threadName + "] =========================================");
        System.out.println("[" + threadName + "] " + nombre 
            + " FINALIZO su ruta: " + entregasCompletadas 
            + "/" + pedidosAsignados.size() + " entregas completadas");
        System.out.println("[" + threadName + "] =========================================");
    }
    
    // ==================== GETTERS ====================
    
    public String getNombre() { return nombre; }
    public List<Pedido> getPedidosAsignados() { return pedidosAsignados; }
    public int getEntregasCompletadas() { return entregasCompletadas; }
}
