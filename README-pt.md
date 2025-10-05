# 📖 BookManager API

> **[🇺🇸 English Version](README.md)**

Uma API RESTful para gerenciar livros, autores e categorias, construída com Spring Boot.

## 📋 Visão Geral

O projeto utiliza uma arquitetura limpa, separando as preocupações em três camadas principais:

-   **Core:** Contém a lógica de negócio e as entidades do domínio (Livro, Autor, Categoria).
-   **Infrastructure:** Responsável pela implementação de gateways, persistência de dados com Spring Data JPA, e configuração da aplicação.
-   **Presentation:** Expõe a API REST usando Spring MVC, com controllers para cada entidade.

## 🛠️ Tecnologias Utilizadas

-   **Java 17**
-   **Spring Boot 3**
-   **Maven** como gerenciador de dependências
-   **Spring Data JPA (Hibernate)** para persistência de dados
-   **PostgreSQL** como banco de dados
-   **Flyway** para migrações de banco de dados
-   **Docker** para ambiente de desenvolvimento
-   **Lombok** para reduzir código boilerplate

## ⚙️ Configuração e Instalação

1.  **Clone o repositório:**

    ```bash
    git clone <url-do-seu-repositorio>
    cd BookManager
    ```

2.  **Configure as variáveis de ambiente:**

    Crie um arquivo `.env` na raiz do projeto. Este arquivo é usado para configurar a conexão com o banco de dados que será executado via Docker. Substitua os valores de placeholder pelos seus.

    **Exemplo de `.env`:**
    ```env
    # Nome do banco de dados (pode manter o padrão)
    DB_NAME=bookmanager

    # Usuário para o banco de dados
    DB_USER=seu_usuario_aqui

    # Senha para o banco de dados
    DB_PASSWORD=sua_senha_aqui

    # URL de conexão JDBC (pode manter o padrão se o host e a porta não mudarem)
    DB_URL=jdbc:postgresql://localhost:5432/bookmanager
    ```

3.  **Inicie o banco de dados com Docker:**

    Execute o comando a seguir para iniciar um container PostgreSQL com as configurações definidas no `docker-compose.yml`.

    ```bash
    docker-compose up -d
    ```

    O banco de dados estará acessível em `localhost:5432`.

4.  **Execute a aplicação:**

    Use o Maven Wrapper para compilar e executar a aplicação Spring Boot. O Flyway executará as migrações do banco de dados automaticamente na inicialização.

    ```bash
    ./mvnw spring-boot:run
    ```

    A API estará disponível em `http://localhost:8080`.

## 🧪 Endpoints da API

### Testando com Postman

A base URL para todos os endpoints é `/bookmanager`.

### Autores (`/author`)

| Método   | Endpoint                 | Descrição                               |
| :------- | :----------------------- | :---------------------------------------- |
| `POST`   | `/createauthor`          | Cria um novo autor.                       |
| `GET`    | `/findall`               | Lista todos os autores.                   |
| `GET`    | `/findid/{id}`           | Busca um autor pelo seu ID.               |
| `PATCH`  | `/update/{id}`           | Atualiza os dados de um autor.            |
| `DELETE` | `/delete/{id}`           | Deleta um autor pelo seu ID.              |

### Livros (`/book`)

| Método   | Endpoint                 | Descrição                               |
| :------- | :----------------------- | :---------------------------------------- |
| `POST`   | `/create`                | Cria um novo livro.                       |
| `GET`    | `/findall`               | Lista todos os livros.                    |
| `GET`    | `/findname/{name}`       | Busca livros pelo nome.                   |
| `GET`    | `/findauthor/{author}`   | Busca livros pelo nome do autor.          |
| `PATCH`  | `/update/{id}`           | Atualiza os dados de um livro.            |
| `DELETE` | `/delete/{id}`           | Deleta um livro pelo seu ID.              |

### Categorias (`/category`)

| Método   | Endpoint                 | Descrição                               |
| :------- | :----------------------- | :---------------------------------------- |
| `POST`   | `/createcategory`        | Cria uma nova categoria.                  |
| `GET`    | `/listallcategory`       | Lista todas as categorias.                |
| `GET`    | `/listbyid/{id}`         | Busca uma categoria pelo seu ID.          |
| `PATCH`  | `/update/{id}`           | Atualiza os dados de uma categoria.       |
| `DELETE` | `/delete/{id}`           | Deleta uma categoria pelo seu ID.         |

## 🔮 Roadmap de Futuras Features

- [ ] **Melhoria no Tratamento de Exceções:** Implementar handlers de exceções mais específicos para fornecer feedback de erro mais claro e padronizado na API.
- [ ] **Testes Unitários e de Integração:** Aumentar a cobertura de testes para garantir a robustez e a confiabilidade da lógica de negócio e dos endpoints.
- [ ] **Documentação com Swagger (OpenAPI):** Integrar o Swagger para gerar documentação interativa da API, facilitando o uso e o teste dos endpoints.
- [ ] **Sistema de Empréstimo de Livros:** Adicionar a funcionalidade de "alugar" livros, controlando o status de disponibilidade e as datas de empréstimo e devolução.
- [ ] **Gerenciamento de Usuários e Autenticação:** Implementar um sistema de usuários com diferentes papéis (ex: `FUNCIONARIO`, `CLIENTE`) e adicionar autenticação/autorização aos endpoints.

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👥 Autores

- **Jhonatta Costa** - *Desenvolvimento inicial* - [JhonattaCosta](https://github.com/JhonattaCosta)
