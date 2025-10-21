import static org.junit.Assert.*;

public class MainTest {
    Main Main = new Main();
    @org.junit.Test
    public void sleepIn() {
        System.out.println(Main.sleepIn(false,true));
        System.out.println(Main.sleepIn(false,false));
        System.out.println(Main.sleepIn(true,true));
    }

    @org.junit.Test
    public void monkeyTrouble() {
        System.out.println(Main.monkeyTrouble(true,true));
        System.out.println(Main.monkeyTrouble(false,true));
        System.out.println(Main.monkeyTrouble(false,false));
    }

    @org.junit.Test
    public void sumDouble() {
        System.out.println(Main.sumDouble(2,2));
        System.out.println(Main.sumDouble(3,2));
        System.out.println(Main.sumDouble(4,2));
    }
}

