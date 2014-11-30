package dados.basic;
import javax.persistence.EntityManager;

import dados.classes.Compra;
import dados.generico.DAOGenerico;

public class CompraBase extends DAOGenerico<Compra> implements ICompraBase{

	public CompraBase(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
