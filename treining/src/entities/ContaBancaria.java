package entities;


public class ContaBancaria {
	private int numeroConta;
	private String nomeConta;
	private double saldoConta;
	
	public ContaBancaria(int numeroConta, String nomeConta, double depositoInicial) {
		this.numeroConta = numeroConta;
		this.nomeConta = nomeConta;
		deposito(depositoInicial);
	}
	public ContaBancaria(int numeroConta, String nomeConta) {
		this.numeroConta = numeroConta;
		this.nomeConta = nomeConta;
		
	}
	
	public int getNumeroConta() {
		return numeroConta;
	}
	public String getNomeConta() {
		return nomeConta;
	}
	public void setNomeConta(String nomeConta) {
		this.nomeConta = nomeConta;
	}
	public double getSaldoConta() {
		return saldoConta;
	}
	
	public void deposito(double quantia) {
		saldoConta += quantia;
	}
	public void saque(double quantia) {
		saldoConta -= quantia + 5;
	}
	public String toString() {
		return  "Número da conta: " + numeroConta +
		", Nome: " + nomeConta +
		", Saldo: " + String.format("%.2f", saldoConta);
		
		
	}

}
