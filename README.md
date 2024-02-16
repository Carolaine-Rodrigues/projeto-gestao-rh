# Documentação da API REST do Sistema de RH

## Visão Geral

Esta API REST é utilizada para realizar operações básicas de gerenciamento de funcionários em um sistema de Recursos Humanos (RH). Além disso, fornece endpoints para autenticação de usuários que gerenciam o sistema.

Base URL: `http://localhost:8084/employee/`

## Endpoints

### Cadastro de Funcionários

#### Criar Funcionário

- **Método:** POST
- **URL:** `http://localhost:8084/employee/save`
- **Descrição:** Cria um novo funcionário no sistema.

- **Exemplo de Corpo da Requisição:**
  ```json
  { 
    "name": "Carolina",
    "email": "cah@gmail.com",
    "position": "Cargo do Funcionário",
    "salary": 50000.00,
    "hireDate": "2024-01-28"

}

- **Resposta de Sucesso:** Código HTTP 200(ok)
- **Resposta de Erro:** Código HTTP 400 (Bad Request) em caso de parâmetros inválidos.

#### Listar Funcionários

- **Método:** GET
- **URL:** `http://localhost:8084/employee/`
- **Descrição:** Retorna a lista de todos os funcionários cadastrados no sistema.
- **Parâmetros:** Nenhum.
- **Resposta de Sucesso:** Código HTTP 200 (OK) com a lista de funcionários.
- **Resposta de Erro:** Código HTTP 404 (Not Found) se não houver funcionários cadastrados.

### Atualização e Deleção de Funcionários

#### Atualizar Funcionário

- **Método:** PUT
- **URL:** `http://localhost:8084/employee/update/{id}`
- **Descrição:** Atualiza as informações de um funcionário existente no sistema.
- **Parâmetros:**
    - `nome` (string): O novo nome do funcionário.
    - `email`(string): O novo email do funcionário.
    - `cargo` (string): O novo cargo do funcionário.
    -  `salário` (bigdecimal): O novo salário do funcionário.
- **Exemplo de Corpo da Requisição:**
  ```json
   "name": "Carolina",
    "email": "cah@gmail.com",
    "position": "Cargo do Funcionário",
    "salary": 50000.00
  ```
- **Resposta de Sucesso:** Código HTTP 200 (OK) com os dados atualizados do funcionário.
- **Resposta de Erro:** Código HTTP 404 (Not Found) se o funcionário não for encontrado.

#### Deletar Funcionário

- **Método:** DELETE
- **URL:** `http://localhost:8084/employee/delete/{id}/`
- **Descrição:** Remove um funcionário do sistema.
- **Parâmetros:**
    - `id` (integer): O ID do funcionário a ser removido.
- **Resposta de Sucesso:** Código HTTP 204 (No Content).
- **Resposta de Erro:** Código HTTP 404 (Not Found) se o funcionário não for encontrado.

### Autenticação de Usuários

#### Login de Usuário

- **Método:** POST
- **URL:** `http://localhost:8084/user/save`
- **Descrição:** Realiza o login de um usuário que gerencia o sistema.
- **Parâmetros:**
    - `name` (string): O nome de usuário.
    - `e-mail` (string): O e-mail de usuário.
    - `password` (string): A senha do usuário que ultiliza criptrografia.
- **Exemplo de Corpo da Requisição:**
  ```json
  {
  "name": "teste7",
  "email": "teste@email.com",
  "password": "senha346"
}
  ```
- **Resposta de Sucesso:** Código HTTP 200 (OK) .
- **Resposta de Erro:** Código HTTP 401 (Unauthorized) se as credenciais estiverem incorretas.


```

