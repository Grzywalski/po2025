import java.util.Random;

public class lotto {
public static void main(String[] args) {
Random random = new Random();
float[] wyniki = new float[6];
for(int i = 0;i<6;i++){
float randomInt = random.nextFloat(49);
wyniki[i] = randomInt;
if(i>=1){
while(randomInt == wyniki[i-1]){
randomInt = random.nextFloat(49);
wyniki[i] = randomInt;
}
}
System.out.println("Random int: " + randomInt);
}
}
} 