package escola.valueobjects;

public class Telefone {

    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero) {

        if (ddd == null) {
            throw new IllegalArgumentException("DDD precisa ser informado!");
        }
        if (numero == null) {
            throw new IllegalArgumentException("Número precisa ser informado!");
        }

        if (!ddd.matches("^\\d{2}$")) {
            throw new IllegalArgumentException("DDD inválido!");
        }

        if (!numero.matches("^\\d{8}|\\d{9}$")) {
            throw new IllegalArgumentException("Número inválido!");
        }

        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }

}
