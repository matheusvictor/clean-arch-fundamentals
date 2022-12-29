package br.com.alura.escola.infra.aluno;

import br.com.alura.escola.dominio.aluno.entities.Aluno;
import br.com.alura.escola.dominio.aluno.valueobjects.Cpf;
import br.com.alura.escola.dominio.aluno.repository.AlunoRepository;
import br.com.alura.escola.dominio.aluno.valueobjects.Telefone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RepositorioDeAlunos implements AlunoRepository {

    private final Connection connection;

    public RepositorioDeAlunos(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        String sqlQuery = "INSERT INTO aluno VALUES(?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, aluno.getCpf());
            preparedStatement.setString(2, aluno.getNome());
            preparedStatement.setString(3, aluno.getEmail());
            preparedStatement.execute();

            sqlQuery = "INSER INTO telefones VALUES(?, ?)";
            preparedStatement = connection.prepareStatement(sqlQuery);

            for (Telefone telefone : aluno.getTelefones()) {
                preparedStatement.setString(1, telefone.getDdd());
                preparedStatement.setString(2, telefone.getNumero());
            }
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno buscarPorCpf(Cpf cpf) {
        // TODO: finalizar implementação
        String sqlQuery = "SELECT id, nome, email FROM aluno WHERE cpf = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, cpf.getNumero());

            ResultSet result = preparedStatement.executeQuery();
            boolean encontrouAluno = result.next();

            if (!encontrouAluno) {
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public List<Aluno> listarAlunosMatriculados() {
        // TODO: implementar
        return null;
    }

}
