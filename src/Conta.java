public abstract class Conta {

    private int agencia;
    private int numero;
    protected double saldo = 0.0; //Só para as filhas.

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public abstract void  sacar(double valor);

    public abstract void  depositar(double valor);

    public abstract void  transferir (Conta contaDestino, double valor);


}
