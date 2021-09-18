import java.util.Scanner;
import java.util.LinkedList;

/*
verificações:
    codigos já está em uso
    verifica a existencias básica para da continuidade
    verificar as entradas

imprementação:
    funções de imprimir os pedidos, garçom e os produtos já cadastrados
    fazer com que quando um novo item que já está no pedido seja adicionado não crie um novo item e sim
incremente o que já existe
    salvar o garçons e os produtos ja cadastrado em arquivos 
*/

public class App_Caixa{
    static Scanner input = new Scanner(System.in);
    static float totalCaixa = 0;
    static LinkedList<Garcom> garcons = new LinkedList<Garcom>();
    static LinkedList<Produto> produtos = new LinkedList<Produto>();
    static LinkedList<Pedido> pedidos = new LinkedList<Pedido>();

    

    public static Garcom proucurarGarcom(int matricula){
        for(Garcom i: garcons){
            if(i.getMAtricula() == matricula){
                return i;
            }
        }

        return null;
    }

    public static void imprimirPedidos(){
        System.out.println("\n----------+++++Pedidos+++++----------");
        System.out.printf("%s %-10s %-8s %-15s\n", "codigo", "Data", "Hora", "nome-garçom");
        for(Pedido i: pedidos){
            System.out.println(i.toString());
        }
        System.out.println("----------+++++++Fim+++++++----------");
    }

    public static void imprimirProdutos(){
        System.out.println("\n----------+++++Produtos+++++----------");
        System.out.printf("%-8s %-15s %s\n","codigo","nome", "preço");
        for(Produto i: produtos){
            System.out.println(i.toString());
        }
        System.out.println("----------+++++++Fim+++++++----------");
    }

    public static void imprimirGarcons(){
        System.out.println("\n----------+++++Graçons+++++----------");
        System.out.printf("%s %s\n","matricula","nome");
        for(Garcom i: garcons){
            System.out.println(i.toString());
        }
        System.out.println("----------+++++++Fim+++++++----------");
    }

    public static Produto proucurarProduto(int codigo){
        for(Produto i: produtos){
            if(i.getCodigo() == codigo){
                return i;
            }
        }
        return null;
    }

    public static Pedido proucurarPedido(int codigo){
        for(Pedido i: pedidos){
            if(i.getCodigo() == codigo){
                return i;
            }
        }

        return null;
    }

    public static boolean verificaCodigo(int codigo){
        for(Produto i: produtos){
            if(i.getCodigo() == codigo){
                return true;
            }
        }

        return false;
    }

    public static boolean verificaMatricula(int matricula){
        for(Garcom i: garcons){
            if(i.getMAtricula() == matricula){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        /*----------AREA PARA VARIAVEIS USADAS NOS CASES----------*/
        Garcom garcom = null;
        Produto produto = null;
        Pedido pedido = null;
        Item itens;
        String nome;
        int matricula;
        int codigo;
        float preco;
        char cadMais;
        int quantidade;
        float total;
        int aux = 0;
        /*--------------------------------------------------------*/
        
        while(aux != 7){
            try{
            System.out.print("\nBem vindo ao Restaurante Heflain - MENU\n" +
            "------------------------\n" +
            "1 - Cadastrar Garçom\n" +
            "2 - Cadastrar Produtos\n" +
            "3 - Abrir Pedido\n" +
            "4 - Adicionar Produto\n" +
            "5 - Fechar Pedido\n" +
            "6 - Total do Caixa\n" +
            "7 - Sair\n" +
            "------------------------\n" +
            "Opcao: ");
            aux = input.nextInt();
            input.nextLine();

            switch (aux){
                case 1:
                    System.out.println("\n-----+++++Cadastra Garçom+++++-----");
                    System.out.print("Digite o nome do garçom: ");
                    nome = input.nextLine();
                    do{
                        System.out.print("Digite o numero de matricula do garçom: ");
                        matricula = input.nextInt();
                    }while(verificaMatricula(matricula));
                    garcons.add(new Garcom(nome, matricula));
                    break;
                case 2:
                    System.out.println("\n-----+++++Cadastra Produto+++++-----");
                    System.out.print("Digite o nome do produto: ");
                    nome = input.nextLine();
                    do{
                        System.out.print("Digite o codigo do produto: ");
                        codigo = input.nextInt();
                    }while(verificaCodigo(codigo));
                    System.out.print("Digite o peço do produto: ");
                    preco = input.nextFloat();
            
                    produtos.add(new Produto(nome, codigo, preco));
                    break;
                case 3:
                    if(garcons.isEmpty()){
                        System.out.println("Não existe garçons cadastrados!!!");
                    }else{ if(produtos.isEmpty()){
                        System.out.println(("Não existe produtos cadastrados!!!"));
                        }else{
                        System.out.println("\n-----+++++Abrir Pedido+++++-----");

                        imprimirGarcons();

                        System.out.print("Digite a matricula do garcom: ");
                        codigo = input.nextInt();
                
                        garcom = proucurarGarcom(codigo);
                
                        if(garcom == null){
                            System.out.println("Garçom não encontrado!!!");
                        }else{
                            pedidos.add(new Pedido(garcom));
                        }
                    }}
                    break;
                case 4:
                    if(pedidos.isEmpty()){
                        System.out.println("Não existe pedidos abertos!!!");
                    }else{
                        System.out.println("\n-----+++++Adicionar Produtos+++++-----");

                        imprimirPedidos();

                        System.out.print("Digite o codigo do pedido: ");
                        codigo = input.nextInt();
                
                        pedido = proucurarPedido(codigo);

                        if(pedido == null){
                            System.out.println("pedido não existe!!!");
                        }else{
                            imprimirProdutos();
                            while(true){
                                System.out.print("Digite o código do produto: ");
                                codigo = input.nextInt();
                                produto = proucurarProduto(codigo);
                
                                if(produto == null){
                                    System.out.println("Produto não encontrado: ");
                                }else{
                                    System.out.print("Digite a quantidade do produto: ");
                                    quantidade = input.nextInt();
                                    itens = new Item(produto, quantidade);
                                    pedido.setItens(itens);
                                }
                
                                System.out.print("Deseja cadastra mais itens[S/N]? ");
                                
                                input.nextLine();
                                cadMais = input.nextLine().charAt(0);

                                if(cadMais == 'N' || cadMais == 'n'){
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 5:
                    if(pedidos.isEmpty()){
                        System.out.println("Não existe pedidos abertos!!!");
                    }else{
                        System.out.println("\n-----+++++Fechar Pedido+++++-----");
                        
                        imprimirPedidos();

                        System.out.print("Digite o codigo do pedido: ");
                        codigo = input.nextInt();
                        
                        pedido = proucurarPedido(codigo);
                
                        if(pedido == null){
                            System.out.println("Pedido não encontrado!!!");
                        }else{
                            total = pedido.fecharPedido();
                            System.out.printf("Total do pedido: R$%.2f\n", total);
                            pedidos.remove(pedido);
                            totalCaixa += total;
                        }
                    }
                    break;
                case 6:
                    System.out.println("\n-----+++++Total em Caixa+++++-----");
                    System.out.printf("O total do caixa é R$:%.2f\n",totalCaixa);
                    break;
                case 7:
                    System.out.println("liberando a lista de garçons...");
                    garcons.clear();
                    System.out.println("liberando a lista de produtos...");
                    produtos.clear();
                    System.out.println("liberando a lista de pedidos...");
                    for(Pedido i: pedidos){
                        i.liberaItens();
                    }
                    pedidos.clear();
                    System.out.println(("saindo..."));
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
            }catch(Exception e){
                System.out.println("Entrada inválida");
                input.nextLine();
            }
        }
    }
}