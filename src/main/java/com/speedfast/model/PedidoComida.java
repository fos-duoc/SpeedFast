package com.speedfast.model;

/**
 * Subclase que representa un pedido de comida
 * Requiere repartidor con mochila termica
 * 
 * @author Fuad Oñate
 * Desarrollo Orientado a Objetos II - Semana 1
 */
public class PedidoComida extends Pedido {
    
    private String restaurante;
    private boolean requiereMochilatermica;
    
    /**
     * Constructor sin parametros
     */
    public PedidoComida() {
        super();
        this.tipoPedido = "Comida";
        this.restaurante = "";
        this.requiereMochilatermica = true;
    }
    
    /**
     * Constructor con parametros
     * @param idPedido Identificador del pedido
     * @param direccionEntrega Direccion de entrega
     * @param restaurante Nombre del restaurante
     */
    public PedidoComida(int idPedido, String direccionEntrega, String restaurante) {
        super(idPedido, direccionEntrega, "Comida");
        this.restaurante = restaurante;
        this.requiereMochilatermica = true;
    }
    
    // Getters y Setters
    public String getRestaurante() {
        return restaurante;
    }
    
    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }
    
    public boolean isRequiereMochilatermica() {
        return requiereMochilatermica;
    }
    
    /**
     * SOBRESCRITURA: Logica especifica para pedidos de comida
     * Valida que el repartidor tenga mochila termica
     */
    @Override
    public void asignarRepartidor() {
        System.out.println("=== PEDIDO COMIDA #" + idPedido + " ===");
        System.out.println("  Restaurante: " + restaurante);
        System.out.println("  Direccion: " + direccionEntrega);
        System.out.println("  [!] Verificando mochila termica...");
        
        if (requiereMochilatermica) {
            System.out.println("  [OK] Repartidor con mochila termica asignado automaticamente");
        }
    }
    
    /**
     * SOBRECARGA: Asigna repartidor especifico verificando mochila termica
     * @param nombreRepartidor Nombre del repartidor
     */
    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("=== PEDIDO COMIDA #" + idPedido + " ===");
        System.out.println("  Restaurante: " + restaurante);
        System.out.println("  Direccion: " + direccionEntrega);
        System.out.println("  [!] Validando repartidor: " + nombreRepartidor);
        System.out.println("  [OK] " + nombreRepartidor + " tiene mochila termica - ASIGNADO");
    }
    
    @Override
    public String toString() {
        return "Pedido Comida #" + idPedido + " | Restaurante: " + restaurante + 
               " | Direccion: " + direccionEntrega;
    }
}
