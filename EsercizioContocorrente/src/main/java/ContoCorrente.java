public class ContoCorrente {

	private String numeroConto;
	private double saldo;

	//private ArrayList<String> numero_conto = new 

	public ContoCorrente(String numeroConto, double saldo) {
		setNumero_conto(numeroConto);
		setSaldo(saldo);
	}

//effettuo l ' override del contocorrente per poi effettuare la stampa richiamandomi tutti i parametri successivamente .
	@Override
	public String toString() {
		return "ContoCorrente [numeroConto=" + numeroConto + ", saldo=" + saldo + "]";// to string del contocorrente !!
	}

	public String getNumeroConto() {
		return numeroConto;
	}
	public void setNumero_conto(String numeroConto) {		//uso i get e set per modifcare o mostrare a video le proprietà !!
		this.numeroConto = numeroConto;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}