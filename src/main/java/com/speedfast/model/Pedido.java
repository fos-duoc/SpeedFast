package com.speedfast.model;

/**
 * Clase base que representa un pedido generico en SpeedFast
 * Contiene atributos comunes y metodos para asignacion de repartidor
 * 
 * @author Fuad Oñate
 * Desarrollo Orientado a Objetos II - Semana 1
 */
public class Pedido {
    
    // Atributos protegidos para acceso desde subclases
    protected int idPedido;
    protected String direccionEntrega;
    protected String tipoPedido;
    
    /**
     * Constructor sin parametros
     */
    public Pedido() {
        this.idPedido = 0;
        this.direccionEntrega = "";
        this.tipoPedido = "Generico";
    }
    
    /**
     * Constructor con parametros
     * @param idPedido Identificador unico del pedido
     * @param direccionEntrega Direccion de entrega del pedido
     * @param tipoPedido Tipo de pedido (Comida, Encomienda, Express)
     */
    public Pedido(int idPedido, String direccionEntrega, String tipoPedido) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.tipoPedido = tipoPedido;
    }
    
    // Getters
    public int getIdPedido() {
        return idPedido;
    }
    
    public String getDireccionEntrega() {
        return direccionEntrega;
    }
    
    public String getTipoPedido() {
        return tipoPedido;
    }
    
    // Setters
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    
    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }
    
    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }
    
    /**
     * Metodo generico para asignar repartidor
     * Sera sobrescrito por las subclases con logica especifica
     */
    public void asignarRepartidor() {
        System.out.println("[PEDIDO #" + idPedido + "] Asignacion generica de repartidor");
        System.out.println("  -> Direccion: " + direccionEntrega);
        System.out.println("  -> Tipo: " + tipoPedido);
    }
    
    /**
     * Metodo sobrecargado que recibe el nombre del repartidor
     * @param nombreRepartidor Nombre del repartidor asignado
     */
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("[PEDIDO #" + idPedido + "] Repartidor asignado: " + nombreRepartidor);
        System.out.println("  -> Direccion: " + direccionEntrega);
        System.out.println("  -> Tipo: " + tipoPedido);
    }
    
    @Override
    public String toString() {
        return "Pedido #" + idPedido + " | Tipo: " + tipoPedido + " | Direccion: " + direccionEntrega;
    }
}
