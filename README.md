# Resumo B3

## Escopo

Esse projeto tem como finalidade gerar um resumo das negociações realizadas na bolsa de valores nacional que facilite a análise dos ativos negociados.

## Descrição

O sistema é executado via linha de comandos, tem
uma interface gráfica, feito inteiramente na linguagem java, suportada pela ferramenta Maven.

Overview: o investidor faz o download, no formato para Execel, do relatório de todas suas negociações na [Área do investidor](https://www.investidor.b3.com.br/), lembrando de selecionar o período desejado. A aplicação é executada e o arquivo baixado é selecionado, ela retorna um arquivo com o resumo das negociações feitas.

## Iniciando

- `git clone https://github.com/nogueiralegacy/resumob3`
- cd `resumob3`

## Pré-requisitos

- JDK e Maven instalados e configurados

## Limpar, compilar e gerar o package

- `mvn clean` <br>
  remove o diretório _target_

- `mvn compile` <br>
  compila o projeto e deposita os resultados no diretório target

- `mvn package` <br>
  gera arquivo _resumob3.jar_ no diretório _target_. Observe que
  o arquivo gerado não é executável. Um arquivo jar é um arquivo no formato
  zip

## Executar a aplicação

### Gerar o package executável

- `mvn package -P executavel-unico` <br>
  gera um arquivo _resumob3-console-exec.jar_ no diretório _target_ que é executável

### Executar o package

- `java -jar target/resumob3-console-exec.jar` <br>
  executa o programa

Agora basta selecionar o arquivo com as negociações e o programa retornará um arquivo com o resumo das negociações.<br>
_Lembrando é necessário ter baixado o arquivo com as negociações no formato Execel na [Área do investidor](https://www.investidor.b3.com.br/)._
