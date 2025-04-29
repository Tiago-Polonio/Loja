package br.com.lojacg.dao;

import br.com.lojacg.model.Endereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

public class EnderecoDao extends Conecta {

    //CRUD - Criar(Create) Ler(Read) Atualizar(Update) Apagar(Delete)
    PreparedStatement stman;
    ResultSet result;

    public void cadastrar(Endereco endereco) {
        try {
            String sql = "insert into endereco (cep, logradouro, bairro, cidade, uf) values (?, ?, ?, ?, ?);";
            getConnection();
            stman = connection.prepareStatement(sql);
            stman.setString(1, endereco.getCep());
            stman.setString(2, endereco.getLogradouro());
            stman.setString(3, endereco.getBairro());
            stman.setString(4, endereco.getCidade());
            stman.setString(5, endereco.getUf());
            stman.execute();
            stman.close();
        } catch (SQLException ex) {
            System.err.println("Erro cadastro cliente: " + ex.toString());
        } finally {
            close();
        }

    }

    public Endereco pesquisar(String cep) {
        Endereco endereco = null;
        try {
            String sql = "select * from endereco where cep = ?";
            getConnection();
            stman = connection.prepareStatement(sql);
            stman.setString(1, cep);
            result = stman.executeQuery();
            if (result.first()){
                endereco = new Endereco();
                endereco.setCep(result.getString("cep"));
                endereco.setLogradouro(result.getString("logradouro"));
                endereco.setBairro(result.getString("bairro"));
                endereco.setCidade(result.getString("cidade"));
                endereco.setUf(result.getString("uf"));
            }
            result.close();
            stman.close();
        } catch (SQLException ex) {
            System.err.println("Erro cadastro cliente: " + ex.toString());
        } finally {
            close();
            return endereco;
        }
    }

}
