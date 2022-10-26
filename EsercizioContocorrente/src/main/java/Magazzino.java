import java.util.ArrayList;
import java.util.Scanner;

public class Magazzino {
	
	
	private Scanner in = new Scanner(System.in);

	private ArrayList<Correntista> correntista = new ArrayList<Correntista>();
	
	
	public void reset() {
		
		correntista.clear();//
		
	}

//effettuo il caricamento delle persone tramite il nome,cognome, codice fiscale , numero del conto e saldo: in modo da poter modificare o ricercare tutto successivamente  
	public void caricamento() {
		
		String nome; 
		String cognome;
		String codiceFiscale;
		String numeroconto;
		int numeroPersone; 
		boolean verifica; 
		double saldo=0;
		System.out.println("Inserire i conti da inserire");
		 numeroPersone=Integer.parseInt(in.nextLine());
		 
		 reset();// tramite il rreset rimuoviamo tutti i set
		 
		 //count per l'inserimento del correntista
		for(int i=0;i< numeroPersone;i++)
				{
					verifica=true;
					//inserimento del nome
					System.out.println("Inserire il nome del propietario del "+(i+1)+ " oppure il corrispondente conto");
					nome=in.nextLine();
					//inserimento del cognome 
					System.out.println("Inserire il cognome del propietario del "+(i+1)+" oppure il corrispondente conto");
					cognome=in.nextLine();
					//inserimento del codice fiscale
					System.out.println("Inserire il codice fiscale del propietario del "+(i+1)+" oppure  il corrispondente conto");
					codiceFiscale=in.nextLine();
					//inserimento del numero del conto
					System.out.println("inserire il numero del conto della "+(i+1)+" oppure il corrispondente conto");
					numeroconto=in.nextLine();
					
					for(int j=0; j<correntista.size(); j++) // controllo se uno dei conti è gia presente !!
					{ 
							for(int s=0; s<correntista.get(j).conto.size();s++)
							{
								if(this.correntista.get(j).conto.get(s).getNumeroConto().equals(numeroconto)) {
									System.out.println("!!ATTENZIONE:Numero dei conti già presenti!!");
									
									i--; // IL CONTATORE TORNA INDIETRO
									
									verifica=false;
								}
							}
					}
		
					if(verifica)
					{
						//inserimento del saldo
					System.out.println("Inserire il saldo");
					saldo=Double.parseDouble(in.nextLine());//prendo il saldo in input
					
						for(int j=0;j<correntista.size();j++) //effetuo un controllo se è gia esistente
						{  
							if(correntista.get(j).getCf().equals(codiceFiscale)) 
							{
								System.out.println("Conto aggiunto a persona esistente");
								this.correntista.get(j).conto.add(new ContoCorrente(numeroconto, saldo));
								verifica=false;
							}
						}
					}
		
					if(verifica)
					{
					this.correntista.add(new Correntista(nome, cognome,codiceFiscale,numeroconto,saldo));// inserimento dell'utente
					System.out.println("Utente inserito");
					}
				}

		   }


	//inserimento del metodo modifica che implementa la modifica tramite il nome ,cognome e  codice fiscale.


		public void modifica() {

			String nomeModifica;	//inserimento dei parametri per la modifica 
			String cognomeModifica;
			String codicef;
			System.out.println("inserire il nome");
			nomeModifica=in.nextLine();
			System.out.println("inserire il cognome");
			cognomeModifica=in.nextLine();

			for(int i=0;i<correntista.size();i++) 
			{
				if(correntista.get(i).getNome().equals(nomeModifica) && correntista.get(i).getCognome().equals(cognomeModifica))
				{
					
					System.out.println(correntista.get(i));	
				}
			}
			//inserimento del codice fiscale per effettuare la modifica 
			System.out.println("Inserisci il codice fiscale dell'utente da modificare");
			codicef=in.nextLine();
			for(int i=0;i<correntista.size();i++) 
			{
				if(correntista.get(i).getNome().equals(nomeModifica) && correntista.get(i).getCognome().equals(cognomeModifica) && correntista.get(i).getCf().equals(codicef))// EQUALS compara due stringhe 
				{
					
					//inserimento dei dati da parte dell'utente
					System.out.println("inserire il nuovo nome");
					correntista.get(i).setNome(in.nextLine());
					System.out.println("inserire il nuovo cognome");
					correntista.get(i).setCognome(in.nextLine());
					System.out.println("MODIFCA ANDATA A BUON FINE !!!");
				}
			}
		}



//imposto una semplice stampa del correntista con tutti i valori corrispondenti 
	public void print() {

			System.out.println(correntista);

	}
	
	
	
	//effettuo l'ordinamento con dei valori 
		public void ordinamento()
		{
			Correntista value= new Correntista("","","","",0.00); 

			String provaverifica;
			
			int verifica;
			for(int i=0;i<correntista.size();i++) 
			{
				for(int j=0;j<correntista.size();j++)
				{
					verifica = correntista.get(i).getCognome().compareToIgnoreCase(correntista.get(j).getCognome());
					
					if(verifica<0)
					{

						value.setCorrentista(correntista.get(i)); 
						
						correntista.get(i).setCorrentista(correntista.get(j));
						
						correntista.get(j).setCorrentista(value);
					}
				}
			}

			print();
		}

		
		//assegno il metodo prelievo per gestirmi tutto all'interno

		public void prelievo() {
			int scelta=0;
			int preleva;
			String app; // INSERIMENTO DEL VALORE APPOGGIO PER EFFETTUARE IL CONTROLLO  
			System.out.println("seleziona il tasto 1 per il prelievo per codice fiscale");
			
			System.out.println("seleziona il tasto 2 per il prelievo per numero conto");
			boolean verifica=false; 

			scelta=Integer.parseInt(in.nextLine());// prendo in input la scelta 
			switch(scelta) {
			//inserimento  dello switch per inserire la scelta tramite codice fiscale o numero del conto
			case 1:
				System.out.println("inserire il Codice Fiscale");
				app=in.nextLine();

				for(int i=0;i<correntista.size();i++) 
				{
					if(correntista.get(i).getCf().equals(app)) 
					{
						if(correntista.get(i).conto.size()>1)  // controllo se sono presenti più conti
						{ 
							System.out.println("sono presenti più conti, effettuare la ricerca tramite il numero, grazie");
						}else{ 
							//se entra nell'else ci darà il valore netto del saldo del determinato correntista
						System.out.println("e' presente un saldo di :"+correntista.get(i).conto.get(i).getSaldo());
						
						System.out.println("inserisci la somma da prelevare");//inserimento della somma da prelevare 
						
						preleva=Integer.parseInt(in.nextLine());// prendo i dati
							if(preleva>correntista.get(i).conto.get(i).getSaldo())
							{ //controllo se è maggiore lo annulla 
							System.out.println("IMPOSSIBILE PROSEGUIRE!!");//caso peggiore 
							}else{
							correntista.get(i).conto.get(i).setSaldo((correntista.get(i).conto.get(i).getSaldo()-preleva));
							System.out.println("PRELIEVO EFFETTUATO CON SUCCESSO"); // inserimento riuscito con rispettivo controllo 
							verifica=true;
							}
						}
					}
				}
				break;
			case 2:
				System.out.println("inserire il numero del conto "); // inserimento tramite conto 
				
				app=in.nextLine(); 
				// impostyo un ciclo che mi effetttua un controllo per quanto riguarda il saldo
				for(int i=0;i<correntista.size();i++) 
				{
					for(int j=0;j<correntista.get(i).conto.size();j++)
					{
						if(correntista.get(i).conto.get(j).getNumeroConto().equals(app))
						{
							System.out.println("Il saldo disponibile è di "+correntista.get(i).conto.get(j).getSaldo()); // controllo per visualizzare il saldo gia presente 
							
							System.out.println("inserire la somma da prelevare");
							
							preleva=Integer.parseInt(in.nextLine()); // inserimento della somma da prelevare 
							
								if(preleva>correntista.get(i).conto.get(j).getSaldo()) 
								{
								System.out.println("IMPOSSIBILE PROSEGUIRE!!"); // se il conto da prelevare è maggiore 
								}else{
									
							correntista.get(i).conto.get(j).setSaldo((correntista.get(i).conto.get(j).getSaldo()-preleva));
							
							System.out.println("PRELIEVO EFFETTUATO CON SUCCESSO");
							
							verifica=true;
							}
						}
				}
				}
					if(!verifica) 
					{
						System.out.println("ricerca fallita!!"); // caso della ricerca fallita 
					}


				break;
			default:
				System.out.println("OPERAZIONE ANNULLATA!");// imposto il caso di defaut per tornare il valore di operazione annullata 
				break;
			}	

		}
		

		public void versamento()
		{ 

			boolean prova1;
			int mette; 
			int scelta=0;
			String prova;
			System.out.println("Versamento:");print();
			
			System.out.println("seleziona 1 per versamento per codice fiscale");// breve sottomenù di accesso per il versamento			
			System.out.println("seleziona 2 per versamento per numero del conto");

			prova1=false;
			scelta=Integer.parseInt(in.nextLine());
			switch(scelta)
			{
				case 1:		//caso di scelta con inserimento del codice fiscale o del numero conto
					System.out.println("inserire il Codice Fiscale");
					prova=in.nextLine();
	
					for(int i=0;i<correntista.size();i++)
					{
						if(correntista.get(i).getCf().equals(prova)) {
							if(correntista.get(i).conto.size()>1)
							{
								System.out.println("sono presenti più conti, effettuare la ricerca tramite numero del conto");
							}else{
								
							System.out.println("Il saldo disponibile è di "+correntista.get(i).conto.get(i).getSaldo()); //mostro a video il saldo tramite i get 
							System.out.println("inserire la somma da versare"); // inserisco la somma da versare e la gestisco successivamente con una semplice somma 
							
							mette=Integer.parseInt(in.nextLine());// prendo il valore sempre di tipo intero
							
							//effettuo la somma 
							correntista.get(i).conto.get(i).setSaldo((correntista.get(i).conto.get(i).getSaldo()+mette));
							//conferma della somma versata 
							System.out.println("VERSAMENTO ANDATO A BUON TERMINE");
							prova1=true;
							}
	
						}
					}
					break;
			case 2:     // caso due pongo la scelta del versamento tramite numero del conto
				System.out.println("inserire il numero del conto");
				prova=in.nextLine();
				for(int i=0;i<correntista.size();i++)
				{
					for(int j=0;j<correntista.get(i).conto.size();j++)
					{
						if(correntista.get(i).conto.get(j).getNumeroConto().equals(prova))
						{
							//stessa cosa, come il codice fiscale effettuo una semplice somma 
							System.out.println("Il saldo disponibile è di "+correntista.get(i).conto.get(j).getSaldo());
							System.out.println("inserire la somma da versare");
							mette=Integer.parseInt(in.nextLine());// prendo i dati in input 
	
							correntista.get(i).conto.get(j).setSaldo((correntista.get(i).conto.get(j).getSaldo()+mette));
							System.out.println("VERSAMENTO ANDATO A BUON TERMINE");	// controllo del versamento , con conferma
							prova1=true;
							}

					}
				}
					if(!prova1)// se la prova , intesa come un controllo non va a rispettare la condizione mi darà: 
					{
						System.out.println("!!RICERCA NON EFFETTUATA!!");
					}
		
		
					break;
				
			}	

		
				if(!prova1)	//se la prova , intesa come un controllo non va a rispettare la condizione mi darà: 
				{
					System.out.println("!!VERSAMENTO NON EFFETTUATO!!");
				}
	     }
		
}