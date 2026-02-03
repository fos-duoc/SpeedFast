package com.speedfast.interfaces;

/**
 * Interface que define el comportamiento de cancelacion.
 * Permite desacoplar la logica de cancelacion de pedidos.
 * 
 * @author Fuad Onate
 * @version 2.0 - Semana 4 DOO II
 */
public interface Cancelable {
    
    /**
     * Cancela el pedido actual.
     * @return mensaje confirmando la cancelacion
     */
    String cancelar();
}
