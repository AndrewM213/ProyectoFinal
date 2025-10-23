/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excel;

import Modelo.dto.Producto;
import Modelo.dto.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




/**
 *
 * @author andre
 */
public class Excel {
   private static final String RUTA_EXCEL = "Inventario.xlsx";

    /**
     * Lee todas las hojas del Excel y las carga en ArrayLists.Devuelve un Mapa donde la clave es el nombre de la hoja (ej.
     * "Usuarios")
 y el valor es el ArrayList correspondiente.
     * @return 
     */
    public Map<String, ArrayList<?>> cargarDatos() {
        Map<String, ArrayList<?>> datos = new HashMap<>();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ArrayList<Producto> listaProductos = new ArrayList<>();
        // ... (crear listas para Categorias, Proveedores, etc.)

        try (FileInputStream fis = new FileInputStream(RUTA_EXCEL);
             Workbook workbook = new XSSFWorkbook(fis)) {

            // --- 1. Cargar Usuarios ---
            Sheet sheetUsuarios = workbook.getSheet("Usuarios");
            for (Row row : sheetUsuarios) {
                if (row.getRowNum() == 0) continue; // Saltar la cabecera
                
                Usuario user = new Usuario();
                user.setIdUsuario(row.getCell(0).getStringCellValue());
                user.setNombreUsuario(row.getCell(1).getStringCellValue());
                user.setContrasena(row.getCell(2).getStringCellValue());
                user.setRol(row.getCell(3).getStringCellValue());
                listaUsuarios.add(user);
            }

            // --- 2. Cargar Productos ---
            Sheet sheetProductos = workbook.getSheet("Productos");
            for (Row row : sheetProductos) {
                if (row.getRowNum() == 0) continue; // Saltar cabecera
                
                Producto prod = new Producto();
                prod.setCodigo(row.getCell(0).getStringCellValue());
                prod.setNombre(row.getCell(1).getStringCellValue());
                prod.setDescripcion(row.getCell(2).getStringCellValue());
                prod.setPrecioCompra(row.getCell(3).getNumericCellValue());
                prod.setPrecioVenta(row.getCell(4).getNumericCellValue());
                prod.setStock((int) row.getCell(5).getNumericCellValue());
                prod.setStockMinimo((int) row.getCell(6).getNumericCellValue());
                prod.setIdCategoria(row.getCell(7).getStringCellValue());
                prod.setIdProveedor(row.getCell(8).getStringCellValue());
                Cell celdaFecha = row.getCell(9);
            
            // 1. ¿La celda existe y es de tipo NÚMERICO?
            // (Excel guarda las fechas como números)
            if (celdaFecha != null && celdaFecha.getCellType() == CellType.NUMERIC) {
                
                // 2. Doble chequeo: ¿Ese número tiene formato de fecha?
                if (DateUtil.isCellDateFormatted(celdaFecha)) {
                
                    // 3. Obtiene la fecha como 'java.util.Date' (el formato antiguo)
                    java.util.Date fechaAntigua = celdaFecha.getDateCellValue();

                    // 4. Convierte la fecha antigua a 'java.time.LocalDate' (el moderno)
                    LocalDate fechaNueva = fechaAntigua.toInstant()
                                                       .atZone(ZoneId.systemDefault())
                                                       .toLocalDate();

                    // 5. Guarda la fecha moderna en el objeto
                    prod.setFechaDeVencimiento(fechaNueva);
                    
                } else {
                    // Es un número, pero no una fecha (quizás es el stock)
                    prod.setFechaDeVencimiento(null);
                }
                
            } else {
                // La celda está vacía o es texto (ej. "N/A")
                prod.setFechaDeVencimiento(null);
            }
                
                listaProductos.add(prod);
            }
            
            // ... (Cargar las otras hojas: Categorias, Proveedores...)
            
            // Poner las listas en el mapa para devolverlas
            datos.put("Usuarios", listaUsuarios);
            datos.put("Productos", listaProductos);
            
            System.out.println("Datos cargados desde Excel exitosamente.");

        } catch (Exception e) {
            e.printStackTrace();
            // Aquí se manejaría un error (ej. archivo no encontrado)
        }
        
        return datos;
    }

    /**
     * Valida si un usuario y contraseña existen en la lista de usuarios.
     * Esta lista fue cargada previamente desde el Excel.
     */
    public Usuario validarLogin(String username, String password, ArrayList<Usuario> usuarios) {
        for (Usuario user : usuarios) {
            if (user.getNombreUsuario().equals(username) && user.getContrasena().equals(password)) {
                return user; // Usuario encontrado
            }
        }
        return null; // Usuario no encontrado
    }


    /**
     * Sobrescribe el archivo Excel con los datos actualizados de los ArrayLists.
     * ESTA ES LA FUNCIÓN QUE SE LLAMA AL CERRAR LA APP O AL DAR "GUARDAR".
     */
        
     public void guardarDatos(ArrayList<Producto> productos, ArrayList<Usuario> usuarios) {

        try (FileInputStream fis = new FileInputStream(RUTA_EXCEL);
         Workbook workbook = new XSSFWorkbook(fis)) { // <-- 1. LEE EL ARCHIVO EXISTENTE

        // --- 1. Guardar Productos ---
        Sheet sheetProductos = workbook.getSheet("Productos"); // <-- 2. OBTIENE LA HOJA (no la crea)
        
        // 3. Limpia solo los datos (deja la cabecera, fila 0)
        int lastRow = sheetProductos.getLastRowNum();
        CellStyle cellStyleFecha = workbook.createCellStyle();
        CreationHelper createHelper = workbook.getCreationHelper();
        cellStyleFecha.setDataFormat(createHelper.createDataFormat().getFormat("dd/mm/yyyy"));
        for (int i = lastRow; i >= 1; i--) { // Loop hacia atrás para borrar
            Row row = sheetProductos.getRow(i);
            if (row != null) {
                sheetProductos.removeRow(row);
            }
        }

        // 4. Escribe los datos nuevos desde la fila 1
        int rowNum = 1;
        for (Producto p : productos) {
            Row row = sheetProductos.createRow(rowNum++);
            // Asegúrate de escribir EN EL MISMO ORDEN que tus cabeceras
            row.createCell(0).setCellValue(p.getCodigo());
            row.createCell(1).setCellValue(p.getNombre());
            row.createCell(2).setCellValue(p.getDescripcion());
            row.createCell(3).setCellValue(p.getPrecioCompra()); 
            row.createCell(4).setCellValue(p.getPrecioVenta());
            row.createCell(5).setCellValue(p.getStock());
            row.createCell(6).setCellValue(p.getStockMinimo());
            row.createCell(7).setCellValue(p.getIdCategoria());
            row.createCell(8).setCellValue(p.getIdProveedor());
            Cell celdaFecha = row.createCell(9);
            if (p.getFechaDeVencimiento() != null) {
                // Escribe el valor de la fecha
               celdaFecha.setCellValue(p.getFechaDeVencimiento());
                
                // ¡¡APLICA EL ESTILO!!
                // Si te falta esta línea, verás el número 46022
                celdaFecha.setCellStyle(cellStyleFecha);
            }

        }

        // --- 2. Guardar Usuarios (Repite el mismo proceso) ---
        Sheet sheetUsuarios = workbook.getSheet("Usuarios"); // Obtiene la hoja de Usuarios

        // Limpia datos de usuarios
        lastRow = sheetUsuarios.getLastRowNum();
        for (int i = lastRow; i >= 1; i--) {
            Row row = sheetUsuarios.getRow(i);
            if (row != null) {
                sheetUsuarios.removeRow(row);
            }
        }
        
        // Escribe datos nuevos de usuarios
        rowNum = 1;
        for (Usuario u : usuarios) {
            Row row = sheetUsuarios.createRow(rowNum++);
            row.createCell(0).setCellValue(u.getIdUsuario());
            row.createCell(1).setCellValue(u.getNombreUsuario());
            row.createCell(2).setCellValue(u.getContrasena());
            row.createCell(3).setCellValue(u.getRol());
        }

        // --- (Repetir el proceso para Categorias, Proveedores, etc.) ---

        
        // 5. Escribe los cambios de vuelta AL MISMO ARCHIVO
        try (FileOutputStream fos = new FileOutputStream(RUTA_EXCEL)) {
            workbook.write(fos);
            System.out.println("Datos guardados en Excel exitosamente (MODO ACTUALIZACIÓN).");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
     }
}
    

    