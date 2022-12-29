package br.com.alura.escola.infra.aluno;

import br.com.alura.escola.dominio.aluno.entities.Aluno;
import br.com.alura.escola.dominio.aluno.exceptions.AlunoNaoEncontradoException;
import br.com.alura.escola.dominio.aluno.repository.AlunoRepository;
import br.com.alura.escola.dominio.aluno.valueobjects.Cpf;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosEmMemoria implements AlunoRepository {

    private List<Aluno> alunosMatriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        this.alunosMatriculados.add(aluno);
    }

    @Override
    public Aluno buscarPorCpf(Cpf cpf) {
        return this.alunosMatriculados.stream()
                .filter(aluno -> aluno.getCpf().equals(cpf.getNumero()))
                .findFirst()
                .orElseThrow(() -> new AlunoNaoEncontradoException(cpf));

    }

    @Override
    public List<Aluno> listarAlunosMatriculados() {
        return this.alunosMatriculados;
    }

}
