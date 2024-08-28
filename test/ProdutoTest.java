
import br.com.joaomiguelg.dao.IProdutoDAO;
import br.com.joaomiguelg.dao.ProdutoDAO;
import br.com.joaomiguelg.domain.Produto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ProdutoTest {

    private IProdutoDAO produtoDAO;

    @Test
    public void cadastrarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("computador");
        produto.setPreco("100");
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoDB = produtoDAO.consultar("computador");
        assertNotNull(produto);
        assertEquals(produto.getNome(), produtoDB.getNome());

        Integer countDel = produtoDAO.excluir(produtoDB);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTest() throws Exception {
        produtoDAO  = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setPreco("100");
        produto.setNome("computador");
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoDB = produtoDAO.consultar("computador");
        assertNotNull(produtoDB);
        assertEquals(produto.getPreco(), produtoDB.getPreco());
        assertEquals(produto.getNome(), produtoDB.getNome());

        Integer countDel = produtoDAO.excluir(produtoDB);
        assertTrue(countDel == 1);
    }

    @Test
    public void excluirTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("computador");
        produto.setPreco("100");
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoDB = produtoDAO.consultar("computador");
        assertNotNull(produtoDB);
        assertEquals(produto.getPreco(), produtoDB.getPreco());
        assertEquals(produto.getNome(), produtoDB.getNome());

        Integer countDel = produtoDAO.excluir(produtoDB);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTodosTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setPreco("100");
        produto.setNome("computador");
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtos = new Produto();
        produtos.setNome("celular");
        produtos.setPreco("200");
        Integer countCad2 = produtoDAO.cadastrar(produtos);
        assertTrue(countCad2 == 1);

        List<Produto> list = produtoDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        int countDel = 0;
        for (Produto prod : list) {
            produtoDAO.excluir(prod);
            countDel++;
        }
        assertEquals(list.size(), countDel);

        list = produtoDAO.buscarTodos();
        assertEquals(list.size(), 0);

    }

    @Test
    public void atualizarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setPreco("100");
        produto.setNome("computador");
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoDB = produtoDAO.consultar("computador");
        assertNotNull(produtoDB);
        assertEquals(produto.getPreco(), produtoDB.getPreco());
        assertEquals(produto.getNome(), produtoDB.getNome());

        produtoDB.setPreco("200");
        produtoDB.setNome("celular");
        Integer countUpdate = produtoDAO.atualizar(produtoDB);
        assertTrue(countUpdate == 1);

        Produto produtoDB1 = produtoDAO.consultar("computador");
        assertNull(produtoDB1);

        Produto produtoDB2 = produtoDAO.consultar("celular");
        assertNotNull(produtoDB2);
        assertEquals(produtoDB.getId(), produtoDB2.getId());
        assertEquals(produtoDB.getPreco(), produtoDB2.getPreco());
        assertEquals(produtoDB.getNome(), produtoDB2.getNome());

        List<Produto> list = produtoDAO.buscarTodos();
        for (Produto prod : list) {
            produtoDAO.excluir(prod);
        }
    }


}
