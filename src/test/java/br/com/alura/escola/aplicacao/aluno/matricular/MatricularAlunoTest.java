package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.dominio.aluno.entities.Aluno;
import br.com.alura.escola.dominio.aluno.valueobjects.Cpf;
import br.com.alura.escola.infra.aluno.repository.RepositorioDeAlunosEmMemoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatricularAlunoTest {

    @Test
    void alunoDeveriaSerPersistido() {

        RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
        MatricularAluno useCase = new MatricularAluno(repositorio);

        AlunoDTO dados = new AlunoDTO(
                "123.456.789-00",
                "Fulano",
                "fulano@email.com"
        );

        useCase.executar(dados);

        Aluno alunoEncontrado = repositorio.buscarPorCpf(
                new Cpf("123.456.789-00")
        );

        assertEquals(dados.getCpf(), alunoEncontrado.getCpf());
        assertEquals(dados.getNome(), alunoEncontrado.getNome());
        assertEquals(dados.getEmail(), alunoEncontrado.getEmail());

    }

}
