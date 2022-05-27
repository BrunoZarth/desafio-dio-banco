import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Banco {
	
	private String nome;
	static List<Cliente> listaDeClientes = new ArrayList<>();


	
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
		System.out.println("________________________________________________");
		for(Cliente cliente : Banco.listaDeClientes) {
			cliente.imprimirInfosDaConta();
			System.out.println("--------------");
		}
		System.out.println("________________________________________________");
	}
	
	
}
