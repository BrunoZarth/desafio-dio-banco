import lombok.Data;

@Data
public class Cliente {
	
	public String nome;
	public Conta conta;
	

	
	public Cliente(String nome, Conta conta) {
		this.nome = nome;
		this.conta = conta;
		Banco.listaDeClientes.add(this);
	}
	
	public void sacarDaConta(double valor) {
		conta.saldo -= valor;
		this.imprimirInfosDaTransacao("saque", valor);
	}

	public void depositarNaConta(double valor) {
		conta.saldo += valor;
		this.imprimirInfosDaTransacao("deposito", valor);
	}

	public void transferirParaConta(double valor, Cliente clienteDestino) {
		this.imprimirInfosDaTransacao("transferencia", valor, clienteDestino);
		this.sacarDaConta(valor);
		clienteDestino.depositarNaConta(valor);
	}
	
	public void imprimirInfosDaConta() {
		System.out.println("Titular: " + this.nome);
		System.out.printf("Agencia: %d \n", conta.agencia);
		System.out.printf("Número: %d \n", conta.numero);
		System.out.printf("Saldo: %.2f \n", conta.saldo);
	}
	
	public void imprimirInfosDaTransacao(String tipoDaTransacao, double valor) {
		String valorFormatado = "R$" + String.valueOf(valor).replace(".", ",") + "0";
		System.out.printf("%s de %s efetuado com sucesso na conta de %s. \n", tipoDaTransacao, valorFormatado, this.getNome());
	}
	
	public void imprimirInfosDaTransacao(String tipoDaTransacao, double valor, Cliente clienteDestino) {
		String valorFormatado = "R$" + String.valueOf(valor).replace(".", ",") + "0";
		System.out.printf("%s de %s de %s para a conta de %s iniciada... \n", tipoDaTransacao, valorFormatado, this.getNome(), clienteDestino.getNome());
	}
}
