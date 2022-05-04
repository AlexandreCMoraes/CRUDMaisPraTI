package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;
//EXTENDE OS ATRIBUTOS DE CALSSE PESSOA
public class Aluno extends Pessoa{
    int notaFinalCurso;

    //CONTRUTOR DE ALUNO COM OS ATRIBUTOS DE PESSOA COM SUPER DE PESSOA E NOVO ATRIBUTO DE ALUNO
    public Aluno(String nome, Long telefone, Date dataNascimento, int notaFinalCurso) {
        super(nome, telefone, dataNascimento);
        this.notaFinalCurso = notaFinalCurso;
    }
    //CONTRUTOR VAZIO, BOA PRATICA
    public Aluno() {
    }

    //GETTERS E SETTERS DOS ATRIBUTOS DE PESSOA
    public int getNotaFinalCurso() {
        return notaFinalCurso;
    }

    public void setNotaFinalCurso(int notaFinalCurso) {
        this.notaFinalCurso = notaFinalCurso;
    }

    //SOBRESCREVENDO OS ATRIBUTOS DATA PARA TER A FORMA CORRETA DE DATA
    @Override
    public String toString() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return "\nNome: " + nome + "\nTelefone: " + telefone + "\nData de Nascimento :" + formatador.format(dataNascimento) +
                "\nData de Cadastro: "
                + formatador.format(dataCadPessoa) + "\nData Última Alteracao: " + (dataUltimaAlt==null?"":
                formatador.format(dataUltimaAlt)) + "\nNota Final do Curso: " + notaFinalCurso + "\n";
    }
}
