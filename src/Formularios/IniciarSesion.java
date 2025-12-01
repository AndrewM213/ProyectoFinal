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
import javax.swing.UIManager;
public class IniciarSesion extends javax.swing.JFrame {
    private IExcel excel;
    private ArrayList<Producto> listaproductos;
    private ArrayList<Usuario> listausuarios;
    private ArrayList<Categorias> listacategorias;
    private ArrayList<Proveedor> listaproveedores;
    private ArrayList<HistoriaVenta> listahistorial;

    public IniciarSesion(IExcel excel, ArrayList<Producto> productos, ArrayList<Usuario> usuarios, ArrayList<Categorias> categorias, ArrayList<Proveedor> proveedores, ArrayList<HistoriaVenta> historial){
        initComponents();        
        this.excel = excel;
        this.listaproductos = productos;
        this.listausuarios = usuarios;
        this.listacategorias = categorias;
        this.listaproveedores = proveedores;
        this.listahistorial = historial;        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("iniciar sesion");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        jLabel1.setText("Iniciar sesion");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 244, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Login.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 170, 140));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        jLabel3.setText("Usuario:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 290, 63, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        jLabel4.setText("Contraseña:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(579, 334, 86, -1));

        txtUsuario.setFont(new java.awt.Font("Segoe UI Semilight", 2, 14)); // NOI18N
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(677, 287, 152, -1));

        txtContraseña.setFont(new java.awt.Font("Segoe UI Semibold", 2, 14)); // NOI18N
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(677, 331, 152, -1));

        btnIngresar.setBackground(new java.awt.Color(255, 204, 204));
        btnIngresar.setFont(new java.awt.Font("Segoe UI Semibold", 3, 18)); // NOI18N
        btnIngresar.setText("INGRESAR");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 383, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe Print", 3, 48)); // NOI18N
        jLabel5.setText("Bienvenido");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 270, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tiendaLazo.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, 349));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 971, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed

        UIManager.put("OptionPane.yesButtonText", "Confirmar");
        UIManager.put("OptionPane.noButtonText", "Cancelar");
        UIManager.put("OptionPane.okButtonText", "Aceptar");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        String usuario = txtUsuario.getText();
        String contraseña = new String(txtContraseña.getPassword());
        Usuario validado = validarLogin(usuario, contraseña);
        if(validado != null ){
            JOptionPane.showMessageDialog(this, "Bienvenido, " + validado.getNombreUsuario(), "Informacion", JOptionPane.INFORMATION_MESSAGE);
            Principal vPrincipal = new Principal(excel,
                validado,
                listaproductos,
                listausuarios,
                listacategorias,
                listaproveedores,
                listahistorial
            );
            vPrincipal.setVisible(true);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private Usuario validarLogin(String usur, String contra) {
        for (Usuario usuario : this.listausuarios) { 
            if (usuario.getNombreUsuario().equals(usur) && usuario.getContrasena().equals(contra)) {
                return usuario; 
            }
        }
        return null;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
