package br.com.alura.escola.infra.aluno.service;

import br.com.alura.escola.dominio.aluno.services.EncriptadorDeSenha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncriptadorDeSenhaMD5Service implements EncriptadorDeSenha {

    @Override
    public String encriptar(String senha) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(senha.getBytes());
            byte[] bytes = messageDigest.digest();

            StringBuilder stringBuilder = new StringBuilder();
            for (byte aByte : bytes) {
                stringBuilder.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }

            return stringBuilder.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar hash da senha.");
        }
    }

    @Override
    public boolean validarSenhaCriptografada(String senhaCriptografada, String senha) {
        return senhaCriptografada.equals(encriptar(senha));
    }
}
