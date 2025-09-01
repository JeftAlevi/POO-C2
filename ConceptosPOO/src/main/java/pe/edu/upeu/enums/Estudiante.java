package pe.edu.upeu.enums;

enum GENERO{
    FEMENINO,
    MASCULINO,
}

public class Estudiante {
    String codigo;
    String nombre;
    String apellido;
    GENERO genero;
    Carrera carrera;

public Estudiante(String codigo, String nombre,
                  String apellido, GENERO genero, Carrera carrera){
    this.codigo = codigo;
    this.nombre = nombre;
    this.apellido = apellido;
    this.genero = genero;
    this.carrera = carrera;
}
public static void main(String[] args) {
   Estudiante e=new Estudiante("213132131","TUMBILLO",
                         "mamani", GENERO.FEMENINO,Carrera.Sistemas);

    System.out.println(e.codigo+" "+e.genero+" "+e.carrera+" ");
}
}

