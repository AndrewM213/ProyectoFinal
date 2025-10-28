
package gestor_de_ventas_y_movimientos;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Venta {
    private final ArrayList<Producto> productosVendidos;
    private final double total;
    private final LocalDateTime fecha;

    public Venta(ArrayList<Producto> productosVendidos, double total) {
        this.productosVendidos = productosVendidos;
        this.total = total;
        this.fecha = LocalDateTime.now();
    }

    public double getTotal() {
        return total;
    }

    public String getFecha() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return fecha.format(f);
    }

    public ArrayList<Producto> getProductosVendidos() {
        return productosVendidos;
    }

    @Override
    public String toString() {
        return "Venta: " + productosVendidos.size() + " productos - Total S/." + total + " - " + getFecha();
    }
}