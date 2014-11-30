package dados.classes;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import negocio.Util;

@Entity
public class Produto {

	public Produto() {
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
	private Animal animal = new Animal();
	@ManyToOne
	private Estoque estoque = new Estoque();

	public String getEstilo() {
		Calendar data1 = Calendar.getInstance();
		Calendar data2 = Calendar.getInstance();
		if (saida != null) {
			data1.setTimeInMillis(saida.getTime());
			data2.setTimeInMillis(new Date().getTime());
			if (Util.compararDatas(saida, new Date())) {
				return "color:goldenrod;";
			}
			if (saida != null && saida.before(new Date())) {
				return "color:red;";
			}
		}
		return "color:black;";

	}

	public String getRemocao() {

		if (saida != null && saida.before(new Date())) {
			return "border-radius:4px;";
		} else {
			return "visibility: hidden;";
		}
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public int getQuantiddae() {
		return quantiddae;
	}

	public void setQuantiddae(int quantiddae) {
		this.quantiddae = quantiddae;
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

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
}
