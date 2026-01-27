package com.speedfast.interfaces;

/**
 * Interface que define el comportamiento de despacho.
 * Permite desacoplar la logica de envio de pedidos.
 * 
 * @author Fuad Onate
 * @version 1.0 - Semana 3 DOO II
 */
public interface Despachable {
    
    /**
     * Ejecuta el despacho del pedido.
     * @return mensaje confirmando el despacho
     */
    String despachar();
}
