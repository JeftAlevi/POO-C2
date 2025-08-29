package pe.edu.upeu.claseinterna;

class ClaseExterna2{
    public static void main(String[] args) {
        ClaseExterna ce = new ClaseExterna();
        ce.a=10;
        ce.b=20;
        ClaseExterna.ClaseInterna1 ci1 = ce.new ClaseInterna1();
        System.out.println(ci1.sumar());

        ClaseExterna.ClaseInterna2 ci2 = ce.new ClaseInterna2();
        ci2.restar();
        System.out.println(ci2.r);
    }
}