
package Modelo;

public class Estadistica {
    
    private double kmrecorridos;
    private double tiempojugado;
    private int goles;
    private int asistencias;
    private int golespp;

    public Estadistica(double kmrecorridos, double tiempojugado, int goles, int asistencias, int golespp) {
        this.kmrecorridos = kmrecorridos;
        this.tiempojugado = tiempojugado;
        this.goles = goles;
        this.asistencias = asistencias;
        this.golespp = golespp;
    }

    public double getKmrecorridos() {
        return kmrecorridos;
    }

    public double getTiempojugado() {
        return tiempojugado;
    }

    public int getGoles() {
        return goles;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public int getGolespp() {
        return golespp;
    }

    public void setKmrecorridos(double kmrecorridos) {
        this.kmrecorridos = kmrecorridos;
    }

    public void setTiempojugado(double tiempojugado) {
        this.tiempojugado = tiempojugado;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public void setGolespp(int golespp) {
        this.golespp = golespp;
    }
}
