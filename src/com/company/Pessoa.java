package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;


//CRIADO CLASSE PESSOA PARA TER OS DADOS NECESSARIOS PARA CADASTRO
public class Pessoa {
    //DADOS QUE A CLASSE PESSOA TERA
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

    //CONTRUTOR VAZIO, BOA PRATICA
    public Pessoa() {
    }

    public static void cadastrar(String pessoa) {
        System.out.println(pessoa);
    }

    //GETTERS E SETTERS DOS ATRIBUTOS DE PESSOA
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

    //SOBRESCREVENDO OS ATRIBUTOS DATA PARA TER A FORMA CORRETA DE DATA
    @Override
    public String toString() {
        //FAZENDO COM QUE DATA TENHA ESSES VALORES PADRAO
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return "\nNome: " + nome + "\nTelefone: " + telefone + "\nData de Nascimento: " + formatador.format(dataNascimento) +
                "\nData de Cadastro: "
                + formatador.format(dataCadPessoa) + "\nData Última Alteracao: " + (dataUltimaAlt==null?"":
                formatador.format(dataUltimaAlt)) + "\n";
    }
}
