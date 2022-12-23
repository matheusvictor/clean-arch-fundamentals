package escola;

import escola.entities.Aluno;
import escola.valueobjects.Cpf;
import escola.valueobjects.Email;

public class FabricaDeAluno {

    private Aluno aluno;

    public void comNomeCpfEmail(String nome, String cpf, String email) {
        this.aluno = new Aluno(
                new Cpf(cpf),
                nome,
                new Email(email)
        );
    }

    public void comTelefone(String ddd, String numero) {
        this.aluno.adicionarTelefone(ddd, numero);
    }

}
