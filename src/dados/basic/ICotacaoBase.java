package dados.basic;

import java.util.List;

import dados.classes.Cotacao;
import dados.generico.IDAOGenerico;

public interface ICotacaoBase extends IDAOGenerico<Cotacao>{
	public List<Cotacao> retornarCotacaoExistentes()throws Exception;
}
