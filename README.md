# 📋 Projeto de Gestão de Solicitações Para Uso De Espaços Físicos 🗂️

Este projeto é um sistema para **gerenciar solicitações de uso de espaços físicos** em uma instituição. Ele permite que professores solicitem a reserva de salas e que um avaliador aprove ou rejeite essas solicitações, garantindo organização e eficiência no uso dos espaços. O sistema está estruturado com um banco de dados robusto, com uma grande quantidade de elementos e diversas relações de chaves estrangeiras (FK), proporcionando uma gestão eficiente das informações.

## 📋 Funcionalidades REST

As funcionalidades do sistema estão expostas via APIs REST, oferecendo uma comunicação eficiente com o banco de dados para manipulação dos recursos. As principais funcionalidades incluem:

- **Cadastro de Solicitações**: Permite a criação de novas solicitações, vinculando usuários e espaços físicos, com a possibilidade de registrar informações detalhadas sobre o tipo de solicitação.
- **Cadastro de Solicitantes e Avaliadores**: Gerenciamento de usuários, permitindo que professores e avaliadores sejam cadastrados no sistema.
- **Criação de Solicitações**: Professores podem criar solicitações informando data, horário, tipo de sala e finalidade do espaço.
- **Visualização de Solicitações**: Professores podem visualizar suas próprias solicitações e seu status.
- **Aprovação de Solicitações**: Avaliadores podem aprovar ou rejeitar solicitações pendentes de reserva de espaços físicos.
- **Histórico de Solicitações**: Registro detalhado de todas as solicitações realizadas e seus status.
- **APIs REST**: A comunicação com o sistema é feita via APIs RESTful, permitindo fácil integração e manipulação de dados via métodos HTTP (GET, POST, PUT, DELETE).
- **MapStruct**: Utilizado para mapear eficientemente os dados entre as entidades e os DTOs, garantindo que a conversão de dados entre camadas do sistema seja rápida e sem erros.

## Manipulação das Tabelas 🛠️
Cada tabela do banco de dados pode ser manipulada através das operações CRUD (Create, Read, Update, Delete). As tabelas envolvidas no processo são:

- **Status**: Gerenciamento dos diferentes status das solicitações.
- **Espaço Físico**: Controle dos espaços disponíveis para reserva.
- **Equipamentos**: Gerenciamento dos equipamentos disponíveis para os espaços.
- **Cargos**: Cadastro dos cargos dos usuários envolvidos nas solicitações.
- **Usuários**: Cadastro e gerenciamento dos usuários do sistema, como solicitantes e avaliadores.
- **Tipo de Sala**: Classificação dos tipos de salas disponíveis para reserva.
- **Solicitações**: Controle das solicitações realizadas pelos usuários.
- **Log de Ações**: Registro das ações realizadas no sistema, como criação, aprovação ou rejeição de solicitações.

## Banco de Dados 💾
O banco de dados do sistema é projetado para lidar com uma quantidade significativa de dados e relações entre entidades. Ele inclui tabelas interconectadas com várias chaves estrangeiras (FK), o que proporciona uma estrutura robusta e escalável para gerenciar informações de solicitações, usuários e recursos.
  
## 🛠️ Tecnologias Utilizadas

- **Java 17**: Linguagem principal do projeto.
- **Spring Boot 3**: Framework para desenvolvimento web e criação de APIs RESTful.
- **PostgreSQL**: Banco de dados relacional para persistência de dados.
- **Hibernate**: ORM para mapeamento objeto-relacional e gerenciamento de entidades.
- **MapStruct**: Ferramenta para mapeamento automático entre DTOs e entidades, otimizando a performance e manutenção do código.
- **Maven**: Gerenciador de dependências e build.

## ⚙️ Configuração do Ambiente

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/usuario/repo-gestao-espacos.git
   cd repo-gestao-espacos
