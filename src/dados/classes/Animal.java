package dados.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Animal {

	public Animal() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue
	private Integer codigo;
	@ManyToOne
    private Tipo tipo = new Tipo();
	private float peso;
	private int quantdade;
	private String nome;
	private double preco;
	@ManyToOne
	private PessoaJuridica pessoaJuridica = new PessoaJuridica();
	private String recebimento;
	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}
	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public int getQuantdade() {
		return quantdade;
	}
	public void setQuantdade(int quantdade) {
		this.quantdade = quantdade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getRecebimento() {
		return recebimento;
	}
	public void setRecebimento(String recebimento) {
		this.recebimento = recebimento;
	}

}
