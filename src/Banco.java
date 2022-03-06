import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private String nome;
	static List<Cliente> listaDeClientes = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Cliente novoCliente(String nome, String tipoDeConta) {
		
		Conta conta = null;
		
		if(tipoDeConta.equals("corrente")) 
			conta = new ContaCorrente();
		if(tipoDeConta.equals("poupanca")) 
			conta = new ContaPoupanca();
		
		Cliente cliente = new Cliente(nome, conta);
		
		return cliente;
	}
	
	public Cliente buscarClientePeloNome(String nome) {
		
		Cliente c = null;
		
		for(Cliente cliente : Banco.listaDeClientes) {
			if(cliente.getNome() == nome) 
				c = cliente;	
		}
		
		return c;
	}
	
	public void getListaDeClientes(){
		for(Cliente cliente : Banco.listaDeClientes) {
			cliente.imprimirInfosDaConta();
			System.out.println("--------------");
		}
		System.out.println("________________________________________________");
	}
	
	
}
