package dados.Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
















import negocio.EstoqueNegocio;
import negocio.ProdutoNegocio;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import dados.basic.IAnimalBase;
import dados.basic.ICotacaoBase;
import dados.basic.IEstoqueBase;
import dados.basic.IEstoqueNegocio;
import dados.basic.IProdutoBase;
import dados.basic.IProdutoNegocio;
import dados.basic.ITipoBase;
import dados.classes.Animal;
import dados.classes.Cotacao;
import dados.classes.Estoque;
import dados.classes.Produto;
import dados.classes.Tipo;
import dados.generico.DAOFactory;

@ManagedBean
public class ProdutoBeans {

	public ProdutoBeans() {
		// TODO Auto-generated constructor stub
	}
	private Produto queimaEstoque = new Produto();
	private Produto produto = new Produto();
	private List<Produto> produtos;
	private List<Produto> produtosNavalidade;
	private Estoque estoque = new Estoque();
	private Tipo tipo = new Tipo();
	private Animal animal = new Animal();
	private List<Animal> animais;
	private List<Estoque> estoques;
	private Cotacao cotacao = new Cotacao();
	private String mensagemPersonalizada = "";
	public List<Produto> getProdutosNavalidade() {
		try {
			IProdutoBase produtoBase = DAOFactory.getProduto();
			produtosNavalidade = produtoBase.listarProdutosNavalidade();	
		} catch (Exception e) {
			// TODO: handle exception
		}
		return produtosNavalidade;
	}

	public void setProdutosNavalidade(List<Produto> produtosNavalidade) {
		this.produtosNavalidade = produtosNavalidade;
	}

	public Cotacao getCotacao() {
		return cotacao;
	}

	public void setCotacao(Cotacao cotacao) {
		this.cotacao = cotacao;
	}

	public String getMensagemPersonalizada() {
		return mensagemPersonalizada;
	}

	public void setMensagemPersonalizada(String mensagemPersonalizada) {
		this.mensagemPersonalizada = mensagemPersonalizada;
	}

	public Produto getQueimaEstoque() {
		return queimaEstoque;
	}

	public void setQueimaEstoque(Produto queimaEstoque) {
		this.queimaEstoque = queimaEstoque;
	}
	@ManagedProperty(value = "#{loginBeans}")
	private LoginBeans loginBeans;
	public LoginBeans getLoginBeans() {
		return loginBeans;
	}

	public void setLoginBeans(LoginBeans loginBeans) {
		this.loginBeans = loginBeans;
	}

	public List<Produto> getProdutos() {
		try {
			IProdutoBase produto = DAOFactory.getProduto();
			produtos = produto.listarProdutos();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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

	public List<Animal> getAnimais() {
		try {
			IAnimalBase animalBase = DAOFactory.getAnimalBase();
			animais = animalBase.listarAnimais();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public Tipo getTipo() {
		try {
			ITipoBase tipoBase = DAOFactory.getTipo();
			tipo = tipoBase.retornaTipo();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
	
	public String cadastrarProduto(){
		try {
			IProdutoBase produtoBase = DAOFactory.getProduto();
			IEstoqueNegocio estoqueNegocio = new EstoqueNegocio();
			produto.setAnimal(animal);
			produto.setEstoque(estoque);
			if(estoqueNegocio.prazoEstoqueUltrapassado(produto.getEntrada(), produto.getSaida(), estoque)){
				if(estoqueNegocio.quantidadeEstoqueUltrapassado(produto.getQuantiddae(), estoque)){
					produtoBase.inserir(produto);
					this.mensagemPersonalizada = "Produto Cadastrado com Sucesso.";
				}else{
					this.mensagemPersonalizada = "Quantidade esta acima do que o estoque suporta!!!";
					return "/Produtos/criar.xhtml";
				}
			}else{
				this.mensagemPersonalizada = "Prazo esta acima do que o estoque suporta!!!";
				return "/Produtos/criar.xhtml";
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		return "/Produtos/listar.xhtml";
	}
	
	public String extouroDePrazo(Produto produto){
		try{
			IProdutoNegocio produtoNegocio = new ProdutoNegocio();
			this.produto = produtoNegocio.Queimadeestoque(produto);
			setQueimaEstoque(this.produto);
			System.out.print(queimaEstoque.getPreco());
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
		return "/Produtos/queimaDeEstoque.xhtml";
	}
	
	public String removerProduto(Produto produto){
		if(this.loginBeans.getPessoaFisica().getAdminitrador() == 1){
			IProdutoBase produtoBase = DAOFactory.getProduto();
			produtoBase.remover(produto);
		}
		return "/menu.xhtml?faces-redirect=true";
	}
	
	public String criarProduto(){
		if(this.loginBeans.getPessoaFisica().getAdminitrador() != 1){
			return "/menu.xhtml?faces-redirect=true";
		}
		return "/Produtos/criar.xhtml?faces-redirect=true";
	}
	
	public String listarProduto(){
		return "/Produtos/listar.xhtml?faces-redirect=true";
	}
	
	public String cadastrarCotacao(){
		try {
			IProdutoBase produtoBase = DAOFactory.getProduto();
			ICotacaoBase cotacaoBase = DAOFactory.getCotacaoBase();
			IEstoqueNegocio estoqueNegocio = new EstoqueNegocio();
			Produto produtoRemover = new Produto();
			queimaEstoque.setEstoque(estoque);
			cotacao.setNome(queimaEstoque.getNome());
			cotacao.setPreco(queimaEstoque.getPreco());
			//cotacao.setPeso(queimaEstoque.getPeso());
			cotacao.setQuantiddae(queimaEstoque.getQuantiddae());
			cotacao.setEstoque(queimaEstoque.getEstoque());
			cotacao.setSaida(queimaEstoque.getSaida());
			cotacao.setEntrada(new Date());
			if(estoqueNegocio.prazoEstoqueUltrapassado(cotacao.getEntrada(), cotacao.getSaida(),estoque)){
				if(estoqueNegocio.quantidadeEstoqueUltrapassado(cotacao.getQuantiddae(), estoque)){
					cotacaoBase.inserir(cotacao);
					produtoBase.remover(queimaEstoque);
				}else{
					this.mensagemPersonalizada = "Quantidade esta acima do que o estoque suporta!!!";
					return "";
				}
			}else{
				this.mensagemPersonalizada = "Prazo esta acima do que o estoque suporta!!!";
				return "";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/menu.xhtml?faces-redirect=true";
	}
}
