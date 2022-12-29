package br.com.alura.escola.dominio.aluno.exceptions;

import br.com.alura.escola.dominio.aluno.valueobjects.Cpf;

public class AlunoNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AlunoNaoEncontradoException(Cpf cpf) {
        super("Não foi possível encontrar o aluno com CPF " + cpf.getNumero());
    }
}
