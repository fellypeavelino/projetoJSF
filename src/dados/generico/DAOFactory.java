package dados.generico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dados.basic.AnimalBase;
import dados.basic.ClienteBase;
import dados.basic.CompraBase;
import dados.basic.CotacaoBase;
import dados.basic.EnderecoBase;
import dados.basic.EstoqueBase;
import dados.basic.FornecedorBase;
import dados.basic.IAnimalBase;
import dados.basic.IClienteBase;
import dados.basic.ICompraBase;
import dados.basic.ICotacaoBase;
import dados.basic.IEnderecoBase;
import dados.basic.IEstoqueNegocio;
import dados.basic.IEstoqueBase;
import dados.basic.IFornecedorBase;
import dados.basic.IPessoaBase;
import dados.basic.IPessoaFisicaBase;
import dados.basic.IPessoaJuridicaBase;
import dados.basic.IProdutoBase;
import dados.basic.ITipoBase;
import dados.basic.PessoaFisicaBase;
import dados.basic.PessoaJuridicaBase;
import dados.basic.ProdutoBase;
import dados.basic.TipoBase;


public abstract class DAOFactory {

	private static EntityManagerFactory factory;
	private static EntityManager entityManager;

	private static IPessoaBase pessoaBase;
	private static IPessoaFisicaBase pessoaFisicaBase;
	private static IPessoaJuridicaBase pessoaJuridica;
	private static IFornecedorBase fornecedorBase;
	private static IClienteBase clienteBase;
	private static IEnderecoBase enderecoBase;
	private static IEstoqueBase estoqueBase;
	private static ITipoBase tipo;
	private static IAnimalBase animalBase;
	private static IProdutoBase produtoBase;
	private static ICotacaoBase cotacaoBase;
	private static ICompraBase compraBase;
	
	public static EntityManagerFactory getFactory() {
		return factory;
	}

	public static void setFactory(EntityManagerFactory factory) {
		DAOFactory.factory = factory;
	}

	public static EntityManager getEntityManager() {
		return entityManager;
	}

	public static void setEntityManager(EntityManager entityManager) {
		DAOFactory.entityManager = entityManager;
	}

	public static IPessoaBase getPessoaBase() {
		return pessoaBase;
	}
	
	public static ICompraBase getCompraBase(){
		compraBase = new CompraBase(factory.createEntityManager());
		return compraBase;
	}
	
	public static ICotacaoBase getCotacaoBase(){
		cotacaoBase = new CotacaoBase(factory.createEntityManager());
		return cotacaoBase ;
	}
	
	public static IPessoaFisicaBase getPessoaFisicaBase() {
		pessoaFisicaBase = new PessoaFisicaBase(factory.createEntityManager());
		return pessoaFisicaBase;
	}

	public static IPessoaJuridicaBase getPessoaJuridica() {
		pessoaJuridica = new PessoaJuridicaBase(factory.createEntityManager());
		return pessoaJuridica;
	}

	public static IFornecedorBase getFornecedorBase() {
		fornecedorBase = new FornecedorBase(factory.createEntityManager());
		return fornecedorBase;
	}

	public static IClienteBase getClienteBase() {
		clienteBase = new ClienteBase(factory.createEntityManager());
		return clienteBase;
	}

	public static IEnderecoBase getEnderecoBase() {
		enderecoBase = new EnderecoBase(factory.createEntityManager());
		return enderecoBase;
	}

	public static IEstoqueBase getEstoqueBase() {
		return estoqueBase;
	}

	public static ITipoBase getTipo() { 
		tipo = new TipoBase(factory.createEntityManager());
		return tipo;
	}
	
	public static IEstoqueBase getEstoque() { 
		estoqueBase = new EstoqueBase(factory.createEntityManager());
		return estoqueBase;
	}

	public static IProdutoBase getProduto(){
		produtoBase = new ProdutoBase(factory.createEntityManager());
		return produtoBase;
	}

	public static IAnimalBase getAnimalBase() {
		animalBase = new AnimalBase(factory.createEntityManager());
		return animalBase;
	}

	// metodos de gerenciamento
	static {
		factory = Persistence.createEntityManagerFactory("unitPSC");
	}

	public static void close() {
		if (factory != null && factory.isOpen()) {
			factory.close();
		}
	}

	public static EntityManager createEntityManager() {
		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	// public static void setEntityManager(EntityManager em){
	// entityManager = em;
	// }

	public static void beginTransaction() {
		if (entityManager != null && entityManager.isOpen()) {
			entityManager.getTransaction().begin();
		}
	}

	public static void commitTransaction() {
		if (entityManager != null && entityManager.isOpen()) {
			entityManager.getTransaction().commit();
		}
	}

	public static void rollback() {
		if (entityManager != null && entityManager.isOpen()) {
			entityManager.getTransaction().rollback();
		}
	}

	public static void closeEntityManager() {
		if (entityManager != null && entityManager.isOpen()) {
			try {
				entityManager.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
