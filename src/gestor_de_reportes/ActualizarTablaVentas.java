/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor_de_reportes;
import Modelo.dto.HistoriaVenta;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andre
 */
public class ActualizarTablaVentas {
    private ArrayList<HistoriaVenta> listaVentas;
    private DefaultTableModel Tabla;

    public ActualizarTablaVentas(ArrayList<HistoriaVenta> listaVentas, DefaultTableModel Tabla) {
        this.listaVentas = listaVentas;
        this.Tabla = Tabla;
    }

    public void actualizarTablaVentas() {
        this.Tabla.setRowCount(0); // Limpia
        for (HistoriaVenta his : this.listaVentas) {
            Object[] fila = {
                his.getIdVenta(),
                his.getFecha(),
                his.getIdUsuario(),
                his.getProductoVendido(),
                his.getCantidad(),
                his.getTotal(),
            };
            this.Tabla.addRow(fila);
        }
    }
}
