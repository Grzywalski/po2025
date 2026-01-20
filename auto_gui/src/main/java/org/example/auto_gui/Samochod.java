package org.example.auto_gui;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.application.Platform;

public class Samochod extends Thread{
    String Nazwa;
    Silnik silnik;
    SkrzyniaBiegow skrzynia;
    Sprzeglo sprzeglo;
    Pozycja cel;
    public Pozycja pozycja;
    public boolean is_auto_on;
    public boolean autoExists;
    public ImageView widokSamochodu;
    private static final Image CAR_IMAGE;
    private static final Random RANDOM = new Random();
    private final List<Listener> listeners = new ArrayList<>();
    boolean SCT;

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
    public void addListener(Listener listener) { listeners.add(listener); }
    public void removeListener(Listener listener) { listeners.remove(listener); }

    private void notifyListeners() {
        List<Listener> copy = new ArrayList<>(listeners);
        for (Listener listener : copy) {
            // listener aktualizuje *tylko swój widok* lub GUI dla aktualnego auta
            Platform.runLater(() -> {
                // jeśli listener to HelloController:
                listener.update();
            });
        }
    }

    public void wlaczAuto() {
        wlacz();
    }

    public void wylaczAuto() {
        wylacz();
    }

    public void wlaczSilnik() {
        if (is_auto_on)
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
        if (sprzeglo.stanSprzegla() && silnik.getObroty() > 3000) {
            skrzynia.zwiekszBieg();
            if (silnik.getObroty() < silnik.maxObroty) {
                silnik.zmniejszObroty(1000);
            }
        } else {
            System.out.println("Nie można zmienić biegu - wciśnij sprzęgło lub zwieksz obroty.");
        }
    }

    public void zmniejszBieg() {
        if (sprzeglo.stanSprzegla() && silnik.getObroty() < 1000) {
            skrzynia.zmniejszBieg();
            if (silnik.getObroty() > 0) {
                silnik.zwiekszObroty(1000);
            }
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

    public boolean isAutoOn(){return is_auto_on;};

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
        is_auto_on = true;
    }

    public void wylacz() {
        System.out.println("auto off");
        silnik.zatrzymaj();
        skrzynia.aktualnyBieg = 0;
        is_auto_on = false;
    }
    public void aktualizujWidokNaPlanszy() {
        Platform.runLater(() -> {
            widokSamochodu.setLayoutX(pozycja.x);
            widokSamochodu.setLayoutY(pozycja.y);
        });
    }
    public void usunAuto(){
        autoExists = false;
        this.interrupt();
    }

    private Pozycja generujLosowaPozycje() {

        final int MAX_X = 700;
        final int MAX_Y = 400;
        double randomX = RANDOM.nextInt(MAX_X);
        double randomY = RANDOM.nextInt(MAX_Y);

        return new Pozycja(randomX, randomY);
    }
    public void jedzDo(Pozycja newPos) {
        this.cel = newPos;
    }
    @Override
    public void run() {
        double deltat = 0.1;

        while (autoExists) {
            if (cel != null) {

                double dx = cel.x - pozycja.x;
                double dy = cel.y - pozycja.y;

                double odleglosc = Math.sqrt(dx * dx + dy * dy);

                if (odleglosc < 5) {
                    pozycja.x = cel.x;
                    pozycja.y = cel.y;
                    cel = null;
                } else {
                    pozycja.x += getPredkosc() * deltat * dx / odleglosc;
                    pozycja.y += getPredkosc() * deltat * dy / odleglosc;
                }
            }

            notifyListeners();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
    public double getPredkosc() {
        if (skrzynia.aktualnyBieg <= 0 || !silnik.isWlaczony() || !is_auto_on) {
            return 0;
        }

        double przelozenie = 1.0 / skrzynia.aktualnyBieg;
        return silnik.getObroty() * przelozenie * 0.01;
    }




    public Samochod(String nazwa, int iloscBiegow,int iloscKoni,boolean SCT) {
        this.Nazwa = nazwa;
        this.silnik = new Silnik(iloscKoni);
        this.skrzynia = new SkrzyniaBiegow(iloscBiegow);
        this.sprzeglo = new Sprzeglo();
        this.is_auto_on = false;
        this.pozycja = generujLosowaPozycje();
        this.widokSamochodu = new ImageView(CAR_IMAGE);
        this.widokSamochodu.setFitWidth(160);
        this.widokSamochodu.setFitHeight(160);
        this.autoExists = true;
        this.SCT = SCT;

        aktualizujWidokNaPlanszy();
        start();
    }


    public Silnik getSilnik() { return silnik; }
    public SkrzyniaBiegow getSkrzynia() { return skrzynia; }
    public Sprzeglo getSprzeglo() { return sprzeglo; }

}