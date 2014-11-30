package dados.basic;
import javax.persistence.EntityManager;

import dados.classes.Gerente;
import dados.generico.DAOGenerico;
public class GerenteBase extends DAOGenerico<Gerente> {

	public GerenteBase(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
