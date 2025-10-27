
package gestor_de_reportes;


import Modelo.dto.Producto;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends javax.swing.JFrame {
    
    private final ArrayList<Producto> listaProductos; 
    private final Configuracion configuracionActual; 
   
    
    public VentanaPrincipal() {
        initComponents();
        this.listaProductos = GestorExcel.cargarDatos(); 
        this.configuracionActual = GestorConfiguracion.cargarConfiguracion(); 
        
        mostrarResumenGeneral(); 
        configurarGuardadoAutomatico(); 
    }
    
    
    private void mostrarResumenGeneral() {
        long totalUnicos = listaProductos.size();
        long bajoStock = listaProductos.stream().filter(p -> p.getStock() < p.getStockMinimo()).count();
        
        String resumen = String.format("""
                                       --- DASHBOARD (Req. 30) ---
                                       Tienda: %s
                                       Productos \u00danicos: %d
                                       Productos Bajo Stock/Agotados: %d""",
                                       configuracionActual.getNombreTienda(), totalUnicos, bajoStock);
        
      
        System.out.println(resumen); 
       
    }
    
   
    private void configurarGuardadoAutomatico() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int opcion = JOptionPane.showConfirmDialog(VentanaPrincipal.this, "¿Desea guardar los cambios antes de salir?", "Guardado Automático (Req. 31)", JOptionPane.YES_NO_CANCEL_OPTION);
                
                if (opcion == JOptionPane.YES_OPTION) {
                    try {
                        GestorExcel.guardarDatos(listaProductos /*, ... otros */); 
                        System.exit(0);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(VentanaPrincipal.this, "Error de Guardado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        System.exit(1);
                    }
                } else if (opcion == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); 
}
    }
    