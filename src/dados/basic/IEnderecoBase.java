package dados.basic;
import dados.classes.Endereco;
import dados.generico.IDAOGenerico;
public interface IEnderecoBase extends IDAOGenerico<Endereco>{
	public Endereco retornarEndereco(Endereco e) throws Exception;
}
