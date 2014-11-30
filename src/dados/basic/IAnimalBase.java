package dados.basic;
import java.util.List;

import dados.classes.Animal;
import dados.generico.IDAOGenerico;
public interface IAnimalBase extends IDAOGenerico<Animal>{
	public List<Animal> listarAnimais() throws Exception;
}
