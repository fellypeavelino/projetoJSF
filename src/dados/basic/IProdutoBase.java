package dados.basic;
import java.util.List;

import dados.classes.Produto;
import dados.generico.IDAOGenerico;
public interface IProdutoBase extends IDAOGenerico<Produto>{
	public List<Produto> listarProdutos() throws Exception;
	public Produto retornarProduto(Produto produto)throws Exception;
	public List<Produto> listarProdutosNavalidade() throws Exception;
}
