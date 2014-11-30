package dados.Beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import dados.basic.IAnimalBase;
import dados.basic.IPessoaJuridicaBase;
import dados.basic.ITipoBase;
import dados.classes.Animal;
import dados.classes.PessoaJuridica;
import dados.classes.Tipo;
import dados.generico.DAOFactory;

@ManagedBean
public class AnimalBeans {

	public AnimalBeans() {
		// TODO Auto-generated constructor stub
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
	private List<Animal> animais;
	@ManagedProperty(value = "#{loginBeans}")
	private LoginBeans loginBeans;
	public LoginBeans getLoginBeans() {
		return loginBeans;
	}
	public void setLoginBeans(LoginBeans loginBeans) {
		this.loginBeans = loginBeans;
	}
	private Tipo tipo = new Tipo();
	private PessoaJuridica pessoaJuridica = new PessoaJuridica();
	private List<Tipo> tipos;
	private String mensagens;
	private List<PessoaJuridica> fornecedores;
	private Animal animal = new Animal();
	public String getMensagens() {
		return mensagens;
	}
	public void setMensagens(String mensagens) {
		this.mensagens = mensagens;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public List<Tipo> getTipos() {
		try {
			ITipoBase tipoBase = DAOFactory.getTipo();
			tipos = tipoBase.listarTipos();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		return tipos;
	}
	public void setTipos(List<Tipo> tipos) {
		this.tipos = tipos;
	}
	public List<PessoaJuridica> getFornecedores() {
		try {
			IPessoaJuridicaBase pessoaJuridicaBase = DAOFactory.getPessoaJuridica();
			fornecedores = pessoaJuridicaBase.retornaPessoaJuridica();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		return fornecedores;
	}
	public void setFornecedores(List<PessoaJuridica> fornecedores) {
		this.fornecedores = fornecedores;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}
	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	
	public String cadastarAnimal(){
		try {
			IAnimalBase animalBase = DAOFactory.getAnimalBase();
			animal.setTipo(tipo);
			animal.setPessoaJuridica(pessoaJuridica);
			animalBase.inserir(animal);
			this.mensagens = "Animal Cadastrado";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		return "/Animais/lista.xhtml";
	}
	
	public String criarAnimal(){
		if(this.loginBeans.getPessoaFisica().getAdminitrador() != 1){
			return "/menu.xhtml?faces-redirect=true";
		}
		return "/Animais/criar.xhtml?faces-redirect=true";
	}
	
	public String listarAnimal(){
		if(this.loginBeans.getPessoaFisica().getAdminitrador() != 1){
			return "/menu.xhtml?faces-redirect=true";
		}
		return "/Animais/lista.xhtml?faces-redirect=true";
	}
}
