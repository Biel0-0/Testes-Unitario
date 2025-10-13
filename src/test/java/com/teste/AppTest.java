package com.teste;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AppTest{
   private Produto produto;
   String nomeProduto;
   double precoProduto;
   int estoqueProduto;
   private int vendidos;
   private Venda venda;


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
    //  Testar criação de produto com estoque negativo (deve ser inválido).
    @Test
    public void produtoComEstoqueIvalido(){
       nomeProduto = "Maca Peruana";
       precoProduto = 20.00;
       estoqueProduto = 5;

       produto = new Produto(nomeProduto, precoProduto, estoqueProduto );

       Assertions.assertEquals(nomeProduto, produto.getNome());
        Assertions.assertEquals(precoProduto, produto.getPreco());
        Assertions.assertEquals(estoqueProduto, produto.getEstoque());

    }
    //  Testar alteração do nome do produto para um valor válido.
    @Test
    public void alterarNomeProduto(){
       nomeProduto = "whey growth";
       String nomeNovo = "Whey Protein";
       precoProduto = 2;
       estoqueProduto = 12;

       produto = new Produto(nomeNovo, precoProduto, estoqueProduto);
       produto.setNome(nomeNovo);

       Assertions.assertEquals(nomeNovo, produto.getNome());
    }
    //  Testar alteração do preço do produto para um valor válido.
    @Test
    public void alterarPrecoProduto(){
        nomeProduto = "Leite";
        precoProduto = 30;
        double novoPreco = 14.5;
        estoqueProduto = 50;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        produto.setPreco(novoPreco);

        Assertions.assertEquals(novoPreco, produto.getPreco());
    }
    //  Testar alteração do estoque para um valor positivo.
    @Test
    public void alterarEstoque(){
        nomeProduto = "carne";
        precoProduto = 22;
        estoqueProduto = 0;
        int novoEstoque = 30;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        produto.setEstoque(novoEstoque);

        Assertions.assertEquals(novoEstoque, produto.getEstoque());

    }
    //  Testar alteração do preço do produto para um valor negativo (deve falhar).
    @Test
    public void precoProdutoInvalido(){
       nomeProduto = "Maça";
       precoProduto = 2;
       double novoPreco = -3;
       estoqueProduto = 0;

       produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
       produto.setPreco(novoPreco);

       Assertions.assertFalse(produto.getPreco() >=0 );

    }
    //  Testar venda com quantidade menor que o estoque disponível.
    @Test
    public void realizaVenda(){
       nomeProduto = "bala";
       precoProduto = 1;
       estoqueProduto = 7;
       vendidos = 5;

       produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
       venda = new Venda(produto, vendidos);

       Assertions.assertTrue(venda.realizarVenda());

    }
    //  Testar venda com quantidade igual ao estoque disponível.
    @Test
    public void estoqueTotal(){
       nomeProduto = "coca";
       precoProduto = 2;
       estoqueProduto = 20;
       vendidos = estoqueProduto;

       produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
       venda = new Venda(produto, vendidos);

       Assertions.assertTrue(venda.realizarVenda());
    }
    //  Testar venda com quantidade maior que o estoque disponível (deve falhar).
    @Test
    public void vendaInvalida(){
       nomeProduto = "po";
       precoProduto = 10;
       estoqueProduto = 10;
       vendidos = 20;

       produto = new Produto(nomeProduto, precoProduto,estoqueProduto);
       venda = new Venda(produto, vendidos);
       venda.realizarVenda();

        Assertions.assertFalse(venda.realizarVenda());

    }
    //  Testar cálculo do total da venda corretamente.
    @Test
    public void calcularTotalVenda(){
        nomeProduto = "Trenbo";
        precoProduto = 10;
        estoqueProduto = 10;
        vendidos = 5;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        venda = new Venda(produto, vendidos);
        venda.realizarVenda();

        Assertions.assertEquals(50, venda.getTotalVenda());
    }
    //  Testar aumento de estoque do produto após uma venda.
    @Test
    public void aumentoEstoque(){
        nomeProduto = "Leite";
        precoProduto = 5;
        estoqueProduto = 10;
        int repor = 5;
        vendidos = 3;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        venda = new Venda(produto, vendidos);

        venda.realizarVenda();
        produto.aumentarEstoque(repor);

        Assertions.assertEquals(12, venda.getProduto().getEstoque());
    }
    //  Testar diminuição do estoque do produto após uma venda bem-sucedida.
    @Test
    public void diminuirEstoque(){
        nomeProduto = "Whey";
        precoProduto = 10;
        estoqueProduto = 10;
        vendidos = 2;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        venda = new Venda(produto, vendidos);
        venda.realizarVenda();

        Assertions.assertEquals(8, venda.getProduto().getEstoque());
    }
    //  Testar realizar venda de um produto que não existe (deve falhar).
    @Test
    public void vendaComProdutoInexistente(){
        vendidos = 2;

        venda = new Venda(produto, vendidos);

        Assertions.assertThrows(NullPointerException.class, () -> venda.realizarVenda());
    }
    //  Testar criação de venda com quantidade negativa (deve falhar).
    @Test
    public void vendaComQuantidadeInvalida(){
        nomeProduto = "Arros";
        precoProduto = 10;
        estoqueProduto = 5;
        vendidos = -3;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        venda = new Venda(produto, vendidos);
        venda.realizarVenda();

        Assertions.assertFalse(venda.getProduto().getEstoque() - venda.getQuantidadeVendida() < produto.getEstoque());
    }
    //  Testar alteração do estoque após a tentativa de venda com estoque insuficiente.
    @Test
    public void alterarEstoqueAposVendaInvalida(){
        nomeProduto = "Deca";
        precoProduto = 10;
        estoqueProduto = 10;
        vendidos = 15;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        venda = new Venda(produto, vendidos);
        venda.realizarVenda();

        Assertions.assertEquals(10, venda.getProduto().getEstoque());
    }
    // Testar criação de vários produtos e realizar vendas com estoque compartilhado.
    // Testar criação de vários produtos e realizar vendas com estoque compartilhado.
    // Testar calcular total de venda quando o preço do produto for alterado antes da venda.

    // Testar comportamento da venda quando o estoque inicial é zero.
    @Test
    public void vendaComEstoqueZerado(){
        nomeProduto = "Banana";
        precoProduto = 30;
        estoqueProduto = 0;
        vendidos = 7;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        venda = new Venda(produto, vendidos);

        Assertions.assertFalse(venda.realizarVenda());
    }
    // Testar aumento do estoque após uma reposição e verificar se a venda é bem-sucedida posteriormente.
    @Test
    public void reporEstoqueERealizarVenda(){
        nomeProduto = "agulha";
        precoProduto = 20;
        estoqueProduto = 10;
        int repor = 5;
        vendidos = 2;

        produto = new Produto(nomeProduto, precoProduto, estoqueProduto);
        venda = new Venda(produto, vendidos);
        produto.aumentarEstoque(repor);

        Assertions.assertEquals(15, produto.getEstoque());
        Assertions.assertTrue(venda.realizarVenda());
    }
}
