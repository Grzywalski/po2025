package symulator;

public class Samochod {
    Silnik silnik;
    SkrzyniaBiegow skrzynia;
    Sprzeglo sprzeglo;
    public void wlacz(){
        System.out.println("auto on");
        silnik.uruchom();
    }
    public void wylacz(){
        System.out.println("auto off");
        silnik.zatrzymaj();
        skrzynia.aktualnyBieg=0;
    }
    Samochod(int iloscBiegow){
        this.silnik = new Silnik();
        this.skrzynia = new SkrzyniaBiegow(iloscBiegow);
        this.sprzeglo = new Sprzeglo();
    }

    public static void main(String[] args){
        Samochod toyotka = new Samochod(6);
        toyotka.wlacz();
        toyotka.sprzeglo.wcisnij();
        toyotka.silnik.zwiekszObroty(2000);
        toyotka.skrzynia.zwiekszBieg();
        toyotka.sprzeglo.zwolnij();
        toyotka.sprzeglo.wcisnij();
        toyotka.silnik.zmniejszObroty(1000);
        toyotka.skrzynia.zmniejszBieg();
        toyotka.sprzeglo.zwolnij();
        toyotka.wylacz();
        System.out.println("jazda probna udana");

    }
}
