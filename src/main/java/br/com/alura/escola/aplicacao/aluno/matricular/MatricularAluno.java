package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.dominio.aluno.entities.Aluno;
import br.com.alura.escola.infra.aluno.repository.RepositorioDeAlunos;

public class MatricularAluno {

    private final RepositorioDeAlunos repositorioDeAlunos;

    public MatricularAluno(RepositorioDeAlunos repositorioDeAlunos) {
        this.repositorioDeAlunos = repositorioDeAlunos;
    }

    public void executar(AlunoDTO dados) {
        Aluno novoAluno = dados.criarAluno();
        repositorioDeAlunos.matricular(novoAluno);
    }
}
