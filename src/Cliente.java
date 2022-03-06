
public class Cliente {
	
	public String nome;
	public Conta conta;
	

	public String getNome() {
		return nome;
	}
	
	public Conta getConta() {
		return conta;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Cliente(String nome, Conta conta) {
		this.nome = nome;
		this.conta = conta;
		Banco.listaDeClientes.add(this);
	}
	
	public void sacarDaConta(double valor) {
		conta.saldo -= valor;
	}

	public void depositarNaConta(double valor) {
		conta.saldo += valor;
	}

	public void transferirParaConta(double valor, Cliente clienteDestino) {
		conta.sacar(valor);
		clienteDestino.depositarNaConta(valor);
	}
	
	public void imprimirInfosDaConta() {
		System.out.println("Titular: " + this.nome);
		System.out.printf("Agencia: %d \n", conta.agencia);
		System.out.printf("Número: %d \n", conta.numero);
		System.out.printf("Saldo: %.2f \n", conta.saldo);
	}
}
