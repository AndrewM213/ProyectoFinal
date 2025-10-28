/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema_de_almacen;

/**
 *
 * @author HP SUPPORT
 */
import Interfaces.IExcel;
import Excel.Excel;
import Modelo.dto.Categorias;
import Modelo.dto.HistoriaVenta;
import Modelo.dto.Producto;
import Modelo.dto.Proveedor;
import Modelo.dto.Usuario;
import Formularios.Login; 
import java.util.ArrayList;
import java.util.Map;
public class Sistena_de_almacen {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
       IExcel excel = new Excel();
        
        // 2. Carga todos los datos del Excel
        Map<String, ArrayList<?>> datos = excel.cargarDatos();

        // 3. Extrae todas las listas de datos del Mapa
        ArrayList<Producto> listaProductos = (ArrayList<Producto>) datos.get("Productos");
        ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>) datos.get("Usuarios");
        ArrayList<Categorias> listaCategorias = (ArrayList<Categorias>) datos.get("Categorias");
        ArrayList<Proveedor> listaProveedores = (ArrayList<Proveedor>) datos.get("Proveedores");
        ArrayList<HistoriaVenta> listaVentas = (ArrayList<HistoriaVenta>) datos.get("HistorialVentas");

        // 4. Abre la Ventana de Login
        // Le pasamos TODAS las listas y el GESTOR,
        // para que esta ventana se las pase a la siguiente (VentanaPrincipal).
        Login Login = new Login(
                excel, 
                listaProductos, 
                listaUsuarios, 
                listaCategorias, 
                listaProveedores, 
                listaVentas
        );
        
        Login.setVisible(true);
        Login.setLocationRelativeTo(null); // Centra la ventana
    }
    
}
