
public class Main {

	public static void main(String[] args) {
		Banco banco = new Banco();
		
		Cliente boris = banco.novoCliente("Boris Augusto", "poupanca");
		Cliente leonor = banco.novoCliente("Leonor Ugo", "corrente");
		
		banco.getListaDeClientes();
		
		boris.depositarNaConta(500);
		leonor.depositarNaConta(1000);
		leonor.sacarDaConta(250);
		
		banco.getListaDeClientes();
		
		boris.transferirParaConta(400, leonor);
		
		banco.getListaDeClientes();
		
		Cliente etevaldo = banco.novoCliente("Etevaldo Peixoto", "poupanca");
		Cliente astrogildo = banco.novoCliente("Astrogildo Peixoto", "corrente");
		
		banco.getListaDeClientes();
		
	}

}
