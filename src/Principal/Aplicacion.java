
package Principal;

import Modelo.DAO.JugadorDAO;
import Vista.VistaJugador;
import Controlador.JugadorController;

public class Aplicacion {

    public static void main(String[] args) {
            javax.swing.SwingUtilities.invokeLater(()->{
            JugadorDAO dao = new JugadorDAO();
            VistaJugador view = new VistaJugador();
            JugadorController controller = new JugadorController(dao,view);
            view.setVisible(true);
        });
    }  
}
