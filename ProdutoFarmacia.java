
package controleestoquefarmacia;

//Classe que diferencia o produto dos outros por ser de uma farmácia

public class ProdutoFarmacia extends Produto {
    
    
    public ProdutoFarmacia(String nome, String codigo, int quantidade, double valorUnitario, String dataValidade, Fornecedor fornecedor) {
        super(nome, codigo, quantidade, valorUnitario, fornecedor);
    }
    private String dataValidade;
    

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }
    
    
    
}
