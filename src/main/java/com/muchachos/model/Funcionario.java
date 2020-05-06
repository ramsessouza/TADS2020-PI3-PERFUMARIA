package com.muchachos.model;

/**
 *
 * @author Valter Lafuente Junior
 */

public class Funcionario extends Pessoa {

	private String senha;
	private String cargo;
	private String filial;
	private String departamento;
	
	public Funcionario() {
		super();
	}
	public Funcionario(String nome, String senha) {
		super(nome);
		this.senha = senha;
	}
	public Funcionario(Integer id, String nome, String cpf, String rg, String sexo, String estadoCivil,
			String dataNascimento, String estado, String cidade, String bairro, String logradouro, int numero,
			String complemento, String telefone, String email, String status, String senha, String cargo,
			String filial, String departamento) {
		super(id, nome, cpf, rg, sexo, estadoCivil, dataNascimento, estado, cidade, bairro, logradouro, numero,
				complemento, telefone, email, status);
		this.senha = senha;
		this.cargo = cargo;
		this.filial = filial; 
		this.departamento = departamento;
	} 

	public Funcionario(Integer id, String nome, String cpf, String status, String cargo, String filial,
			String departamento) {
		super(id, nome, cpf, status);
		this.cargo = cargo;
		this.filial = filial;
		this.departamento = departamento;
	}

	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getFilial() {
		return filial;
	}


	public void setFilial(String filial) {
		this.filial = filial;
	}


	public String getDepartamento() {
		return departamento;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
        
}