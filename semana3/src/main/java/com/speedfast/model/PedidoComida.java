package com.speedfast.model;

/**
 * Subclase que representa un pedido de comida.
 * Hereda de Pedido e implementa logica especifica para delivery de alimentos.
 * Formula tiempo: 15 min base + 2 min por km
 * 
 * @author Fuad Onate
 * @version 1.0 - Semana 3 DOO II
 */
public class PedidoComida extends Pedido {
    
    // Atributo propio de la subclase
    private String tipoComida;
    
    /**
     * Constructor de PedidoComida.
     * @param idPedido identificador unico
     * @param direccionEntrega direccion de destino
     * @param distanciaKm distancia en kilometros
     * @param tipoComida tipo de comida (Sushi, Pizza, etc.)
     */
    public PedidoComida(int idPedido, String direccionEntrega, double distanciaKm, String tipoComida) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.tipoComida = tipoComida;
        this.historial.add("Tipo de comida: " + tipoComida);
    }
    
    /**
     * Sobrescritura de asignarRepartidor.
     * Requiere repartidor con mochila termica.
     */
    @Override
    public void asignarRepartidor() {
        this.repartidorAsignado = "Repartidor con Mochila Termica";
        this.estado = "ASIGNADO";
        this.historial.add("Asignado repartidor con mochila termica (automatico)");
        System.out.println("[COMIDA] Asignado repartidor con mochila termica");
    }
    
    /**
     * Sobrecarga de asignarRepartidor con nombre.
     * Valida que el repartidor tenga equipo termico.
     */
    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        this.repartidorAsignado = nombreRepartidor + " (Equipo Termico)";
        this.estado = "ASIGNADO";
        this.historial.add("Asignado: " + nombreRepartidor + " con equipo termico");
        System.out.println("[COMIDA] Asignado: " + nombreRepartidor + " con equipo termico");
    }
    
    /**
     * Implementacion de calcularTiempoEntrega.
     * Formula: 15 min base + 2 min por cada km
     */
    @Override
    public int calcularTiempoEntrega() {
        return (int) (15 + (2 * distanciaKm));
    }
    
    /**
     * Sobrescritura de mostrarResumen para agregar info de comida.
     */
    @Override
    public void mostrarResumen() {
        System.out.println("=== Pedido de Comida ===");
        super.mostrarResumen();
        System.out.println("Tipo Comida: " + tipoComida);
    }
    
    @Override
    public String getTipo() {
        return "Comida";
    }
    
    // Getter propio
    public String getTipoComida() { return tipoComida; }
}
