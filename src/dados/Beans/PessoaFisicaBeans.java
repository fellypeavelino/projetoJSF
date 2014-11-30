package dados.Beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import dados.basic.IEnderecoBase;
import dados.basic.IPessoaFisicaBase;
import dados.classes.Endereco;
import dados.classes.PessoaFisica;
import dados.generico.DAOFactory;

@ManagedBean
public class PessoaFisicaBeans {

	public PessoaFisicaBeans() {
		// TODO Auto-generated constructor stub
	}
	
	@ManagedProperty(value = "#{loginBeans}")
	private LoginBeans loginBeans;
	private String mensagens;
	private PessoaFisica pessoaFisca = new PessoaFisica();
	private Endereco endereco = new Endereco();
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

	private List<PessoaFisica> listaPessoasFisca;
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public PessoaFisica getPessoaFisca() {
		return pessoaFisca;
	}

	public void setPessoaFisca(PessoaFisica pessoaFisca) {
		this.pessoaFisca = pessoaFisca;
	}
	
	public List<PessoaFisica> getListaPessoasFisca()  {
		try {
			IPessoaFisicaBase pessoaFisicaBase = DAOFactory.getPessoaFisicaBase();
			this.listaPessoasFisca = pessoaFisicaBase.listarPessoasFisica();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listaPessoasFisca;
	}

	public void setListaPessoasFisca(List<PessoaFisica> listaPessoasFisca) {
		this.listaPessoasFisca = listaPessoasFisca;
	}

	public String cadastrarPessoaFisica(){
		try {
			IPessoaFisicaBase pessoaFisicaBase = DAOFactory.getPessoaFisicaBase();
			IEnderecoBase enderecoBase = DAOFactory.getEnderecoBase();
			if(pessoaFisca.getCpf().isEmpty() || endereco.getCep().isEmpty()){
				this.mensagens = "CPF e CEP são o brigatorios!!!";
				return "/Cliente/criar.xhtml";
			}
			enderecoBase.inserir(endereco);
			//Endereco enderecoSql = enderecoBase.retornarEndereco(endereco);
			pessoaFisca.setEndereco(endereco);
			pessoaFisicaBase.inserir(pessoaFisca);
			this.mensagens = "Cliente Cadastrado.";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage()+" / "+e.getStackTrace());
		}finally{
			//DAOFactory.close();
		}
		return "/Cliente/lista.xhtml";
	}
	
	public String ListarPessoas(){
		return "/Cliente/lista.xhtml?faces-redirect=true";
	}
	
	public String criarPessoas(){
		if(this.loginBeans.getPessoaFisica().getAdminitrador() != 1){
			return "/menu.xhtml?faces-redirect=true";
		}
		return "/Cliente/criar.xhtml?faces-redirect=true";
	}
	
	public String getOcultarDataTable(){
		if(this.loginBeans.getPessoaFisica().getAdminitrador() != 1){
			return "display:none;";
		}
		return "";
	}
	
	public String getOcultarDataTable2(){
		if(this.loginBeans.getPessoaFisica().getAdminitrador() != 1){
			return "";
		}
		return "display:none;";
	}

	public String atalizar(PessoaFisica cliente){
		if(this.loginBeans.getPessoaFisica().getAdminitrador() != 1){
			return "/menu.xhtml?faces-redirect=true";
		}
		IEnderecoBase enderecoBase = DAOFactory.getEnderecoBase();
		this.pessoaFisca = cliente;
		this.endereco = enderecoBase.consultarPorId(cliente.getEndereco().getCodigo());
		return "/Cliente/atualizar.xhtml";
	}
	
	public String cadastrarAtualizacao(){
		try {
			if(this.loginBeans.getPessoaFisica().getAdminitrador() != 1){
				return "/menu.xhtml?faces-redirect=true";
			}
			IPessoaFisicaBase pessoaFisicaBase = DAOFactory.getPessoaFisicaBase();
			IEnderecoBase enderecoBase = DAOFactory.getEnderecoBase();
			enderecoBase.alterar(this.endereco);
			this.pessoaFisca.setEndereco(endereco);
			pessoaFisicaBase.alterar(this.pessoaFisca);
			this.mensagens = "Cliente Atualizado.";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace()+"error na atualizacao");
		}
		return "/Cliente/lista.xhtml?";
	}
	
	public String removerCliente(PessoaFisica cliente){
		try {
			if(this.loginBeans.getPessoaFisica().getAdminitrador() != 1){
				return "/menu.xhtml?faces-redirect=true";
			}
			IEnderecoBase enderecoBase = DAOFactory.getEnderecoBase();
			IPessoaFisicaBase pessoaFisicaBase = DAOFactory.getPessoaFisicaBase();
			Endereco enderecoRemover = cliente.getEndereco();
			System.out.println(cliente.getEndereco().getCodigo()+"codigo de teste");
			pessoaFisicaBase.remover(cliente);
			enderecoBase.remover(enderecoRemover);
			this.mensagens = "Cliente Removido.";
		} catch (Exception e) {
			// TODO: handle exception
			this.mensagens = "Cliente ativo.";
		}
		return "/Cliente/lista.xhtml?";
	}
}
