package dados.Beans;

import javax.faces.bean.ManagedBean;

import dados.basic.ITipoBase;
import dados.classes.Tipo;
import dados.generico.DAOFactory;

@ManagedBean
public class TipoBeans {

	public TipoBeans() {
		// TODO Auto-generated constructor stub
	}
	
	private Tipo tipo = new Tipo();
	
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String cadastrar(){
		try {
			ITipoBase tipoBase = DAOFactory.getTipo();
			tipoBase.inserir(tipo);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}finally{
			//DAOFactory.close();
		}
		return "/Animais/criar.xhtml";
	}
	
	public String criarTipo(){
		return "/Tipos/criar.xhtml";
	}
}
