Arquitetura e Padrões de Software · Aula 06

# Exercício prático: propostas comerciais com Builder e Singleton

Implemente, em Java 17 puro, uma aplicação executável que use os dois padrões estudados. Cada padrão deverá resolver um problema diferente e sua decisão deverá aparecer claramente no código.

## Contexto do problema

Uma empresa de tecnologia precisa gerar **propostas comerciais diferentes**. Toda proposta possui cliente, responsável e prazo de validade. Ela também pode conter vários itens, desconto, observações e condições de pagamento.

A aplicação utiliza uma **configuração comercial única durante a execução**, responsável por informar a moeda padrão e o limite máximo de desconto. Essa unicidade vale somente para a JVM em execução.

## Objetivo

Construir propostas legíveis e válidas com **Builder** e controlar a instância da configuração com **Singleton**. O programa deve demonstrar os dois mecanismos no método `main`.

## 1. Produto que será construído

Crie uma classe imutável **PropostaComercial** com os seguintes dados:

|Dado|Regra|
|---|---|
|**cliente**|Obrigatório e não pode estar em branco.|
|**responsavel**|Obrigatório e não pode estar em branco.|
|**validadeEmDias**|Obrigatório e deve ser maior que zero.|
|**itens**|Lista com pelo menos um ItemProposta.|
|**descontoPercentual**|Opcional; entre 0 e o limite informado pela configuração.|
|**observacoes**|Opcional.|
|**moeda**|Recebida da configuração comercial.|

A lista de itens armazenada no produto deve ser uma cópia defensiva. O produto final não deve possuir setters.

## 2. Requisitos do Builder

1. Crie a interface **PropostaBuilder** com operações para iniciar uma proposta, adicionar item, aplicar desconto, definir observações, definir moeda e construir o produto.
2. Crie **PropostaPadraoBuilder** como implementação concreta. Os métodos de configuração devem retornar o próprio Builder para permitir encadeamento.
3. O método **construir()** deve validar todos os campos obrigatórios, exigir pelo menos um item e rejeitar desconto acima do limite permitido.
4. Crie **DiretorPropostas** com duas receitas: **criarPropostaBasica(...)** e **criarPropostaCompleta(...)**.
5. Depois de entregar uma proposta, o Builder deve poder iniciar uma nova montagem sem carregar itens ou valores da construção anterior.

## 3. Requisitos do Singleton

Crie a classe **ConfiguracaoComercial** usando a técnica _Initialization-on-demand holder_:

- construtor privado;
- classe interna estática responsável por armazenar a instância;
- método público estático **getInstancia()**;
- moeda padrão igual a **BRL**;
- limite máximo de desconto igual a **15%**.

**Importante:** não chame `getInstancia()` escondido dentro de todas as classes. Obtenha a configuração no ponto de composição, no início do programa, e passe os valores necessários ao Builder ou ao Director.

## 4. Classes mínimas

|Tipo Java|Responsabilidade|
|---|---|
|**ItemProposta**|Representar descrição, quantidade e valor unitário.|
|**PropostaComercial**|Produto final imutável e capaz de calcular subtotal, desconto e total.|
|**PropostaBuilder**|Contrato das etapas de construção.|
|**PropostaPadraoBuilder**|Acumular dados, validar e entregar o produto.|
|**DiretorPropostas**|Coordenar as duas receitas solicitadas.|
|**ConfiguracaoComercial**|Singleton com moeda e limite de desconto.|
|**Aplicacao**|Conter o método main e demonstrar o programa completo.|

## 5. Fluxo obrigatório no método main

1. Obtenha a configuração duas vezes e imprima o resultado da comparação de identidade com **==**.
2. Crie uma proposta básica pela receita do Director.
3. Crie uma proposta personalizada usando o Builder diretamente, com pelo menos três itens, desconto e observações.
4. Imprima os dados, o subtotal, o desconto e o total das duas propostas.
5. Tente construir uma proposta inválida e trate a exceção, exibindo a mensagem da validação.

Saída mínima esperada (os valores podem variar): Mesma configuração? true Moeda padrão: BRL Proposta básica: ... Total: R$ ... Proposta personalizada: ... Total com desconto: R$ ... Validação: a proposta deve possuir pelo menos um item.

## 6. Critérios de aceitação

- Todo o código deve compilar e executar em **Java 17**, sem frameworks ou dependências externas.
- Não serão aceitos pseudocódigo, reticências, métodos vazios ou comentários do tipo “implementar depois”.
- O produto deve ser imutável e proteger sua coleção de itens.
- O Builder deve possuir etapas compreensíveis, validação e reinicialização segura.
- O Singleton deve usar o holder idiom e devolver a mesma referência no teste com ==.
- As responsabilidades de Builder e Singleton devem permanecer separadas.
- O código deve conter comentários explicando as decisões importantes, e não apenas traduzindo cada linha.

## 7. Entrega

**Envie um único arquivo .zip** contendo:

- todos os arquivos **.java** organizados em pastas coerentes;
- um diagrama UML de classes em PDF ou PNG;
- um arquivo **README.pdf** ou **README.md** com instruções de compilação e execução;
- uma captura da saída completa do programa.

## 8. Perguntas para responder no README

1. Qual problema do exercício foi resolvido pelo Builder?
2. Por que PropostaComercial não deve ser Singleton?
3. Qual é o escopo real da unicidade de ConfiguracaoComercial?
4. Por que o Director é útil neste exercício, mas não é obrigatório para toda proposta?
5. Que dificuldade de teste surgiria se todas as classes chamassem ConfiguracaoComercial.getInstancia() internamente?

**Antes de enviar:** compile o projeto do zero, execute o método main e confira se duas propostas distintas foram construídas enquanto as duas consultas à configuração retornaram a mesma referência.