package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    //PEGAR DADOS INSERIDOS
    static Scanner scanner = new Scanner(System.in);
    //ARRAY COM OS DADOS DE PESSOA
    static List<Pessoa> pessoas = new ArrayList<Pessoa>();
    //ARRAY COM OS DADOS DE ALUNO
    static List<Aluno> alunos = new  ArrayList<Aluno>();
    //ARRAY PARA ADD OS DOIS ACIMA EM UM SOMENTE
    static List listaDeCadastrados = new ArrayList();

    public static void main(String[] args) {
        //ARRAY PRA GUARDAR INFO DAS CLASSES

        boolean continuar = true;

        System.out.println("\nBEM VINDO AO CRUD DO +PraTi\n");
        //DENTRO DE LOOP PARA ENQUANTO USUARIO ESCOLHER SUAS ACOES, IR PARA TELA SEGUINTE OU PRINCIPAL OU ATE
        // ENCERRAR PROGRAMA
        do {
                System.out.println("==============================");
                System.out.println("""
                        O que você gostaria de fazer?
                        Entre com o valor correspondente:\s
                        1 - Cadastrar Pessoas/Alunos
                        2 - Listar Pessoas/Alunos
                        3 - Atualizar Dados
                        4 - Remover Pessoas/Alunos
                        5 - Encerrar Programa""");
                //LEITURA DE DADOS
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
                        System.out.println("Encerrando Programa...");
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

    //METODO CADASTRAR PESSOA OU IDENTIFICAR SE FOR COM NOTA, COLOCAR EM ALUNO
    private static void cadastrar() {
        //COLOCADO DENTRO DE VERIFICACAO DE DADOS
        try {
            //DADOS PEDIDOS DA CLASSES
            System.out.println("Entre com o Nome:");
            String nome = scanner.nextLine();
            System.out.println("Entre com o Telefone (somente números sem DDD):");
            Long telefone = Long.valueOf(scanner.nextLine());
            System.out.println("Entre com a data de nascimento (DD/MM/YYYY):");
            String data = scanner.nextLine();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date dataNascimento = df.parse(data);
            //FIM DADOS DE PESSOA, ABAIXO ENTRA NOS DADOS ALUNO SE TIVER NOTA
            System.out.println("Deseja entrar com nota do curso?\n1 - sim\n2 - não");
            //VERIFICADO SE É ALUNO COM CONDICAO
            int isAluno = Integer.parseInt(scanner.nextLine());
            if (isAluno == 1) {
                System.out.println("Entre com a nota do curso:");
                int nota = Integer.parseInt(scanner.nextLine());
                //AO COLOCAR NOTA, INSERE NO ARRAY ALUNO NA PROXIMA LINHA
                Aluno aluno = new Aluno(nome, telefone, dataNascimento, nota);
                //AO COLOCAR NOTA, INSERE NO ARRAY ALUNO
                alunos.add(aluno);
                System.out.println("Aluno Cadastrado com Sucesso!\n");
            } else if (isAluno == 2) {
                //AO DIGITAR 2, INSERE DADOS NO ARRAY PESSOA
                Pessoa pessoa = new Pessoa(nome, telefone, dataNascimento);
                pessoas.add(pessoa);
                System.out.println("Pessoa Cadastrada com Sucesso!\n");
            } else {
                //QUANDO DADO DIGITADO FOR VERDADEIRO,OU SEJA,INVALIDO, ENTRA NA CORRECAO
                boolean invalido = true;
                while (invalido) {
                    System.out.println("""
                            Opção inválida! Entre com:\s
                            1 - Para adicionar nota do curso
                            2 - Para concluir o cadastro""");
                    isAluno = Integer.parseInt(scanner.nextLine());
                    if (isAluno == 1) {
                        System.out.println("Entre com a nota do curso:");
                        int nota = Integer.parseInt(scanner.nextLine());
                        Aluno aluno = new Aluno(nome, telefone, dataNascimento, nota);
                        alunos.add(aluno);
                        System.out.println("Aluno Cadastrado com Sucesso!\n");
                        invalido = false;
                    } else if (isAluno == 2) {
                        Pessoa pessoa = new Pessoa(nome, telefone, dataNascimento);
                        pessoas.add(pessoa);
                        System.out.println("Pessoa Cadastrada com Sucesso!\n");
                        invalido = false;
                    }
                }
            }

            //SE HOUVER ALGUM ERRO, A MSG É MOSTRADA
        } catch (Exception e) {
            System.out.println("Ocorreu um erro! Vamos tentar novamente?!");
        }
    }

    //LISTAR TODOS OS DADOS DE PESSOAS E ALUNOS
    public static void listar() {
        try{
        //ARRAY PARA GUARDAR ARRAY DE PESSOA E ALUNO NO MESMO
        listaDeCadastrados = new ArrayList();
        //COLOCAR ALUNOS E PESSOAS NO ARRAY listaDeCadastrados
        listaDeCadastrados.addAll(alunos);
        listaDeCadastrados.addAll(pessoas);
        //PERCORRER A listaDeCadastrados COM OS ARRAYS DE PESSOA E ALUNO DENTRO E MOSTRANDO A LISTA DEPOIS DE
            // COLOCADAS DENTRO DE listaDeCadastrados
            System.out.println("\n=============================");
            System.out.println("Lista de Pessoas e Alunos\n");
        for(int i = 0; i < listaDeCadastrados.size(); i++){
            System.out.println("REGISTRO " + i + listaDeCadastrados.get(i).toString());
        }
        }catch (Exception e) {
            System.out.println("Ocorreu um erro! Vamos tentar novamente?!");
            }
        System.out.println("Fim da lista\n");

    }
    //ALTERAR DADOS COMO NOME, DATA DE NASC, ...E NOTA SE FOR ALUNO
    public static void alterar() {
        //IDENTIFICAR O INDICE E TRAZER A INFO DO CADASTRO DO ARRAY CORRESPONDENTE PESSOA OU ALUNO
        try {
            Aluno aluno;
            Pessoa pessoa;
            System.out.println("\n===================================================================");
            System.out.println("Entre com o valor correspondente ao registro que deseja ATUALIZAR");
            listar();
            int idAluno = Integer.parseInt(scanner.nextLine());

            if (alunos.contains(listaDeCadastrados.get(idAluno))) {
                int index = alunos.indexOf(listaDeCadastrados.get(idAluno));
                aluno = alterarAluno(alunos.get(index));
                alunos.set(index, aluno);
            } else {
                int index = pessoas.indexOf(listaDeCadastrados.get(idAluno));
                pessoa = alterarPessoa(pessoas.get(index));
                pessoas.set(index, pessoa);
            }

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro! Vamos tentar novamente?!");
        }
    }

    //ALTERAR DADOS COMO NOME, DATA DE NASC, ...E NOTA SE FOR ALUNO
    private static Aluno alterarAluno(Aluno pessoa) {
        try {
            int continuar = 1;
            do {
            System.out.println("""
                    Digite:
                    1 - Para atualizar nome
                    2 - Para atualizar telefone
                    3 - Para atualizar data de nascimento\s
                    4 - Para atualizar nota final do curso""");
            int informacao = Integer.parseInt(scanner.nextLine());
                switch (informacao) {
                    case 1 -> {
                        System.out.println("Digite o nome:");
                        String nome = scanner.nextLine();
                        pessoa.setNome(nome);
                        System.out.println("""
                                Deseja alterar mais alguma informação do mesmo usuário?\s
                                 1 - sim
                                 2 - não""");
                        continuar = Integer.parseInt(scanner.nextLine());

                    }
                    case 2 -> {
                        System.out.println("Digite o telefone:");
                        Long telefone = Long.valueOf(scanner.nextLine());
                        pessoa.setTelefone(telefone);
                        System.out.println("""
                                Deseja alterar mais alguma informação do mesmo usuário?\s
                                 1 - sim
                                 2 - não""");
                        continuar = Integer.parseInt(scanner.nextLine());
                    }
                    case 3 -> {
                        System.out.println("Digite a data de nascimento:");
                        String data = scanner.nextLine();
                        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        Date dataNascimento = df.parse(data);
                        pessoa.setDataNascimento(dataNascimento);
                        System.out.println("""
                                Deseja alterar mais alguma informação do mesmo usuário?\s
                                 1 - sim
                                 2 - não""");
                        continuar = Integer.parseInt(scanner.nextLine());
                    }
                    case 4 -> {
                        System.out.println("Digite a nota final:");
                        int notaFinal = Integer.parseInt(scanner.nextLine());
                        pessoa.setNotaFinalCurso(notaFinal);
                        System.out.println("""
                                Deseja alterar mais alguma informação do mesmo usuário?\s
                                 1 - sim
                                 2 - não""");
                        continuar = Integer.parseInt(scanner.nextLine());
                    }
                }

            } while (continuar == 1);
            pessoa.setDataUltimaAlt(new Date());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro! Vamos tentar novamente?!");
        }
        System.out.println("Pessoa ou aluno alterado com sucesso!\n");
        return pessoa;

    }

    //ALTERAR DADOS COMO NOME, DATA DE NASC ...
    private static Pessoa alterarPessoa(Pessoa pessoa) {
        try {
            int continuar = 1;
            do {
            System.out.println("""
                    Digite:
                    1 - Para atualizar nome
                    2 - Para atualizar telefone\s
                    3 - Para atualizar data de nascimento""");
            int informacao = Integer.parseInt(scanner.nextLine());

                switch (informacao) {
                    case 1 -> {
                        System.out.println("Digite o nome:");
                        String nome = scanner.nextLine();
                        pessoa.setNome(nome);
                        System.out.println("""
                                Deseja alterar mais alguma informação do mesmo usuário?\s
                                 1 - sim
                                 2 - não""");
                        continuar = Integer.parseInt(scanner.nextLine());
                    }
                    case 2 -> {
                        System.out.println("Digite o telefone:");
                        Long telefone = Long.valueOf(scanner.nextLine());
                        pessoa.setTelefone(telefone);
                        System.out.println("""
                                Deseja alterar mais alguma informação do mesmo usuário?\s
                                 1 - sim
                                 2 - não""");
                        continuar = Integer.parseInt(scanner.nextLine());
                    }
                    case 3 -> {
                        System.out.println("Digite a data de nascimento:");
                        String data = scanner.nextLine();
                        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        Date dataNascimento = df.parse(data);
                        pessoa.setDataNascimento(dataNascimento);
                        System.out.println("""
                                Deseja alterar mais alguma informação do mesmo usuário?\s
                                 1 - sim
                                 2 - não""");
                        continuar = Integer.parseInt(scanner.nextLine());
                    }
                }

            } while (continuar == 1);
            pessoa.setDataUltimaAlt(new Date());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro! Vamos tentar novamente?!");

        }
        System.out.println("Pessoa ou aluno alterado com sucesso!\n");
        return pessoa;
    }

    //DELETAR USUARIO COM VALOR DE RESGISTRO COMENÇANDO EM 0
    public static void deletar() {
        try{
        System.out.println("\n=================================================================");
        System.out.println("Entre com o valor correspondente ao registro que deseja REMOVER");
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
            System.out.println("Ocorreu um erro! Vamos tentar novamente?!");
        }
        System.out.println("Pessoa ou Aluno removido com sucesso!\n");
    }
}
