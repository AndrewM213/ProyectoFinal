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
import java.io.FileInputStream;
import java.io.FileOutputStream;
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


public class Excel implements Interfaces.IExcel{
   public static final String RUTA_EXCEL = "Inventario.xlsx";

   @Override
    public Map<String, ArrayList<?>> cargarDatos(){
        Map<String, ArrayList<?>> datos = new HashMap<>();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<Categorias> listaCategorias = new ArrayList<>();
        ArrayList<Proveedor> listaProveedor = new ArrayList<>();
        ArrayList<HistoriaVenta> listaHistorial = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(RUTA_EXCEL);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheetUsuarios = workbook.getSheet("Usuarios");
            for (Row fila : sheetUsuarios) {
                if (fila.getRowNum() == 0) continue; 
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(fila.getCell(0).getStringCellValue());
                usuario.setNombreUsuario(fila.getCell(1).getStringCellValue());
                usuario.setContrasena(fila.getCell(2).getStringCellValue());
                usuario.setRol(fila.getCell(3).getStringCellValue());
                listaUsuarios.add(usuario);
            }

            Sheet sheetProductos = workbook.getSheet("Productos");
            for (Row fila : sheetProductos) {
                if (fila.getRowNum() == 0) continue;
                Producto prod = new Producto();
                prod.setCodigo(fila.getCell(0).getStringCellValue());
                prod.setNombre(fila.getCell(1).getStringCellValue());
                prod.setDescripcion(fila.getCell(2).getStringCellValue());
                prod.setPrecioCompra(fila.getCell(3).getNumericCellValue());
                prod.setPrecioVenta(fila.getCell(4).getNumericCellValue());
                prod.setStock((int) fila.getCell(5).getNumericCellValue());
                prod.setStockMinimo((int) fila.getCell(6).getNumericCellValue());
                prod.setIdCategoria(fila.getCell(7).getStringCellValue());
                prod.setIdProveedor(fila.getCell(8).getStringCellValue());
                Cell celdaFecha = fila.getCell(9);
                if (celdaFecha != null && celdaFecha.getCellType() == CellType.NUMERIC) {                
                    if (DateUtil.isCellDateFormatted(celdaFecha)) {                
                        java.util.Date fechaAntigua = celdaFecha.getDateCellValue();
                        LocalDate fechaNueva = fechaAntigua.toInstant()
                                                        .atZone(ZoneId.systemDefault())
                                                        .toLocalDate();
                        prod.setFechaDeVencimiento(fechaNueva);                    
                    } else {
                        prod.setFechaDeVencimiento(null);
                    }                
                } else {
                    prod.setFechaDeVencimiento(null);
                }    
                listaProductos.add(prod);
            }
            
            Sheet sheetCategorias = workbook.getSheet("Categorias");
            for (Row fila : sheetCategorias) {
                if (fila.getRowNum() == 0) continue;
                
                Categorias cat = new Categorias();
                cat.setIdCategoria(fila.getCell(0).getStringCellValue());
                cat.setNombreCategoria(fila.getCell(1).getStringCellValue());
                listaCategorias.add(cat);
            }
            
            Sheet sheetProveedor = workbook.getSheet("Proveedores");
            for (Row fila : sheetProveedor) {
                if (fila.getRowNum() == 0) continue;
                Proveedor prov = new Proveedor();
                prov.setIDproveedor((int)fila.getCell(0).getNumericCellValue());
                prov.setNombre(fila.getCell(1).getStringCellValue());
                prov.setTelefono((int)fila.getCell(2).getNumericCellValue());
                prov.setEmail(fila.getCell(3).getStringCellValue());
                listaProveedor.add(prov);
            }
            
            Sheet sheetHistoriaVenta = workbook.getSheet("HistorialVentas");
            for (Row fila : sheetHistoriaVenta) {
                if (fila.getRowNum() == 0) continue;
                HistoriaVenta hv = new HistoriaVenta();
                hv.setIdVenta(fila.getCell(0).getStringCellValue());
                Cell celdaFecha = fila.getCell(1);
                if (celdaFecha != null && celdaFecha.getCellType() == CellType.NUMERIC) {
                    if (DateUtil.isCellDateFormatted(celdaFecha)) {
                        java.util.Date fechaAntigua = celdaFecha.getDateCellValue();
                        LocalDate fechaNueva = fechaAntigua.toInstant()
                                                           .atZone(ZoneId.systemDefault())
                                                           .toLocalDate();
                        hv.setFecha(fechaNueva);                  
                    } else {
                        hv.setFecha(null);
                    }               
                } else {
                    hv.setFecha(null);
                }
                hv.setIdUsuario(fila.getCell(2).getStringCellValue());
                hv.setProductoVendido(fila.getCell(3).getStringCellValue());
                hv.setCantidad((int)fila.getCell(4).getNumericCellValue());
                hv.setTotal((double)fila.getCell(5).getNumericCellValue());
                listaHistorial.add(hv);
            }
              
            datos.put("Usuarios", listaUsuarios);
            datos.put("Productos", listaProductos);
            datos.put("Categorias", listaCategorias);
            datos.put("Proveedores", listaProveedor);
            datos.put("HistorialVentas", listaHistorial);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;
    }

   @Override
     public void guardarDatos(ArrayList<Producto> productos, ArrayList<Usuario> usuarios, 
             ArrayList<Categorias> categorias, ArrayList<Proveedor> proveedores, 
             ArrayList<HistoriaVenta> historial) {

        try (FileInputStream fis = new FileInputStream(RUTA_EXCEL);
                Workbook workbook = new XSSFWorkbook(fis)) {
            
            Sheet sheetProductos = workbook.getSheet("Productos");        
            int ultimaFila = sheetProductos.getLastRowNum();
            CellStyle cellStyleFecha = workbook.createCellStyle();
            CreationHelper createHelper = workbook.getCreationHelper();
            cellStyleFecha.setDataFormat(createHelper.createDataFormat().getFormat("dd/mm/yyyy"));
            for (int i = ultimaFila; i >= 1; i--) { 
                Row fila = sheetProductos.getRow(i);
                if (fila != null) {
                    sheetProductos.removeRow(fila);
                }
            }
            int filaNum = 1;
            for (Producto p : productos) {
                Row fila = sheetProductos.createRow(filaNum++);
                fila.createCell(0).setCellValue(p.getCodigo());
                fila.createCell(1).setCellValue(p.getNombre());
                fila.createCell(2).setCellValue(p.getDescripcion());
                fila.createCell(3).setCellValue(p.getPrecioCompra()); 
                fila.createCell(4).setCellValue(p.getPrecioVenta());
                fila.createCell(5).setCellValue(p.getStock());
                fila.createCell(6).setCellValue(p.getStockMinimo());
                fila.createCell(7).setCellValue(p.getIdCategoria());
                fila.createCell(8).setCellValue(p.getIdProveedor());
                Cell celdaFecha = fila.createCell(9);
                if (p.getFechaDeVencimiento() != null) {
                   celdaFecha.setCellValue(p.getFechaDeVencimiento());
                    celdaFecha.setCellStyle(cellStyleFecha);
                }
            }

            Sheet sheetUsuarios = workbook.getSheet("Usuarios"); 
            ultimaFila = sheetUsuarios.getLastRowNum();
            for (int i = ultimaFila; i >= 1; i--) {
                Row fila = sheetUsuarios.getRow(i);
                if (fila != null) {
                    sheetUsuarios.removeRow(fila);
                }
            }        
            filaNum = 1;
            for (Usuario u : usuarios) {
                Row fila = sheetUsuarios.createRow(filaNum++);
                fila.createCell(0).setCellValue(u.getIdUsuario());
                fila.createCell(1).setCellValue(u.getNombreUsuario());
                fila.createCell(2).setCellValue(u.getContrasena());
                fila.createCell(3).setCellValue(u.getRol());
            }
        
            Sheet sheetCategorias = workbook.getSheet("Categorias");
            ultimaFila = sheetCategorias.getLastRowNum();
            for (int i = ultimaFila; i >= 1; i--) {
                Row fila = sheetCategorias.getRow(i);
                if (fila != null) {
                    sheetCategorias.removeRow(fila);
                }
            }
            filaNum = 1;
            for (Categorias c : categorias) {
                Row fila = sheetCategorias.createRow(filaNum++);
                fila.createCell(0).setCellValue(c.getIdCategoria());
                fila.createCell(1).setCellValue(c.getNombreCategoria());
            }
            Sheet sheetProveedor = workbook.getSheet("Proveedores"); 
            ultimaFila = sheetProveedor.getLastRowNum();
            for (int i = ultimaFila; i >= 1; i--) {
                Row fila = sheetProveedor.getRow(i);
                if (fila != null) {
                    sheetProveedor.removeRow(fila);
                }
            }
            filaNum = 1;
            for (Proveedor pr : proveedores) {
                Row fila = sheetProveedor.createRow(filaNum++);
                fila.createCell(0).setCellValue(pr.getIDproveedor());
                fila.createCell(1).setCellValue(pr.getNombre());
                fila.createCell(2).setCellValue(pr.getTelefono());
                fila.createCell(3).setCellValue(pr.getEmail());
            }
        
            Sheet sheetHistoralVenta = workbook.getSheet("HistorialVentas");    
            ultimaFila = sheetHistoralVenta.getLastRowNum();
            for (int i = ultimaFila; i >= 1; i--) {
                Row fila = sheetHistoralVenta.getRow(i);
                if (fila != null) {
                    sheetHistoralVenta.removeRow(fila);
                }
            }
            filaNum = 1;
            for (HistoriaVenta hv : historial) {
                Row fila = sheetHistoralVenta.createRow(filaNum++);
                fila.createCell(0).setCellValue(hv.getIdVenta());
                Cell celdaFecha = fila.createCell(1);
                if (hv.getFecha()!= null) {
                   celdaFecha.setCellValue(hv.getFecha());
                   celdaFecha.setCellStyle(cellStyleFecha);
                }
                fila.createCell(2).setCellValue(hv.getIdUsuario());
                fila.createCell(3).setCellValue(hv.getProductoVendido());
                fila.createCell(4).setCellValue(hv.getCantidad());
                fila.createCell(5).setCellValue(hv.getTotal());
            }
            try (FileOutputStream fos = new FileOutputStream(RUTA_EXCEL)) {
                workbook.write(fos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
    

    