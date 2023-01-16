
/* public class Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 2;
		short wert;

		switch (n) {
		case 1:
		    wert = 100;
		    break;
		case 2:
		case 3:
		    wert = 2500;
		    break;
		default:
		    wert = 1;
		}

		System.out.println (wert);
	}

}
*/

import java.util.Scanner;
public class Kalender {
	public static void main(String[] args) {
		int tage = 0;
		int monat;
		Scanner tastatur = new Scanner(System.in);

		do {
			System.out.print("Wie lautet der Monat (1-12): ");
			monat = tastatur.nextInt();
	
	                // switch: Anzahl von Tage
			
			switch (monat) {
			case 1, 3, 5, 7, 8, 10, 12: 
				tage = 31;
				break;
			case 2:
				tage = 28;
				break;
			case 4, 6, 9, 11:
				tage = 30;
				break;
			default:
				System.out.println("Dieser Monat existiert nicht.");
				
			}
		} while (tage == 0);

		System.out.printf("Der %d-te Monat im Jahr hat %d Tage.", monat, tage);
		tastatur.close();
	}
}
