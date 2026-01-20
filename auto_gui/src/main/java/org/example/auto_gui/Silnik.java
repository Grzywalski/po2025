package org.example.auto_gui;


public class Silnik extends Komponent {
    final int maxObroty = 10000;
    double obroty;
    private boolean wlaczony;
    Integer iloscKoni;


    public void uruchom() {
        if (!wlaczony) {
            System.out.println("silnik on");
            this.obroty = 1000;
            this.wlaczony = true;
        } else {
            System.out.println("Silnik już działa.");
        }
    }


    public void zatrzymaj() {
        if (wlaczony) {
            System.out.println("silnik off");
            this.obroty = 0;
            this.wlaczony = false;
        } else {
            System.out.println("Silnik jest już wyłączony.");
        }
    }


    public void zwiekszObroty(double newObroty) {
        if (wlaczony) {
            this.obroty += newObroty;
            if (this.obroty > maxObroty) {
                this.obroty = maxObroty;
            }
        } else {
            System.out.println("Nie można zwiększać obrotów, silnik wyłączony.");
        }
    }

    public void zmniejszObroty(double newObroty) {
        if (wlaczony) {
            this.obroty -= newObroty;
            if (this.obroty < 0) {
                this.obroty = 0;
            }
        }
    }

    public int getKonie(){return this.iloscKoni;}
    public double getObroty() {
        return this.obroty;
    }


    public boolean isWlaczony() {
        return this.wlaczony;
    }

    Silnik(Integer iloscKoni) {
        this.obroty = 0;
        this.wlaczony = false;
        this.iloscKoni = iloscKoni;
    }
}