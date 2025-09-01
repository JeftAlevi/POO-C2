package pe.edu.upeu.encapsulamiento;

public class ClaseGeneral {

    public static void probarJugador(){
        Jugador jugador=new Jugador();
        jugador.setNombre("MESSI");
        jugador.setApellido("MAMANI ");
        jugador.setEdad(36);
        jugador.setNumeroCam(10);
        jugador.setPosicion("DELANTERO");
        System.out.println(jugador);

    }
    public static void probar(){
        Estudiante estudiante = new Estudiante();
        estudiante.getCarrera("Ing. Sistemas");
        estudiante.getCodigo("202510847");
        estudiante.trabajo();

    }
    public static void main( String[] args ) {
        Persona persona = new Persona();
        persona.nombre = "Diego";
        persona.edad = 22;
        persona.saludo();
        System.out.println("Genero"+persona.getGenero());
        probarJugador();
        probar();
    }
}
