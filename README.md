### 🌍 Este projeto:
Tem como finalidade a validação de senhas do usuário por meio de API REST por meio de uma operação POST.

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

# O servidor inciará na porta:8080- acesse <http://localhost:8080/swagger-ui.html>
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