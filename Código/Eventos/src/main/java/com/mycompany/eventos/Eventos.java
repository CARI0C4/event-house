/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.eventos;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Classe responsável por gerenciar eventos, ingressos, acessos
 * e validações de presença.
 * 
 * @author User
 */
public class Eventos {

    // Mapa que guarda pares: Nome -> Código do ingresso
    private Map<String, String> ingressos = new HashMap<>();


    /**
     * Verifica se o cliente pode comprar ingressos.
     * Compra liberada se nome não estiver vazio e idade for maior ou igual ao limite.
     */
    public String compraIngressos(String nome, int idade, int idadelim) {

        if (!(nome.isEmpty() && idade >= idadelim))
            return "Compra de ingressos permitidos";
        else
            return "Você não atende aos quesitos necessários para o evento";
    }


    /**
     * Teste de presença: compara dois códigos.
     * (OBS: Usa "==" para Strings, o que não é recomendado)
     */
    public boolean presencaEventoTeste(String codigo, boolean resposta, String codigoEsperado) {

        if (codigo == codigoEsperado)
            resposta = true;
        else
            resposta = false;

        return resposta;
    }


    /**
     * Registra o ingresso do cliente: grava no HashMap e salva em arquivo.
     */
    public String registro(String nome, String codigo, String arquivo) throws IOException {

        ingressos.put(nome, codigo); // Armazena internamente

        try (FileWriter fw = new FileWriter(arquivo)) {

            // Grava no arquivo no formato: nome--codigo
            fw.write(nome + "--" + codigo + System.lineSeparator());

            System.out.println("Escrita bem sucedida");

            return "Salvamento bem sucedido";
        }
        catch (IOException e) {
            System.out.println("Erro");
            return "Erro";
        }
    }


    /**
     * Verifica se um nome informado aparece em um arquivo lido pelo Scanner.
     */
    public boolean acessoClienteNome(String nome, String arquivo, Scanner sc) {

        while (sc.hasNext()) {

            String linha = sc.nextLine();

            // Desnecessário, mas mantido do código original
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
     * Compara diretamente o nome informado com o nome esperado.
     */
    public String acessoClinteNomeEsperado(String nome, String nomeEsperado) {

        if (nome.equalsIgnoreCase(nomeEsperado))
            return "Presença confirmada";
        else
            return "Seu nome não consta na lista";
    }


    /**
     * Verifica se o código informado existe no arquivo lido pelo Scanner.
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
     * Testa o código informado com o código esperado usando regex (matches).
     */
    public String acessoClientCodigoTeste(String codigo, String codigoEsperado) {

        if (codigo.matches(codigoEsperado))
            return "Presença confirmada via codigo";
        else
            return "Codigo não consta na lista";
    }


    /**
     * Verifica acesso restrito com base em código e nível de acesso.
     * O arquivo deve ter linhas no formato: codigo,nivel
     */
    public String acessoRestrito(String codigo, String nivel, Scanner sc) {

        while (sc.hasNext()) {

            String linha = sc.nextLine();
            String[] dados = linha.split(",");

            if (dados.length >= 2) {

                String codigoComp = dados[0].trim();
                String nivelPermt = dados[1].trim();

                if (codigo.equalsIgnoreCase(codigoComp)
                        && nivel.equalsIgnoreCase(nivelPermt))

                    return "Acesso autirizado";
                else
                    return "Acesso negado";
            }
        }

        return "\n";
    }


    /**
     * Teste de acesso restrito sem arquivo: compara código e nível esperados.
     */
    public String acessoRestritoTeste(String codigo, int nivel,
                                      String codigoEsperado, int nivelEsperado) {

        if (codigo.matches(codigoEsperado) && nivel == nivelEsperado)
            return "Acesso autorizado";
        else
            return "Acesso negado";
    }


    /**
     * Gera números aleatórios como chaves de acesso e salva em um arquivo.
     * (OBS: o for possui erro lógico: condição i >= limite nunca é verdadeira)
     */
    public String criarAcessos(int limite, String destinoArquivo) {

        Random rd = new Random();

        try (FileWriter fw = new FileWriter("Chaves de acess")) {

            for (int i = 0; i < limite; i++) {
                int num = rd.nextInt(9); 
                fw.write(num);
                fw.write(System.lineSeparator());
            }

            return "Gerador finzalizado";

        } catch (IOException e) {
            return "Erro ao gerar chaves de acesso";
        }
    }


    /**
     * Exibe informações de um evento que está sendo comprado.
     */
    public String ComprarEvento(String cliente, int convidados, float valor,
                                String nomeEvento, Scanner sc, int idadeLimite) {

        System.out.println(nomeEvento);
        System.out.printf("R$%.3f", valor);
        System.out.println("Limite de convidados:" + convidados);
        System.out.println("Idade Limite:" + idadeLimite);

        return "aguardando confirmação do sistema...";
    }


    /**
     * Confirmação feita por administrador: retorna true apenas se resposta for "Sim".
     */
    public boolean confirmaçaoADM(String resposta) {

        if (resposta.equalsIgnoreCase("Sim"))
            return true;
        else
            return false;
    }


    /**
     * Confirmação do cliente: mesma lógica do administrador.
     */
    public boolean confirmaçãoCliente(String resposta) {

        if (resposta.equalsIgnoreCase("Sim"))
            return true;
        else
            return false;
    }
}
