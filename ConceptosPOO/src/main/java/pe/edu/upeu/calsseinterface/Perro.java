package pe.edu.upeu.calsseinterface;

public class Perro implements Animal {
    @Override
    public void emitirSonido() {
        System.out.println("GUAU GUAUUU.....!");
    }

    @Override
    public void dormir() {
        System.out.println("zzz.....Zzzz");

    }
}
