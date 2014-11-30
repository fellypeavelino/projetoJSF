package dados.basic;
import java.util.List;

import dados.classes.PessoaFisica;
import dados.generico.IDAOGenerico;
public interface IPessoaFisicaBase extends IDAOGenerico<PessoaFisica>{
	public PessoaFisica retornarPessoaFisica(PessoaFisica f)throws Exception;
	public List<PessoaFisica> listarPessoasFisica() throws Exception;
}
