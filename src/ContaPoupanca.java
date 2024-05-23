public class ContaPoupanca extends Conta{

    public ContaPoupanca( int agencia, int numero) {
        setAgencia(agencia);
        setNumero(numero);
    }

    @Override
    public void sacar(double valor) {
        super.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        super.saldo += valor;
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        contaDestino.depositar(valor);
        super.saldo -= valor;
    }

    @Override
    public String toString() {
        return "Agencia: " + super.getAgencia() + " Conta: " + super.getNumero() + " Saldo: " + super.getSaldo();
    }
}
