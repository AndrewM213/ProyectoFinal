/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

import Interfaces.IExcel;
import Modelo.dto.Categorias;
import Modelo.dto.HistoriaVenta;
import Modelo.dto.Producto;
import Modelo.dto.Proveedor;
import Modelo.dto.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Principal extends javax.swing.JFrame {
    private IExcel excel;
    private Usuario usuarioA;
    private ArrayList<Producto> listaproductos;
    private ArrayList<Usuario> listausuarios;
    private ArrayList<Categorias> listacategorias;
    private ArrayList<Proveedor> listaproveedores;
    private ArrayList<HistoriaVenta> listahistorial;
  
    public Principal(IExcel excel,Usuario usuarioA,ArrayList<Producto> productos,
            ArrayList<Usuario> usuarios,
            ArrayList<Categorias> categorias,
            ArrayList<Proveedor> proveedores,
            ArrayList<HistoriaVenta> historial) {
        initComponents();
        this.setLayout(new java.awt.BorderLayout());
    // Asegúrate de usar el nombre de variable correcto de tu ScrollPane (ej. jScrollPane1)
        this.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        this.excel = excel;
        this.usuarioA = usuarioA;
        this.listaproductos = productos;
        this.listausuarios = usuarios;
        this.listacategorias = categorias;
        this.listaproveedores = proveedores;
        this.listahistorial = historial;
        String nombre = usuarioA.getNombreUsuario();
        String mensaje = "Bienvenido " + nombre + ", ¿qué deseas realizar hoy?";
        lblBienvenida.setText(mensaje);
        configurarGuardadoAutomatico();
        if(usuarioA.getRol().equals("Administrador")){
            btnPuntoVenta.setVisible(true);
            btnGestionP.setVisible(true);
            btnInventario.setVisible(true);
            btnReportes.setVisible(true);
            btnGestionU.setVisible(true);
            btnConfig.setVisible(true);
        }
        if(usuarioA.getRol().equals("Empleado")){
            btnPuntoVenta.setVisible(true);
            btnGestionP.setVisible(true);
            btnInventario.setVisible(false);
            btnReportes.setVisible(false);
            btnGestionU.setVisible(false);
       }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        lblBienvenida = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnReportes = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnGestionP = new javax.swing.JButton();
        btnGestionU = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnInventario = new javax.swing.JButton();
        btnPuntoVenta = new javax.swing.JButton();
        btnConfig = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Menú Principal");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(676, 720));
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        lblBienvenida.setFont(new java.awt.Font("Yu Gothic UI Light", 3, 18)); // NOI18N
        lblBienvenida.setText(".");

        btnGuardar.setBackground(new java.awt.Color(255, 204, 204));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar Cambios");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/puntodeventa.png"))); // NOI18N
        jLabel6.setText("jLabel6");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/config.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Usuarios.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Inventario.png"))); // NOI18N

        btnReportes.setBackground(new java.awt.Color(255, 204, 204));
        btnReportes.setFont(new java.awt.Font("Yu Gothic UI Semibold", 3, 14)); // NOI18N
        btnReportes.setText("Reportes");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/productos.png"))); // NOI18N

        btnGestionP.setBackground(new java.awt.Color(255, 204, 204));
        btnGestionP.setFont(new java.awt.Font("Yu Gothic UI Semibold", 3, 14)); // NOI18N
        btnGestionP.setText("Gestionar Productos");
        btnGestionP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionPActionPerformed(evt);
            }
        });

        btnGestionU.setBackground(new java.awt.Color(255, 204, 204));
        btnGestionU.setFont(new java.awt.Font("Yu Gothic UI Semibold", 3, 14)); // NOI18N
        btnGestionU.setText("Gestionar Usuarios");
        btnGestionU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionUActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reportes.png"))); // NOI18N

        btnInventario.setBackground(new java.awt.Color(255, 204, 204));
        btnInventario.setFont(new java.awt.Font("Yu Gothic UI Semibold", 3, 14)); // NOI18N
        btnInventario.setText("Inventario");

        btnPuntoVenta.setBackground(new java.awt.Color(255, 204, 204));
        btnPuntoVenta.setFont(new java.awt.Font("Yu Gothic UI Semibold", 3, 14)); // NOI18N
        btnPuntoVenta.setText("Punto de Ventas");
        btnPuntoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPuntoVentaActionPerformed(evt);
            }
        });

        btnConfig.setBackground(new java.awt.Color(255, 204, 204));
        btnConfig.setFont(new java.awt.Font("Yu Gothic UI Semibold", 3, 14)); // NOI18N
        btnConfig.setText("Configuración");
        btnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardar)
                                .addGap(0, 36, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGap(60, 60, 60))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnPuntoVenta))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addComponent(btnGestionP))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btnGestionU)
                        .addGap(167, 167, 167)
                        .addComponent(btnConfig))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btnInventario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReportes)
                        .addGap(130, 130, 130)))
                .addGap(36, 38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPuntoVenta)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnInventario))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(btnReportes))))
                    .addComponent(btnGestionP))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfig)
                    .addComponent(btnGestionU))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowStateChanged

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
        // Usamos el gestor para guardar TODAS las listas actuales en el Excel
        excel.guardarDatos(
                listaproductos,
                listausuarios,
                listacategorias,
                listaproveedores,
                listahistorial
        );     
            javax.swing.JOptionPane.showMessageDialog(this, "¡Datos guardados en Excel correctamente!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGestionUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionUActionPerformed
        GestionarUsuarios vUsuarios = new GestionarUsuarios(this.listausuarios);
        vUsuarios.setVisible(true);
        vUsuarios.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnGestionUActionPerformed

    private void btnPuntoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPuntoVentaActionPerformed
        PuntodeVenta vVentas = new PuntodeVenta(
            this.listaproductos,
            this.listahistorial,
            this.usuarioA
        );
        vVentas.setVisible(true);
        vVentas.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnPuntoVentaActionPerformed

    private void btnGestionPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionPActionPerformed
        VentanaProductos2 vProd = new VentanaProductos2(this.listaproductos, this.listacategorias);
        vProd.setVisible(true);
        vProd.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnGestionPActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        VentanaReportes vReportes = new VentanaReportes (this.listaproductos,this.listahistorial);
        vReportes.setVisible(true);
        vReportes.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed
        Configuracion vConfiguracion = new Configuracion ();
        vConfiguracion.setVisible(true);
        vConfiguracion.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnConfigActionPerformed
private void configurarGuardadoAutomatico() {
    this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    this.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent e) {
            cerraAplicacion();
        }
    });
}

private void cerraAplicacion() {
<<<<<<< HEAD
    // 1. Crear un array con los textos de los botones en español
    Object[] opciones = {"Sí", "No", "Cancelar"}; // <--- ¡AÑADIDO!

    // 1. Preguntar al usuario con showOptionDialog
    int opcion = javax.swing.JOptionPane.showOptionDialog( // <--- ¡CAMBIO AQUÍ!
            this,
            "¿Desea guardar los cambios realizados antes de salir?",
            "Guardado Automático",
            // Mantenemos esta constante para la compatibilidad lógica
            javax.swing.JOptionPane.YES_NO_CANCEL_OPTION, 
            javax.swing.JOptionPane.QUESTION_MESSAGE,
            null, // Icono personalizado (null para usar el predeterminado)
            opciones, // <--- ¡PASAMOS EL ARRAY DE OPCIONES EN ESPAÑOL!
            opciones[0] // Botón predeterminado ("Sí")
    );

    // 2. Evaluar respuesta
    if (opcion == javax.swing.JOptionPane.YES_OPTION) { // Lógica: Si pulsa "Sí" (índice 0)
        // --- OPCIÓN SÍ: Guardar y Salir ---
        try {
            System.out.println(">>> Guardando datos en Excel...");

            // LLAMADA AL GESTOR (Asegúrate de pasar las 5 listas)
=======
    int opcion = javax.swing.JOptionPane.showConfirmDialog(
            this, 
            "¿Desea guardar los cambios realizados antes de salir?", 
            "Guardado Automático", 
            javax.swing.JOptionPane.YES_NO_CANCEL_OPTION,
            javax.swing.JOptionPane.QUESTION_MESSAGE
    );
    if (opcion == javax.swing.JOptionPane.YES_OPTION) {
        try {
            System.out.println(">>> Guardando datos en Excel...");
>>>>>>> 059dbc8d4b43dfeee1ecacd1391a6735e51d8a29
            excel.guardarDatos(
                    listaproductos,
                    listausuarios,
                    listacategorias,
                    listaproveedores,
                    listahistorial
<<<<<<< HEAD
            );

            javax.swing.JOptionPane.showMessageDialog(this, "Datos guardados correctamente. ¡Hasta luego!");
            System.exit(0); // Cierra el programa totalmente

        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error crítico al guardar: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            // No cerramos la app para que el usuario pueda intentar arreglarlo (ej. cerrar el Excel si lo tiene abierto)
        }

    } else if (opcion == javax.swing.JOptionPane.NO_OPTION) { // Lógica: Si pulsa "No" (índice 1)
        // --- OPCIÓN NO: Salir sin guardar ---
        System.out.println(">>> Cerrando sin guardar.");
        System.exit(0); // Cierra el programa totalmente
    }
    // Si la opción es CANCEL_OPTION (índice 2) o CLOSED_OPTION (hizo clic en la X), el método simplemente termina y la aplicación sigue abierta.
=======
            );            
            javax.swing.JOptionPane.showMessageDialog(this, "Datos guardados correctamente. ¡Hasta luego!");
            System.exit(0);   
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error crítico al guardar: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }        
    } else if (opcion == javax.swing.JOptionPane.NO_OPTION) {
        System.out.println(">>> Cerrando sin guardar.");
        System.exit(0);
    } 
>>>>>>> 059dbc8d4b43dfeee1ecacd1391a6735e51d8a29
}
        
    
    // --- OPCIÓN CANCELAR: No hace nada, se queda en la ventana ---

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfig;
    private javax.swing.JButton btnGestionP;
    private javax.swing.JButton btnGestionU;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnPuntoVenta;
    private javax.swing.JButton btnReportes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBienvenida;
    // End of variables declaration//GEN-END:variables
}
