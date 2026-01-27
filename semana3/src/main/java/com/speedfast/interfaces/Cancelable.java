package com.speedfast.interfaces;

/**
 * Interface que define el comportamiento de cancelacion.
 * Permite desacoplar la logica de cancelacion de pedidos.
 * 
 * @author Fuad Onate
 * @version 1.0 - Semana 3 DOO II
 */
public interface Cancelable {
    
    /**
     * Cancela el pedido actual.
     * @return mensaje confirmando la cancelacion
     */
    String cancelar();
}
