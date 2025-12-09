/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.eventos;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/**
 *
 * @author Userb
 */
public class Eventos {
    private Map <String, String> ingressos = new HashMap<>();
    
    
    public String compraIngressos(String nome, int idade, int idadelim){
        
        if(!(nome.isEmpty() && idade >= idadelim))
            return "Compra de ingressos permitidos";
        else
            return "Você não atende aos quesitos necessários para o evento";
    }
    
    
    
    
    
    public boolean presencaEventoTeste (String codigo, boolean resposta, String codigoEsperado){
            if(codigo == codigoEsperado)
                resposta = true;
            else 
                resposta = false;
            return resposta;
        }
        
        
    
    
    public String registro (String nome, String codigo, String arquivo ) throws IOException{
    ingressos.put(nome, codigo);
    try (FileWriter fw = new FileWriter(arquivo))    {
        fw.write(nome+ "--"+ codigo+ System.lineSeparator());
        System.out.println("Escrita bem sucedida");
        return "Salvamento bem sucedido";
    }
    catch(IOException e){
    System.out.println("Erro");
        return "Erro";
    }
    
    
    
    }
    public boolean acessoClienteNome(String nome, String arquivo, Scanner sc){
        while(sc.hasNext()){
            String linha = sc.nextLine();
            String [] dados = linha.split("\n");
            if(dados.length >= 1){
                String nomeComp = dados[0].trim();
                  if(nome.equalsIgnoreCase(nomeComp))
                return true;
            else
                return false;
            }
                
          
        }
        return false;
    }
        public String acessoClinteNomeEsperado(String nome, String nomeEsperado){
       if (nome.equalsIgnoreCase(nomeEsperado))
           return "Presença confirmada";
       else
           return "Seu nome não consta na lista";
        
        
    }
    public boolean acessoClienteCodigo(String codigo, String arquivo, Scanner sc){
        while(sc.hasNext()){
            String linha = sc.nextLine();
            String [] dados = linha.split("\n");
            if(dados.length >= 1){
                String codigoComp = dados[0].trim();
                  if(codigo.equalsIgnoreCase(codigoComp))
                return true;
            else
                return false;
            }
                
          
        }
        
        return false;
    }
    public String acessoClientCodigoTeste(String codigo, String codigoEsperado){
        if(codigo.matches(codigoEsperado))
            return "Presença confirmada via codigo";
        else
            return "Codigo não consta na lista";
    }
   public String acessoRestrito(String codigo, String nivel, Scanner sc){
       
        while(sc.hasNext()){
            String linha = sc.nextLine();
            String [] dados = linha.split(",");
            if(dados.length >=2){
                String codigoComp = dados[0].trim();
                String nivelPermt = dados[1].trim();
                if(codigo.equalsIgnoreCase(codigoComp) && nivel.equalsIgnoreCase(nivelPermt))
                    return "Acesso autirizado";
                else 
                    return "Acesso negado";
            }
         
        } 
         return "\n";  
   } 
    public String acessoRestritoTeste(String codigo, int nivel, String codigoEsperado, int nivelEsperado){
       
        if (codigo.matches(codigoEsperado) && nivel == nivelEsperado)
           return "Acesso autorizado";
        else
            return "Acesso negado";
         
   } 
  public String criarAcessos(int limite, String destinoArquivo){
     Random rd = new Random();
     try(FileWriter fw = new FileWriter("Chaves de acess")){
         for (int i = 0; i>= limite; i++){
             int num = rd.nextInt(9);
             fw.write(num);
             fw.write(System.lineSeparator());
             
         }
         return "Gerador finzalizado";
     }catch(IOException e){
             return "Erro ao gerar chaves de acesso";
             }
     
  }
    public String ComprarEvento(String cliente, int convidados, float valor, String nomeEvento, Scanner sc, int idadeLimite ){
        System.out.println(nomeEvento );
        System.out.printf("R$%.3f", valor );
        System.out.println("Limite de convidados:"+convidados );
        System.out.println("Idade Limite:"+idadeLimite);
        return "aguardando confirmação do sistema...";
        
       
    }
   public boolean confirmaçaoADM(String resposta){
       
       if (resposta.equalsIgnoreCase("Sim")){
           return true;
       }
       else
           return false;
   }
   public boolean confirmaçãoCliente(String resposta){
       if(resposta.equalsIgnoreCase("Sim")){
           return true;
       }
       else
           return false;
   }
}
