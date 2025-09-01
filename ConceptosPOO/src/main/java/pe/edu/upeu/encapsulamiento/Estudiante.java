package pe.edu.upeu.encapsulamiento;

public class Estudiante {
    private String codigo;
    private String carrera;


    public void trabajo(){
        System.out.println("Estudiar!, investigar en la carrera de: "+carrera);
    }

    public String getCodigo(String number) {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCarrera(String s) {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
