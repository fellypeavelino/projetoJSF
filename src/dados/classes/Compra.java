package dados.classes;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Compra {

	public Compra() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue
	private Integer codigo;
	@ManyToOne
	private PessoaFisica cliente = new PessoaFisica();
	@ManyToOne
	private Cotacao cotacao = new Cotacao();
	private double valor;
	private Date data;
	public PessoaFisica getCliente() {
		return cliente;
	}
	public void setCliente(PessoaFisica cliente) {
		this.cliente = cliente;
	}
	public Cotacao getCotacao() {
		return cotacao;
	}
	public void setCotacao(Cotacao cotacao) {
		this.cotacao = cotacao;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
