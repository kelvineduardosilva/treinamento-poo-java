package entities;

public class ContaBancaria {
	private int numeroConta;
	private String nomeConta;
	private double saldoConta;
	
	public ContaBancaria(int numeroConta, String nomeConta, double saldoConta) {
		this.numeroConta = numeroConta;
		this.nomeConta = nomeConta;
		this.saldoConta = saldoConta;
	}
	
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
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
	public void setSaldoConta(double saldoConta) {
		this.saldoConta = saldoConta;
	}
	
	

}
