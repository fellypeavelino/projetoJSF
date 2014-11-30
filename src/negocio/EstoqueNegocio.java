package negocio;

import java.util.Date;
import java.util.Calendar;

import dados.basic.IEstoqueBase;
import dados.basic.IEstoqueNegocio;
import dados.classes.Estoque;
import dados.generico.DAOFactory;

public class EstoqueNegocio implements IEstoqueNegocio{

	public EstoqueNegocio() {
		// TODO Auto-generated constructor stub
	}
	private IEstoqueBase estoqueBesa = DAOFactory.getEstoque();
	private Estoque estoque = new Estoque();
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	
	public Boolean prazoEstoqueUltrapassado(Date entrada, Date saida, Estoque estoqueExterno) throws Exception{
		try{
		Calendar data1 = Calendar.getInstance();
		data1.setTimeInMillis(entrada.getTime());
		int mes1 = data1.get(Calendar.MONTH);
		int ano1 = data1.get(Calendar.YEAR);
		Calendar data2 = Calendar.getInstance();
		data2.setTimeInMillis(saida.getTime());
		int mes2 = data2.get(Calendar.MONTH);
		int ano2 = data2.get(Calendar.YEAR);
		if(ano2 == ano1){
			int prazo = mes2 - mes1;
			this.estoque = this.estoqueBesa.consultarPorId(estoqueExterno.getCodigo());
			//this.estoque = this.estoqueBesa.consultarPorId(estoqueExterno.getCodigo());
			if(this.estoque.getPrazo() == prazo || this.estoque.getPrazo() > prazo){
				return true;
			}
		}
		/*int prazo = (int)((data2.getTimeInMillis() - data1.getTimeInMillis())/ (30*24*60*60*1000)) ; 
		this.estoque = this.estoqueBesa.consultarPorId(estoqueExterno.getCodigo());
		if(this.estoque.getPrazo() == prazo || this.estoque.getPrazo() > prazo){
			return true;
		}*/
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
		return false;
	}
	
	public boolean quantidadeEstoqueUltrapassado(Integer qtd, Estoque estoqueExterno)throws Exception{
		this.estoque = this.estoqueBesa.consultarPorId(estoqueExterno.getCodigo());
		if(estoque.getQuantidade() < qtd){
			return false;
		}
		return true;
	}
	
	public int estouroDaDataDeSaida(Date saida)throws Exception{
		Date data = new Date(System.currentTimeMillis());
		if(data.equals(saida)){
			return 1;
		}else if(saida.after(data)){
			return 2;
		}
		return 0;
	}
	
	
}
