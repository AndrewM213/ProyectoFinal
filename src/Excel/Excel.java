/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excel;

import Modelo.dto.Producto;
import Modelo.dto.Usuario;
import Modelo.dto.Categorias;
import Modelo.dto.Proveedor;
import Modelo.dto.HistoriaVenta;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
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
    public Map<String, ArrayList<?>> cargarDatos() throws FileNotFoundException, IOException {
        Map<String, ArrayList<?>> datos = new HashMap<>();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<Categorias> listaCategorias = new ArrayList<>();
        ArrayList<Proveedor> listaProveedor = new ArrayList<>();
        ArrayList<HistoriaVenta> listaHistorial = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(RUTA_EXCEL);
             Workbook workbook = new XSSFWorkbook(fis)) {

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
            
            Sheet sheetCategorias = workbook.getSheet("Categorias");
            for (Row row : sheetCategorias) {
                if (row.getRowNum() == 0) continue; // Saltar la cabecera
                
                Categorias cat = new Categorias();
                cat.setIdCategoria(row.getCell(0).getStringCellValue());
                cat.setNombreCategoria(row.getCell(1).getStringCellValue());
                listaCategorias.add(cat);
            }
            
            Sheet sheetProveedor = workbook.getSheet("Proveedores");
            for (Row row : sheetProveedor) {
                if (row.getRowNum() == 0) continue;
                Proveedor prov = new Proveedor();
                prov.setIDproveedor((int)row.getCell(0).getNumericCellValue());
                prov.setNombre(row.getCell(1).getStringCellValue());
                prov.setTelefono((int)row.getCell(2).getNumericCellValue());
                prov.setEmail(row.getCell(3).getStringCellValue());
                listaProveedor.add(prov);
            }
            
            Sheet sheetHistoriaVenta = workbook.getSheet("HistorialVentas");
            for (Row row : sheetHistoriaVenta) {
                if (row.getRowNum() == 0) continue;
                HistoriaVenta hisv = new HistoriaVenta();
                hisv.setIdVenta(row.getCell(0).getStringCellValue());
                Cell celdaFecha = row.getCell(1);
            
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
                    hisv.setFecha(fechaNueva);
                    
                } else {
                    // Es un número, pero no una fecha (quizás es el stock)
                    hisv.setFecha(null);
                }
                
            } else {
                // La celda está vacía o es texto (ej. "N/A")
                hisv.setFecha(null);
            }
                hisv.setIdUsuario(row.getCell(2).getStringCellValue());
                hisv.setProductoVendido(row.getCell(3).getStringCellValue());
                hisv.setCantidad((int)row.getCell(4).getNumericCellValue());
                hisv.setTotal((double)row.getCell(5).getNumericCellValue());
                listaHistorial.add(hisv);
            }
              
            // Poner las listas en el mapa para devolverlas
            datos.put("Usuarios", listaUsuarios);
            datos.put("Productos", listaProductos);
            datos.put("Categorias", listaCategorias);
            datos.put("Proveedores", listaProveedor);
            datos.put("HistorialVentas", listaHistorial);
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
    /**
     * Valida si un usuario y contraseña existen en la lista de usuarios.
     * Esta lista fue cargada previamente desde el Excel.
     */
    /**
     * Valida si un usuario y contraseña existen en la lista de usuarios.
     * Esta lista fue cargada previamente desde el Excel.
     */
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
        
     public void guardarDatos(ArrayList<Producto> productos, ArrayList<Usuario> usuarios, 
             ArrayList<Categorias> categorias, ArrayList<Proveedor> proveedores, 
             ArrayList<HistoriaVenta> historial) {

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
        
        Sheet sheetCategorias = workbook.getSheet("Categorias"); // Obtiene la hoja de Usuarios

            // Limpia datos de Categorias
        lastRow = sheetCategorias.getLastRowNum();
        for (int i = lastRow; i >= 1; i--) {
            Row row = sheetCategorias.getRow(i);
            if (row != null) {
                sheetCategorias.removeRow(row);
            }
        }
        rowNum = 1;
        for (Categorias c : categorias) {
            Row row = sheetCategorias.createRow(rowNum++);
            row.createCell(0).setCellValue(c.getIdCategoria());
            row.createCell(1).setCellValue(c.getNombreCategoria());
        }
        
        Sheet sheetProveedor = workbook.getSheet("Proveedores"); // Obtiene la hoja de Usuarios

            // Limpia datos de Categorias
        lastRow = sheetProveedor.getLastRowNum();
        for (int i = lastRow; i >= 1; i--) {
            Row row = sheetProveedor.getRow(i);
            if (row != null) {
                sheetProveedor.removeRow(row);
            }
        }
        
        // Escribe datos nuevos de usuarios
        rowNum = 1;
        for (Proveedor pr : proveedores) {
            Row row = sheetProveedor.createRow(rowNum++);
            row.createCell(0).setCellValue(pr.getIDproveedor());
            row.createCell(1).setCellValue(pr.getNombre());
            row.createCell(2).setCellValue(pr.getTelefono());
            row.createCell(3).setCellValue(pr.getEmail());
        }
        
        Sheet sheetHistoralVenta = workbook.getSheet("HistorialVentas"); // Obtiene la hoja de Usuarios

            // Limpia datos de Categorias
        lastRow = sheetHistoralVenta.getLastRowNum();
        for (int i = lastRow; i >= 1; i--) {
            Row row = sheetHistoralVenta.getRow(i);
            if (row != null) {
                sheetHistoralVenta.removeRow(row);
            }
        }
        
        // Escribe datos nuevos de usuarios
        rowNum = 1;
        for (HistoriaVenta hv : historial) {
            Row row = sheetHistoralVenta.createRow(rowNum++);
            row.createCell(0).setCellValue(hv.getIdVenta());
            Cell celdaFecha = row.createCell(1);
            if (hv.getFecha()!= null) {
                // Escribe el valor de la fecha
               celdaFecha.setCellValue(hv.getFecha());
                
                // ¡¡APLICA EL ESTILO!!
                // Si te falta esta línea, verás el número 46022
                celdaFecha.setCellStyle(cellStyleFecha);
            }
            row.createCell(2).setCellValue(hv.getIdUsuario());
            row.createCell(3).setCellValue(hv.getProductoVendido());
            row.createCell(4).setCellValue(hv.getCantidad());
            row.createCell(5).setCellValue(hv.getTotal());
            
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
    

    