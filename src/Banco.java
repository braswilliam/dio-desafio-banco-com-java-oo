import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private final List<Conta> contas;

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
        contas.forEach();
    }



}
