package symulator;

public class SkrzyniaBiegow extends Komponent{
    Integer aktualnyBieg;
    Integer iloscBiegow;

    public void zwiekszBieg(){
        this.aktualnyBieg+=1;
    }
    public void zmniejszBieg(){
        this.aktualnyBieg-=1;
    }

    public Integer getAktualnyBieg() {
        return this.aktualnyBieg;
    }

    public Integer getIloscBiegow() {
        return this.iloscBiegow;
    }
    SkrzyniaBiegow(int maxBiegow){
        this.iloscBiegow = maxBiegow;
        this.aktualnyBieg = 0;
    }
}
