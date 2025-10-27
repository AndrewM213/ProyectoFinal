
package gestor_de_reportes;

import java.io.Serializable;

// Almacena datos del propietario (Req. 39) y parámetros del sistema (Req. 40)
public class Configuracion implements Serializable {
    private static final long serialVersionUID = 2L; 
    
    // Req. 39
    private String nombrePropietario = "Propietario Por Defecto";
    
    // Req. 40
    private String nombreTienda = "Inventario App";
    private double tasaImpuesto = 0.15; // 15%
    private String simboloMoneda = "S/.";

    public Configuracion() {}

    // Getters y Setters
    public String getNombrePropietario() { return nombrePropietario; }
    public void setNombrePropietario(String nombrePropietario) { this.nombrePropietario = nombrePropietario; }
    public String getNombreTienda() { return nombreTienda; }
    public void setNombreTienda(String nombreTienda) { this.nombreTienda = nombreTienda; }
    public double getTasaImpuesto() { return tasaImpuesto; }
    public void setTasaImpuesto(double tasaImpuesto) { this.tasaImpuesto = tasaImpuesto; }
    public String getSimboloMoneda() { return simboloMoneda; }
    public void setSimboloMoneda(String simboloMoneda) { this.simboloMoneda = simboloMoneda; }
}