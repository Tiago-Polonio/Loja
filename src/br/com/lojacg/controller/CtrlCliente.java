package br.com.lojacg.controller;

import br.com.lojacg.dao.ClienteDao;
import br.com.lojacg.model.Cliente;
import java.util.List;

public class CtrlCliente {

    public void cadastrar(Cliente cliente){
        ClienteDao dao = new ClienteDao();
        dao.cadastrar(cliente);
    }
    
    public List<Cliente> pesquisar(String dados){
        ClienteDao dao = new ClienteDao();
        return dao.pesquisar(dados);
    }
}
