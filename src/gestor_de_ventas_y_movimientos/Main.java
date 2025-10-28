
package gestor_de_ventas_y_movimientos;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Arroz 1kg", 5.50, 30));
        productos.add(new Producto("Azúcar 1kg", 4.80, 25));
        productos.add(new Producto("Aceite 1L", 8.50, 15));
        productos.add(new Producto("Leche evaporada", 3.20, 40));
        productos.add(new Producto("Huevos (docena)", 10.00, 20));

        ArrayList<Venta> historial = new ArrayList<>();

        VentanaVentas ventana = new VentanaVentas(productos, historial);
        ventana.setVisible(true);
    }
}