package com.speedfast.model;

/**
 * Subclase que representa un pedido de encomienda
 * Requiere validacion de peso y embalaje
 * 
 * @author Fuad Oñate
 * Desarrollo Orientado a Objetos II - Semana 1
 */
public class PedidoEncomienda extends Pedido {
    
    private double pesoKg;
    private boolean embalajeVerificado;
    private String tipoContenido;
    
    /**
     * Constructor sin parametros
     */
    public PedidoEncomienda() {
        super();
        this.tipoPedido = "Encomienda";
        this.pesoKg = 0.0;
        this.embalajeVerificado = false;
        this.tipoContenido = "";
    }
    
    /**
     * Constructor con parametros
     * @param idPedido Identificador del pedido
     * @param direccionEntrega Direccion de entrega
     * @param pesoKg Peso del paquete en kilogramos
     * @param tipoContenido Tipo de contenido (documento, paquete)
     */
    public PedidoEncomienda(int idPedido, String direccionEntrega, double pesoKg, String tipoContenido) {
        super(idPedido, direccionEntrega, "Encomienda");
        this.pesoKg = pesoKg;
        this.embalajeVerificado = true;
        this.tipoContenido = tipoContenido;
    }
    
    // Getters y Setters
    public double getPesoKg() {
        return pesoKg;
    }
    
    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }
    
    public boolean isEmbalajeVerificado() {
        return embalajeVerificado;
    }
    
    public void setEmbalajeVerificado(boolean embalajeVerificado) {
        this.embalajeVerificado = embalajeVerificado;
    }
    
    public String getTipoContenido() {
        return tipoContenido;
    }
    
    public void setTipoContenido(String tipoContenido) {
        this.tipoContenido = tipoContenido;
    }
    
    /**
     * SOBRESCRITURA: Logica especifica para encomiendas
     * Valida peso y estado del embalaje
     */
    @Override
    public void asignarRepartidor() {
        System.out.println("=== PEDIDO ENCOMIENDA #" + idPedido + " ===");
        System.out.println("  Contenido: " + tipoContenido);
        System.out.println("  Direccion: " + direccionEntrega);
        System.out.println("  [!] Validando peso: " + pesoKg + " kg");
        
        if (pesoKg <= 5.0) {
            System.out.println("  [OK] Peso aceptable para repartidor en moto");
        } else if (pesoKg <= 20.0) {
            System.out.println("  [OK] Peso requiere vehiculo - asignando repartidor con auto");
        } else {
            System.out.println("  [!] Peso excede limite - requiere servicio especial");
        }
        
        if (embalajeVerificado) {
            System.out.println("  [OK] Embalaje verificado - Repartidor asignado");
        } else {
            System.out.println("  [ERROR] Embalaje no verificado - No se puede asignar");
        }
    }
    
    /**
     * SOBRECARGA: Asigna repartidor especifico con validacion de peso
     * @param nombreRepartidor Nombre del repartidor
     */
    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("=== PEDIDO ENCOMIENDA #" + idPedido + " ===");
        System.out.println("  Contenido: " + tipoContenido);
        System.out.println("  Direccion: " + direccionEntrega);
        System.out.println("  [!] Validando paquete para " + nombreRepartidor);
        System.out.println("  [OK] Peso: " + pesoKg + " kg - Embalaje OK");
        System.out.println("  [OK] " + nombreRepartidor + " asignado para entrega de encomienda");
    }
    
    @Override
    public String toString() {
        return "Pedido Encomienda #" + idPedido + " | Contenido: " + tipoContenido + 
               " | Peso: " + pesoKg + " kg | Direccion: " + direccionEntrega;
    }
}
