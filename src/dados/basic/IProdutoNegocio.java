package dados.basic;

import dados.classes.Produto;

public interface IProdutoNegocio {
	public Produto Queimadeestoque(Produto produto)throws Exception;
}
