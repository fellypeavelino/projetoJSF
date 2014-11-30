package negocio;

import dados.basic.IProdutoNegocio;
import dados.classes.Produto;

public class ProdutoNegocio implements IProdutoNegocio{

	public ProdutoNegocio() {
		// TODO Auto-generated constructor stub
	}

	public Produto Queimadeestoque(Produto produto)throws Exception{
		double desconto = (produto.getPreco() * 20)/100;
		produto.setPreco(desconto);
		return produto;
	}
}
