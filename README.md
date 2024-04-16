# ceubclinc

Este projeto é parte da atividade de sistematização da disciplina de Programação e Desenvolvimento Web do curso Superior de Tecnologia em Análise e Desenvolvimento de Sistemas do Centro Universitátio de Brasília (CEUB).

# Solução desenvolvida
Uma API para acesso à disponibilidade dos profissionais de saúde de uma clínica fictícia que oferece diversos serviços de saúde. 


# Funcionalidades
- Lista de especilidades atendidas pela clinica com a respectiva lista de profissionais;
- Consulta com filtro por especialidade e/ou médico;

# Executando o projeto
O projeto foi construído na linguagem Java, versão 17, utilizando o framework Spring, versão 3.2.4. Não foi utilizado banco de dados e os dados estão armazenados em um json localizado na pasta src/main/resources/data.


Existem várias maneiras de executar uma aplicação Spring Boot em sua máquina local. Uma maneira é executar o método principal na classe `com.pwd.ceubclinic.CeubclinicApplication` na sua IDE.

- Baixe o zip ou clone o repositório Git.
- Descompacte o arquivo zip (se você baixou um);
- Abra o Prompt de Comando e altere o diretório (cd) para a pasta que contém o pom.xml;
- Importe o projeto conforme as especificidades de sua IDE;
- Escolha o arquivo Spring Boot Application (procure por @SpringBootApplication)
- Clique com o botão direito do mouse no arquivo e execute como aplicativo Java

Alternativamente, você pode usar o plugin Spring Boot Maven como segue:

`mvn spring-boot:run`

Utilize o postman, insomnia ou ferramentas equivalentes ou até mesmo um navegador para testar as funcionalidades.


```
* Endpoints
- Lista todas as especialidades com os respectivos profissionais
GET [/api/v1/specialties]

- Lista as especialidades e respectivos profissionais filtrando pelo nome ou parte do nome da especialidade informada
GET [/api/v1/specialties?specialty=cardiologia]

- Lista profissionais, agrupados por especilidade, filtrando pelo nome ou parte do nome do médico informado. 
GET [/api/v1/specialties?doctor=Ana]

- Lista as especialidades e respectivos profissionais filtrando pelo nome ou parte do nome da especialidade e médico informados
GET [/api/v1/specialties?specialty=cardiologia?doctor=ana&specialty=cardio]

```

Para testes via curl

```
curl http://localhost:8080/api/v1/specialties | json_pp
curl http://localhost:8080/api/v1/specialties\?specialty\=cardiologia | json_pp
curl http://localhost:8080/api/v1/specialties\?doctor\=ana\&specialty\=cardiologia | json_pp

```