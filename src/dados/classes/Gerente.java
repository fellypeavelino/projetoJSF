package dados.classes;

public class Gerente extends Pessoa{

	public Gerente() {
		// TODO Auto-generated constructor stub
	}
	
	private Integer codigo;
	
	private boolean autorizarCompras(){
		return true;
	}
	private boolean autorizarQueimaDeEstaoque(){
		return true;
	}
	private boolean autorizarTrocaDeProdutos(){
		return true;
	}
	private void organizarEstoque(){
		
	}
}
