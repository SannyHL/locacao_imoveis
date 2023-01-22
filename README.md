
<h1 align="center">💻 Controle Locação Imoveis</h1>

<div align="center"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" height="70px"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" height="70px"/>
<img src="https://raw.githubusercontent.com/docker-library/docs/c408469abbac35ad1e4a50a6618836420eb9502e/mysql/logo.png" height="70px"/></div>
<br>
<br>
<h4 align="right">Api de controle de locação de imóveis.</h4>

---------------------------------

<h2 align="center">⚠️Script para a criação do Banco de dados no MySql:</h2> 
<br>
<h5>CREATE DATABASE DB_LOCACAO; <br> USE DB_LOCACAO;</h5>
⚠️As Tabelas e colunas serão criadas automaticamente ao rodar a API, sendo necessário somente a criação do banco de dados, através do script informado.

<br>
<h2>Recursos disponíveis</h2>

- [x] **Cadastro de clientes:**
<br>Caminho local: http://localhost:8080/api/v1/clientes
- [X] **Buscar todos os clientes:**
<br>Caminho local: http://localhost:8080/api/v1/clientes
- [X] **Buscar cliente por ID:**
<br>Caminho local: http://localhost:8080/api/v1/clientes/{id}
- [x] **Exclusão de clientes:**
<br>Caminho local: http://localhost:8080/api/v1/clientes/deletar-cliente/{id}
- [X] **Atualização de clientes:**
<br>Caminho local: http://localhost:8080/api/v1/clientes/atualizar-cliente/{id}
-----------------------------
- [x] **Cadastro de Imóveis:**
<br>Caminho local: http://localhost:8080/api/v1/imoveis
- [X] **Buscar todos os imóveis:**
<br>Caminho local: http://localhost:8080/api/v1/imoveis
- [x] **Exclusão de Imóveis:**
<br>Caminho local: http://localhost:8080/api/v1/imoveis/deletar-imovel/{id}
- [X] **Atualização de Imóveis:**
<br>Caminho local: http://localhost:8080/api/v1/imoveis/atualizar-imovel/{id}
- [X] **Buscar imóveis por ID:**
<br>Caminho local: http://localhost:8080/api/v1/imoveis/{id}
- [X] **Buscar imóveis por ativos:**
<br>Caminho local: http://localhost:8080/api/v1/imoveis/buscar-imoveis-ativos
- [X] **Buscar imóveis por inativos:**
<br>Caminho local: http://localhost:8080/api/v1/imoveis/buscar-imoveis-inativos
- [X] **Buscar imóveis por locados:**
<br>Caminho local: http://localhost:8080/api/v1/imoveis/buscar-imoveis-locados
- [X] **Buscar imóveis por não locados:**
<br>Caminho local: http://localhost:8080/api/v1/imoveis/buscar-imoveis-nao-locados
------------------------------
- [x] **Cadastro de contratos:**
<br>Caminho local: http://localhost:8080/api/v1/contratos
- [X] **Buscar todos os contratos:**
<br>Caminho local: http://localhost:8080/api/v1/contratos
- [X] **Buscar contratos por ID:**
<br>Caminho local: http://localhost:8080/api/v1/contratos/{id}
- [x] **Exclusão de contratos:**
<br>Caminho local: http://localhost:8080/api/v1/contratos/deletar-cliente/{id}
- [X] **Atualização de contratos:**
<br>Caminho local: http://localhost:8080/api/v1/contratos/atualizar-contrato/{id}
------------------------------
- [X] **Buscar todos os Endereços:**
<br>Caminho local: http://localhost:8080/api/v1/enderecos
- [X] **Buscar Endereços por CEP:**
<br>Caminho local: http://localhost:8080/api/v1/enderecos/{CEP}
------------------------------
- [X] Utilização do Swagger para executar as solicitações
<br>Caminho local: http://localhost:8080/swagger-ui/index.html#/<br>

- **Além do Swagger as requisições podem ser realizadas através dos caminhos informados acima, por aplicativos como [Postman](https://www.postman.com/), [IInsomnia](https://insomnia.rest/download) e também por um Front-End.**
<br>

<h2>Pré-requisitos</h2>

#### Para utilizar o código da API, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
- Java - a versão utilizada nesse projeto foi a 17.
- Um editor para trabalhar com o código como [VSCode](https://code.visualstudio.com/) e o [Intellij](https://www.jetbrains.com/idea/download)

### 🎲 Rodando a API na localmente

```bash

➩ Clone este repositório
$ git clone <https://github.com/SannyHL/locacao_imoveis.git>

➩ Acesse o código com o editor de sua preferência

➩ Utilize a branch main
$ git checkout main

➩ Instale as dependências que estão no pom.xml(normalmente o proprio editor instala as dependências)

➩ Rode o Spript para criar o Banco de Dados. 
Script: CREATE DATABASE DB_LOCACAO; 
        USE DB_LOCACAO;"

➩ Ajuste as configurações para o seu banco de dados, no arquivo application.properties que se encontra dentro da pasta resource. 

➩ Rode a aplicação

➩ O servidor inciará na porta:8080 por default - acesse <http://localhost:8080>

➩ O caminho para acessar o Swagger é: <http://localhost:8080/swagger-ui/index.html#/>

```

<h2 align="center">❗ Importante<br></h2>

➩ Para criação de cliente, imoveis e contratos não se faz necessário informar o ID pois ele será gerado automaticamente.

➩ Ao salvar ou atualizar um cliente ou um imóvel,o endereço é salvo automaticamente através da API do Via Cep, sendo
necessário informar somente o cep e o número da moradia.

➩ A exclusão de um contrato ou imóvel é realizaza de forma lógica, dessa forma seu registro permanece no banco de dados. 
Mas a exclusão de cliente é realizada de forma definitiva. <br>

-----------------------------------

<h3>✏️ Exemplo de Json para criação de Cliente:<br></h3>

![image](https://user-images.githubusercontent.com/104280692/213899057-770d4a27-417f-4ccb-94d2-1c7c66905e2a.png)

<h3>✏️ Exemplo de Json para Criação de Imóvel:<br></h3>

![image](https://user-images.githubusercontent.com/104280692/213899141-154d563c-753d-4b06-af44-7c8de996d64a.png)

<h3>✏️ Exemplo de Json para criação de Contrato:<br></h3>

![image](https://user-images.githubusercontent.com/104280692/213900448-3a83df3b-f487-4218-9e31-c83ee43fee62.png)



### 🛠 Tecnologias utilizadas na construção do projeto:

- Java
- Spring Framework
- MySql
- Swagger
- JPA
- API Via Cep


### Autora
---

<img src="https://user-images.githubusercontent.com/104280692/194205159-83b3bca2-3f59-40cd-b909-9bb0b8e40825.png" width="250px;" alt=""/>
Criado com ❤️ por Sanny Helen Lima <br>
⭐ Entre em contato!
<br>


[![Linkedin Badge](https://img.shields.io/badge/-SannyHL-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/sannyhelenlima/)](https://www.linkedin.com/in/sannyhelenlima) 
[![Gmail Badge](https://img.shields.io/badge/-sannyhelenlima@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:sannyhelenlima@gmail.com)](mailto:sannyhelenlima@gmail.com)
