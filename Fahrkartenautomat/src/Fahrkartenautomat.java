import java.util.Scanner;

class Fahrkartenautomat {
	//Hello World
	public static void begruessung() {
		System.out.println("Herzlich Wilkommen!\n");
	}
	
	//Kartenauswahl und Ticketanzahl
	public static int fahrkartenbestellungErfassen(){
		int zahl = 0;
		return zahl;
	}
	
	public static void main(String[] args) {

		Scanner tastatur = new Scanner(System.in);

		double zuZahlenderBetrag = 0;
		double eingezahlterGesamtbetrag;
		double eingeworfeneMuenze;
		double rueckgabebetrag;
		double nochZuZahlen;
		int ticketAnzahl;
		int ticketAuswahl;
		double zwischenSumme = 0;
		boolean wiederholung = true;
		
		begruessung();
		
		System.out.println("Fahrkartenbestellvorgang:\r\n"
				+ "=========================\r\n"
				+ "\r\n");
		do {    
	        System.out.println("Wählen Sie ihre Wunschfahrkarte für Berlin AB aus:\n"
	                + "  Kurzstrecke AB [2,00 EUR] (1)\n"
	                + "  Einzelfahrschein AB [3,00 EUR] (2)\n"
	                + "  Tageskarte AB [8,80 EUR] (3)\n"
	                + "  4-Fahrten-Karte AB [9,40 EUR] (4)"
	                + " \n  Bezahlen (9)"
	                + " \n\n");
	        
	        zuZahlenderBetrag = 0;
	        while (zuZahlenderBetrag == 0) {
	            System.out.print("Ihre Wahl: ");
	            ticketAuswahl = tastatur.nextInt(); 
	                
	            switch (ticketAuswahl) {
	            
	            case 1:
	                zuZahlenderBetrag = 2.00;
	                break;
	            case 2:
	                zuZahlenderBetrag = 3.00;
	                break;
	            case 3:
	                zuZahlenderBetrag = 8.80;
	                break;
	            case 4:
	                zuZahlenderBetrag = 9.40;
	                break;
	            case 9:
	                
	                break;
	            default:
	                zuZahlenderBetrag = 0;
	                System.out.println(" >> Falsche Eingabe << ");
	            }
	            if (ticketAuswahl == 9) {
	                if (zwischenSumme == 0) {
	                
	                }else {
	                    wiederholung = false;
	                    break; 
	                    }
	            }
	            
	        }
	    
	        
	// Ticketanzahl 
	        ticketAnzahl = 0;
	        while (wiederholung) {
	            System.out.print("Anzahl der Tickets: ");
	            ticketAnzahl = tastatur.nextInt();
	            if (ticketAnzahl >= 1 && ticketAnzahl <= 10) break;
	        
	            System.out.println(">> Wählen Sie bitte eine Ticketanzahl von 1 - 10 aus. <<");
	        }    
	        
	        zuZahlenderBetrag = ticketAnzahl*zuZahlenderBetrag;
	        zwischenSumme +=zuZahlenderBetrag;
	        System.out.printf("Zwischensumme: %.2f Euro\n ",zwischenSumme);
	        
	        }while(wiederholung);
		
		zuZahlenderBetrag = zwischenSumme;
		
		//Geldeinwurf
		eingezahlterGesamtbetrag = 0.0;
		nochZuZahlen = 0.0;
		while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
			nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
			System.out.printf("Noch zu zahlen: %.2f\n",nochZuZahlen);
			System.out.print("Eingabe (mind. 5 Cent, höchstens 20 Euro): ");
			eingeworfeneMuenze = tastatur.nextDouble();
				if(eingeworfeneMuenze == 0.05 || eingeworfeneMuenze == 0.1 
					|| eingeworfeneMuenze == 0.2 
					|| eingeworfeneMuenze == 0.5 
					|| eingeworfeneMuenze == 1 
					|| eingeworfeneMuenze == 2 
					|| eingeworfeneMuenze == 5
					|| eingeworfeneMuenze == 10
					|| eingeworfeneMuenze == 20) {
					eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;				
			}else {
				System.out.println(">> Keine gültiges Zahlungsmittel");
			}
		}
		
		// Fahrscheinausgabe
		System.out.println("\nFahrschein wird ausgegeben");
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
		
		// Rückgeldberechnung und -ausgabe
		rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
		if (rueckgabebetrag > 0.0) {
			System.out.printf("Der Rückgabebetrag in Höhe von %.2f Euro ",rueckgabebetrag);
			System.out.println("wird in folgenden Münzen ausgezahlt:");

			while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
				System.out.println("2 Euro");
				rueckgabebetrag = rueckgabebetrag - 2.0;
			}
			while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
				System.out.println("1 Euro");
				rueckgabebetrag = rueckgabebetrag - 1.0;
			}
			while (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
				System.out.println("50 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.5;
			}
			while (rueckgabebetrag >= 0.2) { // 20-Cent-Münzen
				System.out.println("20 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.2;
			}
			while (rueckgabebetrag >= 0.1) { // 10-Cent-Münzen
				System.out.println("10 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.1;
			}
			while (rueckgabebetrag >= 0.05) { // 5-Cent-Münzen
				System.out.println("5 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.049;
			}
		}

		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");

		tastatur.close();
	}
}