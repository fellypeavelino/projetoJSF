package dados.classes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PessoaFisica extends Pessoa{

	public PessoaFisica() {
		// TODO Auto-generated constructor stub
	}
	@Column(unique=true)
	private String cpf;
	private String sexo;
	private Date nascimento;
	private int adminitrador;
	
	public int getAdminitrador() {
		return adminitrador;
	}
	public void setAdminitrador(int adminitrador) {
		this.adminitrador = adminitrador;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
}
