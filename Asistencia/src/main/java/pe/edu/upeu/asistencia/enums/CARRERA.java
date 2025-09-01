package pe.edu.upeu.asistencia.enums;


public enum CARRERA {

    ;

    private FACULTAD facultad;

    CARRERA(FACULTAD facultad) {
        this.facultad = facultad;
    }

    public FACULTAD getFacultad() {
        return facultad;
    }

}
