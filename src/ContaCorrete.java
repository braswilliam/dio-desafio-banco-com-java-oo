public class ContaCorrete extends Conta{

    public ContaCorrete( int agencia, int numero) {
        setAgencia(agencia);
        setNumero(numero);
    }

    @Override
    public void sacar(double valor) {
        double taxa = valor * 0.02;
        super.saldo -= (valor + taxa);
    }

    @Override
    public void depositar(double valor) {
        super.saldo += valor;
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        contaDestino.depositar(valor);
        sacar(valor);
    }

    @Override
    public String toString() {
        return "Agencia: " + super.getAgencia() + " Conta: " + super.getNumero() + " Saldo: " + super.getSaldo();
    }


}
