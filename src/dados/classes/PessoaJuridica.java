package dados.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PessoaJuridica extends Pessoa{

	public PessoaJuridica() {
		// TODO Auto-generated constructor stub
	}
	@Column(unique=true)
	private String cnpj;
	private String nomeFantasia;
	private String razaoSocial;

    private transient String senha;

	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nome_fantasia) {
		this.nomeFantasia = nome_fantasia;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razao_social) {
		this.razaoSocial = razao_social;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
