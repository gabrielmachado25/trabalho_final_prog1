package controleestoquefarmacia;

import static controleestoquefarmacia.Estoque.carregarEstoque;
import static controleestoquefarmacia.Estoque.salvarEstoque;
import java.util.Scanner;


/*AQUI É O "MAIN" QUE TEM QUE SER SUBSTITUÍDO PARA ALGO QUE VAI USAR TIPO:
TELA INICIAL: Selecionar a opção desejada
Ao executar cada ação, volta para tela inicial
Lembrando que o cadastro passa primeiro pelo cadastro do produto e depois para o do fornecedor
*/

public class ControleEstoqueFarmacia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        
        Estoque estoque;

// Tentar carregar o estoque do arquivo
estoque = carregarEstoque();

// Se o estoque não existir, criar um novo
if (estoque == null) {
    estoque = new Estoque();
}

// Loop principal do programa
        while (continuar) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Cadastrar novo produto");
            System.out.println("2 - Remover produto");
            System.out.println("3 - Pesquisar produto");
            System.out.println("4 - Ver todos os produtos em ordem alfabética");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após a leitura do número

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do produto:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o código do produto:");
                    String codigo = scanner.nextLine();
                    System.out.println("Digite a quantidade do produto:");
                    int quantidade = scanner.nextInt();
                    System.out.println("Digite o valor unitário do produto:");
                    double valorUnitario = scanner.nextDouble();
                    System.out.println("Digite a data de validade do produto:");
                    String dataValidade = scanner.nextLine();
                    
                    scanner.nextLine(); // Consumir a quebra de linha após a leitura do número
                    System.out.println("Digite o nome do fornecedor:");
                    String nomeFornecedor = scanner.nextLine();
                    System.out.println("Digite o endereço do fornecedor:");
                    String enderecoFornecedor = scanner.nextLine();
                    System.out.println("Digite o código do fornecedor:");
                    String codigoFornecedor = scanner.nextLine();
                    System.out.println("Digite o CNPJ do fornecedor:");
                    String cnpjFornecedor = scanner.nextLine();
                    Fornecedor fornecedor = new Fornecedor(nomeFornecedor, enderecoFornecedor, codigoFornecedor, cnpjFornecedor);
                    ProdutoFarmacia produto = new ProdutoFarmacia(nome, codigo, quantidade, valorUnitario, dataValidade, fornecedor);
                    estoque.adicionarProduto(produto);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("Digite o código do produto a ser removido:");
                    codigo = scanner.nextLine();
                    estoque.removerProduto(codigo);
                    break;
                case 3:
                    System.out.println("Digite o código do produto a ser pesquisado:");
                    codigo = scanner.nextLine();
                    estoque.pesquisarProduto(codigo);
                    break;
                case 4:
                    estoque.exibirProdutosEmOrdemAlfabetica();
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println();
        }
        // Resto do código do loop principal...

// Salvar o estoque no arquivo
salvarEstoque(estoque);

        System.out.println("Encerrando o sistema de controle de estoque...");
    }
}