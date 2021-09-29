package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.Excecao.DominioExcecao;

public class Conta {
	
	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteDeRetirada;
	private Date dataCadastro;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public Conta(Integer numero, String titular, Double saldo, Double limiteDeRetirada, Date dataCadastro) {
		super();
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteDeRetirada = limiteDeRetirada;
		this.dataCadastro = dataCadastro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}


	public Double getLimiteDeRetirada() {
		return limiteDeRetirada;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public void deposito(double quantia) {
		
		saldo += quantia;
		
	}
	public void saque(double quantia) {
		
		if(quantia > saldo){
			throw new DominioExcecao("Valor insuficiente para saque!");
		}
		if(quantia > limiteDeRetirada) {
			throw new DominioExcecao("Valor excede limite de saque!");
		}
		
		saldo -= quantia;
	}
	
	@Override
	public String toString() {
		
		return "\nNumero Conta: "
			   + getNumero()	
			   +"\nTitular: "
			   + getTitular()
			   +"\nSaldo: "
			   + getSaldo()
			   + "\nData do cadastro: "
			   + sdf.format(getDataCadastro());
	}
}