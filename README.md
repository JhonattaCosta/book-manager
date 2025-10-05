# 📖 BookManager API

> **[🇧🇷 Versão em Português](README-pt.md)**

A RESTful API for managing books, authors, and categories, built with Spring Boot.

## 📋 Overview

The project uses a clean architecture, separating concerns into three main layers:

-   **Core:** Contains the business logic and domain entities (Book, Author, Category).
-   **Infrastructure:** Responsible for implementing gateways, data persistence with Spring Data JPA, and application configuration.
-   **Presentation:** Exposes the REST API using Spring MVC, with controllers for each entity.

## 🛠️ Tech Stack

-   **Java 17**
-   **Spring Boot 3**
-   **Maven** as the dependency manager
-   **Spring Data JPA (Hibernate)** for data persistence
-   **PostgreSQL** as the database
-   **Flyway** for database migrations
-   **Docker** for the development environment
-   **Lombok** to reduce boilerplate code


## ⚙️ Setup and Installation

1.  **Clone the repository:**

    ```bash
    git clone <your-repository-url>
    cd BookManager
    ```

2.  **Configure environment variables:**

    Create a `.env` file in the project root. This file is used to configure the connection to the database that will be run via Docker. Replace the placeholder values with your own.

    **`.env` example:**
    ```env
    # Database name (can keep the default)
    DB_NAME=bookmanager

    # Database user
    DB_USER=your_user_here

    # Database password
    DB_PASSWORD=your_password_here

    # JDBC connection URL (can keep the default if host and port do not change)
    DB_URL=jdbc:postgresql://localhost:5432/bookmanager
    ```

3.  **Start the database with Docker:**

    Run the following command to start a PostgreSQL container with the settings defined in `docker-compose.yml`.

    ```bash
    docker-compose up -d
    ```

    The database will be accessible at `localhost:5432`.

4.  **Run the application:**

    Use the Maven Wrapper to compile and run the Spring Boot application. Flyway will automatically run the database migrations on startup.

    ```bash
    ./mvnw spring-boot:run
    ```

    The API will be available at `http://localhost:8080`.

## 🧪 API Endpoints

### Testing with Postman

The base URL for all endpoints is `/bookmanager`.



### Authors (`/author`)

| Method   | Endpoint                 | Description                             |
| :------- | :----------------------- | :-------------------------------------- |
| `POST`   | `/createauthor`          | Creates a new author.                   |
| `GET`    | `/findall`               | Lists all authors.                      |
| `GET`    | `/findid/{id}`           | Finds an author by their ID.            |
| `PATCH`  | `/update/{id}`           | Updates an author's data.               |
| `DELETE` | `/delete/{id}`           | Deletes an author by their ID.          |

### Books (`/book`)

| Method   | Endpoint                 | Description                             |
| :------- | :----------------------- | :-------------------------------------- |
| `POST`   | `/create`                | Creates a new book.                     |
| `GET`    | `/findall`               | Lists all books.                        |
| `GET`    | `/findname/{name}`       | Finds books by name.                    |
| `GET`    | `/findauthor/{author}`   | Finds books by the author's name.       |
| `PATCH`  | `/update/{id}`           | Updates a book's data.                  |
| `DELETE` | `/delete/{id}`           | Deletes a book by its ID.               |

### Categories (`/category`)

| Method   | Endpoint                 | Description                             |
| :------- | :----------------------- | :-------------------------------------- |
| `POST`   | `/createcategory`        | Creates a new category.                 |
| `GET`    | `/listallcategory`       | Lists all categories.                   |
| `GET`    | `/listbyid/{id}`         | Finds a category by its ID.             |
| `PATCH`  | `/update/{id}`           | Updates a category's data.              |
| `DELETE` | `/delete/{id}`           | Deletes a category by its ID.           |

## 🔮 Future Features Roadmap

- [ ] **Improved Exception Handling:** Implement more specific exception handlers to provide clearer and standardized error feedback in the API.
- [ ] **Unit and Integration Tests:** Increase test coverage to ensure the robustness and reliability of the business logic and endpoints.
- [ ] **Swagger (OpenAPI) Documentation:** Integrate Swagger to generate interactive API documentation, making it easier to use and test the endpoints.
- [ ] **Book Loan System:** Add the functionality to "rent" books, controlling availability status and loan/return dates.
- [ ] **User Management and Authentication:** Implement a user system with different roles (e.g., `EMPLOYEE`, `CUSTOMER`) and add authentication/authorization to the endpoints.

## 📝 License

This project is under the MIT license. See the [LICENSE](LICENSE) file for more details.

## 👥 Authors

- **Jhonatta Costa** - *Initial development* - [JhonattaCosta](https://github.com/JhonattaCosta)
