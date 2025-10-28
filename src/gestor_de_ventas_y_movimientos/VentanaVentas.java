
package gestor_de_ventas_y_movimientos;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class VentanaVentas extends JFrame {
    private ArrayList<Producto> carrito = new ArrayList<>();

    private JComboBox<String> comboProductos;
    private JTextField txtCantidad;
    private JTextArea areaCarrito;
    private JLabel lblTotal;

    private double total = 0;

    public VentanaVentas(ArrayList<Producto> productos, ArrayList<Venta> historial) {
        setTitle("🛒 Punto de Venta - Tienda de Abarrotes");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior
        JPanel panelTop = new JPanel();
        comboProductos = new JComboBox<>();
        for (Producto p : productos) {
            comboProductos.addItem(p.getNombre());
        }

        txtCantidad = new JTextField(5);
        JButton btnAgregar = new JButton("Agregar al carrito");

        panelTop.add(new JLabel("Producto:"));
        panelTop.add(comboProductos);
        panelTop.add(new JLabel("Cantidad:"));
        panelTop.add(txtCantidad);
        panelTop.add(btnAgregar);
        add(panelTop, BorderLayout.NORTH);

        // Área del carrito
        areaCarrito = new JTextArea();
        areaCarrito.setEditable(false);
        add(new JScrollPane(areaCarrito), BorderLayout.CENTER);

        // Panel inferior
        JPanel panelBottom = new JPanel();
        lblTotal = new JLabel("Total: S/. 0.00");
        JButton btnFinalizar = new JButton("Finalizar Venta");
        JButton btnHistorial = new JButton("Ver Historial");

        panelBottom.add(lblTotal);
        panelBottom.add(btnFinalizar);
        panelBottom.add(btnHistorial);
        add(panelBottom, BorderLayout.SOUTH);

        // Acción: agregar producto al carrito
        btnAgregar.addActionListener((ActionEvent e) -> {
            int index = comboProductos.getSelectedIndex();
            Producto p = productos.get(index);
            
            if (txtCantidad.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese una cantidad");
                return;
            }
            
            int cantidad = Integer.parseInt(txtCantidad.getText());
            if (cantidad > p.getStock()) {
                JOptionPane.showMessageDialog(null, "No hay suficiente stock");
                return;
            }
            
            // Agregar al carrito
            carrito.add(new Producto(p.getNombre(), p.getPrecio(), cantidad));
            total += p.getPrecio() * cantidad;
            areaCarrito.append(p.getNombre() + " x" + cantidad + " - S/." + (p.getPrecio() * cantidad) + "\n");
            lblTotal.setText(String.format("Total: S/. %.2f", total));
            txtCantidad.setText("");
        });

        // Acción: finalizar venta
        btnFinalizar.addActionListener((ActionEvent e) -> {
            if (carrito.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay productos en el carrito");
                return;
            }
            
            // Actualizar stock
            for (Producto comprado : carrito) {
                for (Producto p : productos) {
                    if (p.getNombre().equals(comprado.getNombre())) {
                        p.setStock(p.getStock() - comprado.getStock());
                    }
                }
            }
            
            // Registrar venta
            historial.add(new Venta(new ArrayList<>(carrito), total));
            
            JOptionPane.showMessageDialog(null, "Venta realizada con éxito\nTotal: S/." + total);
            
            carrito.clear();
            areaCarrito.setText("");
            lblTotal.setText("Total: S/. 0.00");
            total = 0;
        });

        // Acción: ver historial
        btnHistorial.addActionListener((ActionEvent e) -> {
            StringBuilder sb = new StringBuilder("Historial de Ventas:\n");
            for (Venta v : historial) {
                sb.append(v.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        });
    }
}