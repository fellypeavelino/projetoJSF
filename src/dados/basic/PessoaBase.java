package dados.basic;
import javax.persistence.EntityManager;

import dados.classes.Pessoa;
import dados.generico.DAOGenerico;
public class PessoaBase extends DAOGenerico<Pessoa> implements IPessoaBase{

	public PessoaBase(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
