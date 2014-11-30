package dados.Beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import dados.basic.IEstoqueBase;
import dados.classes.Estoque;
import dados.generico.DAOFactory;

@ManagedBean
public class EstoqueBeans {

	public EstoqueBeans() {
		// TODO Auto-generated constructor stub
	}
	
	private Estoque estoque = new Estoque();
	private List<Estoque> estoques;
	@ManagedProperty(value = "#{loginBeans}")
	private LoginBeans loginBeans;
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

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
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
	
	public String criarEstoque(){
		if(this.loginBeans.getPessoaFisica().getAdminitrador() != 1){
			return "/menu.xhtml?faces-redirect=true";
		}
		return "/Estoque/criar.xhtml?faces-redirect=true";
	}
	
	public String listarEstoque(){
		return "/Estoque/lista.xhtml?faces-redirect=true";
	}
	
	public String cadastrarEstoque(){
		try {
			IEstoqueBase estoqueBase = DAOFactory.getEstoque();
			estoqueBase.inserir(estoque);
			this.mensagens = "Estoque Cadastrado";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		return "/Estoque/lista.xhtml";
	}
	
	public String removerEstoque(Estoque removerEstoque){
		try {
			if(this.loginBeans.getPessoaFisica().getAdminitrador() != 1){
				return "/menu.xhtml?faces-redirect=true";
			}
			IEstoqueBase estoqueBase = DAOFactory.getEstoque();
			estoqueBase.remover(removerEstoque);
			this.mensagens = "Estoque removido";
		} catch (Exception e) {
			// TODO: handle exception
			this.mensagens = "Estoque ativo";
		}
		return "/Estoque/lista.xhtml";
	}
	
	public String cadastrarAtualizacaoEstoque(){
		IEstoqueBase estoqueBase = DAOFactory.getEstoque();
		estoqueBase.alterar(estoque);
		this.mensagens = "Estoque Atualizado";
		return "/Estoque/lista.xhtml";
	}
	
	public String atualizarEstoque(Estoque atualizarEstoque){
		if(this.loginBeans.getPessoaFisica().getAdminitrador() != 1){
			return "/menu.xhtml?faces-redirect=true";
		}
		this.estoque = atualizarEstoque;
		return "/Estoque/atualizar.xhtml";
	}
}
