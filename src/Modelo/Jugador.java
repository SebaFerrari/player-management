
package Modelo;

public class Jugador {
    
    private String nombre;
    private String apellido;
    private int dorsal;
    private String posicion;
    private int edad;
    private int categoria;

    public Jugador(String nombre, String apellido, int categoria, int dorsal, String posicion, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.edad = edad;
        this.categoria = categoria;
    }
    
    private Estadistica estadistica;

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDorsal() {
        return dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public int getEdad() {
        return edad;
    }
    
    public int getCategoria(){
        return categoria;
    }
    
    public Estadistica getEstadistica(){
        return estadistica;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void setCategoria(int categoria){
        this.categoria = categoria;
    }
    
    public void setEstadistica(Estadistica estadistica){
        this.estadistica = estadistica;
    }
    
    @Override
    public String toString(){
        return nombre +" "+ apellido +" | " + categoria +" "+ dorsal +" "+ posicion +" "+ edad + " años";
    }
}
