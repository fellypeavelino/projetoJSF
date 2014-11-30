package dados.basic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import dados.classes.Animal;
import dados.generico.DAOGenerico;


public class AnimalBase extends DAOGenerico<Animal> implements IAnimalBase{

	public AnimalBase(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	public List<Animal> listarAnimais() throws Exception{
		TypedQuery<Animal> listaAnimal = this.entityManager.createQuery("SELECT a from Animal a", Animal.class);
		return listaAnimal.getResultList();
	}
}
