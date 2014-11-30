package dados.classes;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cotacao {

	public Cotacao() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue
	private Integer codigo;
	private double preco;
	private float peso;
	private String nome;
	private Date entrada;
	private Date saida;
	private int quantiddae;
	@ManyToOne
	private Estoque estoque = new Estoque();
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getEntrada() {
		return entrada;
	}
	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}
	public Date getSaida() {
		return saida;
	}
	public void setSaida(Date saida) {
		this.saida = saida;
	}
	public int getQuantiddae() {
		return quantiddae;
	}
	public void setQuantiddae(int quantiddae) {
		this.quantiddae = quantiddae;
	}
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	
}
