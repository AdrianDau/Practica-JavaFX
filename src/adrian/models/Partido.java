package adrian.models;

import java.util.Date;

public class Partido {
    private String equipoLocal;
    private String equipoVisitante;
    private int resultadoLocal;
    private int resultadoVisitante;
    private int division;
    private Date fecha;


    public Partido(String equipoLocal, String equipoVisitante, int resultadoLocal, int resultadoVisitante, int division, Date fecha) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.resultadoLocal = resultadoLocal;
        this.resultadoVisitante = resultadoVisitante;
        this.division = division;
        this.fecha = fecha;

    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public int getResultadoLocal() {
        return resultadoLocal;
    }

    public void setResultadoLocal(int resultadoLocal) {
        this.resultadoLocal = resultadoLocal;
    }

    public int getResultadoVisitante() {
        return resultadoVisitante;
    }

    public void setResultadoVisitante(int resultadoVisitante) {
        this.resultadoVisitante = resultadoVisitante;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}