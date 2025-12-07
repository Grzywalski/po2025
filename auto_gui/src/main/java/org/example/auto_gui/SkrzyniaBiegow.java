package org.example.auto_gui;

public class SkrzyniaBiegow extends Komponent {
    Integer aktualnyBieg;
    Integer iloscBiegow;

    public void zwiekszBieg() {
        if (aktualnyBieg < iloscBiegow) {
            this.aktualnyBieg += 1;
            System.out.println("Zwiększono bieg na: " + this.aktualnyBieg);
        } else {
            System.out.println("Jesteś już na najwyższym biegu.");
        }
    }

    public void zmniejszBieg() {
        if (aktualnyBieg > 0) {
            this.aktualnyBieg -= 1;
            System.out.println("Zmniejszono bieg na: " + this.aktualnyBieg);
        } else {
            System.out.println("Jesteś już na biegu jałowym (0).");
        }
    }

    public Integer getAktualnyBieg() {
        return this.aktualnyBieg;
    }

    public Integer getIloscBiegow() {
        return this.iloscBiegow;
    }

    SkrzyniaBiegow(int maxBiegow) {
        this.iloscBiegow = maxBiegow;
        this.aktualnyBieg = 0;
    }
}