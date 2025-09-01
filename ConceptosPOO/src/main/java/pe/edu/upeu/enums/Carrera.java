package pe.edu.upeu.enums;

enum FACULTAD{
    FIA,
    FCE,
    FACIHED,
    FCS
}

public enum Carrera {
    Sistemas(FACULTAD.FIA),
    Civil(FACULTAD.FIA),
    Administracion(FACULTAD.FCE),
    Enfermeria(FACULTAD.FCS),
    ;


    FACULTAD facultad;
    Carrera(FACULTAD facultad){
        this.facultad = facultad;
    }

}
