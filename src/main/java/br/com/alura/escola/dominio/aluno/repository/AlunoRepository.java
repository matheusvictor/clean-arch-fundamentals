package br.com.alura.escola.dominio.aluno.repository;

import br.com.alura.escola.dominio.aluno.entities.Aluno;
import br.com.alura.escola.dominio.aluno.valueobjects.Cpf;

import java.util.List;

public interface AlunoRepository {

    void matricular(Aluno aluno);

    Aluno buscarPorCpf(Cpf cpf);

    List<Aluno> listarAlunosMatriculados();

}
