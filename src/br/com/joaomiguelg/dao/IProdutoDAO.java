package br.com.joaomiguelg.dao;


import br.com.joaomiguelg.domain.Produto;

import java.util.List;

public interface IProdutoDAO {
    public Integer cadastrar(Produto produto) throws Exception;

    public Produto consultar(String nome) throws Exception;

    public Integer excluir(Produto produto) throws Exception;

    public List<Produto> buscarTodos() throws Exception;

    public Integer atualizar(Produto produto) throws Exception;
}
