package symulator;

public class Sprzeglo extends Komponent{
    boolean stanSprzegla;

    public void wcisnij(){
        System.out.println("sprzeglo on");
        this.stanSprzegla = true;
    }
    public void zwolnij(){
        System.out.println("sprzeglo off");
        this.stanSprzegla = false;
    }
    public boolean stanSprzegla(){
        return this.stanSprzegla;
    }
    Sprzeglo(){
        this.stanSprzegla = false;
    }
}
