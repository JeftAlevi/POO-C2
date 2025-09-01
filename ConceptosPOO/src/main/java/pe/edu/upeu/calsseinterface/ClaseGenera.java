package pe.edu.upeu.calsseinterface;

public class ClaseGenera {
    public static void main(String[] args) {
        Animal a,b;
        a=new Loro();
        a.emitirSonido();
        a.dormir();

        b=new Perro();
        b.dormir();
        b.emitirSonido();

    }
}
