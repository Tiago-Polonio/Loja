package br.com.lojacg.controller;

import br.com.lojacg.dao.EnderecoDao;
import br.com.lojacg.model.Endereco;

public class CtrlEndereco {

    public Endereco pesquisar(String cep){
        EnderecoDao dao = new EnderecoDao();
        return dao.pesquisar(cep);
    }
}
