package entities;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ProdutoDTO {

    // Atributos
    private Integer idProduto;
    private String nomeProduto;
    private String descProduto;
    private BigDecimal precoProduto;
    private Integer estoqueProduto;

    // Construtor
    public ProdutoDTO () {}

    public ProdutoDTO(Integer idProduto, String nomeProduto, String descProduto, BigDecimal precoProduto
            , int estoqueProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.descProduto = descProduto;
        this.precoProduto = precoProduto;
        this.estoqueProduto = estoqueProduto;
    }

    // Getters e Setters

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public BigDecimal getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(BigDecimal precoProduto) {
        this.precoProduto = precoProduto;
    }

    public Integer getEstoqueProduto() {
        return estoqueProduto;
    }

    public void setEstoqueProduto(Integer estoqueProduto) {
        this.estoqueProduto = estoqueProduto;
    }

    // toString

    @Override
    public String toString() {
        return "ProdutoDTO{" +
                "idProduto=" + idProduto +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", descProduto='" + descProduto + '\'' +
                ", precoProduto=" + precoProduto +
                ", estoqueProduto=" + estoqueProduto +
                '}';
    }
}
