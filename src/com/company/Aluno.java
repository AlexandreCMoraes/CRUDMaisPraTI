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
        return "nome:"+nome +", telefone:" + telefone + ", data de nascimento:"+formatador.format(dataNascimento)+", data de cadastro:"
                + formatador.format(dataCadPessoa)+ ", data ultima alteracao: "+ (dataUltimaAlt==null?"":
                formatador.format(dataUltimaAlt))+ ", nota final do curso:"+notaFinalCurso;
    }
}
