package Metodos;

import Modelo.dto.Producto;
import Modelo.dto.Proveedor;
import java.util.ArrayList;
        
public class GestorInventarioproveedor {
    //Atributos 
    private ArrayList<Producto> listaProductos;
    private ArrayList<Proveedor> listaProveedor;
    
    //Constructor 
    public GestorInventarioproveedor(ArrayList<Producto> listaProductos, ArrayList<Proveedor> listaProveedor) {
        this.listaProductos = listaProductos;
        this.listaProveedor = listaProveedor;
    }
    
    //Getters
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<Proveedor> getListaProveedor() {
        return listaProveedor;
    }

    public void setListaProveedor(ArrayList<Proveedor> listaProveedor) {
        this.listaProveedor = listaProveedor;
    }
    
    //LOGICA DE CONTROL DE INVENTARIO
    public int registrarEntrada(String codigoProducto, int CantidadEntrante){
        for (Producto p : listaProductos){
            if (p.getCodigo().equals(codigoProducto)){
                
                int nuevoStock = p.getStock() + CantidadEntrante;
                
                p.setStock(nuevoStock);
                
                return 1;
            }
        }
        return 0;
    }
    
    //LOGICA DE ALERTAS
    public ArrayList<Producto> generarAlertaBajoStock(){
        
        ArrayList<Producto> productoenAlerta = new ArrayList<>();
        
        for (Producto p : listaProductos){
            
            if(p.getStock() <= p.getStockMinimo()){
                
                productoenAlerta.add(p);
            }
        }
        return productoenAlerta;
    }
    
    //LOGICA DE PROVEEDORES
    public void agregarProveedor(Proveedor nuevoProveedor){
        this.listaProveedor.add(nuevoProveedor);
    }
    
    
    public int editarProveedor(Proveedor proveedorEditado){
        
        for (int i = 0; i < listaProveedor.size(); i++){
            Proveedor p = listaProveedor.get(i);
            
            if (p.getIDproveedor() == proveedorEditado.getIDproveedor());{
            
            
                p.setNombre(proveedorEditado.getNombre());
                p.setTelefono(proveedorEditado.getTelefono());
                p.setEmail(proveedorEditado.getEmail());
                
                return 1;
            }
        }
        return 0;
    }
    
    public int eliminarProveedor(int id){
        
        for(int i = 0; i < listaProveedor.size(); i++){
            Proveedor p = listaProveedor.get(i);
            
            if (p.getIDproveedor() == id){
                
                listaProveedor.remove(i);
                
                return 1;
            }
        }
        return 0;
    }
}