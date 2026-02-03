package com.speedfast.model;

/**
 * Subclase que representa un pedido express.
 * Hereda de Pedido e implementa logica especifica para entregas rapidas.
 * Formula tiempo: 10 min base + 5 min adicionales si distancia > 5 km
 * 
 * @author Fuad Onate
 * @version 2.0 - Semana 4 DOO II
 */
public class PedidoExpress extends Pedido {
    
    private boolean esUrgente;
    
    /**
     * Constructor de PedidoExpress.
     * @param idPedido identificador unico
     * @param direccionEntrega direccion de destino
     * @param distanciaKm distancia en kilometros
     * @param esUrgente indica si el pedido es urgente
     */
    public PedidoExpress(int idPedido, String direccionEntrega, double distanciaKm, boolean esUrgente) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.esUrgente = esUrgente;
    }
    
    /**
     * Calcula tiempo de entrega express.
     * Formula: 10 min base + 5 min adicionales si distancia > 5 km
     * @return tiempo en minutos
     */
    @Override
    public int calcularTiempoEntrega() {
        return distanciaKm > 5 ? 15 : 10;
    }
    
    @Override
    public void asignarRepartidor() {
        this.repartidorAsignado = "Repartidor Express #" + (idPedido % 10);
        this.historial.add("Repartidor express asignado: " + this.repartidorAsignado);
    }
    
    @Override
    public void mostrarResumen() {
        System.out.println("=== Pedido Express ===");
        super.mostrarResumen();
        System.out.println("Urgente: " + (esUrgente ? "Si" : "No"));
        System.out.println("Tiempo Estimado: " + calcularTiempoEntrega() + " min");
    }
    
    @Override
    public String getTipo() { return "Express"; }
    
    public boolean isEsUrgente() { return esUrgente; }
}
