package dados.basic;
import java.util.List;

import dados.classes.PessoaJuridica;
import dados.generico.IDAOGenerico;
public interface IPessoaJuridicaBase extends IDAOGenerico<PessoaJuridica>{
	public PessoaJuridica retornaUltimaPessoaJuridica( )throws Exception;
	public List<PessoaJuridica> retornaPessoaJuridica() throws Exception;
}
