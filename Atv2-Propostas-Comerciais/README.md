# Atv2 — Propostas comerciais com Builder e Singleton

Aplicação em Java 17 puro. `atv2.PropostaPadraoBuilder` monta e valida propostas imutáveis; `atv2.ConfiguracaoComercial` mantém a configuração única da JVM com initialization-on-demand holder. A configuração é obtida no `main` e passada explicitamente ao Builder e ao Director. O pacote `atv2` também permite manter esta atividade no mesmo projeto IntelliJ que a Atv1, sem conflito entre as duas classes `Aplicacao`.

## Compilar e executar

No PowerShell, dentro desta pasta:

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac --release 17 -encoding UTF-8 -d out atv2\*.java
java -cp out atv2.Aplicacao
```

A saída demonstra a identidade do Singleton, uma proposta básica criada pelo Director, uma proposta personalizada criada diretamente pelo Builder reutilizado, seus cálculos e a validação de uma proposta sem itens.

## Respostas

1. **Qual problema do exercício foi resolvido pelo Builder?**
   Ele permite montar propostas com combinações diferentes de itens e campos opcionais em etapas legíveis, mantendo a validação e a criação do produto em um único lugar.

2. **Por que PropostaComercial não deve ser Singleton?**
   Cada cliente e negociação precisam de uma proposta própria. Compartilhar uma única instância faria propostas distintas disputarem os mesmos dados.

3. **Qual é o escopo real da unicidade de ConfiguracaoComercial?**
   A instância é única dentro da JVM em execução. Uma nova execução do programa inicia outra JVM e, portanto, outra instância.

4. **Por que o Director é útil neste exercício, mas não é obrigatório para toda proposta?**
   Ele oferece receitas repetíveis para propostas básica e completa. Quando uma proposta precisa de combinações específicas, o código pode usar o Builder diretamente.

5. **Que dificuldade de teste surgiria se todas as classes chamassem ConfiguracaoComercial.getInstancia() internamente?**
   A dependência ficaria escondida e seria difícil substituí-la por uma configuração controlada em cada teste. Passar os valores necessários explicitamente deixa claro o que cada classe usa e permite testar cenários diferentes sem depender de estado global.

## Itens visuais da entrega

A atividade também pede um diagrama UML e uma captura da saída completa. O AGENTS.md do repositório reserva a produção desses artefatos visuais para criação manual; eles não estão incluídos no ZIP gerado.
