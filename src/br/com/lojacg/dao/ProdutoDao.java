package br.com.lojacg.dao;

import br.com.lojacg.model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao extends Conecta {

    //CRUD - Criar(Create) Ler(Read) Atualizar(Update) Apagar(Delete)
    PreparedStatement stman;
    ResultSet result;

    public void cadastrar(Produto produto) {
        
        try {
            String sql = "insert into produto (produto, descricao, quant, quant_min, foto, valor) values (?, ?, ?, ?, ?, ?);";
            getConnection();
            stman = connection.prepareStatement(sql);
            stman.setString(1, produto.getProduto());
            stman.setString(2, produto.getDesc());
            stman.setInt(3, produto.getQuant());
            stman.setInt(4, produto.getMin());
            stman.setString(5, produto.getFoto());
            stman.setDouble(6, produto.getValor());
            stman.execute();
            stman.close();
        } catch (SQLException ex) {
            System.err.println("Erro cadastro produto: " + ex.toString());
        } finally {
            close();
        }

    }

    public List<Produto> pesquisar(String dados) {
         List<Produto> produtos = new ArrayList<>();
         try {
            String sql = "select * from produto where produto like ?";
            getConnection();
            stman = connection.prepareStatement(sql);
            stman.setString(1, dados+"%");
            result = stman.executeQuery();
            while(result.next()){
                Produto produto = new Produto();
                produto.setIdproduto(result.getInt("idproduto"));
                produto.setProduto(result.getString("produto"));
                produto.setDesc(result.getString("descricao"));
                produto.setQuant(result.getInt("quant"));
                produto.setMin(result.getInt("quant_min"));
                produto.setFoto(result.getString("foto"));
                produto.setValor(result.getDouble("valor"));
                produtos.add(produto);
            }
            result.close();
            stman.close();
        } catch (SQLException ex) {
            System.err.println("Erro cadastro produto: " + ex.toString());
        } finally {
            close();
            return produtos;
        }
    }

}
