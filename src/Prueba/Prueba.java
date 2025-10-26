/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba;

import Excel.Excel;
import Modelo.dto.Producto;
import Modelo.dto.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import sistema_de_almacen.InventarioProveedorControlador; //Importar el controlador

/**
 *
 * @author andre
 */
public class Prueba {
    public static void main(String[] args) {
        
        // 1. CREA UNA INSTANCIA DE TU GESTOR
        Excel gestor = new Excel();

        // 2. PRUEBA DE LECTURA (cargarDatos)
        System.out.println("--- PRUEBA DE LECTURA ---");
        
        // Llama a tu método para cargar todo
        Map<String, ArrayList<?>> datosCargados = gestor.cargarDatos();
        
        // Extrae las listas del HashMap
        ArrayList<Producto> productos = (ArrayList<Producto>) datosCargados.get("Productos");
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) datosCargados.get("Usuarios");

        // --- VERIFICACIÓN DE LECTURA ---
        // Comprueba si realmente se cargaron los datos
        
        if (productos != null && !productos.isEmpty()) {
            System.out.println("¡ÉXITO! Se cargaron " + productos.size() + " productos.");
            // Imprime el primer producto para verificar
            Producto primerProducto = productos.get(0);
            System.out.println("El primer producto es: " + primerProducto.getNombre() + 
                               " con stock: " + primerProducto.getStock());
        } else {
            System.out.println("FALLO: No se cargaron productos.");
        }
        
        if (usuarios != null && !usuarios.isEmpty()) {
            System.out.println("¡ÉXITO! Se cargaron " + usuarios.size() + " usuarios.");
            System.out.println("El primer usuario es: " + usuarios.get(0).getNombreUsuario());
        } else {
            System.out.println("FALLO: No se cargaron usuarios.");
        }
        
        System.out.println("\n--- FIN PRUEBA DE LECTURA ---");
        
        //ALERTAS(INVENTARIOPROVEEDORCONTROLADOR)
        
        System.out.println("\n--- INICIO PRUEBA DE ALERTA DE BAJO STOCK ---");
        
        ArrayList<Modelo.dto.Proveedor> proveedores = new ArrayList<>();
        
        InventarioProveedorControlador controladorInventario = 
                new InventarioProveedorControlador(productos, proveedores);
        
        if (productos != null && !productos.isEmpty()){
            Producto productoAProbar = productos.get(0);
            
            if (productoAProbar.getStock() > 0) {
                productoAProbar.setStock(0); //Stock 0
                productoAProbar.setStockMinimo(5); //Stock Minimo = 5
            }
            System.out.println(">>> El producto '" + productoAProbar.getNombre()+
                    "'a sido puesto con Stock 0 y minimo 5 para la prueba");
        }
        
        ArrayList<Producto> productosConAlerta = controladorInventario.generarAlertaBajoStock();
        
        System.out.println("\n>>> RESULTADO DE ALERTA (generarAlertasBajoStock):");
        
        if (productosConAlerta.isEmpty()) {
            System.out.println("--- EXITO: No se encontraron productos con bajo stock. ---");
        }else {
            System.out.println("--- ALERTA DETECTADA. Productos con bajo stock. ---");
            System.out.printf("%-20s | %-10s | %-10s%n", "NOMBRE", "STOCK", "MINIMO");                        
            System.out.println("--------------------------------------------------");
            
            for (Producto p : productosConAlerta) {
                System.out.printf("%-20s | %-10d | %-10d%n",
                                  p.getNombre(),
                                  p.getStock(),
                                  p.getStockMinimo());
            }
            System.out.println("--------------------------------------------------");
            System.out.println(">>> Total de Alertas Generadas: "+ productosConAlerta.size());
        }
        System.out.println("--- FIN PRUEBA DE ALERTA ---");

        
        // 3. PRUEBA DE ESCRITURA (guardarDatos)
        System.out.println("\n--- PRUEBA DE ESCRITURA ---");

        // --- PREPARACIÓN DE DATOS ---
        // Vamos a modificar los datos para ver si se guardan
        
        // A) Creamos un nuevo producto de prueba
        Producto productoPrueba = new Producto("PRUEBA-002", "Producto de Prueb2a", "Producto de prueba 0021", 99.39, 101.20, 10, 2, "Cat-0045", "Prov-0045", LocalDate.of(2025, 12, 31));
        // B) Lo añadimos a la lista que ya cargamos
        if (productos != null) {
            productos.add(productoPrueba);
            System.out.println("Se añadió un producto de prueba a la lista en memoria.");
        }

        // --- EJECUCIÓN DE ESCRITURA ---
        // Llama a tu método para guardar
        if (productos != null && usuarios != null) {
            gestor.guardarDatos(productos, usuarios); // Pasa las listas actualizadas
            System.out.println("¡ÉXITO! Se intentó guardar los datos en el Excel.");
        } else {
            System.out.println("FALLO: No se pudo guardar porque las listas están vacías.");
        }
        
        System.out.println("--- FIN PRUEBA DE ESCRITURA ---");
    }
}

 

