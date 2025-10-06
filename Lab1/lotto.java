import java.util.Random;

public class lotto {
public static void main(String[] args) {
Random random = new Random();
int[] wyniki = new int[6];

for(int i = 0;i<6;i++){
    int randomInt = random.nextInt(49);
    wyniki[i] = randomInt;
    for(int j = 0;j<i;j++){
        while(wyniki[i]==wyniki[j]){
            randomInt = random.nextInt(49);
            wyniki[i] = randomInt;
}
}
}
for (int i =0;i<6;i++){
    System.out.println(wyniki[i]);
}
}
}
