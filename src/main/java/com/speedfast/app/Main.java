package com.speedfast.app;

import com.speedfast.model.Pedido;
import com.speedfast.model.PedidoComida;
import com.speedfast.model.PedidoEncomienda;
import com.speedfast.model.PedidoExpress;

/**
 * Clase principal para demostrar el polimorfismo en SpeedFast
 * Muestra sobrescritura y sobrecarga del metodo asignarRepartidor()
 * 
 * @author Fuad Oñate
 * Desarrollo Orientado a Objetos II - Semana 1
 */
public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║        SPEEDFAST - Sistema de Asignacion de Repartidores     ║");
        System.out.println("║        Desarrollo Orientado a Objetos II - Semana 1          ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        // Crear instancias de cada tipo de pedido
        PedidoComida pedidoComida = new PedidoComida(101, "Av. Providencia 1234", "Sushi Master");
        PedidoEncomienda pedidoEncomienda = new PedidoEncomienda(102, "Las Condes 5678", 3.5, "Documentos");
        PedidoExpress pedidoExpress = new PedidoExpress(103, "Vitacura 910", "Farmacia");
        
        // ========================================
        // DEMOSTRACION DE SOBRESCRITURA (Override)
        // ========================================
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│  PARTE 1: SOBRESCRITURA - asignarRepartidor() sin parametros │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        System.out.println();
        
        // Polimorfismo: cada objeto ejecuta su propia version del metodo
        System.out.println(">>> Pedido de Comida:");
        pedidoComida.asignarRepartidor();
        System.out.println();
        
        System.out.println(">>> Pedido de Encomienda:");
        pedidoEncomienda.asignarRepartidor();
        System.out.println();
        
        System.out.println(">>> Pedido Express:");
        pedidoExpress.asignarRepartidor();
        System.out.println();
        
        // ========================================
        // DEMOSTRACION DE SOBRECARGA (Overload)
        // ========================================
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│  PARTE 2: SOBRECARGA - asignarRepartidor(String nombre)      │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        System.out.println();
        
        // Llamada con parametro: nombre del repartidor
        System.out.println(">>> Pedido de Comida - Repartidor especifico:");
        pedidoComida.asignarRepartidor("Carlos Mendez");
        System.out.println();
        
        System.out.println(">>> Pedido de Encomienda - Repartidor especifico:");
        pedidoEncomienda.asignarRepartidor("Maria Gonzalez");
        System.out.println();
        
        System.out.println(">>> Pedido Express - Repartidor especifico:");
        pedidoExpress.asignarRepartidor("Pedro Soto");
        System.out.println();
        
        // ========================================
        // DEMOSTRACION DE POLIMORFISMO CON ARREGLO
        // ========================================
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│  PARTE 3: POLIMORFISMO - Arreglo de tipo Pedido              │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        System.out.println();
        
        // Arreglo de tipo Pedido (clase base) que almacena objetos de subclases
        Pedido[] pedidos = new Pedido[3];
        pedidos[0] = new PedidoComida(201, "Nunoa 111", "Pizza Hut");
        pedidos[1] = new PedidoEncomienda(202, "Maipu 222", 8.0, "Paquete fragil");
        pedidos[2] = new PedidoExpress(203, "Puente Alto 333", "Supermercado");
        
        System.out.println("Procesando pedidos con polimorfismo:");
        System.out.println("------------------------------------");
        
        for (Pedido pedido : pedidos) {
            System.out.println();
            System.out.println("Pedido tipo: " + pedido.getClass().getSimpleName());
            pedido.asignarRepartidor(); // Cada objeto ejecuta SU version
        }
        
        System.out.println();
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║               Fin de la demostracion SpeedFast               ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
    }
}
