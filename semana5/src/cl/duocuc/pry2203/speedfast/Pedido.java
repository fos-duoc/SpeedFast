package cl.duocuc.pry2203.speedfast;

/**
 * Representa un pedido en el sistema de entregas SpeedFast.
 * Contiene la informacion del pedido y su estado actual dentro del ciclo de vida.
 */
public class Pedido {

    private final int id;
    private final String direccionEntrega;
    private EstadoPedido estado;

    /**
     * Constructor que inicializa un pedido con estado PENDIENTE por defecto.
     * @param id Identificador unico del pedido.
     * @param direccionEntrega Direccion de destino del pedido.
     */
    public Pedido(int id, String direccionEntrega) {
        this.id = id;
        this.direccionEntrega = direccionEntrega;
        this.estado = EstadoPedido.PENDIENTE;
    }

    // --- Getters ---

    public int getId() {
        return id;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public synchronized EstadoPedido getEstado() {
        return estado;
    }

    // --- Setter ---

    /**
     * Cambia el estado del pedido de forma sincronizada para evitar condiciones de carrera.
     * @param estado Nuevo estado del pedido.
     */
    public synchronized void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return String.format("Pedido #%d [%s] -> %s", id, estado, direccionEntrega);
    }
}
