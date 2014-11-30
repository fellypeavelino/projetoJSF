package dados.basic;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import dados.classes.Endereco;
import dados.generico.DAOGenerico;

public class EnderecoBase extends DAOGenerico<Endereco> implements IEnderecoBase{

	public EnderecoBase(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	public Endereco retornarEndereco(Endereco e) throws Exception{
		Query query = this.entityManager.createQuery("SELECT e FROM Endereco e WHERE e.cep ="+e.getCep());
		/*Long id = (Long) query.getSingleResult();
		Query query2 = this.entityManager.createQuery("SELECT e FROM Endereco e WHERE e.cep ="+e.getCep());*/
		Endereco endereco = (Endereco) query.getSingleResult(); 
		return endereco;
		
	}
	
}
