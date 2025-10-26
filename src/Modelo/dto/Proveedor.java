package Modelo.dto;

public class Proveedor {
    //Atributos 
    private int IDproveedor;
    private String nombre;
    private String telefono;
    private String email;
    
    //Constructoe
    public Proveedor(int IDproveedor, String nombre, String telefono, String email) {
        this.IDproveedor = IDproveedor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public int getIDproveedor() {
        return IDproveedor;
    }

    public void setIDproveedor(int IDproveedor) {
        this.IDproveedor = IDproveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
