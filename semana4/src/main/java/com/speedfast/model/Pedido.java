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
 * @version 2.0 - Semana 4 DOO II
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
        this.estado = "PENDIENTE";
        this.historial = new ArrayList<>();
        this.historial.add("Pedido creado - Estado: PENDIENTE");
    }
    
    // ==================== METODOS DE ASIGNACION ====================
    
    /**
     * Asigna un repartidor automaticamente (sobrescritura en subclases).
     */
    public void asignarRepartidor() {
        this.repartidorAsignado = "Repartidor Auto #" + (idPedido % 10);
        this.historial.add("Repartidor asignado: " + this.repartidorAsignado);
    }
    
    /**
     * Asigna un repartidor por nombre (sobrecarga).
     * @param nombreRepartidor nombre del repartidor
     */
    public void asignarRepartidor(String nombreRepartidor) {
        this.repartidorAsignado = nombreRepartidor;
        this.historial.add("Repartidor asignado manualmente: " + nombreRepartidor);
    }
    
    // ==================== METODO IMPLEMENTADO ====================
    
    /**
     * Muestra el resumen basico del pedido (implementado).
     */
    public void mostrarResumen() {
        System.out.println("=== Pedido #" + idPedido + " ===");
        System.out.println("Direccion: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Repartidor: " + repartidorAsignado);
        System.out.println("Estado: " + estado);
    }
    
    // ==================== METODO ABSTRACTO ====================
    
    /**
     * Calcula el tiempo estimado de entrega (abstracto).
     * Cada subclase implementa su propia logica.
     * @return tiempo en minutos
     */
    public abstract int calcularTiempoEntrega();
    
    // ==================== IMPLEMENTACION DE INTERFACES ====================
    
    @Override
    public String despachar() {
        if (this.repartidorAsignado.equals("Sin asignar")) {
            return "ERROR: No se puede despachar sin repartidor asignado";
        }
        this.estado = "EN CAMINO";
        this.historial.add("Pedido despachado - En camino");
        return "Pedido #" + idPedido + " despachado con " + repartidorAsignado;
    }
    
    @Override
    public String cancelar() {
        if (this.estado.equals("ENTREGADO")) {
            return "ERROR: No se puede cancelar un pedido ya entregado";
        }
        this.estado = "CANCELADO";
        this.historial.add("Pedido cancelado");
        return "Pedido #" + idPedido + " ha sido cancelado";
    }
    
    @Override
    public String verHistorial() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Historial Pedido #").append(idPedido).append(" ===\n");
        for (int i = 0; i < historial.size(); i++) {
            sb.append("  ").append(i + 1).append(". ").append(historial.get(i)).append("\n");
        }
        return sb.toString();
    }
    
    /**
     * Marca el pedido como entregado.
     */
    public void marcarEntregado() {
        this.estado = "ENTREGADO";
        this.historial.add("Pedido entregado exitosamente");
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
