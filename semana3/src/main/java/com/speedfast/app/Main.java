package com.speedfast.app;

import com.speedfast.model.*;
import com.speedfast.controller.ControladorEnvios;

/**
 * Clase principal que demuestra el sistema integral de SpeedFast.
 * Integra polimorfismo, abstraccion e interfaces.
 * 
 * Semana 3 - Desarrollo Orientado a Objetos II
 * Actividad Sumativa 1: Sistema con clases abstractas, polimorfismo e interfaces
 * 
 * @author Fuad Onate
 * @version 1.0
 */
public class Main {
    
    public static void main(String[] args) {
        
        // ================================================================
        // ENCABEZADO
        // ================================================================
        System.out.println("================================================================");
        System.out.println("     SPEEDFAST - Sistema Integral de Gestion de Entregas       ");
        System.out.println("        Desarrollo Orientado a Objetos II - Semana 3           ");
        System.out.println("    Polimorfismo + Abstraccion + Interfaces (Desacoplamiento)  ");
        System.out.println("================================================================");
        System.out.println();
        
        // Crear controlador de envios
        ControladorEnvios controlador = new ControladorEnvios();
        
        // ================================================================
        // PARTE 1: CREACION DE PEDIDOS (Polimorfismo)
        // ================================================================
        System.out.println(">>> PARTE 1: Creacion de Pedidos Diferenciados");
        System.out.println("----------------------------------------------------------------");
        
        // Crear pedidos de diferentes tipos
        PedidoComida pedidoComida = new PedidoComida(101, "Av. Providencia 1234", 4.5, "Sushi");
        PedidoEncomienda pedidoEncomienda = new PedidoEncomienda(102, "Las Condes 5678", 8.0, 12.5, true);
        PedidoExpress pedidoExpress1 = new PedidoExpress(103, "Vitacura 910", 3.0, false);
        PedidoExpress pedidoExpress2 = new PedidoExpress(104, "La Reina 2020", 12.0, true);
        
        // Registrar en el controlador
        controlador.registrarPedido(pedidoComida);
        controlador.registrarPedido(pedidoEncomienda);
        controlador.registrarPedido(pedidoExpress1);
        controlador.registrarPedido(pedidoExpress2);
        
        System.out.println("Se crearon " + controlador.getTotalPedidos() + " pedidos de diferentes tipos.");
        System.out.println();
        
        // ================================================================
        // PARTE 2: ASIGNACION DE REPARTIDORES (Sobrecarga y Sobrescritura)
        // ================================================================
        System.out.println(">>> PARTE 2: Asignacion de Repartidores");
        System.out.println("----------------------------------------------------------------");
        System.out.println();
        
        System.out.println("--- Asignacion AUTOMATICA (sobrescritura @Override) ---");
        pedidoComida.asignarRepartidor();           // Requiere mochila termica
        pedidoEncomienda.asignarRepartidor();       // Valida peso
        System.out.println();
        
        System.out.println("--- Asignacion MANUAL (sobrecarga con parametro) ---");
        pedidoExpress1.asignarRepartidor("Carlos Perez");      // Express normal
        pedidoExpress2.asignarRepartidor("Maria Lopez");       // Express urgente
        System.out.println();
        
        // ================================================================
        // PARTE 3: CALCULO DE TIEMPOS (Metodo abstracto)
        // ================================================================
        System.out.println(">>> PARTE 3: Calculo de Tiempos de Entrega (Abstraccion)");
        System.out.println("----------------------------------------------------------------");
        
        // Arreglo polimorfico
        Pedido[] pedidos = {pedidoComida, pedidoEncomienda, pedidoExpress1, pedidoExpress2};
        
        System.out.println();
        for (Pedido p : pedidos) {
            int tiempo = p.calcularTiempoEntrega();
            System.out.println("Pedido #" + p.getIdPedido() + " (" + p.getTipo() + "):");
            System.out.println("  Distancia: " + p.getDistanciaKm() + " km");
            System.out.println("  Tiempo estimado: " + tiempo + " minutos");
            System.out.println();
        }
        
        // ================================================================
        // PARTE 4: TABLA COMPARATIVA DE TIEMPOS
        // ================================================================
        System.out.println(">>> PARTE 4: Tabla Comparativa de Tiempos");
        System.out.println("----------------------------------------------------------------");
        System.out.println("+--------+----------------+------------+----------------+");
        System.out.println("|   ID   |     Tipo       | Distancia  | Tiempo Entrega |");
        System.out.println("+--------+----------------+------------+----------------+");
        
        for (Pedido p : pedidos) {
            System.out.printf("|  %4d  | %-14s | %6.1f km  |    %3d min     |%n", 
                p.getIdPedido(), 
                p.getTipo(), 
                p.getDistanciaKm(), 
                p.calcularTiempoEntrega());
        }
        System.out.println("+--------+----------------+------------+----------------+");
        System.out.println();
        
        // ================================================================
        // PARTE 5: DESPACHO DE PEDIDOS (Interface Despachable)
        // ================================================================
        System.out.println(">>> PARTE 5: Despacho de Pedidos (Interface Despachable)");
        System.out.println("----------------------------------------------------------------");
        
        controlador.despacharPedido(pedidoComida);
        controlador.despacharPedido(pedidoExpress1);
        controlador.despacharPedido(pedidoExpress2);
        System.out.println();
        
        // ================================================================
        // PARTE 6: CANCELACION DE PEDIDO (Interface Cancelable)
        // ================================================================
        System.out.println(">>> PARTE 6: Cancelacion de Pedido (Interface Cancelable)");
        System.out.println("----------------------------------------------------------------");
        
        controlador.cancelarPedido(pedidoEncomienda);
        System.out.println();
        
        // ================================================================
        // PARTE 7: HISTORIAL DE PEDIDO (Interface Rastreable)
        // ================================================================
        System.out.println(">>> PARTE 7: Historial de un Pedido (Interface Rastreable)");
        System.out.println("----------------------------------------------------------------");
        
        controlador.mostrarHistorialPedido(pedidoComida);
        System.out.println();
        
        // ================================================================
        // PARTE 8: HISTORIAL GLOBAL DE ENTREGAS
        // ================================================================
        System.out.println(">>> PARTE 8: Historial Global de Entregas (Controlador)");
        System.out.println("----------------------------------------------------------------");
        System.out.println();
        System.out.println(controlador.verHistorial());
        System.out.println();
        
        // ================================================================
        // PARTE 9: RESUMEN DE PEDIDOS
        // ================================================================
        System.out.println(">>> PARTE 9: Resumen de todos los Pedidos");
        System.out.println("----------------------------------------------------------------");
        System.out.println();
        
        for (Pedido p : pedidos) {
            p.mostrarResumen();
            System.out.println();
        }
        
        // ================================================================
        // CIERRE
        // ================================================================
        System.out.println("================================================================");
        System.out.println("           Fin de la Demostracion SpeedFast S3                 ");
        System.out.println("        Polimorfismo + Abstraccion + Interfaces OK             ");
        System.out.println("================================================================");
    }
}
