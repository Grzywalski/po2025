package zadania;
import animals.*;
import java.util.Random;

public class Zoo {
    Random rand = new Random();
    Animal[] animals = new Animal[100];

    public void stworzZoo() {
        for (int i = 0; i < 100; i++) {
            int r = rand.nextInt(3);
            switch (r) {
                case 0:
                    animals[i] = new Parrot();
                    break;
                case 1:
                    animals[i] = new Snake();
                    break;
                case 2:
                    animals[i] = new Dog();
                    break;
            }
        }
        for (int i = 0;i<100;i++){
            System.out.println(animals[i].getDescription());
        }
    }
}
 class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.stworzZoo();
    }
}