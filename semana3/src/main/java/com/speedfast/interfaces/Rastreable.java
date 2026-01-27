package com.speedfast.interfaces;

/**
 * Interface que define el comportamiento de rastreo.
 * Permite desacoplar la logica de seguimiento de pedidos.
 * 
 * @author Fuad Onate
 * @version 1.0 - Semana 3 DOO II
 */
public interface Rastreable {
    
    /**
     * Muestra el historial de estados del pedido.
     * @return historial del pedido
     */
    String verHistorial();
}
