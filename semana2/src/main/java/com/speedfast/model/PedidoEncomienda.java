package com.speedfast.model;

/**
 * Clase que representa un pedido de encomienda.
 * Hereda de Pedido e implementa su propio calculo de tiempo de entrega.
 * Formula: 20 min base + 1.5 min por kilometro (ajustado a entero)
 * 
 * @author Fuad Oñate
 * Desarrollo Orientado a Objetos II - Semana 2
 */
public class PedidoEncomienda extends Pedido {
    
    // Constantes para el calculo
    private static final int TIEMPO_BASE = 20;
    private static final double MINUTOS_POR_KM = 1.5;
    
    // Atributo propio de encomienda
    private double pesoKg;
    
    /**
     * Constructor completo
     * @param idPedido identificador del pedido
     * @param direccionEntrega direccion de destino
     * @param distanciaKm distancia en kilometros
     * @param pesoKg peso de la encomienda en kilogramos
     */
    public PedidoEncomienda(int idPedido, String direccionEntrega, double distanciaKm, double pesoKg) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.pesoKg = pesoKg;
    }
    
    /**
     * Constructor sin peso
     */
    public PedidoEncomienda(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.pesoKg = 0.0;
    }
    
    // Getter y Setter
    public double getPesoKg() {
        return pesoKg;
    }
    
    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }
    
    /**
     * Implementacion del metodo abstracto.
     * Calcula: 20 min + 1.5 min por kilometro (ajustado a entero)
     * @return tiempo estimado en minutos
     */
    @Override
    public int calcularTiempoEntrega() {
        return TIEMPO_BASE + (int)(MINUTOS_POR_KM * distanciaKm);
    }
    
    /**
     * Sobrescribe mostrarResumen para incluir informacion especifica
     */
    @Override
    public void mostrarResumen() {
        System.out.println("=== Pedido de Encomienda ===");
        System.out.println("ID Pedido: " + idPedido);
        System.out.println("Direccion: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Peso: " + pesoKg + " kg");
        System.out.println("Tiempo Base: " + TIEMPO_BASE + " min + " + MINUTOS_POR_KM + " min/km");
    }
    
    @Override
    public String toString() {
        return "PedidoEncomienda [id=" + idPedido + ", peso=" + pesoKg + " kg, " + 
               "distancia=" + distanciaKm + " km]";
    }
}
