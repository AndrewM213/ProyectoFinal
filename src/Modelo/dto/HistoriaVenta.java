/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.dto;

import java.time.LocalDate;

/**
 *
 * @author andre
 */
public class HistoriaVenta {
    private String idVenta;
    private LocalDate fecha;
    private String idUsuario;
    private String productoVendido;
    private int cantidad;
    private double total;

    public HistoriaVenta() {
    }

    public HistoriaVenta(String idVenta, LocalDate fecha, String idUsuario, String productoVendido, int cantidad, double total) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.productoVendido = productoVendido;
        this.cantidad = cantidad;
        this.total = total;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getProductoVendido() {
        return productoVendido;
    }

    public void setProductoVendido(String productoVendido) {
        this.productoVendido = productoVendido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
