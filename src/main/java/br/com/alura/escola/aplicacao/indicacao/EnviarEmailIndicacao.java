package br.com.alura.escola.aplicacao.indicacao;

import br.com.alura.escola.dominio.aluno.entities.Aluno;

public interface EnviarEmailIndicacao {

    void enviarPara(Aluno alunoIndicado);
}
