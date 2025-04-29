package br.com.lojacg.model;

public class Produto {
    private int idproduto;
    private String produto;
    private String desc;
    private int quant;
    private int min;
    private String foto;
    private double valor;
    
    //Construtor
    public Produto(){
        
    }
    
    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String isProduto(){
        String erros = "";
        if(getProduto().equals("")){
            erros += "Produto em branco \n";
        }
        if(getDesc().equals("")){
            erros += "Descrição em branco \n";
        }
        if(getQuant() == 0){
            erros += "Quantidade em branco \n";
        }
        if(getMin() == 0){
            erros += "Quantidade mínima em branco \n";
        }
        if(getFoto().equals("")){
            erros += "Foto em branco \n";
        }
        if(getValor() == 0){
            erros += "Valor em branco \n";
        }
        return erros;
    }
}
