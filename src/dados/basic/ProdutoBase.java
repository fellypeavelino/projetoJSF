package dados.basic;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import dados.classes.Produto;
import dados.generico.DAOGenerico;
public class ProdutoBase extends DAOGenerico<Produto> implements IProdutoBase{

	public ProdutoBase(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	public List<Produto> listarProdutosNavalidade() throws Exception{
		Calendar data = Calendar.getInstance();
		TypedQuery<Produto> produtos = this.entityManager.createQuery("SELECT p FROM Produto p WHERE p.saida > '"+(data.get(Calendar.YEAR)+"-"+(data.get(Calendar.MONTH) + 1)+"-"+data.get(Calendar.DATE))+"'", Produto.class);
		return produtos.getResultList();
	}
	
	public List<Produto> listarProdutos() throws Exception{
		TypedQuery<Produto> produtos = this.entityManager.createQuery("SELECT p FROM Produto p", Produto.class);
		return produtos.getResultList();
	}
	
	public Produto retornarProduto(Produto produto)throws Exception{
		TypedQuery<Produto> query = this.entityManager.createQuery("SELECT p FROM Produto p WHERE p.codigo= "+produto.getCodigo(), Produto.class);
		return query.getSingleResult();
	}
}
