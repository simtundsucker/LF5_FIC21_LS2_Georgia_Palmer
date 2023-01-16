import java.util.Scanner;

class Fahrkartenautomat {
	static int gesamtzahlTickets = 0;
	
	public static void main(String[] args) {

		Scanner tastatur = new Scanner(System.in);

		double zuZahlenderBetrag = 0;
		double zwischenSumme = 0;
		double eingezahlterGesamtbetrag;
		
		
		begruessung();
		zuZahlenderBetrag = fahrkartenbestellungErfassung(tastatur);
		zwischenSumme = zuZahlenderBetrag;
		System.out.printf("\nZwischensumme: %.2f Euro\n", zwischenSumme);
		eingezahlterGesamtbetrag = fahrkartenBezahlen(tastatur, zuZahlenderBetrag);
		fahrkartenAusgabe(gesamtzahlTickets);
		rueckgeldAusgabe(eingezahlterGesamtbetrag, zuZahlenderBetrag);
		
		tastatur.close();
	
}
	public static void begruessung() {
		System.out.println("Herlich Willkommen!");	
	}
	
	public static double fahrkartenbestellungErfassung (Scanner tastatur) {
		double zuZahlenderBetrag = 0.0;
		int anzahlDerTickets = 0;
		int wahlDerTickets;
		do {
			do {
			System.out.println("\nWählen Sie Ihre Wunschfahrkarte für Berlin AB aus:"
					+ "\n  Kurzstrecke AB [2,00 EUR] (1)"
					+ "\n  Einzelfahrschein AB [3,00 EUR] (2)"
					+ "\n  Tageskarte AB [8,80 EUR] (3)"
					+ "\n  4-Fahrten-Karte AB [9,40 EUR] (4))"
					+ "\n  Bezahlen (9)");
			System.out.println("\n\nIhre Wahl: " );
			
			wahlDerTickets = tastatur.nextInt();
			
			switch (wahlDerTickets) {
			case 1:
				zuZahlenderBetrag = 2; 
				break;
			case 2:
				zuZahlenderBetrag = 3;
				break;
			case 3:
				zuZahlenderBetrag = 8.8;
				break;
			case 4:
				zuZahlenderBetrag = 9.4;
				break;
			case 9:	break;
				default:
					System.out.println(">>falsche Eingabe<< Bitte Eingabe zwischen 1-4 oder 9 tätigen: "); break;
			}  
		} while (wahlDerTickets != 1 && wahlDerTickets != 2 && wahlDerTickets != 3 && wahlDerTickets != 4 && wahlDerTickets != 9);
		
			if (wahlDerTickets == 9) break;
			
		while (true) {
			System.out.print("Anzahl der Tickets: ");
			anzahlDerTickets = tastatur.nextInt();
			if (1 <= anzahlDerTickets && anzahlDerTickets <=10) {
				break;
			}
			else {
				System.out.println(">> Wählen Sie bitte eine Anzahl von 1 bis 10 Tickets aus. <<");
			}
		}
		
		gesamtzahlTickets += anzahlDerTickets;
			
		} while (true);	
		
		zuZahlenderBetrag *= gesamtzahlTickets;
		
		return zuZahlenderBetrag;
	}
	
	public static double fahrkartenBezahlen(Scanner tastatur, double zuZahlenderBetrag) {
		double eingezahlterGesamtbetrag = 0.0;
		double nochZuZahlen = 0.0;
		double eingeworfeneMuenze = 0.0;
		while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
			nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
			System.out.printf("Noch zu zahlen: %.2f Euro\n", nochZuZahlen);
			System.out.print("Eingabe (mind. 5 Cent, höchstens 20 Euro): ");
			eingeworfeneMuenze = tastatur.nextDouble();
			if (eingeworfeneMuenze != 5 && eingeworfeneMuenze != 10 && eingeworfeneMuenze !=20 && eingeworfeneMuenze != 0.05 && eingeworfeneMuenze != 0.10 && eingeworfeneMuenze != 0.20 && eingeworfeneMuenze != 0.50 && eingeworfeneMuenze != 1 && eingeworfeneMuenze !=2) {
				System.out.println(">> Kein gültiges Zahlungsmittel << ");
				eingeworfeneMuenze = 0;
			}
			else {
			eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
			}
		}
		return eingezahlterGesamtbetrag;
	}
	
	public static void fahrkartenAusgabe(int gesamtzahlTickets) {
		System.out.println("\n" + gesamtzahlTickets + (gesamtzahlTickets == 1 ? " Fahrschein wird" : " Fahrscheine werden") + "ausgegeben");
		for (int i = 0; i < 8; i++) {
			System.out.print("=");
			try {
				Thread.sleep(200);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\n\n");
		
	}

	public static void rueckgeldAusgabe(double eingezahlterGesamtbetrag, double zuZahlenderBetrag) {
		double rueckgabebetrag = 0.0;
		rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
		if (rueckgabebetrag > 0.0) {
			System.out.printf("Der Rückgabebetrag in Höhe von %.2f Euro ", rueckgabebetrag);
			System.out.println("wird in folgenden Münzen ausgezahlt:");
			
//			muenzRueckgabe (rueckgabebetrag, 2.0);
//			muenzRueckgabe (rueckgabebetrag, 1.0);
//			muenzRueckgabe (rueckgabebetrag, 0.49);
//			muenzRueckgabe (rueckgabebetrag, 0.19);
//			muenzRueckgabe (rueckgabebetrag, 0.09);
//			muenzRueckgabe (rueckgabebetrag, 0.49);

			while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
				System.out.println("2 Euro");
				rueckgabebetrag = rueckgabebetrag - 2.0;
			}
			while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
				System.out.println("1 Euro");
				rueckgabebetrag = rueckgabebetrag - 1.0;
			}
			while (rueckgabebetrag >= 0.49) { // 50-Cent-Münzen
				System.out.println("50 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.5;
			}
			while (rueckgabebetrag >= 0.19) { // 20-Cent-Münzen
				System.out.println("20 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.2;
			}
			while (rueckgabebetrag >= 0.09) { // 10-Cent-Münzen
				System.out.println("10 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.1;
			}
			while (rueckgabebetrag >= 0.049) { // 5-Cent-Münzen
				System.out.println("5 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.05;
			}
		}

		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");
		
	}

//	public static double muenzRueckgabe(double rueckgabebetrag, double muenze) {
//		while (rueckgabebetrag >= muenze) { // 2-Euro-Münzen
//			System.out.println(muenze + " Euro");
//			rueckgabebetrag = rueckgabebetrag - muenze;
//		}
//		return rueckgabebetrag;
//	}

}

