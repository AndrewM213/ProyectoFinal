/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

/**
 *
 * @author andre
 */
import Modelo.dto.Usuario;
import Metodos.GestionUsuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
public class GestionarUsuarios extends javax.swing.JFrame {
    
    private GestionUsuario gestion;
    private ArrayList<Usuario> listaGeneral;
    public GestionarUsuarios(ArrayList<Usuario> listaUsuario) {        
        initComponents();
        this.listaGeneral = listaUsuario;
        DefaultTableModel tabla = (DefaultTableModel) tablaU.getModel();
        this.gestion = new GestionUsuario(this.listaGeneral, tabla);
        gestion.actualizarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaU = new javax.swing.JTable();
        txtRol = new javax.swing.JTextField();
        btn_volver = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnModificar3 = new javax.swing.JButton();
        txtUsuario3 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaU3 = new javax.swing.JTable();
        txtRol3 = new javax.swing.JTextField();
        btn_volver3 = new javax.swing.JButton();
        btnLimpiar3 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btnEliminar3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtContraseña3 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnguardar3 = new javax.swing.JButton();
        txtID3 = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnModificar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        txtUsuario.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N

        tablaU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Usuario", "Nombre Usuario", "Rol"
            }
        ));
        jScrollPane2.setViewportView(tablaU);

        txtRol.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N

        btn_volver.setText("Volver");
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel1.setText("ID Usuario: ");

        btnEliminar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel2.setText("Rol:");

        jLabel3.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel3.setText("Contraseña: ");

        txtContraseña.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel4.setText("Nombre Usuario:");

        btnguardar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        txtID.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion de usuarios");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnModificar3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnModificar3.setText("Modificar");
        btnModificar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar3ActionPerformed(evt);
            }
        });

        txtUsuario3.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N

        tablaU3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Usuario", "Nombre Usuario", "Rol"
            }
        ));
        jScrollPane5.setViewportView(tablaU3);

        txtRol3.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N

        btn_volver3.setText("Volver");
        btn_volver3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volver3ActionPerformed(evt);
            }
        });

        btnLimpiar3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnLimpiar3.setText("Limpiar");
        btnLimpiar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar3ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel13.setText("ID Usuario: ");

        btnEliminar3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEliminar3.setText("Eliminar");
        btnEliminar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar3ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel14.setText("Rol:");

        jLabel15.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel15.setText("Contraseña: ");

        txtContraseña3.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel16.setText("Nombre Usuario:");

        btnguardar3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnguardar3.setText("Guardar");
        btnguardar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar3ActionPerformed(evt);
            }
        });

        txtID3.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        txtID3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtID3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtID3)
                            .addComponent(txtUsuario3)
                            .addComponent(txtContraseña3)
                            .addComponent(txtRol3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnguardar3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnModificar3)
                        .addGap(47, 47, 47)
                        .addComponent(btnEliminar3)
                        .addGap(28, 28, 28)
                        .addComponent(btnLimpiar3))
                    .addComponent(btn_volver3))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btn_volver3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtID3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(txtContraseña3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(txtRol3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar3)
                    .addComponent(btnLimpiar3)
                    .addComponent(btnEliminar3)
                    .addComponent(btnModificar3))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        UIManager.put("OptionPane.yesButtonText", "Confirmar");
        UIManager.put("OptionPane.noButtonText", "Cancelar");
        UIManager.put("OptionPane.okButtonText", "Aceptar");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        int filaSeleccionada = tablaU.getSelectedRow();
        if(filaSeleccionada >= 0){
            String id = txtID.getText();
            String nombre = txtUsuario.getText();
            String contraseña = txtContraseña.getText();
            String rol = txtRol.getText();

            gestion.modificarUsuario(filaSeleccionada, id, nombre, contraseña, rol);
            JOptionPane.showMessageDialog(this, "Usuario Modificado", "Informacion",JOptionPane.INFORMATION_MESSAGE);
            txtContraseña.setText("");
            txtID.setText("");
            txtUsuario.setText("");
            txtRol.setText("");
        }else {
            JOptionPane.showMessageDialog(this,"Seleccione un usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_volverActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtID.setText("");
        txtUsuario.setText("");
        txtContraseña.setText("");
        txtRol.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        UIManager.put("OptionPane.yesButtonText", "Confirmar");
        UIManager.put("OptionPane.noButtonText", "Cancelar");
        UIManager.put("OptionPane.okButtonText", "Aceptar");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        int filaSeleccionada = tablaU.getSelectedRow();
        if(filaSeleccionada >= 0){
            int resp = JOptionPane.showConfirmDialog(this, "¿Estas seguro de elimiar al usuario seleccionado?",
                "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(resp == JOptionPane.YES_OPTION){
                gestion.eliminarUsuario(filaSeleccionada);
                JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente", "Informacion",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        UIManager.put("OptionPane.yesButtonText", "Confirmar");
        UIManager.put("OptionPane.noButtonText", "Cancelar");
        UIManager.put("OptionPane.okButtonText", "Aceptar");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        String id = txtID.getText();
        String nombre = txtUsuario.getText();
        String contraseña = txtContraseña.getText();
        String rol = txtRol.getText();

        boolean bien = gestion.guardarUsuario(id, nombre, contraseña, rol);
        if(bien){
            JOptionPane.showMessageDialog(this, "Usuario Guardado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            txtContraseña.setText("");
            txtID.setText("");
            txtUsuario.setText("");
            txtRol.setText("");
        }else {
            JOptionPane.showMessageDialog(this, "ingrese bien los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnModificar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar3ActionPerformed
        UIManager.put("OptionPane.yesButtonText", "Confirmar");
        UIManager.put("OptionPane.noButtonText", "Cancelar");
        UIManager.put("OptionPane.okButtonText", "Aceptar");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        int filaSeleccionada = tablaU.getSelectedRow();
        if(filaSeleccionada >= 0){
            String id = txtID.getText();
            String nombre = txtUsuario.getText();
            String contraseña = txtContraseña.getText();
            String rol = txtRol.getText();

            gestion.modificarUsuario(filaSeleccionada, id, nombre, contraseña, rol);
            JOptionPane.showMessageDialog(this, "Usuario Modificado", "Informacion",JOptionPane.INFORMATION_MESSAGE);
            txtContraseña.setText("");
            txtID.setText("");
            txtUsuario.setText("");
            txtRol.setText("");
        }else {
            JOptionPane.showMessageDialog(this,"Seleccione un usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificar3ActionPerformed

    private void btn_volver3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volver3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_volver3ActionPerformed

    private void btnLimpiar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar3ActionPerformed
        txtID.setText("");
        txtUsuario.setText("");
        txtContraseña.setText("");
        txtRol.setText("");
    }//GEN-LAST:event_btnLimpiar3ActionPerformed

    private void btnEliminar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar3ActionPerformed
        UIManager.put("OptionPane.yesButtonText", "Confirmar");
        UIManager.put("OptionPane.noButtonText", "Cancelar");
        UIManager.put("OptionPane.okButtonText", "Aceptar");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        int filaSeleccionada = tablaU.getSelectedRow();
        if(filaSeleccionada >= 0){
            int resp = JOptionPane.showConfirmDialog(this, "¿Estas seguro de elimiar al usuario seleccionado?",
                "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(resp == JOptionPane.YES_OPTION){
                gestion.eliminarUsuario(filaSeleccionada);
                JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente", "Informacion",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminar3ActionPerformed

    private void btnguardar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar3ActionPerformed
        UIManager.put("OptionPane.yesButtonText", "Confirmar");
        UIManager.put("OptionPane.noButtonText", "Cancelar");
        UIManager.put("OptionPane.okButtonText", "Aceptar");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        String id = txtID.getText();
        String nombre = txtUsuario.getText();
        String contraseña = txtContraseña.getText();
        String rol = txtRol.getText();

        boolean bien = gestion.guardarUsuario(id, nombre, contraseña, rol);
        if(bien){
            JOptionPane.showMessageDialog(this, "Usuario Guardado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            txtContraseña.setText("");
            txtID.setText("");
            txtUsuario.setText("");
            txtRol.setText("");
        }else {
            JOptionPane.showMessageDialog(this, "ingrese bien los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnguardar3ActionPerformed

    private void txtID3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtID3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtID3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar3;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiar3;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificar3;
    private javax.swing.JButton btn_volver;
    private javax.swing.JButton btn_volver3;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnguardar3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tablaU;
    private javax.swing.JTable tablaU3;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtContraseña3;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtID3;
    private javax.swing.JTextField txtRol;
    private javax.swing.JTextField txtRol3;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtUsuario3;
    // End of variables declaration//GEN-END:variables
}
