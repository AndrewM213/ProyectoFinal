 package gestor_de_reportes;

import Modelo.dto.HistoriaVenta;
import Modelo.dto.Producto;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane; 
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GestorReportes {

    public static String rutaArchivo;
    
   
    // El método ahora devuelve el Workbook (la plantilla de Excel)
    public static void generarReporteInventarioExcel(ArrayList<Producto> listaProductos, String rutaArchivo) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Inventario Actual");

        try {
          
            Row headerRow = sheet.createRow(0);
            String[] columnas = {"Código", "Nombre", "Stock", "Stock Mínimo", "Precio Venta", "Valor Compra Total"};
            for (int i = 0; i < columnas.length; i++) {
                headerRow.createCell(i).setCellValue(columnas[i]);
            }

          
            int rowNum = 1;
            for (Producto p : listaProductos) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(p.getCodigo());
                row.createCell(1).setCellValue(p.getNombre());
                row.createCell(2).setCellValue(p.getStock());
                row.createCell(3).setCellValue(p.getStockMinimo());
                row.createCell(4).setCellValue(p.getPrecioVenta());
                row.createCell(5).setCellValue(p.getStock() * p.getPrecioCompra()); // Cálculo del valor total de compra
            }

          
            for (int i = 0; i < columnas.length; i++) { sheet.autoSizeColumn(i); }
            try (FileOutputStream fileOut = new FileOutputStream(rutaArchivo)) {
                workbook.write(fileOut);
            }
            JOptionPane.showMessageDialog(null, " Reporte de Inventario Actual exportado a: " + rutaArchivo, "Éxito de Exportación", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, " Error al generar el reporte Excel: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try { workbook.close(); } catch (IOException e) { }
        }
    }


    public static void generarReporteAgotadosExcel(ArrayList<Producto> listaProductos, String rutaArchivo) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Productos Agotados/Bajo Stock");
        
        try {
            Row headerRow = sheet.createRow(0);
            String[] columnas = {"Código", "Nombre", "Stock Actual", "Stock Mínimo"};
            for (int i = 0; i < columnas.length; i++) { headerRow.createCell(i).setCellValue(columnas[i]); }

      
            int rowNum = 1;
            for (Producto p : listaProductos) {
                if (p.getStock() <= p.getStockMinimo()) { 
                    Row row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(p.getCodigo());
                    row.createCell(1).setCellValue(p.getNombre());
                    row.createCell(2).setCellValue(p.getStock());
                    row.createCell(3).setCellValue(p.getStockMinimo());
                }
            }
            
    
            if (rowNum == 1) { 
                sheet.createRow(1).createCell(0).setCellValue("Todos los productos están por encima de su stock mínimo.");
            }

           
            for (int i = 0; i < columnas.length; i++) { sheet.autoSizeColumn(i); }
            try (FileOutputStream fileOut = new FileOutputStream(rutaArchivo)) {
                workbook.write(fileOut);
            }
            JOptionPane.showMessageDialog(null, " Reporte de Productos Agotados/Bajo Stock exportado a: " + rutaArchivo, "Éxito de Exportación", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
             JOptionPane.showMessageDialog(null, "Error al generar el reporte Excel: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
             try { workbook.close(); } catch (IOException e) { }
        
    }
       }

    public static void generarReporteVentasExcel(ArrayList<HistoriaVenta> listaVentas, String ruta) {
    /**
     * Genera un reporte de ventas (HistoriaVenta) en formato Excel.
     * @param listaVentas La lista de objetos HistoriaVenta a reportar.
    // Código corregido (usando 'ruta' para que coincida con la firma del método):
// (Asegúrate de cambiar también la línea en FileOutputStream y JOptionPane)

public static void generarReporteVentasExcel(ArrayList<HistoriaVenta> listaVentas, String ruta) { // <- Usamos 'ruta'
    // ...
    // ...
    try (FileOutputStream fileOut = new FileOutputStream(ruta)) { // <- Usamos 'ruta'
        workbook.write(fileOut);
    }
    JOptionPane.showMessageDialog(null, "✅ Reporte de Ventas exportado a: " + ruta, "Éxito de Exportación", JOptionPane.INFORMATION_MESSAGE); // <- Usamos 'ruta'
    // ...
}
     */
    
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Reporte de Ventas");

        try {
            // 1. Crear Fila de Encabezados
            Row headerRow = sheet.createRow(0);
            String[] columnas = {"ID Venta", "Fecha", "Usuario Vendedor", "Total Venta"};
            for (int i = 0; i < columnas.length; i++) {
                headerRow.createCell(i).setCellValue(columnas[i]);
            }

            // 2. Llenar los Datos
            int rowNum = 1;
            // Recorrer la lista de HistoriaVenta
            for (HistoriaVenta venta : listaVentas) {
                Row row = sheet.createRow(rowNum++);
                
                // Columna 1: ID Venta
                row.createCell(0).setCellValue(venta.getCodigo()); 
                
                // Columna 2: Fecha
                // Asume que getFecha() devuelve un String o tiene un toString() adecuado
                row.createCell(1).setCellValue(venta.getFecha()); 
                
                // Columna 3: Usuario Vendedor
                // Asume que tienes un método para obtener el nombre o ID del usuario vendedor
                row.createCell(2).setCellValue(venta.getUsuario()); 
                
                // Columna 4: Total Venta
                row.createCell(3).setCellValue(venta.getTotalVenta()); 
            }

            // 3. Ajustar Columnas y Escribir el Archivo
            for (int i = 0; i < columnas.length; i++) { sheet.autoSizeColumn(i); }
            
            try (FileOutputStream fileOut = new FileOutputStream(rutaArchivo)) {
                workbook.write(fileOut);
            }
            
            JOptionPane.showMessageDialog(null, " Reporte de Ventas exportado a: " + rutaArchivo, "Éxito de Exportación", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el reporte Excel: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try { workbook.close(); } catch (IOException e) { }
        }
    }   

    public static void generarReporteInventarioIExcel(ArrayList<Producto> listaProductos, String reporte_Inventarioxlsx) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void generarReporteAgotadosIExcel(ArrayList<Producto> listaProductos, String reporte_BajoStockxlsx) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }
    