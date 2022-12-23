import java.util.ArrayList;
import java.util.List;

public class Aluno {

    private Cpf cpf;
    private String nome;
    private Email email;
    private final List<Telefone> telefones = new ArrayList<>();

    public void adicionarTelefone(Telefone telefone) {
        //TODO
    }

    public void adicionarTelefone(String ddd, String numero) {
        this.telefones.add(new Telefone(ddd, numero));
    }

    public Cpf getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Email getEmail() {
        return email;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }
}
