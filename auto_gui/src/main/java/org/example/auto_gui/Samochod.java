package org.example.auto_gui;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Random;
public class Samochod {
    String Nazwa;
    Silnik silnik;
    SkrzyniaBiegow skrzynia;
    Sprzeglo sprzeglo;
    public Pozycja pozycja;
    public ImageView widokSamochodu;
    private static final Image CAR_IMAGE;
    private static final Random RANDOM = new Random();
    static {
        Image imageToLoad;
        try {

            imageToLoad = new Image(HelloApplication.class.getResource("/org/example/auto_gui/car.png").toExternalForm());
        } catch (Exception e) {
            System.err.println("BŁĄD KRYTYCZNY: Nie można załadować statycznego obrazu car.jpg!");
            e.printStackTrace();
            imageToLoad = null;
        }
        CAR_IMAGE = imageToLoad;
    }

    public void wlaczAuto() {
        wlacz();
    }

    public void wylaczAuto() {
        wylacz();
    }

    public void wlaczSilnik() {
        silnik.uruchom();
    }

    public void wylaczSilnik() {
        silnik.zatrzymaj();
    }

    public void wcisnijSprzeglo() {
        sprzeglo.wcisnij();
    }

    public void zwolnijSprzeglo() {
        sprzeglo.zwolnij();

    }

    public void zwiekszBieg() {
        if (sprzeglo.stanSprzegla()) {
            skrzynia.zwiekszBieg();
        } else {
            System.out.println("Nie można zmienić biegu - wciśnij sprzęgło.");
        }
    }

    public void zmniejszBieg() {
        if (sprzeglo.stanSprzegla()) {
            skrzynia.zmniejszBieg();
        } else {
            System.out.println("Nie można zmienić biegu - wciśnij sprzęgło.");
        }
    }


    public void zwiekszObroty(double newObroty) {
        silnik.zwiekszObroty(newObroty);
    }

    public void zmniejszObroty(double newObroty) {
        silnik.zmniejszObroty(newObroty);
    }

    public String getNazwa() {
        return Nazwa;
    }

    public int getIloscBiegow() {
        return skrzynia.getIloscBiegow();
    }

    public int getAktualnyBieg() {
        return skrzynia.getAktualnyBieg();
    }

    public double getObrotySilnika() {
        return silnik.getObroty();
    }

    public boolean isSilnikWlaczony() {
        return silnik.isWlaczony();
    }

    public boolean isSprzegloWcisniete() {
        return sprzeglo.stanSprzegla();
    }

    @Override
    public String toString() {
        return Nazwa;
    }

    public void wlacz() {
        System.out.println("auto on");
        silnik.uruchom();
    }

    public void wylacz() {
        System.out.println("auto off");
        silnik.zatrzymaj();
        skrzynia.aktualnyBieg = 0;
    }
    public void aktualizujWidokNaPlanszy() {
        this.widokSamochodu.setLayoutX(this.pozycja.x);
        this.widokSamochodu.setLayoutY(this.pozycja.y);
    }


    public void przesun(double deltaX, double deltaY) {
        this.pozycja.changePosition(this.pozycja.x + deltaX, this.pozycja.y + deltaY);
        aktualizujWidokNaPlanszy();
    }
    private Pozycja generujLosowaPozycje() {

        final int MAX_X = 400;
        final int MAX_Y = 500;
        double randomX = RANDOM.nextInt(MAX_X);
        double randomY = RANDOM.nextInt(MAX_Y);

        return new Pozycja(randomX, randomY);
    }

    public Samochod(String nazwa, int iloscBiegow) {
        this.Nazwa = nazwa;
        this.silnik = new Silnik();
        this.skrzynia = new SkrzyniaBiegow(iloscBiegow);
        this.sprzeglo = new Sprzeglo();

        this.pozycja = generujLosowaPozycje();
        this.widokSamochodu = new ImageView(CAR_IMAGE);
        this.widokSamochodu.setFitWidth(160);
        this.widokSamochodu.setFitHeight(160);

        this.widokSamochodu.setStyle("-fx-border-color: gray; -fx-border-width: 1;");
        aktualizujWidokNaPlanszy();
    }


    public Silnik getSilnik() { return silnik; }
    public SkrzyniaBiegow getSkrzynia() { return skrzynia; }
    public Sprzeglo getSprzeglo() { return sprzeglo; }
}