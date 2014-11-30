package dados.basic;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import dados.classes.Estoque;
import dados.generico.DAOGenerico;
public class EstoqueBase extends DAOGenerico<Estoque> implements IEstoqueBase{

	public EstoqueBase(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	public List<Estoque> listaEstoque() throws Exception{
		TypedQuery<Estoque> listaEstoque = this.entityManager.createQuery("SELECT e FROM Estoque e", Estoque.class);
		return listaEstoque.getResultList();
	}
	
	public Estoque retornarEstoque(Estoque estoque) throws Exception{
		Query query = this.entityManager.createQuery("SELECT e FROM Estoque e WHERE e.codigo = "+estoque.getCodigo());
		return (Estoque) query.getSingleResult();
	}
}
