package br.com.alura.escola.infra.indicacao;

import br.com.alura.escola.dominio.aluno.entities.Aluno;
import br.com.alura.escola.aplicacao.indicacao.EnviarEmailIndicacao;

public class EnviarEmailIndicacaoJavaMail implements EnviarEmailIndicacao {

    @Override
    public void enviarPara(Aluno alunoIndicado) {
        //TODO: implementar regra para envio de e-email
    }
}
