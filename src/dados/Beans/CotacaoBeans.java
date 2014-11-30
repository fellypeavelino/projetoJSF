package dados.Beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import dados.basic.ICotacaoBase;
import dados.basic.IEstoqueBase;
import dados.basic.IProdutoBase;
import dados.classes.Cotacao;
import dados.classes.Estoque;
import dados.classes.Produto;
import dados.generico.DAOFactory;

@ManagedBean
public class CotacaoBeans {

	public CotacaoBeans() {
		// TODO Auto-generated constructor stub
	}
	
	@ManagedProperty(value = "#{loginBeans}")
	private LoginBeans loginBeans;
	private Produto produto = new Produto();
	private Cotacao cotacao = new Cotacao();
	private Estoque estoque = new Estoque();
	private List<Estoque> estoques;
	private List<Cotacao> cotacoes;
	private ProdutoBeans produtoBeans = new ProdutoBeans();
	private String mensagens;
	private Integer novaQtd;
	public Integer getNovaQtd() {
		return novaQtd;
	}

	public void setNovaQtd(Integer novaQtd) {
		this.novaQtd = novaQtd;
	}

	public String getMensagens() {
		return mensagens;
	}

	public void setMensagens(String mensagens) {
		this.mensagens = mensagens;
	}

	public List<Cotacao> getCotacoes() {
		try {
			ICotacaoBase cotacaoBase = DAOFactory.getCotacaoBase();
			cotacoes = cotacaoBase.retornarCotacaoExistentes();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}

		return cotacoes;
	}

	public void setCotacoes(List<Cotacao> cotacoes) {
		this.cotacoes = cotacoes;
	}

	public ProdutoBeans getProdutoBeans() {
		return produtoBeans;
	}

	public void setProdutoBeans(ProdutoBeans produtoBeans) {
		this.produtoBeans = produtoBeans;
	}

	public List<Estoque> getEstoques() {
		try {
			IEstoqueBase estoqueBase = DAOFactory.getEstoque();
			estoques = estoqueBase.listaEstoque();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		return estoques;
	}

	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public Cotacao getCotacao() {
		return cotacao;
	}

	public void setCotacao(Cotacao cotacao) {
		this.cotacao = cotacao;
	}

	public LoginBeans getLoginBeans() {
		return loginBeans;
	}

	public void setLoginBeans(LoginBeans loginBeans) {
		this.loginBeans = loginBeans;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public String validarQuantidade(){
		if(this.cotacao.getQuantiddae() < this.novaQtd){
			System.out.print("erro do ajax");
			return this.mensagens = "digite uma quantidade menor que "+this.cotacao.getQuantiddae();
		}
		return "";
	}
	
	public String prepararCompra(Cotacao cotacao){
		try {
			this.cotacao = cotacao;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "criar.xhtml";
	}
}
