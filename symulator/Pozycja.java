package symulator;

public class Pozycja {
    double x;
    double y;
    public String getPosition(){
        return "x:"+this.x+" y:"+this.y;
    }
    public void changePosition(double newX,double newY){
        this.x = newX;
        this.y = newY;
    }
    Pozycja(double startX,double startY){
        this.x = startX;
        this.y = startY;
    }
}
