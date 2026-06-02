
package Controlador;

import Modelo.DAO.JugadorDAO;
import Vista.VistaJugador;
import Modelo.Estadistica;
import Modelo.Jugador;
import java.util.*;

public class JugadorController {
    
    private final JugadorDAO modelo;
    private final VistaJugador vista;

    public JugadorController(JugadorDAO modelo, VistaJugador vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.agregarManejadorAgregar(e -> agregarJugador());
        vista.agregarManejadorModificar(e -> modificarJugador());
        vista.agregarManejadorMostrar(e -> cargarJugador());
        vista.agregarManejadorEliminar(e -> eliminarJugador());
        actualizarLista();
    }
    
    private void agregarJugador(){
        try{
            Jugador jugador = vista.obtenerDatos();
            boolean exito = modelo.agregarJugador(jugador);
            if(exito){
                vista.mostrarMensaje("Jugador agregado con exito");
                vista.limpiarDatos();
                actualizarLista();
            }
        }
        catch (NumberFormatException ex){
            vista.mostrarMensaje("Ocurrio un error. Por favor coloque bien los datos");
        }
        catch (Exception ex){
            vista.mostrarMensaje("Ocurrio un error: "+ex.getMessage());
        }
    }
    
    private void modificarJugador(){
        try{
            Jugador jugador = vista.obtenerDatos();
            boolean exito = modelo.modificarJugador(jugador);
            if(exito){
                vista.mostrarMensaje("Jugador modificado con exito");
                vista.limpiarDatos();
                actualizarLista();
            }
            else{
                vista.mostrarMensaje("Error al modificar");
            }
        }
        catch (NumberFormatException ex){
            vista.mostrarMensaje("Ocurrio un error. Por favor coloque bien los datos");
        }
        catch (Exception ex){
            vista.mostrarMensaje("Error: "+ex.getMessage());
        }
    }
    
    private void cargarJugador(){
        try{
            String apellido = vista.buscarJugador();
            Jugador jugador = modelo.buscarJugador(apellido);
            if(jugador !=null){
                vista.cargarDatos(jugador,jugador.getEstadistica());
            }
            else{
                vista.mostrarMensaje("Jugador no encontrado");
                vista.limpiarDatos();
            }
        }
        catch(Exception ex){
            vista.mostrarMensaje("Error: "+ex.getMessage());
        }
    }
    
    private void eliminarJugador(){
        try{
            String apellido = vista.buscarJugador();
            boolean exito = modelo.eliminarJugador(apellido);
            if(exito){
                vista.mostrarMensaje("Jugador eliminado con exito");
                vista.limpiarDatos();
                actualizarLista();
            }
            else{
                vista.mostrarMensaje("Error al eliminar. Jugador no encontrado");
            }
        }
        catch(Exception ex){
            vista.mostrarMensaje("Error: "+ex.getMessage());
        }
    }
    
    private void actualizarLista() {
        try {
            List<Jugador> jugadores = modelo.listarTodos();
            vista.mostrarListaJugadores(jugadores);
        } catch (Exception ex) {
            vista.mostrarMensaje("Error al cargar la lista de jugadores: " + ex.getMessage());
        }
    }
}
