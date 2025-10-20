//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public boolean sleepIn(boolean weekday, boolean vacation) {
        if(weekday==false || vacation==true){
            return true;
        }else{
            return false;
        }
    }

    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        if((aSmile ==true && bSmile==true)||(aSmile==false &&bSmile==false)){
            return true;
        }else{
            return false;
        }
    }

    public int sumDouble(int a, int b) {
        if(a==b){
            return 4*a;
        }else{
            return a+b;
        }
    }


    public void main(String[] args) {

        System.out.println(sleepIn(true,false));

        System.out.println(monkeyTrouble(true,true));

        System.out.println(sumDouble(3,3));
        }
    }
