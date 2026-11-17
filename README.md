# Avaliacao semestral - Padroes de Projetos

Joao Gabriel Mota Kochla

Implementacao em Java, utilizando somente a biblioteca padrao.

## Questao 1 - Provisionamento multinuvem

Abstract Factory cria os recursos de Aws e Azure. Configuracao e Auditoria
usam Singleton. A auditoria e os contadores de recursos usam sincronizacao.
O orcamento e verificado antes de criar os recursos.

Execute os comandos dentro de `questao1`, para carregar `config.properties`:

```sh
javac -encoding UTF-8 -d bin src/*.java
java -cp bin Main
```

A Main demonstra dois provisionamentos simultaneos, tres ambientes aceitos
e um recusado por orcamento. O historico final possui quatro registros.

## Questao 2 - Casa de leiloes

Observer comunica os lances aos interessados, Strategy permite trocar a
comissao e Decorator permite combinar e repetir os servicos da fatura.

Execute os comandos dentro de `questao2`:

```sh
javac -encoding UTF-8 -d bin src/*.java
java -cp bin Main
```

A Main demonstra dois lotes, tres participantes, painel e auditor, lances
aceitos e recusados, saida do acompanhamento, campanha de comissao, lote
vendido e nao vendido, e servicos adicionais com embalagem repetida.

## Diagramas

Os diagramas ainda estao pendentes nesta etapa.
