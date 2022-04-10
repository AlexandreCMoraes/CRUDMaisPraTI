package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static List<Pessoa> pessoas = new ArrayList<Pessoa>();
    static List<Aluno> alunos = new  ArrayList<Aluno>();
    static List listaDeCadastrados = new ArrayList();

    public static void main(String[] args) {
        //ARRAY PRA GUARDAR INFO DAS CLASSES

        boolean continuar = true;


        System.out.println("Bem Vindo ao CRUD do +PraTi");
        do {
                System.out.println("===============================");
                System.out.println("""
                        O que você gostaria de fazer?
                        Entre com o valor correspondente:\s
                        1 - Cadastrar
                        2 - Listar Pessoas/Alunos
                        3 - Atualizar dados
                        4 - Deletar
                        5 - Encerrar""");
                int entrada = Integer.parseInt(scanner.nextLine());

                switch (entrada) {
                    case 1 -> {
                        cadastrar();
                        break;
                    }
                    case 2 -> {
                        listar();
                        break;
                    }
                    case 3 -> {
                        alterar();
                        break;
                    }
                    case 4 -> {
                        deletar() ;
                        break;
                    }
                    case 5 -> {
                        System.out.println("Encerrando...");
                        continuar = false;
                        break;
                    }
                }


            }

        while(continuar);
    }
//    private static void cadastrar(){
//        System.out.println("Entre com o nome");
//        Scanner scanner = new Scanner(System.in);
//        String nome = scanner.nextLine();
//        System.out.println(nome);
//    }


    private static void cadastrar() {
        try {
            System.out.println("entre com o Nome");
            String nome = scanner.nextLine();
            System.out.println("Entre com o Telefone - somente números");
            Long telefone = Long.valueOf(scanner.nextLine());
            System.out.println("entre com a data de nascimento (DD/MM/YYYY)");
            String data = scanner.nextLine();
            Date dataNascimento = new Date(data);
            System.out.println("Deseja entrar com nota do curso:\n1 - sim\n2 - não");
            int isAluno = Integer.parseInt(scanner.nextLine());
            if (isAluno == 1) {
                System.out.println("Entre com a nota do curso");
                int nota = Integer.parseInt(scanner.nextLine());
                Aluno aluno = new Aluno(nome, telefone, dataNascimento, nota);
                alunos.add(aluno);
                System.out.println("Aluno Cadastrado com sucesso!");
            } else if (isAluno == 2) {
                Pessoa pessoa = new Pessoa(nome, telefone, dataNascimento);
                pessoas.add(pessoa);
                System.out.println("Pessoa Cadastrada com sucesso!");
            } else {
                boolean invalido = true;
                while (invalido) {
                    System.out.println("Opção invalida! Entre com: \n1 - para adicionar nota do curso"+
                            "\n2 - para concluir o cadastro");
                    isAluno = Integer.parseInt(scanner.nextLine());
                    if (isAluno == 1) {
                        System.out.println("Entre com a nota do curso");
                        int nota = Integer.parseInt(scanner.nextLine());
                        Aluno aluno = new Aluno(nome, telefone, dataNascimento, nota);
                        alunos.add(aluno);
                        System.out.println("Aluno Cadastrado com sucesso!");
                        invalido = false;
                    } else if (isAluno == 2) {
                        Pessoa pessoa = new Pessoa(nome, telefone, dataNascimento);
                        pessoas.add(pessoa);
                        System.out.println("Pessoa Cadastrada com sucesso!");
                        invalido = false;

                    }
                }
            }


        } catch (Exception e) {
            System.out.println("Ocorreu um erro! Vamos tentar novamente");
        }
    }

    public static void listar() {
        try{
        listaDeCadastrados = new ArrayList();
        listaDeCadastrados.addAll(alunos);
        listaDeCadastrados.addAll(pessoas);
        for(int i = 0; i < listaDeCadastrados.size(); i++){
            System.out.println(i + "-"+  listaDeCadastrados.get(i).toString());
        }}
        catch (Exception e) {
                System.out.println("Ocorreu um erro! Vamos tentar novamente");
            }
    }
    public static void alterar() {
        try {
            boolean isAluno;
            Aluno aluno;
            Pessoa pessoa;
            System.out.println("Entre com o valor correspondente ao registro que deseja atualizar");
            listar();
            int idAluno = Integer.parseInt(scanner.nextLine());

            if (alunos.contains(listaDeCadastrados.get(idAluno))) {
                isAluno = true;
                int index = alunos.indexOf(listaDeCadastrados.get(idAluno));
                aluno = alterarAluno(alunos.get(idAluno));
                alunos.set(index, aluno);
            } else {
                isAluno = false;
                int index = pessoas.indexOf(listaDeCadastrados.get(idAluno));
                pessoa = alterarPessoa(pessoas.get(idAluno));
                pessoas.set(index, pessoa);
            }

        }catch (Exception e) {
            System.out.println("Ocorreu um erro! Vamos tentar novamente");
        }
    }

    private static Aluno alterarAluno(Aluno pessoa) {
        try {
            int continuar = 1;
            do {
            System.out.println("""
                    Digite:
                    1 - para atualizar nome
                    2 - para telefone
                    3 - para data de nascimento\s
                    4 - para nota final do curso""");
            int informacao = Integer.parseInt(scanner.nextLine());
                switch (informacao) {
                    case 1 -> {
                        System.out.println("Digite o nome");
                        String nome = scanner.nextLine();
                        pessoa.setNome(nome);
                        System.out.println("deseja alterar mais alguma informação do mesmo usuário? Digite 1 para sim, 2 para" +
                                " não");
                        continuar = Integer.parseInt(scanner.nextLine());

                    }
                    case 2 -> {
                        System.out.println("Digite o telefone");
                        Long telefone = Long.valueOf(scanner.nextLine());
                        pessoa.setTelefone(telefone);
                        System.out.println("deseja alterar mais alguma informação do mesmo usuário? Digite 1 para sim, 2 para" +
                                " não");
                        continuar = Integer.parseInt(scanner.nextLine());
                    }
                    case 3 -> {
                        System.out.println("Digite a data de nascimento");
                        String data = scanner.nextLine();
                        Date dataNascimento = new Date(data);
                        pessoa.setDataNascimento(dataNascimento);
                        System.out.println("deseja alterar mais alguma informação do mesmo usuário? Digite 1 para sim, 2 para" +
                                " não");
                        continuar = Integer.parseInt(scanner.nextLine());
                    }
                    case 4 -> {
                        System.out.println("Digite a nota final");
                        int notaFinal = Integer.parseInt(scanner.nextLine());
                        pessoa.setNotaFinalCurso(notaFinal);
                        System.out.println("deseja alterar mais alguma informação do mesmo usuário? Digite 1 para sim, 2 para" +
                                " não");
                        continuar = Integer.parseInt(scanner.nextLine());
                    }
                }

            } while (continuar == 1);
            pessoa.setDataUltimaAlt(new Date());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro! Vamos tentar novamente");

        }
        return pessoa;

    }


    private static Pessoa alterarPessoa(Pessoa pessoa) {
        try {
            System.out.println("""
                    Digite:
                    1 - para atualizar nome
                    2 - para telefone\s
                    3 - para data de nascimento""");
            int informacao = Integer.parseInt(scanner.nextLine());
            int continuar = 1;
            do {
                switch (informacao) {
                    case 1 -> {
                        System.out.println("Digite o nome");
                        String nome = scanner.nextLine();
                        pessoa.setNome(nome);
                        System.out.println("deseja alterar mais alguma informação do mesmo usuário? Digite 1 para sim, 2 para" +
                                " não");
                        continuar = Integer.parseInt(scanner.nextLine());

                    }
                    case 2 -> {
                        System.out.println("Digite o telefone");
                        Long telefone = Long.valueOf(scanner.nextLine());
                        pessoa.setTelefone(telefone);
                        System.out.println("deseja alterar mais alguma informação do mesmo usuário? Digite 1 para sim, 2 para" +
                                " não");
                        continuar = Integer.parseInt(scanner.nextLine());
                    }
                    case 3 -> {
                        System.out.println("Digite a data de nascimento");
                        String data = scanner.nextLine();
                        Date dataNascimento = new Date(data);
                        pessoa.setDataNascimento(dataNascimento);
                        System.out.println("deseja alterar mais alguma informação do mesmo usuário? Digite 1 para sim, 2 para" +
                                " não");
                        continuar = Integer.parseInt(scanner.nextLine());
                    }
                }

            } while (continuar == 1);
            pessoa.setDataUltimaAlt(new Date());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro! Vamos tentar novamente");

        }
        return pessoa;
    }


    public static void deletar() {
        try{
        System.out.println("Entre com o valor correspondente ao registro que deseja remover");
        listar();
        int idAluno = Integer.parseInt(scanner.nextLine());
        while(idAluno>= listaDeCadastrados.size()|| idAluno<0){

            System.out.println("Valor inválido, entre com o valor correspondente ao registro que deseja remover");
            idAluno = Integer.parseInt(scanner.nextLine());
        }
            if (alunos.contains(listaDeCadastrados.get(idAluno))) {
                int index = alunos.indexOf(listaDeCadastrados.get(idAluno));
                alunos.remove(index);
            } else {
                int index = pessoas.indexOf(listaDeCadastrados.get(idAluno));
                pessoas.remove(index);
            }

    }catch (Exception e) {
            System.out.println("Ocorreu um erro! Vamos tentar novamente");

        }
    }

}
