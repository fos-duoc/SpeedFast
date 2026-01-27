package com.speedfast.controller;

import com.speedfast.model.Pedido;
import com.speedfast.interfaces.Despachable;
import com.speedfast.interfaces.Cancelable;
import com.speedfast.interfaces.Rastreable;
import java.util.ArrayList;

/**
 * Controlador central que gestiona todos los envios de SpeedFast.
 * Implementa las interfaces para demostrar desacoplamiento.
 * Mantiene el historial global de entregas realizadas.
 * 
 * @author Fuad Onate
 * @version 1.0 - Semana 3 DOO II
 */
public class ControladorEnvios implements Rastreable {
    
    // Lista de pedidos registrados
    private ArrayList<Pedido> pedidosRegistrados;
    
    // Historial global de entregas
    private ArrayList<String> historialEntregas;
    
    /**
     * Constructor del controlador.
     */
    public ControladorEnvios() {
        this.pedidosRegistrados = new ArrayList<>();
        this.historialEntregas = new ArrayList<>();
    }
    
    /**
     * Registra un nuevo pedido en el sistema.
     * @param pedido pedido a registrar
     */
    public void registrarPedido(Pedido pedido) {
        pedidosRegistrados.add(pedido);
        historialEntregas.add("Pedido #" + pedido.getIdPedido() + " (" + pedido.getTipo() + ") registrado");
    }
    
    /**
     * Despacha un pedido usando la interface Despachable.
     * @param pedido pedido a despachar (debe implementar Despachable)
     */
    public void despacharPedido(Despachable pedido) {
        String resultado = pedido.despachar();
        System.out.println(resultado);
        if (pedido instanceof Pedido) {
            Pedido p = (Pedido) pedido;
            historialEntregas.add("Despachado: Pedido #" + p.getIdPedido());
        }
    }
    
    /**
     * Cancela un pedido usando la interface Cancelable.
     * @param pedido pedido a cancelar (debe implementar Cancelable)
     */
    public void cancelarPedido(Cancelable pedido) {
        String resultado = pedido.cancelar();
        System.out.println(resultado);
        if (pedido instanceof Pedido) {
            Pedido p = (Pedido) pedido;
            historialEntregas.add("Cancelado: Pedido #" + p.getIdPedido());
        }
    }
    
    /**
     * Muestra el historial de un pedido especifico.
     * @param pedido pedido a consultar (debe implementar Rastreable)
     */
    public void mostrarHistorialPedido(Rastreable pedido) {
        System.out.println(pedido.verHistorial());
    }
    
    /**
     * Implementacion de Rastreable para el historial global.
     * Muestra todas las operaciones realizadas en el sistema.
     */
    @Override
    public String verHistorial() {
        StringBuilder sb = new StringBuilder();
        sb.append("+----------------------------------------------------------------+\n");
        sb.append("|        HISTORIAL GLOBAL DE ENTREGAS - SPEEDFAST               |\n");
        sb.append("+----------------------------------------------------------------+\n");
        
        if (historialEntregas.isEmpty()) {
            sb.append("|  No hay entregas registradas                                 |\n");
        } else {
            for (int i = 0; i < historialEntregas.size(); i++) {
                String linea = String.format("|  %2d. %-57s |", (i + 1), historialEntregas.get(i));
                sb.append(linea).append("\n");
            }
        }
        
        sb.append("+----------------------------------------------------------------+\n");
        sb.append("|  Total operaciones: ").append(String.format("%-42d", historialEntregas.size())).append("|\n");
        sb.append("+----------------------------------------------------------------+");
        
        return sb.toString();
    }
    
    /**
     * Obtiene la lista de pedidos registrados.
     * @return lista de pedidos
     */
    public ArrayList<Pedido> getPedidosRegistrados() {
        return pedidosRegistrados;
    }
    
    /**
     * Obtiene el total de pedidos registrados.
     * @return cantidad de pedidos
     */
    public int getTotalPedidos() {
        return pedidosRegistrados.size();
    }
}
