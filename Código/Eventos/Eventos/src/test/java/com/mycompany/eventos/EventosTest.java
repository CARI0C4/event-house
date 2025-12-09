/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.eventos;

import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Userb
 */
public class EventosTest {
    
    public EventosTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of compraIngressos method, of class Eventos.
     */
    @Test
    public void testCompraIngressos() {
        System.out.println("compraIngressos");
        String nome = "Rafael";
        int idade = 19;
        int idadelim = 18;
        Eventos instance = new Eventos();
        String expResult = "Compra de ingressos permitidos";
        String result = instance.compraIngressos(nome, idade, idadelim);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of presencaEventoTeste method, of class Eventos.
     */
    @Test
    public void testPresencaEventoTeste() {
        System.out.println("presencaEventoTeste");
        String codigo = "55441";
        boolean resposta = false;
        String codigoEsperado = "55441";
        Eventos instance = new Eventos();
        boolean expResult = true;
        boolean result = instance.presencaEventoTeste(codigo, resposta, codigoEsperado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of registro method, of class Eventos.
     */
    @Test
    public void testRegistro() throws Exception {
        System.out.println("registro");
        String nome = "Rafael";
        String codigo = "55441";
        String arquivo = "Convidados";
        Eventos instance = new Eventos();
        String expResult = "Salvamento bem sucedido";
        String result = instance.registro(nome, codigo, arquivo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of acessoClienteNome method, of class Eventos.
     */
    @Test
    public void testAcessoClienteNome() {
        System.out.println("acessoClienteNome");
        String nome = "";
        String arquivo = "";
        Scanner sc = null;
        Eventos instance = new Eventos();
        boolean expResult = false;
        boolean result = instance.acessoClienteNome(nome, arquivo, sc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of acessoClinteNomeEsperado method, of class Eventos.
     */
    @Test
    public void testAcessoClinteNomeEsperado() {
        System.out.println("acessoClinteNomeEsperado");
        String nome = "Rafael";
        String nomeEsperado = "Rafael";
        Eventos instance = new Eventos();
        String expResult = "Presença confirmada";
        String result = instance.acessoClinteNomeEsperado(nome, nomeEsperado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of acessoClienteCodigo method, of class Eventos.
     */
    @Test
    public void testAcessoClienteCodigo() {
        System.out.println("acessoClienteCodigo");
        String codigo = "";
        String arquivo = "";
        Scanner sc = null;
        Eventos instance = new Eventos();
        boolean expResult = false;
        boolean result = instance.acessoClienteCodigo(codigo, arquivo, sc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of acessoClientCodigoTeste method, of class Eventos.
     */
    @Test
    public void testAcessoClientCodigoTeste() {
        System.out.println("acessoClientCodigoTeste");
        String codigo = "55441";
        String codigoEsperado = "55441";
        Eventos instance = new Eventos();
        String expResult = "Presença confirmada via codigo";
        String result = instance.acessoClientCodigoTeste(codigo, codigoEsperado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of acessoRestrito method, of class Eventos.
     */
    @Test
    public void testAcessoRestrito() {
        System.out.println("acessoRestrito");
        String codigo = "";
        String nivel = "";
        Scanner sc = null;
        Eventos instance = new Eventos();
        String expResult = "";
        String result = instance.acessoRestrito(codigo, nivel, sc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of acessoRestritoTeste method, of class Eventos.
     */
    @Test
    public void testAcessoRestritoTeste() {
        System.out.println("acessoRestritoTeste");
        String codigo = "55441";
        int nivel = 4;
        String codigoEsperado = "55441";
        int nivelEsperado = 4;
        Eventos instance = new Eventos();
        String expResult = "Acesso autorizado";
        String result = instance.acessoRestritoTeste(codigo, nivel, codigoEsperado, nivelEsperado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of criarAcessos method, of class Eventos.
     */
    @Test
    public void testCriarAcessos() {
        System.out.println("criarAcessos");
        int limite = 5;
        String destinoArquivo = "Dados";
        Eventos instance = new Eventos();
        String expResult = "Gerador finzalizado";
        String result = instance.criarAcessos(limite, destinoArquivo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of ComprarEvento method, of class Eventos.
     */
    @Test
    public void testComprarEvento() {
        System.out.println("ComprarEvento");
        String cliente = "Kauan";
        int convidados = 2000000;
        float valor = 0.0F;
        String nomeEvento = "Lollapaluzza";
        Scanner sc = null;
        int idadeLimite = 18;
        Eventos instance = new Eventos();
        String expResult = "aguardando confirmação do sistema...";
        String result = instance.ComprarEvento(cliente, convidados, valor, nomeEvento, sc, idadeLimite);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of confirmaçaoADM method, of class Eventos.
     */
    @Test
    public void testConfirmaçaoADM() {
        System.out.println("confirma\u00e7aoADM");
        String resposta = "sim";
        Eventos instance = new Eventos();
        boolean expResult = true;
        boolean result = instance.confirmaçaoADM(resposta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of confirmaçãoCliente method, of class Eventos.
     */
    @Test
    public void testConfirmaçãoCliente() {
        System.out.println("confirma\u00e7\u00e3oCliente");
        String resposta = "não";
        Eventos instance = new Eventos();
        boolean expResult = false;
        boolean result = instance.confirmaçãoCliente(resposta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
