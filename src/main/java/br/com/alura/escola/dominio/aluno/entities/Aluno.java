package br.com.alura.escola.dominio.aluno.entities;

import br.com.alura.escola.dominio.aluno.valueobjects.Cpf;
import br.com.alura.escola.dominio.aluno.valueobjects.Email;
import br.com.alura.escola.dominio.aluno.valueobjects.Telefone;

import java.util.List;
import java.util.ArrayList;

public class Aluno {

    private Cpf cpf;
    private String nome;
    private Email email;
    private String senha;
    private final List<Telefone> telefones = new ArrayList<>();

    public Aluno(Cpf cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public void adicionarTelefone(Telefone telefone) {
        //TODO
    }

    public void adicionarTelefone(String ddd, String numero) {
        this.telefones.add(new Telefone(ddd, numero));
    }

    public String getCpf() {
        return this.cpf.getNumero();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email.getEndereco();
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }
}
