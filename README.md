🏦 Sistema Bancário Central (Core Banking)

Este projeto documenta a evolução prática de um motor de processamento de transações bancárias, simulando operações críticas de um core financeiro. O objetivo é demonstrar o ciclo completo de desenvolvimento e refatoração de software, evoluindo de um modelo procedural para uma arquitetura limpa, escalável e orientada a sistemas reais de alta confiabilidade, com foco em consistência de dados e integridade de operações.

🎯 Roadmap de Refatoração e Evolução

O desenvolvimento está estruturado em fases progressivas de maturidade em engenharia de software, evidenciando a evolução arquitetural do sistema ao longo do tempo.

A Fase 1: O Marco Zero (Script Procedural) representa o estágio atual do projeto. Nela, a implementação é realizada em um único arquivo (BancoSimples.java), utilizando estruturas de controle de fluxo, loops e entrada/saída via console. Este estágio evidencia limitações importantes, como o forte acoplamento entre regras de negócio e interface, ausência de encapsulamento e falta de modelagem de estado. Esses problemas são intencionalmente mantidos para demonstrar, na prática, a necessidade de evolução arquitetural.

A Fase 2: Refatoração para Orientação a Objetos (POO) introduz a separação de responsabilidades com base nos princípios SOLID, especialmente o Single Responsibility Principle (SRP). Nesta etapa, serão criadas entidades de domínio como Conta e Cliente, promovendo encapsulamento das regras de negócio e isolamento completo entre a lógica de domínio e a interface de usuário.

Na Fase 3: Persistência e Padrões de Projeto, o sistema passa a integrar um banco de dados relacional (MySQL), utilizando padrões como Repository/DAO para abstração de acesso a dados. Também são introduzidos conceitos fundamentais de sistemas financeiros, como o uso de transações para garantir propriedades ACID, além da preparação para cenários de concorrência e consistência de dados.

A Fase 4: API RESTful e Nuvem marca a transição para um ambiente moderno de aplicações distribuídas. O sistema será migrado para o ecossistema Spring Boot, com exposição de endpoints REST e estrutura preparada para deploy em nuvem. Além disso, serão considerados aspectos essenciais de sistemas em produção, como observabilidade, logging estruturado e boas práticas de segurança. A evolução futura também contempla conceitos como idempotência e controle de concorrência, aproximando o projeto de cenários reais de sistemas financeiros distribuídos.

💻 Stack Tecnológica
Linguagem: Java (JDK 21)
Paradigma Atual: Imperativo (em evolução para Orientação a Objetos)
Controle de Versão: Git & GitHub
⚙️ Como Executar a Fase 1
javac BancoSimples.java
java BancoSimples
