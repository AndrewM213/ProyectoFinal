/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Modelo.dto.CarroCompra;
import Modelo.dto.HistoriaVenta;
import Modelo.dto.Producto;
import Modelo.dto.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentaControlador {
    // --- Listas de Datos ---
    private ArrayList<Producto> listaProductos;
    private ArrayList<HistoriaVenta> listaHistorialVentas;
    private Usuario usuarioActual;
    
    // --- Carrito Actual ---
    private ArrayList<CarroCompra> carritoActual; // ¡TIPO AJUSTADO!
    
    // --- Componentes de la Vista ---
    private DefaultTableModel modeloTabla;
    private JLabel lblTotal;

    // Constructor
    public VentaControlador(ArrayList<Producto> p, ArrayList<HistoriaVenta> v, Usuario u, DefaultTableModel m, JLabel lbl) {
        this.listaProductos = p;
        this.listaHistorialVentas = v;
        this.usuarioActual = u;
        this.modeloTabla = m;
        this.lblTotal = lbl;
        this.carritoActual = new ArrayList<>(); // Inicia el carrito vacío
    }
    
    // --- Lógica de Búsqueda (Sin cambios) ---
    private Producto buscarProductoPorCodigo(String codigo) {
        for (Producto p : this.listaProductos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    // --- Lógica del btnAgregar ---
    public void agregarAlCarrito(String codigo, int cantidad) {
        // 1. Buscar el producto
        Producto p = buscarProductoPorCodigo(codigo);
        if (p == null) {
            JOptionPane.showMessageDialog(null, "Error: Producto no encontrado.");
            return;
        }

        // 2. Validar Stock
        if (p.getStock() < cantidad) {
            JOptionPane.showMessageDialog(null, "Error: Stock insuficiente. Solo quedan " + p.getStock() + " unidades.");
            return;
        }

        // 3. Crear item y añadir al carrito
        CarroCompra item = new CarroCompra(p, cantidad); // ¡CLASE AJUSTADA!
        this.carritoActual.add(item);
        
        // 4. Actualizar la vista
        actualizarTablaCarrito();
    }

    // --- Lógica del btnFinalizarVenta ---
    public void finalizarVenta() {
        if (carritoActual.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos en el carrito.");
            return;
        }
        
        // 1. Recorre el carrito y actualiza el stock MAESTRO
        for (CarroCompra item : carritoActual) { // ¡CLASE AJUSTADA!
            Producto p = buscarProductoPorCodigo(item.getCodigo());
            p.setStock(p.getStock() - item.getCantidad()); // ¡RESTA EL STOCK!
        }

        // 2. Crea UN registro para el Historial de Ventas
        // (Simplificado: guardamos una fila por cada item)
        String idVentaUnica = "V-" + UUID.randomUUID().toString().substring(0, 8);
        
        for (CarroCompra item : carritoActual) { // ¡CLASE AJUSTADA!
            HistoriaVenta v = new HistoriaVenta();
            v.setIdVenta(idVentaUnica);
            v.setFecha(LocalDate.now());
            v.setIdUsuario(usuarioActual.getIdUsuario());
            v.setProductoVendido(item.getNombre());
            v.setCantidad(item.getCantidad());
            v.setTotal(item.getSubtotal());
            
            this.listaHistorialVentas.add(v); 
        }
        
        // 3. Limpia la vista
        cancelarVenta();
        JOptionPane.showMessageDialog(null, "¡Venta realizada con éxito!");
    }

    // --- Lógica de la Vista ---
    public void actualizarTablaCarrito() {
        modeloTabla.setRowCount(0);
        double total = 0;
        
        for (CarroCompra item : carritoActual) { 
            Object[] fila = {
                item.getCodigo(),
                item.getNombre(),
                item.getCantidad(),
                item.getPrecioUnitario(),
                item.getSubtotal()
            };
            modeloTabla.addRow(fila);
            total += item.getSubtotal();
        }
        
        // Actualiza el JLabel del total
        lblTotal.setText(String.format("S/ %.2f", total));
    }

    public void eliminarItem(int filaSeleccionada) {
        if (filaSeleccionada >= 0) {
            carritoActual.remove(filaSeleccionada);
            actualizarTablaCarrito();
        }
    }
    
    public void cancelarVenta() {
        carritoActual.clear();
        actualizarTablaCarrito();
    }
}
   
