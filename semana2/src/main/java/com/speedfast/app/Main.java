package com.speedfast.app;

import com.speedfast.model.Pedido;
import com.speedfast.model.PedidoComida;
import com.speedfast.model.PedidoEncomienda;
import com.speedfast.model.PedidoExpress;

/**
 * Clase principal para demostrar la jerarquia de clases abstractas en SpeedFast.
 * Crea objetos de cada tipo de pedido, muestra resumen y calcula tiempos de entrega.
 * 
 * @author Fuad Oñate
 * Desarrollo Orientado a Objetos II - Semana 2
 */
public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("================================================================");
        System.out.println("     SPEEDFAST - Sistema de Calculo de Tiempos de Entrega     ");
        System.out.println("        Desarrollo Orientado a Objetos II - Semana 2          ");
        System.out.println("           Jerarquias con Clases Abstractas                   ");
        System.out.println("================================================================");
        System.out.println();
        
        // =====================================================================
        // PARTE 1: Crear instancias de cada tipo de pedido
        // =====================================================================
        System.out.println(">>> PARTE 1: Creacion de Pedidos");
        System.out.println("----------------------------------------------------------------");
        
        // Pedido de Comida: 15 min + 2 min/km
        PedidoComida pedidoComida = new PedidoComida(101, "Av. Providencia 1234", 4.5, "Sushi");
        
        // Pedido de Encomienda: 20 min + 1.5 min/km
        PedidoEncomienda pedidoEncomienda = new PedidoEncomienda(102, "Calle Las Condes 567", 8.0, 2.5);
        
        // Pedido Express corto (<=5km): 10 min base
        PedidoExpress pedidoExpressCorto = new PedidoExpress(103, "Metro Tobalaba", 3.0, true);
        
        // Pedido Express largo (>5km): 10 min + 5 min extra
        PedidoExpress pedidoExpressLargo = new PedidoExpress(104, "Aeropuerto SCL", 12.0, true);
        
        System.out.println("Se crearon 4 pedidos de diferentes tipos.");
        System.out.println();
        
        // =====================================================================
        // PARTE 2: Mostrar resumen de cada pedido
        // =====================================================================
        System.out.println(">>> PARTE 2: Resumen de cada Pedido");
        System.out.println("----------------------------------------------------------------");
        
        pedidoComida.mostrarResumen();
        System.out.println();
        
        pedidoEncomienda.mostrarResumen();
        System.out.println();
        
        pedidoExpressCorto.mostrarResumen();
        System.out.println();
        
        pedidoExpressLargo.mostrarResumen();
        System.out.println();
        
        // =====================================================================
        // PARTE 3: Calcular y comparar tiempos de entrega
        // =====================================================================
        System.out.println(">>> PARTE 3: Calculo de Tiempos de Entrega");
        System.out.println("----------------------------------------------------------------");
        
        int tiempoComida = pedidoComida.calcularTiempoEntrega();
        int tiempoEncomienda = pedidoEncomienda.calcularTiempoEntrega();
        int tiempoExpressCorto = pedidoExpressCorto.calcularTiempoEntrega();
        int tiempoExpressLargo = pedidoExpressLargo.calcularTiempoEntrega();
        
        System.out.println("Pedido #" + pedidoComida.getIdPedido() + " (Comida):");
        System.out.println("  Formula: 15 min + 2 min * " + pedidoComida.getDistanciaKm() + " km");
        System.out.println("  Tiempo estimado: " + tiempoComida + " minutos");
        System.out.println();
        
        System.out.println("Pedido #" + pedidoEncomienda.getIdPedido() + " (Encomienda):");
        System.out.println("  Formula: 20 min + 1.5 min * " + pedidoEncomienda.getDistanciaKm() + " km");
        System.out.println("  Tiempo estimado: " + tiempoEncomienda + " minutos");
        System.out.println();
        
        System.out.println("Pedido #" + pedidoExpressCorto.getIdPedido() + " (Express <= 5km):");
        System.out.println("  Formula: 10 min base (distancia " + pedidoExpressCorto.getDistanciaKm() + " km <= 5 km)");
        System.out.println("  Tiempo estimado: " + tiempoExpressCorto + " minutos");
        System.out.println();
        
        System.out.println("Pedido #" + pedidoExpressLargo.getIdPedido() + " (Express > 5km):");
        System.out.println("  Formula: 10 min + 5 min extra (distancia " + pedidoExpressLargo.getDistanciaKm() + " km > 5 km)");
        System.out.println("  Tiempo estimado: " + tiempoExpressLargo + " minutos");
        System.out.println();
        
        // =====================================================================
        // PARTE 4: Tabla comparativa usando polimorfismo
        // =====================================================================
        System.out.println(">>> PARTE 4: Tabla Comparativa de Tiempos");
        System.out.println("----------------------------------------------------------------");
        
        // Arreglo polimorfico de tipo Pedido
        Pedido[] pedidos = {pedidoComida, pedidoEncomienda, pedidoExpressCorto, pedidoExpressLargo};
        
        System.out.println("+--------+----------------+------------+----------------+");
        System.out.println("|   ID   |     Tipo       | Distancia  | Tiempo Entrega |");
        System.out.println("+--------+----------------+------------+----------------+");
        
        for (Pedido p : pedidos) {
            String tipo = p.getClass().getSimpleName().replace("Pedido", "");
            System.out.printf("|  %4d  | %-14s |   %5.1f km |    %3d min     |%n",
                    p.getIdPedido(), tipo, p.getDistanciaKm(), p.calcularTiempoEntrega());
        }
        
        System.out.println("+--------+----------------+------------+----------------+");
        System.out.println();
        
        // =====================================================================
        // FIN
        // =====================================================================
        System.out.println("================================================================");
        System.out.println("          Fin de la demostracion SpeedFast S2                 ");
        System.out.println("================================================================");
    }
}
