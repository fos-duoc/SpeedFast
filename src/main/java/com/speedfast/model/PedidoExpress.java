package com.speedfast.model;

/**
 * Subclase que representa un pedido de compra express
 * Requiere asignar al repartidor mas cercano con disponibilidad inmediata
 * 
 * @author Fuad Oñate
 * Desarrollo Orientado a Objetos II - Semana 1
 */
public class PedidoExpress extends Pedido {
    
    private String tipoCompra; // supermercado o farmacia
    private boolean urgente;
    private int tiempoEstimadoMinutos;
    
    /**
     * Constructor sin parametros
     */
    public PedidoExpress() {
        super();
        this.tipoPedido = "Express";
        this.tipoCompra = "";
        this.urgente = true;
        this.tiempoEstimadoMinutos = 30;
    }
    
    /**
     * Constructor con parametros
     * @param idPedido Identificador del pedido
     * @param direccionEntrega Direccion de entrega
     * @param tipoCompra Tipo de compra (supermercado, farmacia)
     */
    public PedidoExpress(int idPedido, String direccionEntrega, String tipoCompra) {
        super(idPedido, direccionEntrega, "Express");
        this.tipoCompra = tipoCompra;
        this.urgente = true;
        this.tiempoEstimadoMinutos = 30;
    }
    
    // Getters y Setters
    public String getTipoCompra() {
        return tipoCompra;
    }
    
    public void setTipoCompra(String tipoCompra) {
        this.tipoCompra = tipoCompra;
    }
    
    public boolean isUrgente() {
        return urgente;
    }
    
    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }
    
    public int getTiempoEstimadoMinutos() {
        return tiempoEstimadoMinutos;
    }
    
    public void setTiempoEstimadoMinutos(int tiempoEstimadoMinutos) {
        this.tiempoEstimadoMinutos = tiempoEstimadoMinutos;
    }
    
    /**
     * SOBRESCRITURA: Logica especifica para compras express
     * Asigna al repartidor mas cercano con disponibilidad inmediata
     */
    @Override
    public void asignarRepartidor() {
        System.out.println("=== PEDIDO EXPRESS #" + idPedido + " ===");
        System.out.println("  Tipo compra: " + tipoCompra);
        System.out.println("  Direccion: " + direccionEntrega);
        System.out.println("  [!] Buscando repartidor cercano...");
        System.out.println("  [!] Verificando disponibilidad inmediata...");
        
        if (urgente) {
            System.out.println("  [URGENTE] Priorizando asignacion");
        }
        
        System.out.println("  [OK] Repartidor mas cercano asignado");
        System.out.println("  [OK] Tiempo estimado: " + tiempoEstimadoMinutos + " minutos");
    }
    
    /**
     * SOBRECARGA: Asigna repartidor especifico verificando cercania
     * @param nombreRepartidor Nombre del repartidor
     */
    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("=== PEDIDO EXPRESS #" + idPedido + " ===");
        System.out.println("  Tipo compra: " + tipoCompra);
        System.out.println("  Direccion: " + direccionEntrega);
        System.out.println("  [!] Verificando disponibilidad de " + nombreRepartidor);
        System.out.println("  [OK] " + nombreRepartidor + " esta disponible y cercano");
        System.out.println("  [OK] Asignado para entrega express en " + tiempoEstimadoMinutos + " min");
    }
    
    @Override
    public String toString() {
        return "Pedido Express #" + idPedido + " | Compra: " + tipoCompra + 
               " | Direccion: " + direccionEntrega + " | Tiempo: " + tiempoEstimadoMinutos + " min";
    }
}
