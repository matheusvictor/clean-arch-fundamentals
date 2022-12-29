package br.com.alura.escola.dominio.aluno.services;

public interface EncriptadorDeSenha {

    String encriptar(String senha);

    boolean validarSenhaCriptografada(String senhaCriptografada, String senha);
}
