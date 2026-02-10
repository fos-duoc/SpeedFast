package cl.duocuc.pry2203.speedfast;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Representa la zona de carga compartida entre multiples repartidores.
 * Utiliza BlockingQueue para garantizar acceso concurrente seguro (thread-safe)
 * y evitar entregas duplicadas.
 */
public class ZonaDeCarga {

    private final BlockingQueue<Pedido> colaPedidos;

    /**
     * Constructor que inicializa la zona de carga con capacidad ilimitada.
     */
    public ZonaDeCarga() {
        this.colaPedidos = new LinkedBlockingQueue<>();
    }

    /**
     * Agrega un pedido a la zona de carga.
     * BlockingQueue es thread-safe, por lo que multiples productores pueden agregar sin conflicto.
     * @param pedido Pedido a agregar.
     */
    public void agregarPedido(Pedido pedido) {
        colaPedidos.offer(pedido);
        System.out.println("[ZONA DE CARGA] Pedido #" + pedido.getId()
                + " agregado -> " + pedido.getDireccionEntrega());
    }

    /**
     * Retira un pedido de la zona de carga de forma segura.
     * Utiliza poll() que retorna null si la cola esta vacia (no bloquea).
     * @return Pedido retirado o null si no hay pedidos disponibles.
     */
    public Pedido retirarPedido() {
        return colaPedidos.poll();
    }

    /**
     * Verifica si aun quedan pedidos en la zona de carga.
     * @return true si la cola esta vacia.
     */
    public boolean estaVacia() {
        return colaPedidos.isEmpty();
    }

    /**
     * Retorna la cantidad actual de pedidos en la zona de carga.
     * @return Cantidad de pedidos pendientes de retiro.
     */
    public int cantidadPedidos() {
        return colaPedidos.size();
    }
}
