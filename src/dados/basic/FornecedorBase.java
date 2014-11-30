package dados.basic;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import dados.classes.Endereco;
import dados.classes.Fornecedor;
import dados.generico.DAOGenerico;
public class FornecedorBase extends DAOGenerico<Fornecedor> implements IFornecedorBase{

	public FornecedorBase(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	public Fornecedor retornarUltimoFornecedor(Fornecedor f){
		Query query = this.entityManager.createQuery("SELECT COUNT(f) FROM Fornecedor f");
		Long id = (Long) query.getSingleResult();
		Query query2 = this.entityManager.createQuery("SELECT f FROM Fornecedor f WHERE f.codigo ="+f.getCodigo());
		Fornecedor fornecedor = (Fornecedor) query.getSingleResult(); 
		return fornecedor;
	}
}
