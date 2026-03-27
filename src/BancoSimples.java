import domain.model.Cliente;
import domain.model.Conta;
import java.util.Scanner;

/**
 * Ponto de entrada da aplicação — o "Maestro" (Passo 4).
 *
 * Responsabilidade única: ler entradas do usuário, delegar operações
 * para os objetos de domínio corretos e exibir o resultado.
 *
 * NÃO contém regras de negócio (sem "saldo -= valor", sem "if saldo >= saque").
 * Toda a inteligência bancária vive dentro de Conta.java.
 */
public class BancoSimples {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ── Cadastro inicial ─────────────────────────────────────────────────
        System.out.println("--- CADASTRO INICIAL ---");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        // Instancia as entidades de domínio (Passo 1 — sem variáveis soltas)
        Cliente cliente = new Cliente(nome, cpf);
        Conta   conta   = new Conta(cliente, 1500.00);

        // ── Menu de operações ────────────────────────────────────────────────
        int opcao = 0;

        do {
            System.out.println("\n--- MENU DO CLIENTE: " + cliente.getNome() + " ---");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Consultar Saldo");
            System.out.println("4. Sair");
            System.out.print("Escolha a operação: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.print("Digite o valor para depositar: R$ ");
                    double valorDeposito = scanner.nextDouble();
                    if (conta.depositar(valorDeposito)) {
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Erro: valor de depósito inválido.");
                    }
                    break;

                case 2:
                    System.out.print("Digite o valor para sacar: R$ ");
                    double valorSaque = scanner.nextDouble();
                    if (conta.sacar(valorSaque)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Erro: saldo insuficiente ou valor inválido.");
                    }
                    break;

                case 3:
                    System.out.printf("Seu saldo atual é: R$ %.2f%n", conta.getSaldo());
                    break;

                case 4:
                    System.out.println("Encerrando programa. Até logo, " + cliente.getNome() + "!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 4);

        scanner.close();
    }
}
