# helpRegistrationAPI

## Descrição

Este projeto é uma aplicação web para gerenciar o cadastro de colaboradores e suas atividades. O sistema permite o registro de informações sobre colaboradores e facilita a organização de tarefas associadas a cada um deles.

## Funcionalidades

### Parte 1: Cadastro de Colaboradores

1. **Cadastro de Colaboradores:**
   - Permite adicionar novos colaboradores com os seguintes campos:
     - Nome completo
     - Cargo
     - Data de admissão
     - Setor
     - Salário
   - Valida os dados inseridos, garantindo que o salário seja um valor positivo.

2. **Listagem de Colaboradores:**
   - Exibe a lista de colaboradores cadastrados.
   - Permite filtrar colaboradores por setor.

3. **Detalhes do Colaborador:**
   - Ao clicar em um colaborador na lista, exibe os detalhes completos (todos os campos).

### Parte 2: Cadastro de Atividades

1. **Descrição da Atividade:**
   - Permite adicionar novas atividades com uma descrição detalhada.
   - Associa cada atividade a um colaborador específico.

2. **Listagem de Atividades:**
   - Exibe a lista de atividades cadastradas.
   - Permite filtrar atividades por colaborador ou por status (pendente, em andamento, concluída).

3. **Atualização de Status:**
   - Permite marcar uma atividade como concluída.

### Bônus (opcional):
- Implementar autenticação usando JWT (JSON Web Tokens) para proteger o acesso à aplicação.
- Adicionar paginação na listagem de colaboradores e atividades.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.3.2
- Spring Data JPA
- Spring Security
- Spring Validation
- H2 Database para testes
- Lombok para facilitar a criação de classes
- JWT para autenticação (bônus)

- Execução do Projeto
Para executar o projeto, você precisará ter o Java 17 e o Maven instalados. Siga os passos abaixo:

Clone este repositório:
```shell
git clone <URL_DO_REPOSITORIO>
cd helpRegistration
```

```shell
mvn spring-boot:run
```

## Estrutura do Projeto

O projeto segue o padrão de estrutura do Maven. Abaixo, um resumo do arquivo `pom.xml`:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" ... >
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.3.2</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    ...
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        ...
    </dependencies>
    ...
</project>
```

## Rotas da Aplicação

### Colaboradores

| Método | Rota                     | Descrição                                   |
|--------|--------------------------|---------------------------------------------|
| GET    | `/collaborator/{id}`     | Busca um colaborador pelo ID.              |
| GET    | `/collaborator`          | Lista todos os colaboradores.               |
| POST   | `/collaborator`          | Cria um novo colaborador.                   |
| PUT    | `/collaborator/{id}`     | Atualiza um colaborador existente pelo ID.  |
| DELETE | `/collaborator/{id}`     | Remove um colaborador pelo ID.              |

### Atividades

| Método | Rota                   | Descrição                                   |
|--------|------------------------|---------------------------------------------|
| GET    | `/activity/{id}`       | Busca uma atividade pelo ID.                |
| GET    | `/activity`            | Lista todas as atividades.                  |
| POST   | `/activity`            | Cria uma nova atividade.                    |
| PUT    | `/activity/{id}`       | Atualiza uma atividade existente pelo ID.    |


## Stay in touch

- Author - https://www.linkedin.com/in/jefferson-coelho/
- Website - https://github.com/BioJJ
- Twitter - https://twitter.com/bio_jefferson
