package controleestoquefarmacia;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.Serializable;

public class Estoque implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<ProdutoFarmacia> produtos;

    public Estoque() {
        produtos = new ArrayList<>();
        
    }

    public void adicionarProduto(ProdutoFarmacia produto) {
        produtos.add(produto);
    }

    public void removerProduto(String codigo) {
        ProdutoFarmacia produtoRemover = null;
        for (ProdutoFarmacia produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                produtoRemover = produto;
                break;
            }
        }
        if (produtoRemover != null) {
            produtos.remove(produtoRemover);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    public void pesquisarProduto(String codigo) {
        for (ProdutoFarmacia produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                System.out.println("Produto encontrado:");
                System.out.println("Nome: " + produto.getNome());
                System.out.println("Código: " + produto.getCodigo());
                System.out.println("Quantidade: " + produto.getQuantidade());
                System.out.println("Valor Unitário: " + produto.getValorUnitario());
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }

    public void exibirProdutosEmOrdemAlfabetica() {
        Collections.sort(produtos, (p1, p2) -> p1.getNome().compareToIgnoreCase(p2.getNome()));
        System.out.println("Produtos em ordem alfabética:");
        for (ProdutoFarmacia produto : produtos) {
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Código: " + produto.getCodigo());
            System.out.println("Quantidade: " + produto.getQuantidade());
            System.out.println("Valor Unitário: " + produto.getValorUnitario());
            System.out.println("Data de Validade: " + produto.getDataValidade());
            System.out.println();
        }
    }

    public boolean salvar(ProdutoFarmacia produto) { //salvar um veículo

        if (produto != null) { //esse "if" é para verificar se tem algo ou não
            produtos.add(produto); //caso tenha algo, ele adiciona na ArrayList
            return true;
        } else { //caso o objeto seja falso, não tenha nada, retorna falso
            return false;
        }
    }

public static void salvarEstoque(Estoque estoque) { //aqui salva arquivo binário na pasta do arquivo
    try {
        FileOutputStream fileOut = new FileOutputStream("estoque.bin");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(estoque);
        objectOut.close();
        fileOut.close();
        System.out.println("Estoque salvo com sucesso!");
    } catch (Exception e) {
        System.out.println("Erro ao salvar o estoque: " + e.getMessage());
    }
}

public static Estoque carregarEstoque() {
    Estoque estoque = null;
    try {
        FileInputStream fileIn = new FileInputStream("estoque.bin");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        estoque = (Estoque) objectIn.readObject();
        objectIn.close();
        fileIn.close();
    } catch (Exception e) {
        System.out.println("Erro ao carregar o estoque: " + e.getMessage());
    }
    return estoque;
}


}

