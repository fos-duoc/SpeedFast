package com.speedfast.model;

/**
 * Subclase que representa un pedido de encomienda.
 * Hereda de Pedido e implementa logica especifica para paquetes.
 * Formula tiempo: 20 min base + 1.5 min por km (entero)
 * 
 * @author Fuad Onate
 * @version 1.0 - Semana 3 DOO II
 */
public class PedidoEncomienda extends Pedido {
    
    // Atributos propios de la subclase
    private double pesoKg;
    private boolean requiereEmbalaje;
    
    /**
     * Constructor de PedidoEncomienda.
     * @param idPedido identificador unico
     * @param direccionEntrega direccion de destino
     * @param distanciaKm distancia en kilometros
     * @param pesoKg peso del paquete en kg
     * @param requiereEmbalaje si necesita embalaje especial
     */
    public PedidoEncomienda(int idPedido, String direccionEntrega, double distanciaKm, 
                            double pesoKg, boolean requiereEmbalaje) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.pesoKg = pesoKg;
        this.requiereEmbalaje = requiereEmbalaje;
        this.historial.add("Peso: " + pesoKg + " kg | Embalaje: " + (requiereEmbalaje ? "Si" : "No"));
    }
    
    /**
     * Sobrescritura de asignarRepartidor.
     * Valida capacidad de carga segun peso.
     */
    @Override
    public void asignarRepartidor() {
        if (pesoKg > 10) {
            this.repartidorAsignado = "Repartidor Vehiculo Grande";
            this.historial.add("Asignado vehiculo grande por peso > 10kg");
        } else {
            this.repartidorAsignado = "Repartidor Moto";
            this.historial.add("Asignado repartidor en moto");
        }
        this.estado = "ASIGNADO";
        System.out.println("[ENCOMIENDA] Peso: " + pesoKg + "kg -> " + repartidorAsignado);
    }
    
    /**
     * Sobrecarga de asignarRepartidor con nombre.
     * Valida embalaje antes de asignar.
     */
    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        if (requiereEmbalaje) {
            this.historial.add("Embalaje especial aplicado");
            System.out.println("[ENCOMIENDA] Embalaje especial aplicado");
        }
        this.repartidorAsignado = nombreRepartidor;
        this.estado = "ASIGNADO";
        this.historial.add("Asignado manualmente: " + nombreRepartidor);
        System.out.println("[ENCOMIENDA] Asignado: " + nombreRepartidor);
    }
    
    /**
     * Implementacion de calcularTiempoEntrega.
     * Formula: 20 min base + 1.5 min por km (redondeado)
     */
    @Override
    public int calcularTiempoEntrega() {
        return (int) (20 + (1.5 * distanciaKm));
    }
    
    /**
     * Sobrescritura de mostrarResumen para agregar info de encomienda.
     */
    @Override
    public void mostrarResumen() {
        System.out.println("=== Pedido de Encomienda ===");
        super.mostrarResumen();
        System.out.println("Peso: " + pesoKg + " kg");
        System.out.println("Embalaje especial: " + (requiereEmbalaje ? "Si" : "No"));
    }
    
    @Override
    public String getTipo() {
        return "Encomienda";
    }
    
    // Getters propios
    public double getPesoKg() { return pesoKg; }
    public boolean isRequiereEmbalaje() { return requiereEmbalaje; }
}
