import java.util.Scanner;

public class BancoSimples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome;
        String cpf;
        double saldo = 1500;
        int opcao = 0;

        System.out.println("--- CADASTRO INICIAL ---");
        System.out.print("Digite seu nome: ");
        nome = scanner.nextLine();

        System.out.print("Digite seu CPF: ");
        cpf = scanner.nextLine();

        do {
            System.out.println("\n--- MENU DO CLIENTE: " + nome + " ---");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Consultar Saldo");
            System.out.println("4. Sair");
            System.out.println("Escolha a operação: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor para depositar: R$ ");
                    double deposito = scanner.nextDouble();
                    saldo += deposito;
                    System.out.println("Sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o valor para sacar: R$ ");
                    double saque = scanner.nextDouble();
                    if (saldo >= saque) {
                        saldo -= saque;
                        System.out.println("Sucesso!");
                    } else {
                        System.out.println("Erro: Saldo insuficiente.");
                    }
                    break;
                case 3:
                    System.out.println("Seu saldo é: R$ " + saldo);
                    break;
                case 4:
                    System.out.println("Encerrando programa...");

                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        } while (opcao != 4);

        scanner.close();
    }
}
