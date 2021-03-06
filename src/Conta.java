import lombok.Data;

@Data
public abstract class Conta implements IConta{
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 0;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	
	public Conta() {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
	}
	
	public void sacar() {
		
	}
	
	public void depositar() {
		
	}
	
	public void transferir() {
		
	}


	@Override
	public void sacar(double valor) {
		this.saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		this.saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	public void imprimirInfosComuns() {
		System.out.printf("Agencia: %d \n", this.agencia);
		System.out.printf("N?mero: %d \n", this.numero);
		System.out.printf("Saldo: %.2f \n", this.saldo);
	}
	
	
}
