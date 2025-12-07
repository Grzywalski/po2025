package org.example.auto_gui;

public class Sprzeglo extends Komponent {
    boolean stanSprzegla;

    public void wcisnij() {
        System.out.println("sprzeglo on");
        this.stanSprzegla = true;
    }

    public void zwolnij() {
        System.out.println("sprzeglo off");
        this.stanSprzegla = false;
    }


    public boolean stanSprzegla() {
        return this.stanSprzegla;
    }


    public boolean isWcisniete() {
        return this.stanSprzegla;
    }

    Sprzeglo() {
        this.stanSprzegla = false;
    }
}