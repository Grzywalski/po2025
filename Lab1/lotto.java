import java.util.Random;

public class lotto {
public static void main(String[] args) {
Random random = new Random();
int[] wyniki = new int[6];
for(int i = 0;i<6;i++){
int randomInt = random.nextInt(49);
System.out.println("Random int: " + randomInt);
wyniki[i] = randomInt;
}
System.out.println(wyniki);
}
} 