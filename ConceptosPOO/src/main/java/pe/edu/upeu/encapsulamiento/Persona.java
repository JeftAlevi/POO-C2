package pe.edu.upeu.encapsulamiento;

public class Persona {
    String nombre;
    int edad;
    char genero;

    void saludo (){
        System.out.println("mi nombre es "+nombre+" y mi edad es "+edad);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
}

