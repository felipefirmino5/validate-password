### 🌍 Este projeto:
Tem como finalidade a validação de senhas do usuário por meio de API REST.  
Tecnologias utilizadas:  
Spring Boot  
Java8  
Swagger  
Maven

### 🚀 Como Iniciar:
Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:

[Java 8](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html)  
[Maven 3](https://maven.apache.org/download.cgi)  
[Download IntellJ](https://www.jetbrains.com/pt-br/idea/download/) ou uma IDE de sua preferência (IntellJ, Eclipse, STS etc)


### 🎲 Rodando o Back End (servidor)

```bash
# Clone este repositório
$ git clone <https://github.com/felipefirmino5/validate-password.git>

# Acesse a pasta do projeto no terminal/cmd
$ cd validate-password

# Rode o comando
$ mvn clean install

# Execute a aplicação em modo de desenvolvimento
$ acesse a pasta target(Gerada após execução do comando acima) e execute o comando  java -jar validador-0.0.1.jar 

# O servidor inciará na porta:8080 acesse <http://localhost:8080/swagger-ui.html>
```
### 🏃‍♀️ Rodando os testes de integração
```bash
# No Diretório do projeto execute:
$ mvn test

# O Resultado esperado:
```
![alt text](https://github.com/felipefirmino5/validate-password/blob/main/assets/test_integracao.png?raw=true)

### 🏃‍♀️ Rodando os testes unitários
```bash
# No Diretório do projeto execute:
$ mvn test

# O Resultado esperado:
```
![alt text](https://github.com/felipefirmino5/validate-password/blob/main/assets/test_unit.png?raw=true)


### 💻 Testando a aplicação
```bash
# CURL
curl -X POST "http://localhost:8080/valida" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"senha\": \"AAAbbbCc\"}"

# Swagger
# acesse <http://localhost:8080/swagger-ui.html>
# informe a senha no objeto
 {
  "senha": "AbTp9!fok"
}
# Clique em execute
```
![alt text](https://github.com/felipefirmino5/validate-password/blob/main/assets/swagger.png?raw=true)

```bash
# O Resultado será:
{
  "retorno": true
}
# ou
{
  "retorno": false
}

```
![alt text](https://github.com/felipefirmino5/validate-password/blob/main/assets/swagger_result.png?raw=true)


###🕵🏻‍♂️ Detalhes da Implementação
```bash
# Regras definidas: 1 - Nove ou mais caracteres
#          2 - Ao menos 1 dígito
#          3 - Ao menos 1 letra minúscula e Ao menos 1 letra maiúscula
#          4 - Ao menos 1 caractere especial (!@#$%^&*()-+)
#          5 - Não possuir caracteres repetidos dentro do conjunto
# Obs: Considerei (por ex:A e a) como sendo o mesmo caractere
 ```

A implementação foi realizada utilizando expressões regulares.  
A Classe ValidatorPasswordRegexImpl Implementa o metodo ValidatorPassword(Password value),  com essa abordagem, ganhamos flexibilidade na 
implementação de novas formas de validação, utilizando BeansValidator por exemplo.  
A implementação desse metodo realiza as seguintes verfições:  
1 - Testa se o objeto Password recebido no argumento do metodo é diferente de nulo (Evitar uma NPE)  
2 - Em Seguida testa se a senha é diferente de nulo  
3 - Por fim testa se a string não contém um ou mais espaços vazios (" ")  
4 - Se todas as premissas acima forem atendidas:  
4.1 - Verifica se existem repetições de caracteres (Via REGEX)  
4.2 - Verifica se as condições são atendidas (1 digito, 1 letra maiuscula, 1 minuscula, 1 caractere especial e pelo menos 9 digitos)  
5 - Não contendo repetições e atendendo os requisitos acima, o metodo retorna true, caso contrário, retorna false.


A implementação de ValidatorPasswordRegexImpl é consumida por um RestController implementado na classe ValidatorControllerRestImpl.  
A classe ValidatorControllerRestImpl implementa a interface ValidatorController, cujo objetivo é padronizar novas implementações caso necessário (Ex: Um endpoint baseado em SOAP).  
É exposto uma operação POST (/valida) (Optei em utilizar o POST ao invés do GET para trafegar o objeto no body da requsição, facilitando alguma implementação de criptografia por exemplo).

Para a construção das duas expressões regulares, utiliezei o site [Regex Testing](https://www.regextester.com/), cujo objetivo é validar o funcionamento da expressão.

### 🛠 Estrutura da aplicação
```bash
  pacote business: Implementação de toda regra de negócio
pacote controller: Implementação dos controladores de in/out da aplicação
    pacote domain: Representação das entidades de dominio da aplicação
```
![alt text](https://github.com/felipefirmino5/validate-password/blob/main/assets/packs.png?raw=true)
