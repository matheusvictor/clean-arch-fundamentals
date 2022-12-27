package escola.valueobjects;

public class Cpf {

    private String numero;

    public Cpf(String numero) {
        if (numero == null ||
                !numero.matches("([0-9]{3}[\\.][0-9]{3}[\\.][0-9]{3}[-][0-9]{2})")) {
            // CPF precisa estar no formato XXX.XXX.XXX-XX
            throw new IllegalArgumentException("CPF inválido!");
        }
        this.numero = numero;
    }
}
