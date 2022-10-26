import java.util.ArrayList;
import java.util.Scanner;
public class Correntista extends Persona{

	private String nome;
	private String cognome;
	private String cf;
//arraylist del conto corrente 
	
	ArrayList<ContoCorrente> conto = new ArrayList();

//stampa dei parametri 
	@Override
	public String toString() {
		return "Correntista [nome=" + nome + ", cognome=" + cognome + ", cf=" + cf + ", conto=" + conto + "]";	//tostring del correntista!! !
	}


	public Correntista(String nome, String cognome, String cf, String n_conto, double saldo) {
		
		
		this.cognome=cognome;
		this.nome=nome;
		this.cf=cf;
		this.conto.add(new ContoCorrente(n_conto, saldo));// tramite il this mi vado a riferire agni stessi parametri impostati(nella classe stessa)
		
	}


//ordinamento
	public void setCorrentista(Correntista corr) {
		this.nome = corr.getNome();
		this.cognome = corr.getCognome();
		this.cf= corr.getCf();

		conto.clear();
		if(corr.conto.size()>1) {
			for(int i=0;i<corr.conto.size();i++) {
				this.conto.add(new ContoCorrente(corr.conto.get(i).getNumeroConto(),corr.conto.get(i).getSaldo()));
			}
		}
	}
//imposto get e set 
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getCf() {
		return cf;
	}


	public void setCf(String cf) {
		this.cf = cf;
	}



}