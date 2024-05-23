public class BancoTeste {
    public static void main(String[] args) {

        ContaCorrete c1 = new ContaCorrete(4321, 1);
        c1.depositar(100.00);

        ContaPoupanca c2 = new ContaPoupanca(5432, 2); //essa conta já começa zerada:

        //c1 transfere para c2 com Juros herança do método abstrato da classe abstrata Conta -> transferir():
        c1.transferir(c2, 50);
        //Quando impresso o saldo de c1 será verificado que foi descontado juros:
        System.out.println(c1);

        // //c2 transfere para c1 com herança do método abstrato da classe abstrata Conta -> transferir():
        c2.transferir(c1, 40.00);
        //Quando impresso o saldo de c2 será verificado há juros por se tratar de uma contaPoupanca:
        System.out.println("\n"+c2); //saldo de R$10.00.

        //cria uma classe banco já contendo uma lista vazia:
        Banco meuBanco = new Banco("LoserBank");

        //adiciona uma conta a esta lista:
        meuBanco.addConta(c1);
        meuBanco.addConta(c2);

        System.out.println("\nLista de contas cadastrada no banco " + meuBanco.getNome() + ":");
        Banco.imprimirContas();



    }
}
