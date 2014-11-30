package dados.basic;
import java.util.List;

import dados.classes.Estoque;
import dados.generico.IDAOGenerico;
public interface IEstoqueBase extends IDAOGenerico<Estoque>{
	public List<Estoque> listaEstoque() throws Exception;
	public Estoque retornarEstoque(Estoque estoque) throws Exception;
}
