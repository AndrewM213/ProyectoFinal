package Metodos;

import Interfaces.IExcel;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class GestorSistema {
    

    public static void crearCopiaSeguridad() {
        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String nombreCopia = "Backup_" + timestamp + ".xlsx";
            
            Path origen = Paths.get(IExcel.RUTA_EXCEL);
            Path destino = Paths.get(nombreCopia); 

     
            
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
            JOptionPane.showMessageDialog(null, " Copia de seguridad creada: " + nombreCopia, "Éxito (Req. 37)", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, " Error al crear la copia de seguridad. Asegúrese de que el archivo principal (" + IExcel.RUTA_EXCEL + ") exista y no esté en uso.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void restaurarCopiaSeguridad() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Seleccionar Archivo de Backup a Restaurar");
        int userSelection = chooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File archivoCopia = chooser.getSelectedFile();
            int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de **SOBRESCRIBIR** los datos actuales con la copia de: " + archivoCopia.getName() + "? ¡Esta acción es irreversible!", "Confirmar Restauración (Req. 38)", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    Path origen = archivoCopia.toPath();
                    Path destino = Paths.get(IExcel.RUTA_EXCEL);
                    
                    Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
                    JOptionPane.showMessageDialog(null, " Base de datos restaurada. REINICIE LA APLICACIÓN para cargar los datos restaurados.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, " Error al restaurar la copia de seguridad.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}

