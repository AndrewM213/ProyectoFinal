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

    /**
     * Lógica para refrescar la tabla.
     * Es invocado por la ventana.
     */
    public void actualizarTabla() {
        this.Tabla.setRowCount(0); // Limpia
        for (Usuario user : this.listaUsuarios) {
            Object[] fila = {
                user.getIdUsuario(),
                user.getNombreUsuario(),
                user.getRol()
            };
            this.Tabla.addRow(fila);
        }
    }

    /**
     * Lógica para guardar un nuevo usuario.
     * Es invocado por el botón "Guardar" de la ventana.
     */
    public boolean guardarUsuario(String id, String nombre, String pass, String rol) {
        // 1. Validaciones
        if (id.isEmpty() || nombre.isEmpty() || pass.isEmpty()) {
            return false; // Faltan datos
        }
        
        // 2. Crea el objeto
        Usuario nuevoUsuario = new Usuario(id, nombre, pass, rol);
        
        // 3. Añade al ArrayList
        this.listaUsuarios.add(nuevoUsuario);
        
        // 4. Refresca la tabla
        actualizarTabla();
        return true; // Éxito
    }

    /**
     * Lógica para eliminar un usuario.
     * Es invocado por el botón "Eliminar" de la ventana.
     */
    public void eliminarUsuario(int filaSeleccionada) {
        this.listaUsuarios.remove(filaSeleccionada);
        actualizarTabla();
    }
    
    /**
     * Lógica para modificar un usuario.
     * Es invocado por el botón "Modificar" de la ventana.
     */
    public void modificarUsuario(int filaSeleccionada, String id, String nombre, String pass, String rol) {
        // 1. Obtiene el objeto original
        Usuario user = this.listaUsuarios.get(filaSeleccionada);
            
        // 2. Modifica sus datos
        user.setIdUsuario(id);
        user.setNombreUsuario(nombre);
        user.setContrasena(pass);
        user.setRol(rol);
            
        // 3. Refresca la tabla
        actualizarTabla();
    }
    
}
