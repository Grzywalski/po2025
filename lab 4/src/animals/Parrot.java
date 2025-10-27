package animals;

public class Parrot extends Animal {
    public Parrot(){
        this.IloscNog = 2;
    }
    public String getDescription() {
        return "papuga";
    }
    public Integer getNogi() {
        return IloscNog;
    }
}
