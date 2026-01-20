package com.speedfast.model;

/**
 * Clase que representa un pedido de comida.
 * Hereda de Pedido e implementa su propio calculo de tiempo de entrega.
 * Formula: 15 min base + 2 min por cada kilometro
 * 
 * @author Fuad Oñate
 * Desarrollo Orientado a Objetos II - Semana 2
 */
public class PedidoComida extends Pedido {
    
    // Constantes para el calculo
    private static final int TIEMPO_BASE = 15;
    private static final int MINUTOS_POR_KM = 2;
    
    // Atributo propio de pedido de comida
    private String tipoComida;
    
    /**
     * Constructor completo
     * @param idPedido identificador del pedido
     * @param direccionEntrega direccion de destino
     * @param distanciaKm distancia en kilometros
     * @param tipoComida tipo de comida del pedido
     */
    public PedidoComida(int idPedido, String direccionEntrega, double distanciaKm, String tipoComida) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.tipoComida = tipoComida;
    }
    
    /**
     * Constructor sin tipo de comida
     */
    public PedidoComida(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.tipoComida = "General";
    }
    
    // Getter y Setter
    public String getTipoComida() {
        return tipoComida;
    }
    
    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }
    
    /**
     * Implementacion del metodo abstracto.
     * Calcula: 15 min + 2 min por cada kilometro
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
        System.out.println("=== Pedido de Comida ===");
        System.out.println("ID Pedido: " + idPedido);
        System.out.println("Direccion: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Tipo Comida: " + tipoComida);
        System.out.println("Tiempo Base: " + TIEMPO_BASE + " min + " + MINUTOS_POR_KM + " min/km");
    }
    
    @Override
    public String toString() {
        return "PedidoComida [id=" + idPedido + ", tipo=" + tipoComida + 
               ", distancia=" + distanciaKm + " km]";
    }
}
