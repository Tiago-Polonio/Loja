package br.com.lojacg.model;

public class Cliente {
    private long id;
    private String nome;
    private String email;
    private String pws;
    private boolean ativo;
    
    private Endereco endereco;
    
    //Construtor
    public Cliente(){
        ativo = true;
        endereco = new Endereco();
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPws() {
        return pws;
    }

    public void setPws(String pws) {
        this.pws = pws;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String valida(String confSenha) {
       return "";
    }
    
    
}
