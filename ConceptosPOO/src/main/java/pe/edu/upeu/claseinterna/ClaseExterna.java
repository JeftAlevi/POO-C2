package pe.edu.upeu.claseinterna;

public class ClaseExterna {
    int a, b;
    class ClaseInterna1{
        double r;
        double sumar(){
            return a+b;
        }
    }
    class ClaseInterna2{
        double r;
        double restar(){
            r=a-b;
            return r;
        }
    }
}