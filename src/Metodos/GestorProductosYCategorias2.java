/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Metodos;
/**
 *
 * @author Eduardo
 */
import Modelo.dto.Producto;
import Modelo.dto.Categorias;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;

public class GestorProductosYCategorias2 {
    private ArrayList<Producto> listaProductos;
    private ArrayList<Categorias> listaCategorias;
    private DefaultTableModel modeloTabla;

    // Constructor principal: recibe productos y categorías
    public GestorProductosYCategorias2(ArrayList<Producto> productos, ArrayList<Categorias> categorias, DefaultTableModel modeloTabla) {
        this.listaProductos = productos;
        this.listaCategorias = categorias;
        this.modeloTabla = modeloTabla;
    }

    // Refrescar JTable con todos los productos
    public void actualizarTabla() {
        modeloTabla.setRowCount(0);
        for (Producto p : listaProductos) {
            Object[] fila = {
                p.getCodigo(),
                p.getNombre(),
                p.getDescripcion(),
                p.getPrecioCompra(),
                p.getPrecioVenta(),
                p.getStock(),
                p.getStockMinimo(),
                p.getIdCategoria(),
                p.getIdProveedor(),
                p.getFechaDeVencimiento()
            };
            modeloTabla.addRow(fila);
        }
    }

    // Crear producto
    public boolean agregarProducto(String codigo, String nombre, String descripcion,
                                   double precioCompra, double precioVenta,
                                   int stock, int stockMinimo,
                                   String idCategoria, String idProveedor,
                                   LocalDate fechaVencimiento) {
        if (codigo.isEmpty() || nombre.isEmpty()) {
            return false;
        }
        Producto nuevo = new Producto(codigo, nombre, descripcion, precioCompra, precioVenta,
                                      stock, stockMinimo, idCategoria, idProveedor, fechaVencimiento);
        listaProductos.add(nuevo);
        actualizarTabla();
        return true;
    }

    // Editar producto
    public boolean editarProducto(int filaSeleccionada, String codigo, String nombre, String descripcion,
                                  double precioCompra, double precioVenta,
                                  int stock, int stockMinimo,
                                  String idCategoria, String idProveedor,
                                  LocalDate fechaVencimiento) {
        if (filaSeleccionada < 0 || filaSeleccionada >= listaProductos.size()) {
            return false;
        }
        Producto p = listaProductos.get(filaSeleccionada);
        p.setCodigo(codigo);
        p.setNombre(nombre);
        p.setDescripcion(descripcion);
        p.setPrecioCompra(precioCompra);
        p.setPrecioVenta(precioVenta);
        p.setStock(stock);
        p.setStockMinimo(stockMinimo);
        p.setIdCategoria(idCategoria);
        p.setIdProveedor(idProveedor);
        p.setFechaDeVencimiento(fechaVencimiento);
        actualizarTabla();
        return true;
    }

    // Eliminar producto
    public boolean eliminarProducto(int filaSeleccionada) {
        if (filaSeleccionada < 0 || filaSeleccionada >= listaProductos.size()) {
            return false;
        }
        listaProductos.remove(filaSeleccionada);
        actualizarTabla();
        return true;
    }

    // Buscar por nombre
    public ArrayList<Producto> buscarPorNombre(String nombre) {
        return listaProductos.stream()
                .filter(p -> p.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    // Buscar por código
    public Producto buscarPorCodigo(String codigo) {
        return listaProductos.stream()
                .filter(p -> p.getCodigo().equalsIgnoreCase(codigo))
                .findFirst()
                .orElse(null);
    }

    // Gestión de categorías
    public void agregarCategoria(String idCategoria, String nombreCategoria) {
        listaCategorias.add(new Categorias(idCategoria, nombreCategoria));
    }

    public ArrayList<Categorias> getCategorias() {
        return listaCategorias;
    }

    public ArrayList<Producto> getProductos() {
        return listaProductos;
    }
}
