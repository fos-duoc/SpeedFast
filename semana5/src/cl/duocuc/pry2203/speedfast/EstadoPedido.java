package cl.duocuc.pry2203.speedfast;

/**
 * Enum que representa los posibles estados de un pedido en el sistema SpeedFast.
 * Sigue el ciclo de vida: PENDIENTE -> EN_REPARTO -> ENTREGADO.
 */
public enum EstadoPedido {
    PENDIENTE("Pendiente"),
    EN_REPARTO("En Reparto"),
    ENTREGADO("Entregado");

    private final String descripcion;

    EstadoPedido(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
