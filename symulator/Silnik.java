package symulator;

public class Silnik extends Komponent{
    final int maxObroty = 10000;
    double obroty;

    public void uruchom(){
        System.out.println("silnik on");
        this.obroty = 1000;

    }
    public void zatrzymaj(){
        System.out.println("silnik off");
        this.obroty = 0;
    }


    public void zwiekszObroty(double newObroty){
        this.obroty += newObroty;
    }
    public void zmniejszObroty(double newObroty){
        this.obroty -= newObroty;
    }
    Silnik(){
        this.obroty = 0;
    }
}
