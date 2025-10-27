package gestor_de_reportes;

import Modelo.dto.Producto;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GestorReportes {
    
   
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
            JOptionPane.showMessageDialog(null, "✅ Reporte de Inventario Actual exportado a: " + rutaArchivo, "Éxito de Exportación", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al generar el reporte Excel: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
    }