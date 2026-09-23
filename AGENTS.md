# AGENTS.md

## Objetivo do repositório

Este repositório reúne as atividades da disciplina de Arquitetura e Padrões de Software, com foco na implementação prática de Design Patterns.

Cada atividade deve ser mantida isolada em sua própria pasta, por exemplo:

- `Atv2`
- `Atv3-qualquer-legenda`

## Regra principal

Ao trabalhar em uma atividade, leia primeiro o arquivo `.md` de instruções existente dentro da pasta correspondente. A implementação deve seguir esse arquivo estritamente, de forma pragmática.

As instruções da atividade são a fonte de verdade para:

- linguagem, versão e dependências;
- estrutura e nomes de classes, interfaces e métodos;
- padrões de projeto exigidos;
- regras, restrições e critérios de aceitação;
- exemplos de execução e perguntas que precisam ser respondidas.

Não invente requisitos, não expanda o escopo e não faça refatorações ou melhorias que não sejam necessárias para cumprir a atividade.

## Organização das atividades

- Crie uma nova pasta para cada atividade.
- Use um nome identificável, como `Atv2` ou `Atv3-NomeDaAtividade`.
- Coloque dentro dela o arquivo Markdown recebido com as instruções.
- Mantenha nessa pasta todo o código, documentação e demais arquivos relacionados à atividade.
- Não misture classes, recursos ou respostas de atividades diferentes.

### Localização obrigatória dos arquivos

- As pastas das atividades ficam diretamente na raiz do repositório, no mesmo nível de `AGENTS.md`.
- A implementação deve ficar diretamente na raiz da pasta da atividade, organizada apenas em subpastas funcionais quando isso for necessário (por exemplo, `entrega/` e `pagamento/`).
- Não crie um diretório global `src/` nem uma camada adicional como `src/atv1`, `src/atv2` ou equivalente.
- O Markdown de instruções, documentação, respostas e demais arquivos da atividade também devem permanecer dentro da respectiva pasta.
- Se uma atividade Java usar `package`, os diretórios do pacote devem partir diretamente da pasta da atividade; se o `package` for opcional e a atividade exigir a implementação na raiz, prefira o pacote padrão.
- Ao mover uma atividade, atualize as configurações de execução e de projeto que apontarem para os caminhos ou nomes de classes antigos.

Essa regra de localização é uma convenção do repositório e não substitui as instruções específicas de cada atividade. O Markdown da atividade continua sendo a fonte de verdade para linguagem, contratos, padrões, restrições e critérios de aceitação.

## Execução das tarefas

1. Identifique a pasta da atividade e leia integralmente suas instruções.
2. Verifique a estrutura e os arquivos já existentes antes de editar.
3. Implemente somente o que foi solicitado no Markdown.
4. Preserve os contratos, nomes e restrições definidos pela atividade.
5. Compile e execute o projeto quando isso fizer parte dos requisitos ou for possível no ambiente.
6. Corrija erros reais encontrados na implementação e valide novamente.
7. Informe claramente qualquer verificação que não pôde ser realizada.

## Artefatos visuais

Se as instruções pedirem captura de tela, print da execução, diagrama UML, diagrama de classes ou outro artefato visual, não gere nem faça essa parte. Esses artefatos serão produzidos manualmente pelo responsável pelo repositório.

Essa exceção vale apenas para a produção do artefato visual. Ainda devem ser implementados e verificados os requisitos de código, execução, documentação textual, respostas e demais entregas não visuais descritas nas instruções.

Quando a atividade exigir um arquivo ZIP, o responsável adicionará manualmente os artefatos visuais ao pacote após produzi-los.

## Estilo de implementação

- Seja direto e pragmático.
- Prefira a solução mais simples que cumpra integralmente a especificação.
- Não use frameworks, bibliotecas ou recursos proibidos pelas instruções da atividade.
- Não deixe pseudocódigo, métodos vazios, reticências ou `TODO` quando forem proibidos.
- Não altere uma atividade anterior para resolver uma atividade nova, salvo se as instruções determinarem isso explicitamente.
