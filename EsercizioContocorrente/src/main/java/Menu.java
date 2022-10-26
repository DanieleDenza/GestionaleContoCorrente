import java.util.Scanner;

public class Menu {

	private int scelta=0; // mi serve per gestire la scelta dell'utente
	private boolean scan; //controllo quandop effettuo il caricamento 
	Scanner in = new Scanner(System.in);


public void stampaMenu(Magazzino magazzino) {

	scan=false;
	//imposto il menu principale dove andrò ad effettuare la scelta 
	while(scelta!=7) {
	System.out.println("				BENVENUTO NEL MENU GESTIONE CONTO CORRENTE");
	System.out.println("					");
	System.out.println("			-->	seleziona il tasto 1 per effettuare il Caricamento");

	System.out.println("			-->	seleziona il tasto 2 per effettuare la Modifica tramite gli utenti");
	
	System.out.println("			-->	seleziona il tasto 3  per ordinare i correntisti tramite il cognome , stampa");
	
	System.out.println("			-->     seleziona il tasto 4 per il Prelievo tramite numero conto e  Cod.Fiscale");
	
	System.out.println("			-->	seleziona il tasto 5 per effettuare un Versamento");
	
	System.out.println("		        -->     seleziona il tasto 6 per effettuare la Stampa dettagliata degli utenti");
	
	System.out.println("			-->	seleziona il tasto 7 per USCIRE");

	scelta = Integer.parseInt(in.nextLine()); // prendo la scelta tramite lo scan 
	switch(scelta) {
	
	//imposto uno switch case per entrare grazie ai metodi nella sezione dove voglio operare
	
	case 1:
		magazzino.caricamento();
		
		scan=true;
		// ESEMPIO : imposto su 1 o vero perche il caricamento è andato a buon termine
		
		break;
		
		
	case 2:
		if(scan) {
		magazzino.modifica();
		}else {
			System.out.println("errore!!");
		}
		break;
	case 3:
		if(scan) {
		magazzino.ordinamento();
		}else {
			System.out.println("!!ATTENZIONE CARICA PRIMA I VALORI!!");
		}
		break;
	case 4:
		if(scan) {
			magazzino.prelievo();
		}else {
			System.out.println("!!ATTENZIONE CARICA PRIMA I VALORI!!");
		}
		break;
	case 5:
		if(scan) {
		magazzino.versamento();
		}else {
			System.out.println("!!ATTENZIONE CARICA PRIMA I VALORI!!");
		}
		break;
	case 6:
		if(scan) {
		magazzino.print();
		}else {
			System.out.println("!!ATTENZIONE CARICA PRIMA I VALORI!!");
		}
		break;
	case 7:
		System.out.println("Arrividereci , alla prossima :)");
		break;
		
	}
	}
	}

}