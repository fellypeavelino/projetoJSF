package dados.basic;

import javax.persistence.EntityManager;

import dados.generico.DAOGenerico;
import dados.classes.Cliente;

public class ClienteBase extends DAOGenerico<Cliente> implements IClienteBase{

	public ClienteBase(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
}
