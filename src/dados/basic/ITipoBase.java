package dados.basic;
import java.util.List;

import dados.classes.Tipo;
import dados.generico.IDAOGenerico;
public interface ITipoBase extends IDAOGenerico<Tipo>{
	public Tipo retornaTipo() throws Exception;
	public List<Tipo> listarTipos() throws Exception;
}
