/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema_de_almacen;

import Interfaces.IExcel;
import Excel.Excel;
import Modelo.dto.Categorias;
import Modelo.dto.HistoriaVenta;
import Modelo.dto.Producto;
import Modelo.dto.Proveedor;
import Modelo.dto.Usuario;
import Formularios.IniciarSesion; 
import java.util.ArrayList;
import java.util.Map;
public class Sistena_de_almacen {
    
    public static void main(String[] args) {
        IExcel excel = new Excel();
        Map<String, ArrayList<?>> datos = excel.cargarDatos();
        ArrayList<Producto> listaProductos = (ArrayList<Producto>) datos.get("Productos");
        ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>) datos.get("Usuarios");
        ArrayList<Categorias> listaCategorias = (ArrayList<Categorias>) datos.get("Categorias");
        ArrayList<Proveedor> listaProveedores = (ArrayList<Proveedor>) datos.get("Proveedores");
        ArrayList<HistoriaVenta> listaVentas = (ArrayList<HistoriaVenta>) datos.get("HistorialVentas");

        IniciarSesion iniciarSesion = new IniciarSesion(
                excel, 
                listaProductos, 
                listaUsuarios, 
                listaCategorias, 
                listaProveedores, 
                listaVentas
        );
        iniciarSesion.setVisible(true);
        iniciarSesion.setLocationRelativeTo(null);
    }    
}
