package controleestoquefarmacia;

import java.io.Serializable;


public class Produto implements Serializable{
    private String nome;
    private String codigo;
    private int quantidade;
    private double valorUnitario;
    private Fornecedor fornecedor;

    public Produto(String nome, String codigo, int quantidade, double valorUnitario, Fornecedor fornecedor) {
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

}
