package pe.edu.upeu.abspolimorfismo;

public class Loro extends Animal {
    private String tipo= "ave";
    @Override
    public void emitirSonido()
    {
        System.out.println("HEY no te duermas");
    }
    @Override
    public void dormir(){
        super.dormir();
        System.out.println(super.tipo);
        System.out.println(this.tipo);
        System.out.println("NO MOLESTAR TASU");
    }

}
