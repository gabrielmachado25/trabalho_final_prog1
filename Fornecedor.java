package controleestoquefarmacia;

import java.io.Serializable;


public class Fornecedor implements Serializable {
    public String nomeFornecedor;
    private String endereco;
    private String codigo;
    private String cnpj;

    public Fornecedor(String nomeFornecedor, String endereco, String codigo, String cnpj) {
        this.nomeFornecedor = nomeFornecedor;
        this.endereco = endereco;
        this.codigo = codigo;
        this.cnpj = cnpj;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


}
