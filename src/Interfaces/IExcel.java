/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

/**
 *
 * @author andre
 */

import java.util.ArrayList;
import java.util.Map;
import Modelo.dto.Categorias;
import Modelo.dto.HistoriaVenta;
import Modelo.dto.Producto;
import Modelo.dto.Proveedor;
import Modelo.dto.Usuario;
public interface IExcel {
    Map<String, ArrayList<?>> cargarDatos();
    
    void guardarDatos(ArrayList<Producto> productos,
            ArrayList<Usuario> usuarios,
            ArrayList<Categorias> categorias,
            ArrayList<Proveedor> proveedores,
            ArrayList<HistoriaVenta> historial);
            
    
}
