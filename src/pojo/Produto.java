
package pojo;


public class Produto {

    private static Integer idProduto;
    private String codProduto;
    private String nomeProduto;
    private double precoCusto;
    private double precoVenda;
    private int qtdEstoque;

    public static Integer getIdProduto() {
        return idProduto;
    }
    public static void setIdProduto(Integer idProduto) {
        Produto.idProduto = idProduto;
    }

    public String getCodProduto() {
        return codProduto;
    }
    public void setCodProduto(String codProduto) {
        this.codProduto = codProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }
    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public  double getPrecoVenda() {
        return precoVenda;
    }
    public  void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public  int getQtdEstoque() {
        return qtdEstoque;
    }
    public  void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }   
}
