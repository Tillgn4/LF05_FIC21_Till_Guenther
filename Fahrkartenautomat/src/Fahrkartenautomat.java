import java.util.Scanner;

class Fahrkartenautomat {
	//Hello Welt
	public static double fahrkartenbestellungErfassen() {
    double[] ticketpreise = {3.00,3.50,3.80,2.00,8.60,9.20,10.00,9.40,12.60,13.80,25.50,26.00,26.50};   
    int[] anzahlTickets = new int[ticketpreise.length];

    double gesamtPreis = 0.0;
    int auswahl;
    Scanner tastatur = new Scanner(System.in);
    
    System.out.println(" Fahrkartenbestellvorgang:");
    System.out.println(" =========================");
    do {
      auswahl = fahrkartenMenue(ticketpreise);
      
      if (auswahl == 0)
    	  for (int i=0 ; i < ticketpreise.length ; i++)
              gesamtPreis += ticketpreise[i] * anzahlTickets[i]; 
     else
    	 erfasseTicketAnzahl(anzahlTickets, auswahl);  
        
    }while(auswahl!=0);

	return gesamtPreis;

	}

	public static void erfasseTicketAnzahl(int[] anzahlTickets, int auswahl) {
	  Scanner tastatur = new Scanner(System.in);
	  System.out.print("\n  Anzahl der Tickets: ");
      anzahlTickets[auswahl-1] += tastatur.nextInt();
  }

	public static int fahrkartenMenue(double [] ticketpreise) {
        String[] eintraege = { "Einzelfahrschein Berlin AB ", 
        					   "Einzelfahrschein Berlin BC ", 
        					   "Einzelfahrschein Berlin ABC ", 
        					   "Kurzstrecke AB ",
        					   "Tageskarte Berlin AB ",
        					   "Tageskarte Berlin BC ",
        					   "Tageskarte Berlin ABC ",
        					   "4-Fahrten-Karte AB ",
        					   "4-Fahrten-Karte BC ",
        					   "4-Fahrten-Karte ABC ",
        					   "Kleingruppen-Tageskarte Berlin AB ",
        					   "Kleingruppen-Tageskarte Berlin BC ",
        					   "Kleingruppen-Tageskarte Berlin ABC "
        					};
    int auswahl;
    boolean istEingabeKorrekt = false;
    Scanner tastatur = new Scanner(System.in);

    do {
      System.out.println("\n  Wählen Sie :");
      for (int i = 0; i < eintraege.length ; i++) {
        System.out.printf("    %s [%.2f] (%d)\n", eintraege[i], ticketpreise[i], (i+1));  
      }
      System.out.println("    Bezahlen (0)\n");
      System.out.print("  Ihre Wahl: ");
      auswahl = tastatur.nextInt();
      if (auswahl < eintraege.length && auswahl >= 0)
        istEingabeKorrekt = true;
      else
        System.out.println("  >>falsche Eingabe<<");
        

    } while (!istEingabeKorrekt);
    return auswahl;
  }

	public static double fahrkartenBezahlen(double zuZahlenderBetrag) {
		double eingeworfeneMünze;
		double eingezahlterGesamtbetrag = 0.0;
		Scanner tastatur = new Scanner(System.in);

		while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
			System.out.format("  Noch zu zahlen: %4.2f € %n", (zuZahlenderBetrag - eingezahlterGesamtbetrag));
			System.out.print("  Eingabe (mind. 5Ct, höchstens 10 Euro): ");
			eingeworfeneMünze = tastatur.nextDouble();
			eingezahlterGesamtbetrag += eingeworfeneMünze;
		}
		return eingezahlterGesamtbetrag - zuZahlenderBetrag;
	}

	public static void fahrkartenAusgeben() {
		System.out.println("\n  Fahrschein wird ausgegeben");
		System.out.print("  ");
		for (int i = 0; i < 8; i++) {
			System.out.print("=");
			warte(255);
		}
		System.out.println("\n");
	}

	public static void warte(int milisekunde) {
		try {
			Thread.sleep(milisekunde);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void rückgeldAusgeben(double rückgabebetrag) {

		if (rückgabebetrag > 0.0) {
			System.out.format("  Der Rückgabebetrag in Höhe von %4.2f € %n", rückgabebetrag);
			System.out.println("  wird in folgenden Münzen ausgezahlt:");

			while (rückgabebetrag >= 2.0) {// 2 EURO-Münzen
				münzeAusgeben(2, "EURO");
				rückgabebetrag -= 2.0;
			}
			while (rückgabebetrag >= 1.0) {// 1 EURO-Münzen
				münzeAusgeben(1, "EURO");
				rückgabebetrag -= 1.0;
			}
			while (rückgabebetrag >= 0.5) // 50 CENT-Münzen
			{
				münzeAusgeben(50, "CENT");
				rückgabebetrag -= 0.5;
			}
			while (rückgabebetrag >= 0.2) // 20 CENT-Münzen
			{
				münzeAusgeben(20, "CENT");
				rückgabebetrag -= 0.2;
			}
			while (rückgabebetrag >= 0.1) // 10 CENT-Müzen
			{
				münzeAusgeben(10, "CENT");
				rückgabebetrag -= 0.1;
			}
			while (rückgabebetrag >= 0.05)// 5 CENT-Münzen
			{
				münzeAusgeben(5, "CENT");
				rückgabebetrag -= 0.05;
			}
		}
	}

	public static void münzeAusgeben(int betrag, String einheit) {

		System.out.println("                 * * *        ");
		System.out.println("               *       *      ");
		System.out.format("              *    %-2s   *     %n", betrag);
		System.out.format("              *   %4s  *     %n", einheit);
		System.out.println("               *       *      ");
		System.out.println("                 * * *        ");

	}

	public static void main(String[] args) {

		double zuZahlenderBetrag;
		double rückgabebetrag;
		do {

			zuZahlenderBetrag = fahrkartenbestellungErfassen();
			rückgabebetrag = fahrkartenBezahlen(zuZahlenderBetrag);
			fahrkartenAusgeben();
			rückgeldAusgeben(rückgabebetrag);

			System.out.println("\n  Vergessen Sie nicht, den Fahrschein\n" + "  vor Fahrtantritt entwerten zu lassen!\n"
					+ "  Wir wünschen Ihnen eine gute Fahrt.\n\n");
		} while (true);

	}
}
