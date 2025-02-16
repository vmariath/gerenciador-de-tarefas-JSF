# Gerenciador de Tarefas em JSF

Este projeto é um sistema simples de gerenciamento de tarefas desenvolvido utilizando JavaServer Faces (JSF). Ele permite que os usuários criem, visualizem, atualizem e excluam tarefas, proporcionando uma interface amigável para o gerenciamento de atividades diárias.

## Tecnologias Utilizadas

- **JavaServer Faces (JSF)**: Framework para construção de interfaces web baseadas em Java.
- **Java Persistence API (JPA)**: Para persistência de dados e interação com o banco de dados.
- **PrimeFaces**: Biblioteca de componentes visuais para JSF, utilizada para criar uma interface moderna e responsiva.
- **MySQL**: Banco de dados relacional para armazenamento das tarefas.
- **Maven**: Gerenciador de dependências e construção do projeto.

## Funcionalidades

- **Cadastro de Tarefas**: Adicionar novas tarefas com título, descrição, data de criação e status.
- **Listagem de Tarefas**: Visualizar todas as tarefas cadastradas em uma tabela.
- **Edição de Tarefas**: Atualizar informações de uma tarefa existente.
- **Exclusão de Tarefas**: Remover tarefas que não são mais necessárias.
- **Filtro e Ordenação**: Filtrar e ordenar tarefas por título, data ou status.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

- `src/main/java`: Contém as classes Java, incluindo modelos, controladores e serviços.
  - `br/com/gerenciadortarefas/model`: Classes de modelo (entidades JPA).
  - `br/com/gerenciadortarefas/controller`: Classes controladoras (Managed Beans).
  - `br/com/gerenciadortarefas/service`: Classes de serviço para lógica de negócios.
- `src/main/resources`: Arquivos de configuração, como `persistence.xml` para configuração do JPA.
- `src/main/webapp`: Contém as páginas JSF (XHTML) e recursos estáticos (CSS, JS).
  - `WEB-INF`: Configurações específicas do projeto web, como `web.xml`.
- `pom.xml`: Arquivo de configuração do Maven para gerenciamento de dependências.

## Como Executar o Projeto

1. **Pré-requisitos**:
   - Java JDK 8 ou superior.
   - Apache Maven instalado.
   - Banco de dados MySQL configurado.

2. **Configuração do Banco de Dados**:
   - Crie um banco de dados MySQL chamado `gerenciador_tarefas`.
   - Configure as credenciais do banco de dados no arquivo `persistence.xml`.

3. **Compilação e Execução**:
   - Clone o repositório:
     ```bash
     git clone https://github.com/vmariath/gerenciador-de-tarefas-JSF.git
     ```
   - Navegue até o diretório do projeto:
     ```bash
     cd gerenciador-de-tarefas-JSF
     ```
   - Compile o projeto com Maven:
     ```bash
     mvn clean install
     ```
   - Execute o projeto em um servidor Java EE (como Apache Tomcat ou WildFly).

4. **Acesso à Aplicação**:
   - Após iniciar o servidor, acesse a aplicação no navegador:
     ```
     http://localhost:8080/gerenciador-de-tarefas-JSF/
     ```

