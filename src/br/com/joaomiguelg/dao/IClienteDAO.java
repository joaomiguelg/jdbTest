package br.com.joaomiguelg.dao;

import br.com.joaomiguelg.domain.Cliente;

import java.util.List;

public interface IClienteDAO {


    public Integer cadastrar(Cliente cliente) throws Exception;

    public Cliente consultar(String codigo) throws Exception;

    public Integer excluir(Cliente clienteBD) throws Exception;

    public List<Cliente> buscarTodos() throws Exception;

    public Integer atualizar(Cliente cliente) throws Exception;
}