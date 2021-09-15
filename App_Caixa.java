import java.util.Scanner;


public class App_Caixa{
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int aux;
        while(true){
            System.out.println("Bem vindo ao Restaurante Heflain - MENU%n" +
            "------------------------%n" +
            "1 - Cadastrar Garçom%n" +
            "2 - Cadastrar Produtos%n" +
            "3 - Abrir Pedido%n" +
            "4 - Adicionar Produto%n" +
            "5 - Fechar Pedido%n" +
            "6 - Total do Caixa%n" +
            "7 - Sair%n" +
            "------------------------%n" +
            "Opcao: ");
            aux = input.nextInt();
        }
    }
}