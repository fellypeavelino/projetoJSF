package dados.basic;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import dados.classes.Fornecedor;
import dados.classes.PessoaJuridica;
import dados.generico.DAOGenerico;
public class PessoaJuridicaBase extends DAOGenerico<PessoaJuridica> implements IPessoaJuridicaBase{

	public PessoaJuridicaBase(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	public PessoaJuridica retornaUltimaPessoaJuridica(){
		TypedQuery<PessoaJuridica> query = this.entityManager.createQuery("SELECT j FROM PessoaJuridica j ORDER BY j.codigo desc", PessoaJuridica.class);
		return query.setMaxResults(1).getSingleResult();
	}
	
	public List<PessoaJuridica> retornaPessoaJuridica() throws Exception{
		TypedQuery<PessoaJuridica> query = this.entityManager.createQuery("SELECT j FROM PessoaJuridica j", PessoaJuridica.class);
		return query.getResultList();
	}
}
