# Task Manager API — Spring Security

![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1-6DB33F?logo=springboot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?logo=springsecurity&logoColor=white)
![H2](https://img.shields.io/badge/H2-in--memory-1E90FF)

API REST para **gerenciamento de tarefas**, com rotas protegidas por **Spring Security**. Os usuários e seus papéis (roles) ficam no banco, e o carregamento é feito por um `UserDetailsService` próprio. Para facilitar os testes, a persistência usa o banco **H2** em memória.

## Funcionalidades

- CRUD de tarefas (título, descrição, status e data de entrega)
- Autenticação e autorização com Spring Security e usuários persistidos com roles
- Console do H2 disponível em `/h2` para inspecionar os dados

## Endpoints

| Método | Rota | Descrição |
|---|---|---|
| `GET` | `/tasks` | Lista tarefas |
| `GET` | `/tasks/{taskId}` | Busca tarefa por id |
| `POST` | `/tasks` | Cria tarefa |
| `PUT` | `/tasks/{taskId}` | Atualiza tarefa |
| `DELETE` | `/tasks/{taskId}` | Remove tarefa |

```json
POST /tasks
{
  "title": "Estudar Spring Security",
  "description": "Revisar filtros e autenticação",
  "status": "PENDENTE",
  "dueDate": "2023-11-10"
}
```

## Como executar

```bash
cd CheckDigital
./mvnw spring-boot:run
```

A API sobe em `http://localhost:8080`. O usuário padrão é `admin`, e a senha pode ser definida com a variável `ADMIN_PASSWORD` (padrão: `admin123`). Não é preciso configurar banco, porque o H2 sobe junto com a aplicação.

---

Projeto acadêmico desenvolvido na **FIAP** (Digital Business Enablement, 2023).
