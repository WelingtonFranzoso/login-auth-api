# login-auth-api

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/WelingtonFranzoso/franzoso-agregador-de-investimentos/blob/main/LICENSE) 

# Sobre o projeto

Este projeto é uma API simples desenvolvida com Spring Boot e Spring Security, utilizando JWT para autenticação e autorização de usuários. O sistema oferece funcionalidades básicas de sign up e login de usuários, além de utilizar tokens JWT para liberar o acesso às requisições autenticadas.

# Funcionalidades
- Cadastro de usuários: Permite que novos usuários se cadastrem no sistema.
- Login de usuários: Realiza a autenticação de usuários já cadastrados e retorna um token JWT.
- Autenticação via JWT: As requisições são protegidas por meio de tokens JWT, garantindo que apenas usuários autenticados possam acessá-las.


# Tecnologias utilizadas
- Spring Boot: Framework Java para desenvolvimento de aplicações backend.
- Spring Security: Para autenticação e autorização de usuários.
- JWT: Para criação e validação de tokens de acesso.
- Banco de dados H2 para testes

# Como executar o projeto
## Back end
### Pré-requisitos: 
- Java 17 ou superior
- Maven (para construção do projeto)


```bash
# clonar repositório
git clone git@github.com:WelingtonFranzoso/login-auth-api.git

# entrar na pasta do projeto back end
cd login-auth-api

# executar o projeto
./mvnw spring-boot:run
```

# Autor

Welington Franzoso
https://www.linkedin.com/in/welington-franzoso-88a8301b9
