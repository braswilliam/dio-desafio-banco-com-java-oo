import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private static List<Conta> contas;

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
