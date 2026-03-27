package domain.model;

/**
 * Entidade de domínio que representa um Cliente do banco.
 *
 * Responsabilidade única: armazenar e proteger os dados cadastrais do cliente.
 * Sem Scanner ou System.out — princípio SRP aplicado (Passo 3).
 */
public class Cliente {

    private final String nome;
    private final String cpf;

    public Cliente(String nome, String cpf) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser vazio.");
        }
        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("CPF do cliente não pode ser vazio.");
        }
        this.nome = nome;
        this.cpf  = cpf;
    }

    public String getNome() { return nome; }
    public String getCpf()  { return cpf;  }

    @Override
    public String toString() {
        return "Cliente{nome='" + nome + "', cpf='" + cpf + "'}";
    }
}
