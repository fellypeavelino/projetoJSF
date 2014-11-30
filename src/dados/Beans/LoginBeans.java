package dados.Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import dados.basic.IPessoaFisicaBase;
import dados.classes.PessoaFisica;
import dados.classes.PessoaJuridica;
import dados.generico.DAOFactory;

@ManagedBean
@SessionScoped
public class LoginBeans {

	public LoginBeans() {
		// TODO Auto-generated constructor stub
	}
	private PessoaFisica pessoaFisica = new PessoaFisica();
	private PessoaJuridica pessoaJuridica = new PessoaJuridica();
	
	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	private String alertarLoginInvalido = "";
	
	public String getAlertarLoginInvalido() {
		return alertarLoginInvalido;
	}

	public void setAlertarLoginInvalido(String alertarLoginInvalido) {
		this.alertarLoginInvalido = alertarLoginInvalido;
	}
	
	public String fazerLoginPessoaFisica(){
		try {
			IPessoaFisicaBase pessoaFisicaBase = DAOFactory.getPessoaFisicaBase();
			this.pessoaFisica = pessoaFisicaBase.retornarPessoaFisica(pessoaFisica);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage()+" / "+e.getStackTrace());
			this.alertarLoginInvalido = "Login ou Senha são invalidos!";
			return "";
		}
		return "menu.xhtml?faces-redirect=true";
	}
	
}
