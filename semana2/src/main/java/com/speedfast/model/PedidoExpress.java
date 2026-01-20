package com.speedfast.model;

/**
 * Clase que representa un pedido express.
 * Hereda de Pedido e implementa su propio calculo de tiempo de entrega.
 * Formula: 10 min base, si distancia > 5 km se agregan 5 min extra
 * 
 * @author Fuad Oñate
 * Desarrollo Orientado a Objetos II - Semana 2
 */
public class PedidoExpress extends Pedido {
    
    // Constantes para el calculo
    private static final int TIEMPO_BASE = 10;
    private static final int TIEMPO_EXTRA = 5;
    private static final double DISTANCIA_LIMITE = 5.0;
    
    // Atributo propio de pedido express
    private boolean esUrgente;
    
    /**
     * Constructor completo
     * @param idPedido identificador del pedido
     * @param direccionEntrega direccion de destino
     * @param distanciaKm distancia en kilometros
     * @param esUrgente indica si el pedido es urgente
     */
    public PedidoExpress(int idPedido, String direccionEntrega, double distanciaKm, boolean esUrgente) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.esUrgente = esUrgente;
    }
    
    /**
     * Constructor sin urgencia (por defecto es urgente)
     */
    public PedidoExpress(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.esUrgente = true;
    }
    
    // Getter y Setter
    public boolean isEsUrgente() {
        return esUrgente;
    }
    
    public void setEsUrgente(boolean esUrgente) {
        this.esUrgente = esUrgente;
    }
    
    /**
     * Implementacion del metodo abstracto.
     * Calcula: 10 min base, si distancia > 5 km se agregan 5 min extra
     * @return tiempo estimado en minutos
     */
    @Override
    public int calcularTiempoEntrega() {
        if (distanciaKm > DISTANCIA_LIMITE) {
            return TIEMPO_BASE + TIEMPO_EXTRA;
        }
        return TIEMPO_BASE;
    }
    
    /**
     * Sobrescribe mostrarResumen para incluir informacion especifica
     */
    @Override
    public void mostrarResumen() {
        System.out.println("=== Pedido Express ===");
        System.out.println("ID Pedido: " + idPedido);
        System.out.println("Direccion: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Es Urgente: " + (esUrgente ? "Si" : "No"));
        System.out.println("Tiempo Base: " + TIEMPO_BASE + " min" + 
                          (distanciaKm > DISTANCIA_LIMITE ? " + " + TIEMPO_EXTRA + " min (>5km)" : ""));
    }
    
    @Override
    public String toString() {
        return "PedidoExpress [id=" + idPedido + ", urgente=" + esUrgente + 
               ", distancia=" + distanciaKm + " km]";
    }
}
