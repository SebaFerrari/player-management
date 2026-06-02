
package Modelo.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Modelo.Jugador;

public class JugadorDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_jugadores";
    private static final String USER = "root"; 
    private static final String PASS = "";
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
    
    public boolean agregarJugador(Jugador jugador){
        String sql = "INSERT INTO jugadores " +
                 "(nombre, apellido, categoria, dorsal, posicion, edad, " +
                 " goles, asistencias, tiempojugado, kmrecorridos, golespp) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, jugador.getNombre());
            stmt.setString(2, jugador.getApellido());
            stmt.setInt(3, jugador.getCategoria());
            stmt.setInt(4, jugador.getDorsal());
            stmt.setString(5, jugador.getPosicion());
            stmt.setInt(6, jugador.getEdad());

            Modelo.Estadistica st = jugador.getEstadistica();
            int goles        = (st != null) ? st.getGoles() : 0;
            int asistencias  = (st != null) ? st.getAsistencias() : 0;
            double tJugado   = (st != null) ? st.getTiempojugado() : 0.0;
            double km        = (st != null) ? st.getKmrecorridos() : 0.0;
            int golespp      = (st != null) ? st.getGolespp() : 0;

            stmt.setInt(7,  goles);
            stmt.setInt(8,  asistencias);
            stmt.setBigDecimal(9,  java.math.BigDecimal.valueOf(tJugado));
            stmt.setBigDecimal(10, java.math.BigDecimal.valueOf(km));
            stmt.setInt(11, golespp);

            return stmt.executeUpdate()>0;
        } 
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public Jugador buscarJugador(String apellido){
        String sql = "SELECT nombre, apellido, categoria, dorsal, posicion, edad, " +
                 "goles, asistencias, tiempojugado, kmrecorridos, golespp " +
                 "FROM jugadores WHERE apellido = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, apellido);
            try (ResultSet rs = stmt.executeQuery()){
                if (!rs.next()) return null;

                Jugador j = new Jugador(
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getInt("categoria"),
                    rs.getInt("dorsal"),
                    rs.getString("posicion"),
                    rs.getInt("edad")
                );

                Modelo.Estadistica st = new Modelo.Estadistica(
                    rs.getDouble("kmrecorridos"),
                    rs.getDouble("tiempojugado"),
                    rs.getInt("goles"),
                    rs.getInt("asistencias"),
                    rs.getInt("golespp")
                );
                j.setEstadistica(st);
                return j;
            }
        } 
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean modificarJugador(Jugador jugador){
        String sql = "UPDATE jugadores SET nombre = ?, categoria = ?, dorsal = ?, posicion = ?, edad = ?, " +
                 "goles = ?, asistencias = ?, tiempojugado = ?, kmrecorridos = ?, golespp = ? " +
                 "WHERE apellido = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, jugador.getNombre());
            stmt.setInt(2, jugador.getCategoria());
            stmt.setInt(3, jugador.getDorsal());
            stmt.setString(4, jugador.getPosicion());
            stmt.setInt(5, jugador.getEdad());

            Modelo.Estadistica st = jugador.getEstadistica();
            int goles        = (st != null) ? st.getGoles() : 0;
            int asistencias  = (st != null) ? st.getAsistencias() : 0;
            double tJugado   = (st != null) ? st.getTiempojugado() : 0.0;
            double km        = (st != null) ? st.getKmrecorridos() : 0.0;
            int golespp      = (st != null) ? st.getGolespp() : 0;

            stmt.setInt(6,  goles);
            stmt.setInt(7,  asistencias);
            stmt.setBigDecimal(8,  java.math.BigDecimal.valueOf(tJugado));
            stmt.setBigDecimal(9,  java.math.BigDecimal.valueOf(km));
            stmt.setInt(10, golespp);

            stmt.setString(11, jugador.getApellido());
            return stmt.executeUpdate() > 0;
        } 
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminarJugador(String apellido){
        String sql = "DELETE FROM jugadores WHERE apellido = ?";
        try (Connection conn = getConnection();PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, apellido);
            return stmt.executeUpdate() > 0;
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Jugador> listarTodos(){
        String sql = "SELECT nombre, apellido, categoria, dorsal, posicion, edad, " +
                 "goles, asistencias, tiempojugado, kmrecorridos, golespp " +
                 "FROM jugadores";
    
        List<Jugador> lista = new ArrayList<>();
    
        try (Connection conn = getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(sql); 
            ResultSet rs = stmt.executeQuery()) {
        
            while (rs.next()) {
            
                Jugador j = new Jugador(
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getInt("categoria"),
                    rs.getInt("dorsal"),
                    rs.getString("posicion"),
                    rs.getInt("edad")
                );

            
                Modelo.Estadistica st = new Modelo.Estadistica(
                    rs.getDouble("kmrecorridos"),
                    rs.getDouble("tiempojugado"),
                    rs.getInt("goles"),
                    rs.getInt("asistencias"),
                    rs.getInt("golespp")
                );
            
            
                j.setEstadistica(st);
            
           
                lista.add(j);
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
