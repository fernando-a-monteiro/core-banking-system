package domain.model;

/**
 * Entidade de domínio que representa uma Conta bancária.
 *
 * Responsabilidade única: guardar o saldo e executar as regras de negócio
 * financeiras (depositar, sacar). A Conta se autogerencia — nenhum código
 * externo faz "saldo -= valor" diretamente (Passo 2).
 *
 * Composição: cada Conta pertence a exatamente um Cliente (Passo 1).
 * Sem Scanner ou System.out — princípio SRP aplicado (Passo 3).
 */
public class Conta {

    private double saldo;
    private final Cliente titular;

    public Conta(Cliente titular, double saldoInicial) {
        if (titular == null) {
            throw new IllegalArgumentException("Conta precisa de um titular.");
        }
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("Saldo inicial não pode ser negativo.");
        }
        this.titular = titular;
        this.saldo   = saldoInicial;
    }

    public boolean depositar(double valor) {
        if (valor <= 0) {
            return false;
        }
        saldo += valor;
        return true;
    }

    public boolean sacar(double valor) {
        if (valor <= 0) {
            return false;
        }
        if (valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    public double getSaldo()    { return saldo;   }
    public Cliente getTitular() { return titular; }

    @Override
    public String toString() {
        return "Conta{titular=" + titular.getNome() + ", saldo=R$ " + saldo + "}";
    }
}
