package com.teste;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AppTest{
   private Produto produto;
   String nomeProduto;
   double precoProduto;
   int estoqueProduto;


   // teste de criacao de produto com valores validos
   @Test
   public void criarProdutosValidados(){
       nomeProduto = "Mentos";
       precoProduto = 5.00;
       estoqueProduto = 30;

       produto = new Produto(nomeProduto, precoProduto, estoqueProduto);

       Assertions.assertEquals(nomeProduto, produto.getNome());
       Assertions.assertEquals(precoProduto, produto.getPreco());
       Assertions.assertEquals(estoqueProduto, produto.getEstoque());
   }

   //teste criação de produto com preço negativo (deve ser inválido).
    @Test
    public void CriarProdutoValorNegativo(){
       nomeProduto = "Creatina";
       precoProduto = -50.99;
       estoqueProduto = 30;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);

        Assertions.assertEquals(nomeProduto, produto.getNome());
        Assertions.assertEquals(precoProduto, produto.getPreco());
        Assertions.assertEquals(estoqueProduto, produto.getEstoque());

    }
   /* /**
     * Create the test case
     *
     * @param testName name of the test case
     /
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     /
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)

    public void testApp()
    {
        assertTrue( true );
    }*/
}
