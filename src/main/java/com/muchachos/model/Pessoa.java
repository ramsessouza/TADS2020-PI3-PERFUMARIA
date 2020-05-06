package com.muchachos.model;

/**
 *
 * @author Valter Lafuente Junior
 */
public class Pessoa {
    
        private Integer id;
	private String nome;
	private String cpf;
	private String rg;
	private String sexo;
	private String estadoCivil;
	private String dataNascimento;
	private String estado;
	private String cidade;
        private String cep;
	private String bairro;
	private String logradouro;
	private int numero;
	private String complemento;
	private String telefone;
	private String email;
	private String status;
	
	
	public Pessoa() {

	}
	
	public Pessoa(String nome) {
		this.nome = nome;
	}

	public Pessoa(Integer id, String nome, String cpf, String rg, String sexo, String estadoCivil,
			String dataNascimento, String estado, String cidade, String bairro, String logradouro, int numero,
			String complemento, String telefone, String email, String status) {
		
		this.id = id;
		this.nome = nome;
		this.cpf = cpf; 
		this.rg = rg;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.dataNascimento = dataNascimento;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.telefone = telefone;
		this.email = email;
		this.status = status;
	}

    


	public Pessoa(Integer id, String nome, String cpf, String rg, String sexo, String estadoCivil,
			String dataNascimento, String estado, String cidade, String bairro, String logradouro, int numero,
			String complemento, String telefone, String email) {
	
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.dataNascimento = dataNascimento;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.telefone = telefone;
		this.email = email;
	}

	public Pessoa(Integer id, String nome, String cpf, String status) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.status = status;
	}
	
	

	public Pessoa(Integer id, String nome, String cpf, String telefone, String email) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

        public String getCep() {
        return cep;
       }

        public void setCep(String cep) {
        this.cep = cep;
        }

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
        }

}
