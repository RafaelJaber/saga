[JAVA_BADGE]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[SWAGGER_BADGE]: https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white
[DOCKER_BADGE]: https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white
[POSTGRES_BADGE]: https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white
[KAFKA_BADGE]: https://img.shields.io/badge/Apache%20Kafka-000?style=for-the-badge&logo=apachekafka

<h1 align="center" style="font-weight: bold;">Saga Project 📋</h1>

<div style="text-align: center;">

![java][JAVA_BADGE]
![spring][SPRING_BADGE]
![Docker][DOCKER_BADGE]
![Swagger][SWAGGER_BADGE]
![Postgres][POSTGRES_BADGE]
![Apache Kafka][KAFKA_BADGE]

</div>

<p align="center">
 <a href="#tech">Tecnologias</a> • 
 <a href="#description">Descrição do Projeto</a> • 
 <a href="#motivation">Motivação do Projeto</a> • 
 <a href="#started">Getting Started</a> • 
 <a href="#routes">Endpoints da API</a> •
 <a href="#branches">Branches</a> •
 <a href="#colab">Colaboradores</a> • 
 <a href="#thanks">Agradecimentos</a>
</p>

O **Projeto Saga** foi desenvolvido para aprimorar habilidades em **Java Spring Boot** e explorar o padrão arquitetural de Sagas para coordenação de microsserviços e a arquitetura Hexagonal. Este projeto tem como objetivo principal a implementação de uma arquitetura robusta para manipular processos distribuídos garantindo a consistência de dados.

## 💻 Tecnologias

Este projeto utiliza as seguintes tecnologias e frameworks:

- **Java 21**: Linguagem de programação utilizada para o desenvolvimento backend.
- **Spring Boot**: Framework que facilita a criação de aplicações Spring autônomas e de produção.
- **Spring Data JPA**: Abstração de persistência de dados baseada no JPA.
- **PostgreSQL**: Banco de dados relacional utilizado para persistência dos dados.
- **Kafka**: Sistema de mensagens distribuído e streaming.
- **Docker**: Ferramenta para criação e gerenciamento de containers, utilizada para isolar e executar as aplicações.
- **Lombok**: Biblioteca para reduzir a verbosidade do código Java.
- **MapStruct**: Biblioteca para criar o mapeamento de entidades.

<h2 id="description">📝 Descrição do Projeto</h2>

O **Saga** é um projeto desenvolvido para demonstrar o uso do padrão arquitetural Sagas em um sistema distribuído de microsserviços. O sistema coordena transações distribuídas através de eventos Kafka, garantindo que operações complexas que envolvem múltiplos serviços sejam concluídas de forma consistente.

<h2 id="motivation">🌟 Motivação</h2>

A motivação para a criação deste projeto surgiu da necessidade de consolidar e aprimorar habilidades em desenvolvimento com Java e Spring Boot, além de explorar o conceito de coordenação de transações distribuídas usando o padrão Sagas. Este projeto foi estruturado para incorporar boas práticas de desenvolvimento de microsserviços e garantir a consistência de dados através de eventos.

## Arquitetura do Projeto

Abaixo está a representação da arquitetura do **Saga** e a interação entre os serviços:

```plaintext
                            +-----------------------+
                            |     Orchestrator      |
                            |      (Porta 8083)     |
                            +-----------+-----------+
                                        |
         +------------------------------+--------------------------------+
         |                              |                                |              
  +------v-------+              +-------v-------+              +---------v--------+       
  | SaleService  |              | PaymentService|              | InventoryService |  
  | (Porta 8080) |              |  (Porta 8081) |              |   (Porta 8082)   |  
  +--------------+              +---------------+              +------------------+ 
        |                               |                               |
     +--+--+                         +--+--+                         +--+--+ 
     | DB  |                         | DB  |                         | DB  | 
     |5434 |                         |5436 |                         |5435 |
     +-----+                         +-----+                         +-----+
    PostgreSQL                      PostgreSQL                      PostgreSQL
```

<h2 id="started">🚀 Getting started</h2>

### Pré-requisitos

Antes de começar, certifique-se de ter os seguintes softwares instalados em sua máquina:

- **[Docker](https://www.docker.com/)**: Para criar e gerenciar containers.
- **[Docker Compose](https://docs.docker.com/compose/)**: Para orquestrar múltiplos containers.
- **[Java 21](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html)**: Linguagem de programação usada no backend do projeto.
- **[Git](https://git-scm.com/)**: Controle de versão para clonar o repositório do projeto.

### Adicionais

- **Um editor de texto** como IntelliJ IDEA para explorar e editar o código.
- **Postman** ou uma ferramenta similar para testar as APIs manualmente.

## Passo a Passo para Executar o Projeto

### 1. Clonar o Repositório

Abra um terminal e execute o comando para clonar o repositório:

```bash
git clone https://github.com/RafaelJaber/saga.git
```

### 2. Verificar Dependências

Certifique-se de que as seguintes ferramentas estão instaladas em seu sistema:

```bash
docker --version
docker-compose --version
java -version
```

### 3. Configuração do Arquivo `application.yml`

Os arquivos `application.yml` para cada serviço já estão configurados. Certifique-se de que os detalhes do banco de dados e os tópicos Kafka estejam definidos conforme necessário.

Exemplo de configuração do `application.yml` para o serviço de venda:

```yaml
server:
  port: 8080
spring:
  application:
    name: sale-service
  datasource:
    url: jdbc:postgresql://localhost:5434/sale-db
    username: postgres
    password: postgres
  jpa:
    hibernate:
      ddl-auto: update
jaber:
  kafka:
    topics:
      sale: tp-saga-sale
      orchestrator: tp-saga-orchestrator
    group-id:
      sale-finalize: "sale-finalize"
      sale-cancel: "sale-cancel"
```

### 4. Executar o Docker Compose

Para iniciar todos os serviços, utilize o comando:

```bash
docker-compose up --build
```

### Acessos e Configurações

- **Redpanda**: [http://localhost:8081](http://localhost:8081)
- **Swagger para a API**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html#/)

<h2 id="routes">📍 Endpoints da API</h2>

| **Serviço**       | **Endpoint**                        | **Método** | **Descrição**             |
|-------------------|-------------------------------------|------------|---------------------------|
| `Sale Service`    | `/api/v1/sales`                     | `POST`     | Criar uma nova venda      |

<h2 id="branches">🔀 Branches</h2>

Este projeto possui duas branches principais que mostram diferentes implementações do padrão SAGA:

- **orchestrated-saga-implementation**: Esta branch contém a implementação do padrão SAGA Orquestrado.
- **choreographed-saga-implementation**: Esta branch contém a implementação do padrão SAGA Coreografado.

Cada branch demonstra uma abordagem distinta para a coordenação de transações distribuídas, e você pode explorar cada uma para entender suas respectivas arquiteturas e fluxos.

<h2 id="colab">🤝 Colaboradores</h2>

<div style="display: flex; justify-content: space-around; align-items: center; margin-top: 20px;">

  <div style="text-align: center;">
    <a href="https://github.com/rafaeljaber" target="_blank">
      <img src="https://github.com/rafaeljaber.png" width="120px;" alt="Rafael Jáber Profile Picture" style="border-radius: 50%; border: 2px solid #ddd;"/>
      <br>
      <sub>
        <b>Rafael Jáber</b>
      </sub>
    </a>
    <p style="font-style: italic;">Desenvolvedor</p>
  </div>

<div style="text-align: center;">
    <a href="https://www.udemy.com/user/danilo-arantes-4/" target="_blank">
      <img src="https://img-b.udemycdn.com/user/200_H/39379932_55db_2.jpg" width="120px;" alt="Danilo Arantes Profile Picture" style="border-radius: 50%; border: 2px solid #ddd;"/>
      <br>
      <sub>
        <b>Danilo Arantes</b>
      </sub>
    </a>
    <p style="font-style: italic;">Instrutor</p>
  </div>

</div>

<h2 id="thanks">🙏 Agradecimentos</h2>

Gostaria de expressar minha sincera gratidão a todos que contribuíram para a realização deste projeto:

- **Equipe do Curso**: Pelo suporte e orientação durante o desenvolvimento, que foram fundamentais para o aprendizado e aplicação das tecnologias utilizadas.
- **Comunidade Open Source**: Pelo desenvolvimento e manutenção das ferramentas e frameworks que possibilitaram a construção deste projeto.
- **Você, Leitor**: Agradeço por dedicar seu tempo para explorar este projeto. Espero que ele possa inspirar e auxiliar em seus próprios empreendimentos. Seu interesse e feedback são valiosos para mim.

Sua contribuição e suporte foram essenciais para o sucesso deste projeto. Muito obrigado!

**Obrigado por acompanhar e apoiar este trabalho!**