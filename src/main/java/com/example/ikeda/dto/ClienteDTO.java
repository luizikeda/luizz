package com.example.ikeda.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class ClienteDTO {

    String cep;

    String cpf;

    String email;

    String estado;

    String telefone;

    @JsonFormat(pattern = "dd-MM-yyyy")
    Date data_nascimento;

    public ClienteDTO(Object[] obj) throws ParseException {
        this.cep = Objects.nonNull(obj[0]) ? obj.toString() : "";
        this.cpf = Objects.nonNull(obj[1]) ? obj.toString() : "";
        this.email = Objects.nonNull(obj[2]) ? obj.toString() : "";
        this.estado = Objects.nonNull(obj[3]) ? obj.toString() : "";
        this.telefone = Objects.nonNull(obj[4]) ? obj.toString() : "";
        this.data_nascimento = Objects.isNull(obj[5]) ? null : new SimpleDateFormat("yyyy-MM-dd").parse(obj[5].toString());
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
}
