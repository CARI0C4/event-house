package com.mycompany.eventos;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Classe que gerencia eventos, incluindo compra de ingressos,
 * registro de participantes e controle de acesso.
 * 
 * @author Userb
 */
public class Eventos {

    /** Mapa que armazena os ingressos com o nome do cliente como chave e o código como valor */
    private Map<String, String> ingressos = new HashMap<>();

    /**
     * Verifica se o cliente pode comprar ingressos com base na idade e nome.
     *
     * @param nome Nome do cliente
     * @param idade Idade do cliente
     * @param idadelim Idade mínima permitida
     * @return Mensagem indicando se a compra é permitida ou não
     */
    public String compraIngressos(String nome, int idade, int idadelim) {
        if (!(nome.isEmpty() && idade >= idadelim))
            return "Compra de ingressos permitidos";
        else
            return "Você não atende aos quesitos necessários para o evento";
    }

    /**
     * Testa a presença do cliente no evento com base no código.
     *
     * @param codigo Código do ingresso do cliente
     * @param resposta Valor booleano de resposta inicial
     * @param codigoEsperado Código esperado para validação
     * @return true se o código for igual ao esperado, false caso contrário
     */
    public boolean presencaEventoTeste(String codigo, boolean resposta, String codigoEsperado) {
        if (codigo.equals(codigoEsperado))
            resposta = true;
        else
            resposta = false;
        return resposta;
    }

    /**
     * Registra um cliente em um arquivo e no mapa de ingressos.
     *
     * @param nome Nome do cliente
     * @param codigo Código do ingresso
     * @param arquivo Arquivo onde será salvo o registro
     * @return Mensagem indicando se o salvamento foi bem-sucedido ou se ocorreu erro
     * @throws IOException Caso ocorra erro de escrita no arquivo
     */
    public String registro(String nome, String codigo, String arquivo) throws IOException {
        ingressos.put(nome, codigo);
        try (FileWriter fw = new FileWriter(arquivo)) {
            fw.write(nome + "--" + codigo + System.lineSeparator());
            System.out.println("Escrita bem sucedida");
            return "Salvamento bem sucedido";
        } catch (IOException e) {
            System.out.println("Erro");
            return "Erro";
        }
    }

    /**
     * Verifica se o cliente está presente no arquivo pelo nome.
     *
     * @param nome Nome do cliente
     * @param arquivo Arquivo de registros
     * @param sc Scanner para leitura do arquivo
     * @return true se o cliente estiver presente, false caso contrário
     */
    public boolean acessoClienteNome(String nome, String arquivo, Scanner sc) {
        while (sc.hasNext()) {
            String linha = sc.nextLine();
            String[] dados = linha.split("\n");
            if (dados.length >= 1) {
                String nomeComp = dados[0].trim();
                if (nome.equalsIgnoreCase(nomeComp))
                    return true;
                else
                    return false;
            }
        }
        return false;
    }

    /**
     * Confirma se o nome do cliente está na lista esperada.
     *
     * @param nome Nome do cliente
     * @param nomeEsperado Nome esperado
     * @return Mensagem indicando se a presença foi confirmada ou não
     */
    public String acessoClinteNomeEsperado(String nome, String nomeEsperado) {
        if (nome.equalsIgnoreCase(nomeEsperado))
            return "Presença confirmada";
        else
            return "Seu nome não consta na lista";
    }

    /**
     * Verifica se o cliente está presente no arquivo pelo código.
     *
     * @param codigo Código do ingresso
     * @param arquivo Arquivo de registros
     * @param sc Scanner para leitura do arquivo
     * @return true se o código estiver presente, false caso contrário
     */
    public boolean acessoClienteCodigo(String codigo, String arquivo, Scanner sc) {
        while (sc.hasNext()) {
            String linha = sc.nextLine();
            String[] dados = linha.split("\n");
            if (dados.length >= 1) {
                String codigoComp = dados[0].trim();
                if (codigo.equalsIgnoreCase(codigoComp))
                    return true;
                else
                    return false;
            }
        }
        return false;
    }

    /**
     * Testa a presença do cliente via código.
     *
     * @param codigo Código do cliente
     * @param codigoEsperado Código esperado
     * @return Mensagem indicando se a presença foi confirmada
     */
    public String acessoClientCodigoTeste(String codigo, String codigoEsperado) {
        if (codigo.matches(codigoEsperado))
            return "Presença confirmada via codigo";
        else
            return "Código não consta na lista";
    }

    /**
     * Verifica acesso restrito com código e nível de permissão.
     *
     * @param codigo Código do cliente
     * @param nivel Nível de permissão
     * @param sc Scanner do arquivo
     * @return Mensagem indicando se o acesso é autorizado ou negado
     */
    public String acessoRestrito(String codigo, String nivel, Scanner sc) {
        while (sc.hasNext()) {
            String linha = sc.nextLine();
            String[] dados = linha.split(",");
            if (dados.length >= 2) {
                String codigoComp = dados[0].trim();
                String nivelPermt = dados[1].trim();
                if (codigo.equalsIgnoreCase(codigoComp) && nivel.equalsIgnoreCase(nivelPermt))
                    return "Acesso autorizado";
                else
                    return "Acesso negado";
            }
        }
        return "\n";
    }

    /**
     * Testa acesso restrito com código e nível esperados.
     *
     * @param codigo Código do cliente
     * @param nivel Nível de permissão
     * @param codigoEsperado Código esperado
     * @param nivelEsperado Nível esperado
     * @return Mensagem indicando se o acesso foi autorizado
     */
    public String acessoRestritoTeste(String codigo, int nivel, String codigoEsperado, int nivelEsperado) {
        if (codigo.matches(codigoEsperado) && nivel == nivelEsperado)
            return "Acesso autorizado";
        else
            return "Acesso negado";
    }

    /**
     * Cria chaves de acesso aleatórias e grava em arquivo.
     *
     * @param limite Quantidade de chaves a gerar
     * @param destinoArquivo Arquivo destino
     * @return Mensagem indicando sucesso ou erro na geração
     */
    public String criarAcessos(int limite, String destinoArquivo) {
        Random rd = new Random();
        try (FileWriter fw = new FileWriter(destinoArquivo)) {
            for (int i = 0; i < limite; i++) {
                int num = rd.nextInt(9);
                fw.write(num);
                fw.write(System.lineSeparator());
            }
            return "Gerador finalizado";
        } catch (IOException e) {
            return "Erro ao gerar chaves de acesso";
        }
    }

    /**
     * Exibe informações sobre o evento e aguarda confirmação.
     *
     * @param cliente Nome do cliente
     * @param convidados Limite de convidados
     * @param valor Valor do ingresso
     * @param nomeEvento Nome do evento
     * @param sc Scanner para leitura
     * @param idadeLimite Idade mínima permitida
     * @return Mensagem de status
     */
    public String ComprarEvento(String cliente, int convidados, float valor, String nomeEvento, Scanner sc, int idadeLimite) {
        System.out.println(nomeEvento);
        System.out.printf("R$%.3f", valor);
        System.out.println("Limite de convidados:" + convidados);
        System.out.println("Idade Limite:" + idadeLimite);
        return "Aguardando confirmação do sistema...";
    }

    /**
     * Confirmação do administrador.
     *
     * @param resposta Resposta do administrador
     * @return true se a resposta for "Sim", false caso contrário
     */
    public boolean confirmacaoADM(String resposta) {
        return resposta.equalsIgnoreCase("Sim");
    }

    /**
     * Confirmação do cliente.
     *
     * @param resposta Resposta do cliente
     * @return true se a resposta for "Sim", false caso contrário
     */
    public boolean confirmacaoCliente(String resposta) {
        return resposta.equalsIgnoreCase("Sim");
    }
}



