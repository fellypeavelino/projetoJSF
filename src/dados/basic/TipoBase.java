package dados.basic;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import dados.classes.Tipo;
import dados.generico.DAOGenerico;
public class TipoBase extends DAOGenerico<Tipo> implements ITipoBase{

	public TipoBase(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	public Tipo retornaTipo() throws Exception{
		Query query = this.entityManager.createQuery("SELECT COUNT(t) FROM Tipo t");
		Long id = (Long) query.getSingleResult();
		Query query2 = this.entityManager.createQuery("SELECT t FROM Tipo t WHERE t.codigo = "+id);
		Tipo tipo = (Tipo) query2.getSingleResult();
		return tipo;
	}
	
	public List<Tipo> listarTipos() throws Exception{
		TypedQuery<Tipo> listaTipo = this.entityManager.createQuery("SELECT t FROM Tipo t", Tipo.class);
		return listaTipo.getResultList();
	}
}
