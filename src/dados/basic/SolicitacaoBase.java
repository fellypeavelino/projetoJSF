package dados.basic;
import javax.persistence.EntityManager;

import dados.classes.Solicitacao;
import dados.generico.DAOGenerico;
public class SolicitacaoBase extends DAOGenerico<Solicitacao> implements ISolicitacaoBase{

	public SolicitacaoBase(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
