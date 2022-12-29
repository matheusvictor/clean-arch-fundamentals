package br.com.alura.escola.infra.aluno.repository;

import br.com.alura.escola.dominio.aluno.entities.Aluno;
import br.com.alura.escola.dominio.aluno.exceptions.AlunoNaoEncontradoException;
import br.com.alura.escola.dominio.aluno.valueobjects.Cpf;
import br.com.alura.escola.dominio.aluno.repository.AlunoRepository;
import br.com.alura.escola.dominio.aluno.valueobjects.Email;
import br.com.alura.escola.dominio.aluno.valueobjects.Telefone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunos implements AlunoRepository {

    private final Connection connection;

    public RepositorioDeAlunos(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {

        try {
            String sqlQuery = "INSERT INTO ALUNO VALUES(?, ?, ?)";
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

        try {
            String sqlQuery = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, cpf.getNumero());

            ResultSet result = preparedStatement.executeQuery();
            boolean encontrouAluno = result.next();

            if (!encontrouAluno) {
                throw new AlunoNaoEncontradoException(cpf);
            }

            String nomeAluno = result.getString("nome");
            Email email = new Email(result.getString("email"));

            Aluno alunoEcontrado = new Aluno(cpf, nomeAluno, email);

            long id = result.getLong("id");
            sqlQuery = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, id);
            result = preparedStatement.executeQuery();

            while (result.next()) {
                String ddd = result.getString("dddd");
                String numero = result.getString("numero");
                alunoEcontrado.adicionarTelefone(ddd, numero);
            }

            return alunoEcontrado;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> listarAlunosMatriculados() {

        try {
            String sqlQuery = "SELECT id, cpf, nome, email FROM ALUNO";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet result = preparedStatement.executeQuery();

            List<Aluno> alunos = new ArrayList<>();

            while (result.next()) {
                Cpf cpf = new Cpf(result.getString("cpf"));
                String nome = result.getString("nome");
                Email email = new Email(result.getString("email"));

                Aluno aluno = new Aluno(cpf, nome, email);

                long id = result.getLong("id");
                sqlQuery = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
                preparedStatement = connection.prepareStatement(sqlQuery);
                preparedStatement.setLong(1, id);
                result = preparedStatement.executeQuery();

                while (result.next()) {
                    String ddd = result.getString("dddd");
                    String numero = result.getString("numero");
                }

                alunos.add(aluno);
            }

            return alunos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
