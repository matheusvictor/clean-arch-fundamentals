package escola;

import escola.entities.Aluno;

import java.time.LocalDate;

public class Indicacao {

    private Aluno indicado;
    private Aluno indicante;
    private LocalDate dataIndicacao;

    public Indicacao(Aluno indicado, Aluno indicante) {
        this.indicado = indicado;
        this.indicante = indicante;
        this.dataIndicacao = LocalDate.now();
    }

    public Aluno getIndicado() {
        return indicado;
    }

    public Aluno getIndicante() {
        return indicante;
    }

    public LocalDate getDataIndicacao() {
        return dataIndicacao;
    }
}
