/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor_de_reportes;

import Modelo.dto.HistoriaVenta;
import Modelo.dto.Producto;

/**
 *
 * @author andre
 */
      
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public class ActualizarInventario {
    private ArrayList<HistoriaVenta> listaVentas;
    private ArrayList<Producto> listaProductos; 
    private DefaultTableModel Tabla;    

    public ActualizarInventario(ArrayList<Producto> listaProductos, DefaultTableModel Tabla) {
        this.listaProductos = listaProductos;
        this.Tabla = Tabla;
    }
    
    public void actualizarTablaInventario() {
        this.Tabla.setRowCount(0); // Limpia
        for (Producto pro : this.listaProductos) {
            Object[] fila = {
                pro.getCodigo(),
                pro.getNombre(),
                pro.getStock(),
                pro.getStockMinimo(),
                pro.getPrecioVenta(),
                pro.getStock() * pro.getPrecioCompra()
            };
            this.Tabla.addRow(fila);
        }
    }
    public void actualizarTablaStock() {
        this.Tabla.setRowCount(0); // Limpia
        for (Producto pro : this.listaProductos) {
            Object[] fila = {
                pro.getCodigo(),
                pro.getNombre(),
                pro.getStock(),
                pro.getStockMinimo(),
            };
            this.Tabla.addRow(fila);
        }
    }
     
}
