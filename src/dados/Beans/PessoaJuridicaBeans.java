package dados.Beans;

import java.util.List;

import javassist.bytecode.stackmap.BasicBlock.Catch;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import dados.basic.IEnderecoBase;
import dados.basic.IFornecedorBase;
import dados.basic.IPessoaJuridicaBase;
import dados.classes.Endereco;
import dados.classes.PessoaJuridica;
import dados.generico.DAOFactory;

@ManagedBean
public class PessoaJuridicaBeans {

	public PessoaJuridicaBeans() {
		// TODO Auto-generated constructor stub
	}
	
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

	private PessoaJuridica pessoaJuridica = new PessoaJuridica();
	private Endereco endereco = new Endereco();
	private List<PessoaJuridica> litasPessoaJuridica;
	
	public List<PessoaJuridica> getLitasPessoaJuridica() {
		try{
			IPessoaJuridicaBase pessoaJuridicaBase = DAOFactory.getPessoaJuridica();
			litasPessoaJuridica = pessoaJuridicaBase.retornaPessoaJuridica();
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
		return litasPessoaJuridica;
	}

	public void setLitasPessoaJuridica(List<PessoaJuridica> litasPessoaJuridica) {
		this.litasPessoaJuridica = litasPessoaJuridica;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String cadastrarPessoaJuridica(){
		try {
			IPessoaJuridicaBase pessoaJuridicaBase = DAOFactory.getPessoaJuridica();	
			IEnderecoBase enderecoBaseJ = DAOFactory.getEnderecoBase();
			if(endereco.getCep().isEmpty() || pessoaJuridica.getCnpj().isEmpty()){
				this.mensagens = "CNPJ e CEP são Obrigatorios!!!!";
				return "/Fornecedor/criar.xhtml";
			}
			enderecoBaseJ.inserir(endereco);
			pessoaJuridica.setEndereco(endereco);
			pessoaJuridicaBase.inserir(pessoaJuridica);
			this.mensagens = "Forenecedor cadastrado";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage()+" / "+e.getStackTrace());
		}
		return "/Fornecedor/lista.xhtml";
	}
	
	public String ListarPessoaJuridica(){
		return "/Fornecedor/lista.xhtml?faces-redirect=true";
	}
	
	public String criarPessoaJuridica(){
		if(this.loginBeans.getPessoaFisica().getAdminitrador() != 1){
			return "/menu.xhtml?faces-redirect=true";
		}
		return "/Fornecedor/criar.xhtml?faces-redirect=true";
	}
	
	public String removerPessoaJuridica(PessoaJuridica fornecedor){
		try {
			if(this.loginBeans.getPessoaFisica().getAdminitrador() != 1){
				return "/menu.xhtml?faces-redirect=true";
			}
			IPessoaJuridicaBase pessoaJuridicaBase = DAOFactory.getPessoaJuridica();
			IEnderecoBase enderecoBase = DAOFactory.getEnderecoBase();
			Endereco enderecoRemover = this.pessoaJuridica.getEndereco();
			pessoaJuridicaBase.remover(fornecedor);
			enderecoBase.remover(enderecoRemover);
			this.mensagens = "Fornecedor removido.";
		} catch (Exception e) {
			// TODO: handle exception
			this.mensagens = "Fornecedor ativo";
		}
		return "/Fornecedor/lista.xhtml";
	}
	
	public String atualizarPessoaJuridica(PessoaJuridica fornecedor){
		if(this.loginBeans.getPessoaFisica().getAdminitrador() != 1){
			return "/menu.xhtml?faces-redirect=true";
		}
		IEnderecoBase enderecoBase = DAOFactory.getEnderecoBase();
		this.pessoaJuridica = fornecedor;
		this.endereco = enderecoBase.consultarPorId(fornecedor.getEndereco().getCodigo());
		return "/Fornecedor/atualizar.xhtml";
	}
	
	public String cadastrarAtualizacaoPessoaJuridica(){
		try {
			IEnderecoBase enderecoBase = DAOFactory.getEnderecoBase();
			IPessoaJuridicaBase pessoaJuridicaBase = DAOFactory.getPessoaJuridica();
			enderecoBase.alterar(this.endereco);
			this.pessoaJuridica.setEndereco(endereco);
			pessoaJuridicaBase.alterar(pessoaJuridica);
			this.mensagens = "Fornecedor ataulizado.";
		} catch (Exception e) {
			// TODO: handle exception
		}
		//
		return "/Fornecedor/lista.xhtml";
	}
}
