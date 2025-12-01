/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

/**
 *
 * @author andre
 */
import Modelo.dto.Usuario;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class GestionUsuario {
    private ArrayList<Usuario> listaUsuarios; 
    private DefaultTableModel Tabla;    

    public GestionUsuario(ArrayList<Usuario> listaUsuarios, DefaultTableModel modeloTabla) {
        this.listaUsuarios = listaUsuarios;
        this.Tabla = modeloTabla;
    }

    public void actualizarTabla() {
        this.Tabla.setRowCount(0);
        for (Usuario usuario : this.listaUsuarios) {
            Object[] fila = {
                usuario.getIdUsuario(),
                usuario.getNombreUsuario(),
                usuario.getRol()
            };
            this.Tabla.addRow(fila);
        }
    }

    public boolean guardarUsuario(String id, String nombre, String contraseña, String rol) {
        if (id.isEmpty() || nombre.isEmpty() || contraseña.isEmpty()) {
            return false;
        }
        Usuario nuevoUsuario = new Usuario(id, nombre, contraseña, rol);
        this.listaUsuarios.add(nuevoUsuario);
        actualizarTabla();
        return true;
    }

    public void eliminarUsuario(int filaSeleccionada) {
        this.listaUsuarios.remove(filaSeleccionada);
        actualizarTabla();
    }

    public void modificarUsuario(int filaSeleccionada, String id, String nombre, String pass, String rol) {
        Usuario usuario = this.listaUsuarios.get(filaSeleccionada);       
        usuario.setIdUsuario(id);
        usuario.setNombreUsuario(nombre);
        usuario.setContrasena(pass);
        usuario.setRol(rol);
        actualizarTabla();
    }
    
}
