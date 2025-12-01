/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.dto;

public class CarroCompra {
    private String codigo;
    private String nombre;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    // Constructor: Asumo que la clase Producto tiene métodos getCodigo(), getNombre(), y getPrecioVenta()
    public CarroCompra(Producto p, int cantidad) {
        this.codigo = p.getCodigo();
        this.nombre = p.getNombre();
        this.cantidad = cantidad;
        this.precioUnitario = p.getPrecioVenta();
        this.subtotal = p.getPrecioVenta() * cantidad;
    }

    // Getters (Setters no son tan necesarios aquí)
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
    public double getPrecioUnitario() { return precioUnitario; }
    public double getSubtotal() { return subtotal; }
}