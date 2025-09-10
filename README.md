# Web Services Project

Este projeto é uma API REST em **Spring Boot** para gerenciar usuários, utilizando **Spring Data JPA** com suporte a banco de dados **H2** e **PostgreSQL**. Feito para fins de estudo e prática de acordo com os exercícios do curso de Nélio Alves

A API possui endpoints para criar, consultar, atualizar e deletar usuários, com tratamento de exceções padronizado e validação de dados.

---

## Tecnologias

- Java 17
- Spring Boot 3.5.4
- Spring Data JPA
- H2 Database (desenvolvimento)
- PostgreSQL (produção)
- Lombok
- Maven

---

## Endpoints - UserController

Base URL: `/usuarios`

### 1. Listar todos os usuários
GET /usuarios

**Resposta:**

- Status 200 OK  
- Body: JSON com lista de usuários

```json
[
  {
    "id": 1,
    "name": "Vic",
    "email": "vic@gmail.com",
    "phone": "9999999"
  },
  {
    "id": 2,
    "name": "Carol",
    "email": "carol@gmail.com",
    "phone": "98989898"
  }
]
```


### 2. Consultar usuário por ID
GET /usuarios/{id}

Parâmetros:

`id (path) - ID do usuário`

Respostas possíveis:

* 200 OK: usuário encontrado
```json

  {
    "id": 1,
    "name": "Vic",
    "email": "vic@gmail.com",
    "phone": "9999999"
  }

```

  

* 404 Not Found: usuário não existe (JSON de erro padronizado)

```json
  "timestamp": "2025-09-10T12:30:00Z",
  "status": 404,
  "error": "Recurso nao encontrado",
  "path": "/usuarios/5"
```



### 3. Criar um novo usuário



