package teste;

import dados.basic.EstoqueBase;
import dados.basic.IAnimalBase;
import dados.basic.IClienteBase;
import dados.basic.IEnderecoBase;
import dados.basic.IEstoqueBase;
import dados.basic.IFornecedorBase;
import dados.basic.IPessoaBase;
import dados.basic.IPessoaFisicaBase;
import dados.basic.IPessoaJuridicaBase;
import dados.basic.ITipoBase;
import dados.basic.PessoaJuridicaBase;
import dados.classes.Animal;
import dados.classes.Cliente;
import dados.classes.Endereco;
import dados.classes.Estoque;
import dados.classes.Fornecedor;
import dados.classes.Pessoa;
import dados.classes.PessoaFisica;
import dados.classes.PessoaJuridica;
import dados.classes.Tipo;
import dados.generico.DAOFactory;
import dados.generico.DAOGenerico;

public class TesteProdutosDAO {

	public static void main(String[] args) {
		/*		
		ICidadeDAO cidadeDAO = DAOFactory.getCidadeDAO();
		
		Cidade cidade = new Cidade();
		cidade.setNome("Salvador");
		cidade.setUf(UF.BA);
		
		cidadeDAO.inserir(cidade);
		
		listarCidades();
		
		Cidade cidRec = cidadeDAO.consultarPorId(1);
		cidRec.setNome("RECIFE");
		
		cidadeDAO.alterar(cidRec);
		
		cidade = cidadeDAO.consultarPorId(4);
		cidadeDAO.remover(cidade);
		
		listarCidades();
		
		DAOFactory.close();
*/
		try {
			
		//Cadastrando Tipo
		ITipoBase tipoBase = DAOFactory.getTipo();
		/**Tipo tipo = new Tipo();
		tipo.setNome("bovino2");
		tipoBase.inserir(tipo);
		
		//pessoa fisica e endereco
		//IClienteBase clienteBase = DAOFactory.getClienteBase(); 
		IPessoaFisicaBase pessoaFisicaBase = DAOFactory.getPessoaFisicaBase();
		IPessoaBase pessoaBase = DAOFactory.getPessoaBase();
		IEnderecoBase enderecoBase = DAOFactory.getEnderecoBase();
		
		Cliente cliente = new Cliente();//Pfisica
		//Pessoa pessoa = new Pessoa();
		
		PessoaFisica pessoa = new PessoaFisica();
		Endereco endereco = new Endereco();
		pessoa.setCpf("08008414413");
		pessoa.setMail("fellypeavelino@hotmail.com");
		pessoa.setSenha("nirvana");
		pessoa.setTelefone("92737317");
		pessoa.setNome("felipe avelino");
		endereco.setBairro("piedade");
		endereco.setCep("000003");
		endereco.setEstado("Pernambuco");
		endereco.setMunicipio("jaboatao");
		endereco.setPais("brasil4");
		//cliente.setPessoa(pessoa);
		//clienteBase.inserir(cliente);
		enderecoBase.inserir(endereco);
		Endereco enderecoSql = enderecoBase.retornarEndereco(endereco);
		pessoa.setEndereco(enderecoSql);
		//System.out.print(enderecoSql.getCodigo());
		pessoaFisicaBase.inserir(pessoa);
		//pessoa fisica e endereco
		
		//pessoa juridica e fornecedor**/
		IPessoaJuridicaBase pessoaJuridicaBase = DAOFactory.getPessoaJuridica();	
		/**IFornecedorBase fornecedorBase = DAOFactory.getFornecedorBase();
		IEnderecoBase enderecoBaseJ = DAOFactory.getEnderecoBase();
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		Fornecedor fornecedor = new Fornecedor();
		Endereco enderecoJ = new Endereco();
		pessoaJuridica.setCelular("000000000");
		pessoaJuridica.setCnpj("000000000000");
		pessoaJuridica.setMail("teste@");
		pessoaJuridica.setNome("testeFornecedor");
		pessoaJuridica.setNomeFantasia("testeFornecedor");
		pessoaJuridica.setRazaoSocial("testeFornecedor");
		pessoaJuridica.setSenha("teste");
		pessoaJuridica.setTelefone("0000000000");
		enderecoJ.setBairro("piedade");
		enderecoJ.setCep("3333");
		enderecoJ.setEstado("Pernambuco");
		enderecoJ.setMunicipio("jaboatao");
		enderecoJ.setPais("brasil3");
		enderecoBaseJ.inserir(enderecoJ);
		Endereco enderecoJSql = enderecoBaseJ.retornarEndereco(enderecoJ);
		pessoaJuridica.setEndereco(enderecoJSql);
		pessoaJuridicaBase.inserir(pessoaJuridica);**/
		//PessoaJuridica juridicaSql = pessoaJuridicaBase.retornaUltimaPessoaJuridica(pessoaJuridica);
		/*IFornecedorBase fornecedorBase = DAOFactory.getFornecedorBase();
		IEnderecoBase enderecoBaseJ = DAOFactory.getEnderecoBase();
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		Fornecedor fornecedor = new Fornecedor();
		Endereco enderecoJ = new Endereco();
		fornecedor.setCelular("000000000");
		fornecedor.setCnpj("000000000000");
		fornecedor.setMail("teste@");
		fornecedor.setNome("testeFornecedor");
		fornecedor.setNomeFantasia("testeFornecedor");
		fornecedor.setRazaoSocial("testeFornecedor");
		fornecedor.setSenha("teste");
		fornecedor.setTelefone("0000000000");
		enderecoJ.setBairro("piedade");
		enderecoJ.setCep("3333");
		enderecoJ.setEstado("Pernambuco");
		enderecoJ.setMunicipio("jaboatao");
		enderecoJ.setPais("brasil3");
		enderecoBaseJ.inserir(enderecoJ);
		Endereco enderecoJSql = enderecoBaseJ.retornarEndereco(enderecoJ);
		fornecedor.setEndereco(enderecoJSql);
		fornecedorBase.inserir(fornecedor);*/
		//pessoa juridica e fornecedor
		
		//cadastrando animal
		IAnimalBase animalBase = DAOFactory.getAnimalBase();
		Animal animal = new Animal();
		animal.setPeso(50);
		animal.setPreco(50);
		animal.setQuantdade(1);
		animal.setNome("bufalo");
		Tipo tipoSql = tipoBase.retornaTipo();
		animal.setTipo(tipoSql);
		PessoaJuridica juridicaSql = pessoaJuridicaBase.retornaUltimaPessoaJuridica();
		animal.setPessoaJuridica(juridicaSql);
		animalBase.inserir(animal);
		//pessoaFisicaBase.inserir(pessoa);
		//System.out.print(enderecoSql.getPais()+"teste");
		
		/*IEstoqueBase estoqueBase = DAOFactory.getEstoque();
		Estoque estoque = new Estoque();
		estoque.setPrazo(4);
		estoque.setQuantidade(5);
		estoqueBase.inserir(estoque);
		DAOFactory.close();*/
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("Erro "+e.getMessage());
		}
	}

/*
	private static void listarCidades() {
		List<Cidade> cidades = DAOFactory.getCidadeDAO().consultarTodos();
		for(Cidade cid : cidades){
			System.out.println(cid.getNome());
		}
	}
*/
}
