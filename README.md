###### (v1.0.0)
# Banco Digital 



Este projeto é uma implementação de um banco digital simples em Java. Ele demonstra funcionalidades básicas de uma conta bancária, incluindo operações como depósito, saque com taxa de serviço, transferência entre contas, e consulta de saldo. O objetivo é oferecer uma base para entender conceitos fundamentais de programação orientada a objetos e manipulação de dados em Java.

## Funcionalidades

- **Criação de Conta:** Crie novas contas bancárias, tanto correntes quanto poupança.
- **Depósito:** Adicione fundos às suas contas.
- **Saque:** Realize saques com ou sem uma taxa de serviço, dependendo do tipo de conta.
- **Transferência:** Transfira fundos entre contas, com ou sem taxa, dependendo do tipo de conta.
- **Consulta de Saldo:** Verifique o saldo atual das suas contas.
- **Listagem de Contas:** Liste todas as contas registradas no banco.

## Estrutura do Projeto

### Classe `Banco`

A classe `Banco` é responsável por gerenciar as contas.

```java
public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void addConta(Conta conta) {
        contas.add(conta);
    }

    public static void imprimirContas() {
       if (!contas.isEmpty()) {
           contas.forEach(System.out::println);
       } else {
           throw new RuntimeException("Lista vazia.");
        }
    }
}

```

### Classe `Conta`
A classe abstrata `Conta` define a estrutura básica das contas bancárias.
```Java
    public abstract class Conta {
    private int agencia;
    private int numero;
    protected double saldo = 0.0;

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

    public abstract void sacar(double valor);

    public abstract void depositar(double valor);

    public abstract void transferir(Conta contaDestino, double valor);
}
```
### Classe `ContaCorrente`
A classe ContaCorrente é filha da classe `Conta` implementando o método abstrato `sacar` e `transferir` com uma taxa de saque de `2%` por operação.
```Java
    public class ContaCorrente extends Conta {
    public ContaCorrente(int agencia, int numero) {
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
```
### Classe `ContaPoupanca`
A classe ContaCorrente é filha da classe `Conta` implementando o método abstrato `sacar` e `transferir` sem taxação de saque por operação.
```Java
public class ContaPoupanca extends Conta {
public ContaPoupanca(int agencia, int numero) {
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

```
### Classe `BancoTeste`
A classe BancoTeste contém o método main para testar as funcionalidades do banco digital.
```Java
public class BancoTeste {
    public static void main(String[] args) {
        ContaCorrente c1 = new ContaCorrente(4321, 1);
        c1.depositar(100.00);

        ContaPoupanca c2 = new ContaPoupanca(5432, 2);

        c1.transferir(c2, 50);
        System.out.println(c1);

        c2.transferir(c1, 40.00);
        System.out.println("\n" + c2);

        Banco meuBanco = new Banco("LoserBank");
        meuBanco.addConta(c1);
        meuBanco.addConta(c2);

        System.out.println("\nLista de contas cadastradas no banco " + meuBanco.getNome() + ":");
        Banco.imprimirContas();
    }
}
```

### Como Usar:
1. Clone o repositório com o comando:`git clone https://github.com/braswilliam/dio-desafio-banco-com-java-oo.git`
2. Navegue até o diretório do projeto com o comando:`cd dio-desafio-banco-com-java-oo`
3. Compile os arquivos Java com o comando:`javac src/com/seu/pacote/BancoTeste.java`

- (Certifique-se de que o caminho esteja correto, substituindo src/com/seu/pacote pelo caminho correto dos arquivos .java. Pode ser necessário compilar múltiplos arquivos dependendo da estrutura do seu projeto.)
4. Execute o programa com o comando:`java -cp src com.seu.pacote.BancoTeste` (Novamente, substitua com.seu.pacote pelo caminho correto do pacote.).

### Detalhes Importantes:
- Certifique-se de estar na raiz do diretório do projeto antes de compilar e executar os arquivos.
- O comando javac compila o código fonte e o comando java executa o bytecode compilado.
- Se o projeto estiver utilizando pacotes, o caminho completo do pacote deve ser especificado tanto na compilação quanto na execução.