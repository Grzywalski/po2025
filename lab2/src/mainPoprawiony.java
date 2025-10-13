package lab2;
import java.util.ArrayList;
import java.util.Random;


class lotto {
	
	ArrayList<Integer> los = new ArrayList<Integer>();
	
	void losujLiczbe() {
		Random random = new Random();
		for(int i = 0;i<6;i++) {
			int mozliwylos = random.nextInt(47)+1; 
			while(los.contains(mozliwylos)) {
				mozliwylos = random.nextInt(47)+1; 
			}
			los.add(mozliwylos);
			
		}
		
		
	}
	boolean CheckLiczbe(ArrayList<Integer> args) {
		ArrayList<Integer> checker = new ArrayList<Integer>();
		for (int j = 0;j<6;j++) {
			checker.add(args.get(j));
		}
		return checker.equals(los);
	}
	/*
	 *  kod do sprawdzania czy argumenty podane na wejsciu funkcji to nasza zgadywana liczba lotto
	 * boolean CheckLiczbe(String[] args) {
		ArrayList<Integer> checker = new ArrayList<Integer>();
		for (int j = 0;j<6;j++) {
			checker.add(Integer.parseInt(args[j]));
		}
		return checker.equals(los);
	}*/
	ArrayList<Integer> zgadujliczbe() {
		Random random = new Random();
		ArrayList<Integer> zgadywanylos = new ArrayList<Integer>();
		for(int i = 0;i<6;i++) {
			int mozliwylos = random.nextInt(47)+1; 
			while(zgadywanylos.contains(mozliwylos)) {
				mozliwylos = random.nextInt(47)+1; 
			}
		zgadywanylos.add(mozliwylos);
			
		}
		return zgadywanylos;
	}
}

public class mainPoprawiony {
	public static void main(String[] args) {
		lotto lotto = new lotto();
		lotto.losujLiczbe();
		System.out.println(lotto.los + " liczby lotto");
		Integer counter = 0; 
		ArrayList<Integer> proba = lotto.zgadujliczbe();
		if(proba.equals(lotto.los)) {
			System.out.println("zgadles liczby:"+proba + "za "+counter+ " razem");
		}else {
			while(!proba.equals(lotto.los)) {
				proba = lotto.zgadujliczbe();
				counter++;
			}
			System.out.println("zgadles liczby:"+proba + "za "+counter+ " razem");
		}
		
		
		/*   dalsza czesc kodu do sprawdzenie czy argumnety na wejsciu to nasza liczba lotto
		System.out.println(lotto.CheckLiczbe(args));
		*/
	}
	
	
}
