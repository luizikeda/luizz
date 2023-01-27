package com.example.luizz.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "index")
public class IndexModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O email é obrigatório")
    private String email;

    @NotNull(message = "A senha é obrigatória")
    private String senha;

    @NotNull(message = "O endereço é obrigatório")
    private String endereco;

    @NotNull(message = "O número é obrigatório")
    private String numero;

    @NotNull(message = "O CPF é obrigatório")
    private String cpf;

    @NotNull(message = "O telefone é obrigatório")
    private String telefone;

    @NotNull(message = "A cidade é obrigatório")
    private String cidade;

    @NotNull(message = "O estado é obrigatório")
    private String estado;

    @NotNull(message = "O CEP é obrigatório")
    private String cep;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
