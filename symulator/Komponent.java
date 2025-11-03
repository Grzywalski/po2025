package symulator;

public abstract class Komponent {
    String producent;
    String model;

    public String getModel() {
        return this.model;
    }
    public String getProducent(){
        return this.producent;
    }
}
