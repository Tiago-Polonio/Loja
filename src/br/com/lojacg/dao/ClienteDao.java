package br.com.lojacg.dao;

import br.com.lojacg.model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao extends Conecta {

    //CRUD - Criar(Create) Ler(Read) Atualizar(Update) Apagar(Delete)
    PreparedStatement stman;
    ResultSet result;

    public void cadastrar(Cliente cliente) {
        EnderecoDao enderecoDao = new EnderecoDao();
        if (enderecoDao.pesquisar(cliente.getEndereco().getCep()) == null) {
            enderecoDao.cadastrar(cliente.getEndereco());
        }
        try {
            String sql = "insert into cliente (nome, email, pws, ativo, cep) values (?, ?, ?, ?, ?);";
            getConnection();
            stman = connection.prepareStatement(sql);
            stman.setString(1, cliente.getNome());
            stman.setString(2, cliente.getEmail());
            stman.setString(3, cliente.getPws());
            stman.setBoolean(4, cliente.isAtivo());
            stman.setString(5, cliente.getEndereco().getCep());
            stman.execute();
            stman.close();
        } catch (SQLException ex) {
            System.err.println("Erro cadastro cliente: " + ex.toString());
        } finally {
            close();
        }

    }

    public List<Cliente> pesquisar(String dados) {
         List<Cliente> clientes = new ArrayList<>();
         try {
            String sql = "select * from cliente where nome like ?";
            getConnection();
            stman = connection.prepareStatement(sql);
            stman.setString(1, dados+"%");
            result = stman.executeQuery();
            while(result.next()){
                Cliente cliente = new Cliente();
                cliente.setNome(result.getString("nome"));
                cliente.setAtivo(result.getBoolean("ativo"));
                cliente.setEmail(result.getString("email"));
                cliente.setId(result.getLong("id"));
                cliente.getEndereco().setCep(result.getString("cep"));
                clientes.add(cliente);
            }
            result.close();
            stman.close();
        } catch (SQLException ex) {
            System.err.println("Erro cadastro cliente: " + ex.toString());
        } finally {
            close();
            return clientes;
        }
    }

}
