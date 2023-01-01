package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.dominio.aluno.entities.Aluno;
import br.com.alura.escola.dominio.aluno.valueobjects.Cpf;
import br.com.alura.escola.dominio.aluno.valueobjects.Email;

public class AlunoDTO {

    private String cpf;
    private String nome;
    private String email;

    public AlunoDTO(String cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public Aluno criarAluno() {
        return new Aluno(new Cpf(cpf), nome, new Email(email));
    }

}
