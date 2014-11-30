package dados.Beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.ManyToOne;

import dados.basic.ICompraBase;
import dados.basic.ICotacaoBase;
import dados.classes.Compra;
import dados.classes.Cotacao;
import dados.classes.PessoaFisica;
import dados.classes.Produto;
import dados.generico.DAOFactory;

@ManagedBean
@SessionScoped
public class CompraBeans {

	public CompraBeans() {
		// TODO Auto-generated constructor stub
	}
	@ManagedProperty(value = "#{loginBeans}")
	private LoginBeans loginBeans;
	private Compra compra = new Compra();
	private List<Compra> compras = new ArrayList<Compra>();
	private PessoaFisica cliente;
	private Produto produto = new Produto();
	private Cotacao cotacao = new Cotacao();
	private String mensagens;
	
	public String getMensagens() {
		return mensagens;
	}
	public void setMensagens(String mensagens) {
		this.mensagens = mensagens;
	}
	public LoginBeans getLoginBeans() {
		return loginBeans;
	}
	public void setLoginBeans(LoginBeans loginBeans) {
		this.loginBeans = loginBeans;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public List<Compra> getCompras() {
		return compras;
	}
	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	public PessoaFisica getCliente() {
		cliente = loginBeans.getPessoaFisica();
		return cliente;
	}
	public void setCliente(PessoaFisica cliente) {
		this.cliente = cliente;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Cotacao getCotacao() {
		return cotacao;
	}
	public void setCotacao(Cotacao cotacao) {
		this.cotacao = cotacao;
	}
	
	public String realizarCompraDeCotacao(Integer id, Integer qtd){
		ICotacaoBase cotacaoBase = DAOFactory.getCotacaoBase();
		ICompraBase compraBase = DAOFactory.getCompraBase();
		Cotacao cotacao = cotacaoBase.consultarPorId(id);
		cotacao.setQuantiddae(cotacao.getQuantiddae() - qtd);
		cotacaoBase.alterar(cotacao);
		compra.setCliente(loginBeans.getPessoaFisica());
		compra.setCotacao(cotacao);
		compra.setValor(cotacao.getPreco() * qtd);
		compra.setData(new Date());
		compraBase.inserir(compra);
		mensagens = "compra realizada";
		return "/Cotacaoes/lista.xhtml";
	}
	
	public String carrinhoDeCotacao(Integer id, Integer qtd){
		Compra compra = new Compra();
		ICompraBase compraBase = DAOFactory.getCompraBase();
		ICotacaoBase cotacaoBase = DAOFactory.getCotacaoBase();
		Cotacao cotacao = cotacaoBase.consultarPorId(id);
		cotacao.setQuantiddae(cotacao.getQuantiddae() - qtd);
		cotacaoBase.alterar(cotacao);
		compra.setCliente(loginBeans.getPessoaFisica());
		compra.setCotacao(cotacao);
		compra.setValor(cotacao.getPreco() * qtd);
		compra.setData(new Date());
		compras.add(compra);
		System.out.print(compras.size());
		mensagens = ""; 
		return "/Cotacaoes/lista.xhtml";
	}
	
	public String cadastrarCarrinhoDeCotacao(){
		ICompraBase compraBase = DAOFactory.getCompraBase();
		for (Compra Novacompra : compras) {
			compraBase.inserir(Novacompra);
		}
		//List<Compra> compras = new ArrayList<Compra>();
		//this.setCompra(compra);
		this.compras.clear();
		mensagens = "compras realizadas";
		return "";
	}
	
	public String getRevelarBotaoDeCompra(){
		if(compras.size() > 0){
			return "";
		}
		return "display:none;";
	}
	///http://javasemcafe.blogspot.com.br/2011/05/jsf-20-componentes-primefaces-221-parte.html
}
