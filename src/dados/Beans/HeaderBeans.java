package dados.Beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import dados.classes.Compra;

@ManagedBean
public class HeaderBeans {

	public HeaderBeans() {
		// TODO Auto-generated constructor stub
	}
	
	 public HttpSession getminhaSession() {
	    FacesContext context = FacesContext.getCurrentInstance();
	    HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
	    session.getAttribute("loginBeans");
	    return session;
	 }

	@ManagedProperty(value = "#{compraBeans}")
	private CompraBeans compraBeans;
	@ManagedProperty(value = "#{loginBeans}")
	private LoginBeans loginBeans;
	public CompraBeans getCompraBeans() {
		return compraBeans;
	}

	public void setCompraBeans(CompraBeans compraBeans) {
		this.compraBeans = compraBeans;
	}

	public LoginBeans getLoginBeans() {
		return loginBeans;
	}
	
	public void setLoginBeans(LoginBeans loginBeans) {
		this.loginBeans = loginBeans;
	}

	public String redirecionarParaInicio(){
		List<Compra> compras = new ArrayList<Compra>();
		compraBeans.setCompras(compras);
		return "/menu.xhtml?faces-redirect=true";
	}
	
	public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }


}
