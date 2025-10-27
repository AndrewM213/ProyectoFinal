
package gestor_de_reportes;


import java.io.*;
import javax.swing.JOptionPane;

public class GestorConfiguracion {
    private static final String ARCHIVO_CONFIG = "config.ser";

    // Guarda el objeto 'Configuracion' usando serialización
    public static void guardarConfiguracion(Configuracion config) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CONFIG))) {
            oos.writeObject(config);
            System.out.println("LOG: Configuración guardada en " + ARCHIVO_CONFIG);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar configuración: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Carga el objeto 'Configuracion' desde el archivo serializado
    public static Configuracion cargarConfiguracion() {
        File f = new File(ARCHIVO_CONFIG);
        if (f.exists() && f.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                return (Configuracion) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error al cargar configuración. Usando valores por defecto.");
                return new Configuracion(); 
            }
        }
        return new Configuracion();
    }
}
