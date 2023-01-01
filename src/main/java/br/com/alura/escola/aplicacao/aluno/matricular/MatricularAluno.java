package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.dominio.aluno.entities.Aluno;
import br.com.alura.escola.dominio.aluno.repository.AlunoRepository;
import br.com.alura.escola.infra.aluno.repository.RepositorioDeAlunos;

public class MatricularAluno {

    private final AlunoRepository repositorioDeAlunos;

    public MatricularAluno(AlunoRepository repositorioDeAlunos) {
        this.repositorioDeAlunos = repositorioDeAlunos;
    }

    public void executar(AlunoDTO dados) {
        Aluno novoAluno = dados.criarAluno();
        repositorioDeAlunos.matricular(novoAluno);
    }
}
