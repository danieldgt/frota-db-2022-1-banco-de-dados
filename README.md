# frota-db-2022-2-banco-de-dados

documentação do PSQL - POSTGRESQL
https://www.postgresql.org/docs/7/app-psql.html

Conectar em um banco de dados específico 
-h endereco do host
-p porta do host
-U nome do usuário
-d nome do banco alvo
$ psql -h 200.17.32.221 -p 5432 -U postgres -d professor_frota

Executar arquivos em um banco de dados. para executar o comando abaixo
precisa estar na pasta do arquivo
-h endereco do host
-p porta do host
-d nome do banco alvo
-U nome do usuário
-a imprimir o que está sendo executado
-f arquivo que será executado
$ psql -h 200.17.32.221 -p 5432 -d professor_frota -U postgres -a -f inserts.sql


O Projeto tem um crud básico da entidade marca, e para testar o main está no path:
src/br/com/frota/util/Teste.java
