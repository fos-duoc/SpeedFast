package com.speedfast.model;

/**
 * Clase abstracta que representa un pedido generico en SpeedFast.
 * Define atributos comunes y metodos que seran heredados por las subclases.
 * 
 * @author Fuad Oñate
 * Desarrollo Orientado a Objetos II - Semana 2
 */
public abstract class Pedido {
    
    // Atributos comunes protegidos para acceso desde subclases
    protected int idPedido;
    protected String direccionEntrega;
    protected double distanciaKm;
    
    /**
     * Constructor de la clase Pedido
     * @param idPedido identificador unico del pedido
     * @param direccionEntrega direccion de destino
     * @param distanciaKm distancia en kilometros hasta el destino
     */
    public Pedido(int idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
    }
    
    /**
     * Constructor vacio
     */
    public Pedido() {
    }
    
    // Getters y Setters
    public int getIdPedido() {
        return idPedido;
    }
    
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    
    public String getDireccionEntrega() {
        return direccionEntrega;
    }
    
    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }
    
    public double getDistanciaKm() {
        return distanciaKm;
    }
    
    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }
    
    /**
     * Metodo implementado que muestra el resumen del pedido.
     * Imprime los datos basicos comunes a todos los tipos de pedido.
     */
    public void mostrarResumen() {
        System.out.println("=== Resumen del Pedido ===");
        System.out.println("ID Pedido: " + idPedido);
        System.out.println("Direccion: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
    }
    
    /**
     * Metodo abstracto que calcula el tiempo estimado de entrega.
     * Cada subclase implementara su propia logica de calculo.
     * @return tiempo estimado en minutos
     */
    public abstract int calcularTiempoEntrega();
    
    @Override
    public String toString() {
        return "Pedido [id=" + idPedido + ", direccion=" + direccionEntrega + 
               ", distancia=" + distanciaKm + " km]";
    }
}
