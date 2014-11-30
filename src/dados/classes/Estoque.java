package dados.classes;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Estoque {

	public Estoque() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue
	private Integer codigo;
	private int quantidade;
	private int prazo;
    //private ArrayList<Produto> produto = new ArrayList<Produto>();
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getPrazo() {
		return prazo;
	}
	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}
	
}
