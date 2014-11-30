package dados.basic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import dados.classes.Cotacao;
import dados.classes.PessoaFisica;
import dados.generico.DAOGenerico;

public class CotacaoBase extends DAOGenerico<Cotacao> implements ICotacaoBase{

	public CotacaoBase(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	public List<Cotacao> retornarCotacaoExistentes()throws Exception{
		TypedQuery<Cotacao> cotacoes = this.entityManager.createQuery("SELECT c FROM Cotacao c WHERE c.quantiddae > "+0, Cotacao.class);
		return cotacoes.getResultList();
	}
}
