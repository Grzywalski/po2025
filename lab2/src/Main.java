import java.util.ArrayList;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] wyniki = new int[6];
        for (int i = 0; i < 6; i++) {
            int randomInt = random.nextInt(49);
            wyniki[i] = randomInt;
            for (int j = 0; j < i; j++) {
                while (wyniki[i] == wyniki[j]) {
                    randomInt = random.nextInt(49);
                    wyniki[i] = randomInt;

                }
            }
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(wyniki[i]);
        }
        if (args.length == 6) {

            int[] checker = new int[6];
            for (int i = 0; i < checker.length; i++) {
                checker[i] = 0;
            }

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (Integer.parseInt(args[i]) == wyniki[j]) {
                        checker[i] = 1;

                    }
                }
            }
            for(int i =0;i<6;i++){
                if(checker[i]==1){
                    System.out.println("trafiona wartosc:"+args[i]);
                }else{
                    System.out.println("nie trafione");
                }
            }
        } else if (args.length==1) {
            int[] los = new int[6];
            int[] checker = new int[6];
            for (int i = 0; i < checker.length; i++) {
                checker[i] = 0;
            while(checker[0]+checker[1]+checker[2]+checker[3]+checker[4]+checker[5]!=6){
    for (int k = 0; k < 6; k++) {
        int randomInt = random.nextInt(49);
        los[k] = randomInt;
        for (int j = 0; j < k; j++) {
            while (los[k] == los[j]) {
                randomInt = random.nextInt(49);
                los[k] = randomInt;

            }
        }
    }
    for (int r = 0; r < checker.length; r++) {
        checker[r] = 0;
    }
    for (int p = 0; p < 6; p++) {
        for (int a = 0; a < 6; a++) {
            if (los[p] == wyniki[a]) {
                checker[p] = 1;
                System.out.println(los[p]);
            }
        }
    }
}
        }
    }
}}