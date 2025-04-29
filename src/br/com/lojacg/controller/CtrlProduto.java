package br.com.lojacg.controller;

import br.com.lojacg.dao.ProdutoDao;
import br.com.lojacg.model.Produto;
import java.util.List;

public class CtrlProduto {

    public void cadastrar(Produto produto){
        ProdutoDao dao = new ProdutoDao();
        dao.cadastrar(produto);
    }
    
    public List<Produto> pesquisar(String dados){
        ProdutoDao dao = new ProdutoDao();
        return dao.pesquisar(dados);
    }
}
