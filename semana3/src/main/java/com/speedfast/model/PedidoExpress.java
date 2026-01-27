package com.speedfast.model;

/**
 * Subclase que representa un pedido express.
 * Hereda de Pedido e implementa logica especifica para entregas urgentes.
 * Formula tiempo: 10 min base (+5 min si distancia > 5km)
 * 
 * @author Fuad Onate
 * @version 1.0 - Semana 3 DOO II
 */
public class PedidoExpress extends Pedido {
    
    // Atributo propio de la subclase
    private boolean esUrgente;
    
    /**
     * Constructor de PedidoExpress.
     * @param idPedido identificador unico
     * @param direccionEntrega direccion de destino
     * @param distanciaKm distancia en kilometros
     * @param esUrgente si es entrega urgente
     */
    public PedidoExpress(int idPedido, String direccionEntrega, double distanciaKm, boolean esUrgente) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.esUrgente = esUrgente;
        this.historial.add("Prioridad: " + (esUrgente ? "URGENTE" : "Normal"));
    }
    
    /**
     * Sobrescritura de asignarRepartidor.
     * Busca repartidor mas cercano para entregas express.
     */
    @Override
    public void asignarRepartidor() {
        this.repartidorAsignado = "Repartidor Cercano Express";
        this.estado = "ASIGNADO";
        this.historial.add("Busqueda de repartidor mas cercano...");
        this.historial.add("Asignado repartidor express automaticamente");
        System.out.println("[EXPRESS] Buscando repartidor mas cercano...");
        System.out.println("[EXPRESS] Asignado: Repartidor Cercano Express");
    }
    
    /**
     * Sobrecarga de asignarRepartidor con nombre.
     * Asigna con prioridad maxima si es urgente.
     */
    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        this.repartidorAsignado = nombreRepartidor;
        this.estado = "ASIGNADO";
        if (esUrgente) {
            this.historial.add("PRIORIDAD MAXIMA activada");
            System.out.println("[EXPRESS] PRIORIDAD MAXIMA para " + nombreRepartidor);
        }
        this.historial.add("Asignado express: " + nombreRepartidor);
        System.out.println("[EXPRESS] Asignado: " + nombreRepartidor);
    }
    
    /**
     * Implementacion de calcularTiempoEntrega.
     * Formula: 10 min base (+5 min si distancia > 5km)
     */
    @Override
    public int calcularTiempoEntrega() {
        int tiempo = 10;
        if (distanciaKm > 5) {
            tiempo += 5;
        }
        return tiempo;
    }
    
    /**
     * Sobrescritura de mostrarResumen para agregar info express.
     */
    @Override
    public void mostrarResumen() {
        System.out.println("=== Pedido Express ===");
        super.mostrarResumen();
        System.out.println("Urgente: " + (esUrgente ? "SI" : "No"));
    }
    
    @Override
    public String getTipo() {
        return "Express";
    }
    
    // Getter propio
    public boolean isEsUrgente() { return esUrgente; }
}
