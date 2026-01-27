package com.speedfast.model;

import com.speedfast.interfaces.Despachable;
import com.speedfast.interfaces.Cancelable;
import com.speedfast.interfaces.Rastreable;
import java.util.ArrayList;

/**
 * Clase abstracta que representa un pedido generico en SpeedFast.
 * Implementa las interfaces Despachable, Cancelable y Rastreable
 * para desacoplar responsabilidades.
 * 
 * @author Fuad Onate
 * @version 1.0 - Semana 3 DOO II
 */
public abstract class Pedido implements Despachable, Cancelable, Rastreable {
    
    // Atributos protegidos para herencia
    protected int idPedido;
    protected String direccionEntrega;
    protected double distanciaKm;
    protected String repartidorAsignado;
    protected String estado;
    protected ArrayList<String> historial;
    
    /**
     * Constructor completo de Pedido.
     * @param idPedido identificador unico del pedido
     * @param direccionEntrega direccion de destino
     * @param distanciaKm distancia en kilometros
     */
    public Pedido(int idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.repartidorAsignado = "Sin asignar";
        this.estado = "CREADO";
        this.historial = new ArrayList<>();
        this.historial.add("Pedido #" + idPedido + " creado");
    }
    
    // ==================== METODOS IMPLEMENTADOS ====================
    
    /**
     * Muestra el resumen del pedido (metodo implementado).
     */
    public void mostrarResumen() {
        System.out.println("ID Pedido: " + idPedido);
        System.out.println("Direccion: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Repartidor: " + repartidorAsignado);
        System.out.println("Estado: " + estado);
    }
    
    /**
     * Asignacion automatica de repartidor (metodo base).
     * Sera sobrescrito en las subclases.
     */
    public void asignarRepartidor() {
        this.repartidorAsignado = "Repartidor Generico";
        this.estado = "ASIGNADO";
        this.historial.add("Repartidor asignado automaticamente");
    }
    
    /**
     * Asignacion manual de repartidor (sobrecarga).
     * @param nombreRepartidor nombre del repartidor a asignar
     */
    public void asignarRepartidor(String nombreRepartidor) {
        this.repartidorAsignado = nombreRepartidor;
        this.estado = "ASIGNADO";
        this.historial.add("Repartidor asignado manualmente: " + nombreRepartidor);
    }
    
    // ==================== METODO ABSTRACTO ====================
    
    /**
     * Calcula el tiempo de entrega estimado.
     * Cada subclase implementa su propia logica.
     * @return tiempo en minutos
     */
    public abstract int calcularTiempoEntrega();
    
    // ==================== IMPLEMENTACION DE INTERFACES ====================
    
    /**
     * Implementacion de Despachable.
     * Despacha el pedido si tiene repartidor asignado.
     */
    @Override
    public String despachar() {
        if (this.repartidorAsignado.equals("Sin asignar")) {
            return "ERROR: No se puede despachar sin repartidor asignado";
        }
        this.estado = "EN CAMINO";
        this.historial.add("Pedido despachado - En camino");
        return "Pedido #" + idPedido + " despachado con " + repartidorAsignado;
    }
    
    /**
     * Implementacion de Cancelable.
     * Cancela el pedido si no ha sido entregado.
     */
    @Override
    public String cancelar() {
        if (this.estado.equals("ENTREGADO")) {
            return "ERROR: No se puede cancelar un pedido ya entregado";
        }
        this.estado = "CANCELADO";
        this.historial.add("Pedido cancelado");
        return "Pedido #" + idPedido + " ha sido cancelado";
    }
    
    /**
     * Implementacion de Rastreable.
     * Muestra el historial completo del pedido.
     */
    @Override
    public String verHistorial() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Historial Pedido #").append(idPedido).append(" ===\n");
        for (int i = 0; i < historial.size(); i++) {
            sb.append("  ").append(i + 1).append(". ").append(historial.get(i)).append("\n");
        }
        return sb.toString();
    }
    
    // ==================== GETTERS ====================
    
    public int getIdPedido() { return idPedido; }
    public String getDireccionEntrega() { return direccionEntrega; }
    public double getDistanciaKm() { return distanciaKm; }
    public String getRepartidorAsignado() { return repartidorAsignado; }
    public String getEstado() { return estado; }
    
    /**
     * Retorna el tipo de pedido (para polimorfismo).
     */
    public abstract String getTipo();
}
