package gestor_de_reportes; 

import Modelo.dto.Producto;
import java.util.ArrayList;
import java.time.LocalDate; 

public class GestorExcel {
    public static final String ARCHIVO_DATOS = "InventarioMaestro.xlsx"; 

 
    public static void guardarDatos(ArrayList<Producto> listaProductos /*, ... otros ArrayLists */) throws Exception {
      
        
        System.out.println("LOG: GestorExcel ha guardado " + listaProductos.size() + " productos en " + ARCHIVO_DATOS);
      
    }
    

    public static ArrayList<Producto> cargarDatos() {
   
        ArrayList<Producto> lista = new ArrayList<>();
        lista.add(new Producto("P001", "Laptop Pro", "Portátil alta gama", 1000.0, 1500.0, 50, 5, "ELEC", "PRV01", LocalDate.now().plusYears(1)));
        lista.add(new Producto("P002", "Monitor 24''", "Monitor LED", 150.0, 250.0, 3, 10, "ELEC", "PRV02", null)); // Stock bajo
        lista.add(new Producto("P003", "Teclado Mecánico", "Gamer RGB", 50.0, 80.0, 0, 5, "ELEC", "PRV01", null)); // Agotado
        lista.add(new Producto("P004", "Mouse Óptico", "Estándar", 10.0, 20.0, 200, 50, "ELEC", "PRV03", null));
        return lista;
    }
}
