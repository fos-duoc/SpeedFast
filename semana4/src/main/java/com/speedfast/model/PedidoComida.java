package com.speedfast.model;

/**
 * Subclase que representa un pedido de comida.
 * Hereda de Pedido e implementa logica especifica para delivery de alimentos.
 * Formula tiempo: 15 min base + 2 min por km
 * 
 * @author Fuad Onate
 * @version 2.0 - Semana 4 DOO II
 */
public class PedidoComida extends Pedido {
    
    private String tipoComida;
    
    /**
     * Constructor de PedidoComida.
     * @param idPedido identificador unico
     * @param direccionEntrega direccion de destino
     * @param distanciaKm distancia en kilometros
     * @param tipoComida tipo de comida (ej: Sushi, Pizza)
     */
    public PedidoComida(int idPedido, String direccionEntrega, double distanciaKm, String tipoComida) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.tipoComida = tipoComida;
    }
    
    /**
     * Calcula tiempo de entrega para comida.
     * Formula: 15 min base + 2 min por cada km
     * @return tiempo en minutos
     */
    @Override
    public int calcularTiempoEntrega() {
        return (int) (15 + 2 * distanciaKm);
    }
    
    /**
     * Sobrescribe asignarRepartidor con logica especifica.
     */
    @Override
    public void asignarRepartidor() {
        this.repartidorAsignado = "Repartidor Comida #" + (idPedido % 10);
        this.historial.add("Repartidor de comida asignado: " + this.repartidorAsignado);
    }
    
    @Override
    public void mostrarResumen() {
        System.out.println("=== Pedido de Comida ===");
        super.mostrarResumen();
        System.out.println("Tipo Comida: " + tipoComida);
        System.out.println("Tiempo Estimado: " + calcularTiempoEntrega() + " min");
    }
    
    @Override
    public String getTipo() { return "Comida"; }
    
    public String getTipoComida() { return tipoComida; }
}
