package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

public class Pessoa {

    String nome;
    Long telefone;
    Date dataNascimento;
    Date dataCadPessoa;
    Date dataUltimaAlt;

    //CONSTRUTOR DA CLASSE PESSOA
    public Pessoa(String nome, Long telefone, Date dataNascimento) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.dataCadPessoa = new Date();
    }

    //CONTRUTOR VAZIO,
    public Pessoa() {
    }

    public static void cadastrar(String pessoa) {
        System.out.println(pessoa);

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCadPessoa() {
        return dataCadPessoa;
    }

    public void setDataCadPessoa(Date dataCadPessoa) {
        this.dataCadPessoa = dataCadPessoa;
    }

    public Date getDataUltimaAlt() {
        return dataUltimaAlt;
    }

    public void setDataUltimaAlt(Date dataUltimaAlt) {
        this.dataUltimaAlt = dataUltimaAlt;
    }
    @Override
    public String toString() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return "nome:"+nome +", telefone:" + telefone + ", data de nascimento:"+formatador.format(dataNascimento)+", data de cadastro:"
                + formatador.format(dataCadPessoa)+ "data ultima alteracao: "+ (dataUltimaAlt==null?"":
                formatador.format(dataUltimaAlt));
    }
}
