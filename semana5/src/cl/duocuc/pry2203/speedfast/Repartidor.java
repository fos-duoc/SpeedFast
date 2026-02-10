package cl.duocuc.pry2203.speedfast;

/**
 * Representa un repartidor que opera como un hilo independiente.
 * Implementa Runnable para ejecutarse dentro de un ExecutorService o Thread.
 * Cada repartidor retira pedidos de la zona de carga compartida y simula la entrega.
 */
public class Repartidor implements Runnable {

    private final String nombre;
    private final ZonaDeCarga zonaDeCarga;
    private int entregasRealizadas;

    /**
     * Constructor del repartidor.
     * @param nombre Nombre identificador del repartidor.
     * @param zonaDeCarga Referencia al recurso compartido (zona de carga).
     */
    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
        this.entregasRealizadas = 0;
    }

    // --- Getters ---

    public String getNombre() {
        return nombre;
    }

    public int getEntregasRealizadas() {
        return entregasRealizadas;
    }

    /**
     * Logica principal del hilo repartidor.
     * Ciclo: retira pedido -> cambia estado a EN_REPARTO -> simula entrega -> marca ENTREGADO.
     * Si no hay pedidos, el repartidor finaliza su turno.
     */
    @Override
    public void run() {
        String hilo = Thread.currentThread().getName();
        System.out.println("[" + hilo + "] " + nombre + " inicio su turno de reparto.");

        try {
            while (true) {
                // Retirar pedido de la zona de carga (thread-safe via BlockingQueue)
                Pedido pedido = zonaDeCarga.retirarPedido();

                // Si no hay mas pedidos, el repartidor termina
                if (pedido == null) {
                    System.out.println("[" + hilo + "] " + nombre
                            + " no encontro mas pedidos. Fin del turno.");
                    break;
                }

                // Cambiar estado a EN_REPARTO
                pedido.setEstado(EstadoPedido.EN_REPARTO);
                System.out.println("[" + hilo + "] " + nombre
                        + " retiro " + pedido);

                // Simular tiempo de entrega (entre 1 y 3 segundos)
                int tiempoEntrega = 1000 + (int) (Math.random() * 2000);
                System.out.println("[" + hilo + "] " + nombre
                        + " entregando Pedido #" + pedido.getId()
                        + " (estimado: " + tiempoEntrega + " ms)...");
                Thread.sleep(tiempoEntrega);

                // Marcar como ENTREGADO
                pedido.setEstado(EstadoPedido.ENTREGADO);
                entregasRealizadas++;
                System.out.println("[" + hilo + "] " + nombre
                        + " completo " + pedido
                        + " | Total entregas: " + entregasRealizadas);
            }
        } catch (InterruptedException e) {
            System.err.println("[" + hilo + "] " + nombre
                    + " fue interrumpido: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
