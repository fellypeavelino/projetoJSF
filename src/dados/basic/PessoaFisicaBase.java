package dados.basic;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import dados.classes.PessoaFisica;
import dados.generico.DAOGenerico;
public class PessoaFisicaBase extends DAOGenerico<PessoaFisica> implements IPessoaFisicaBase{

	public PessoaFisicaBase(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	public PessoaFisica retornarPessoaFisica(PessoaFisica f)throws Exception{
		String query = "SELECT f FROM PessoaFisica f where f.cpf='"+f.getCpf()+"' and f.senha='"+f.getSenha()+"'";
		TypedQuery<PessoaFisica> pessoaFisica = this.entityManager.createQuery(query, PessoaFisica.class);
		return pessoaFisica.getSingleResult();
	}
	
	public List<PessoaFisica> listarPessoasFisica() throws Exception{
		TypedQuery<PessoaFisica> pessoaFisica = this.entityManager.createQuery("SELECT f FROM PessoaFisica f", PessoaFisica.class);
		List<PessoaFisica> lista = pessoaFisica.getResultList();
		return lista;
	}
}
