package com.speedfast.model;

/**
 * Subclase que representa un pedido de encomienda.
 * Hereda de Pedido e implementa logica especifica para paquetes.
 * Formula tiempo: 20 min base + 1.5 min por km (entero)
 * 
 * @author Fuad Onate
 * @version 2.0 - Semana 4 DOO II
 */
public class PedidoEncomienda extends Pedido {
    
    private double pesoKg;
    
    /**
     * Constructor de PedidoEncomienda.
     * @param idPedido identificador unico
     * @param direccionEntrega direccion de destino
     * @param distanciaKm distancia en kilometros
     * @param pesoKg peso del paquete en kg
     */
    public PedidoEncomienda(int idPedido, String direccionEntrega, double distanciaKm, double pesoKg) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.pesoKg = pesoKg;
    }
    
    /**
     * Calcula tiempo de entrega para encomienda.
     * Formula: 20 min base + 1.5 min por cada km (resultado entero)
     * @return tiempo en minutos
     */
    @Override
    public int calcularTiempoEntrega() {
        return (int) (20 + 1.5 * distanciaKm);
    }
    
    @Override
    public void asignarRepartidor() {
        this.repartidorAsignado = "Repartidor Encomienda #" + (idPedido % 10);
        this.historial.add("Repartidor de encomienda asignado: " + this.repartidorAsignado);
    }
    
    @Override
    public void mostrarResumen() {
        System.out.println("=== Pedido de Encomienda ===");
        super.mostrarResumen();
        System.out.println("Peso: " + pesoKg + " kg");
        System.out.println("Tiempo Estimado: " + calcularTiempoEntrega() + " min");
    }
    
    @Override
    public String getTipo() { return "Encomienda"; }
    
    public double getPesoKg() { return pesoKg; }
}
