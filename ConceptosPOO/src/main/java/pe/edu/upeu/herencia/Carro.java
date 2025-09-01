package pe.edu.upeu.herencia;

import pe.edu.upeu.encapsulamiento.Jugador;

public class Carro extends Vehiculo{
    String modelo="MISTANG";
    String color="AMARILLO";
    String placa="PE-213123123";
    void caracteristicas(){

        System.out.println("LAS CARACTERISTICAS DE ESTE CARR SON:");
        System.out.println("Modelo: "+marca); //atributo heredado
        System.out.println("Color: "+color);
        System.out.println("Placa: "+placa);
    }

    public static void main(String[] args) {
        Carro carro=new Carro();
        carro.caracteristicas();
        carro.sonido();//metodo heredado
    }
}
