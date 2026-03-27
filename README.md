# 🏦 Core Banking System

> Motor de processamento de transações bancárias em desenvolvimento iterativo, evoluindo de um modelo procedural para uma arquitetura limpa e escalável.

---

## 📌 Sobre o Projeto

Este repositório documenta **minha evolução como desenvolvedor Java**, mostrando na prática como um sistema bancário cresce em maturidade arquitetural a cada fase.

O objetivo não é apenas fazer o código funcionar — é fazê-lo da forma certa, aplicando os mesmos princípios usados por empresas como **Itaú, B3 e Nubank**.

---

## 🗺️ Roadmap de Fases

| Fase | Branch | Status | Descrição |
|------|--------|--------|-----------|
| Fase 1 | `main` | ✅ Concluída | Script procedural — monolito funcional |
| Fase 2 | `fase-2` | ✅ Concluída | Orientação a Objetos — encapsulamento e SRP |
| Fase 3 | `fase-3` | 🔜 Em breve | Persistência com banco de dados MySQL |
| Fase 4 | `fase-4` | 🔜 Em breve | API REST com Spring Boot |

---

## 🚀 Fase 2 — Orientação a Objetos (Branch Atual)

### O que mudou em relação à Fase 1?

Na Fase 1, o código era um **monolito procedural**: `nome`, `cpf` e `saldo` eram variáveis soltas dentro do `main`, e toda a lógica bancária estava misturada em um único arquivo.

Na Fase 2, o sistema foi **refatorado para arquitetura em camadas**, aplicando três princípios fundamentais:

---

### 🏗️ Arquitetura Aplicada
```
src/
├── BancoSimples.java          → Orquestrador (main)
└── domain/
    └── model/
        ├── Cliente.java       → Entidade de domínio
        └── Conta.java         → Entidade de domínio
```

---

### 🔒 Princípio 1 — Encapsulamento

`Cliente` e `Conta` possuem todos os atributos `private`. Nenhum código externo acessa ou altera `cpf`, `nome` ou `saldo` diretamente.
```java
// ❌ Fase 1 — dado solto, sem proteção
double saldo = 1500;
saldo -= valorSaque;

// ✅ Fase 2 — dado protegido dentro do objeto
private double saldo;
conta.sacar(valorSaque);
```

---

### 🧠 Princípio 2 — Domínio Rico

A classe `Conta` é um **objeto inteligente**: ela conhece suas próprias regras de negócio e as aplica sozinha.
```java
public boolean sacar(double valor) {
    if (valor <= 0)      return false;
    if (valor > saldo)   return false;
    saldo -= valor;
    return true;
}
```

---

### 🎯 Princípio 3 — SRP (Single Responsibility Principle)

Cada classe tem **uma única responsabilidade**:

- `Cliente` → guarda dados cadastrais
- `Conta` → executa operações financeiras
- `BancoSimples` → lê entradas e exibe resultados

---

## 🛠️ Como Executar

**Pré-requisitos:** Java 11+
```bash
# Clone o repositório
git clone https://github.com/fernando-a-monteiro/core-banking-system.git

# Entre na pasta
cd core-banking-system

# Compile
javac -d out src/domain/model/Cliente.java src/domain/model/Conta.java src/BancoSimples.java

# Execute
java -cp out BancoSimples
```

---

## 👨‍💻 Autor

**Fernando Monteiro**  
[![GitHub](https://img.shields.io/badge/GitHub-fernando--a--monteiro-black?logo=github)](https://github.com/fernando-a-monteiro)
