package dados.basic;
import java.util.Date;

import dados.classes.Estoque;
import dados.generico.IDAOGenerico;
public interface IEstoqueNegocio{
	public Boolean prazoEstoqueUltrapassado(Date entrada, Date saida, Estoque estoqueExterno) throws Exception;
	public int estouroDaDataDeSaida(Date saida)throws Exception;
	public boolean quantidadeEstoqueUltrapassado(Integer qtd, Estoque estoqueExterno)throws Exception;
}
