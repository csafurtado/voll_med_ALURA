- Um projeto Maven tem as pastas 'src' para os arquivos principais, 'test' que tem os arquivos com os testes das classes em 'src'.

- As dependências do projeto ficam no arquivo `pom.xml`. O `pom.xml` de um projeto de Spring Boot 'herda' de outro mini-`pom.xml` dentro de sua tag `<parent>`

- O projeto de Spring Boot também tem a pasta **resources** dentro de 'src/main'. Na _static_ temos os arquivos estáticos (.css por exemplo) e na _templates_ temos os arquivos HTML da página. Não se usa estas pastas para um projeto API REST. Se usará bastante o arquivo **application.properties**.

- O projeto já possui um servidor embutido (Tomcat) para rodar a aplicação. A classe Main irá rodar o projeto.

- O <a href="https://youtu.be/4KHiSt0oLJ0?si=kRX3aHPuU2Bf6oGp">CORS</a> é um mecanismo utilizado para adicionar cabeçalhos HTTP que informam aos navegadores para permitir que uma aplicação Web seja executada em uma origem e acesse recursos de outra origem diferente. Esse tipo de ação é chamada de requisição cross-origin HTTP. Na prática, então, ele informa aos navegadores se um determinado recurso pode ou não ser acessado. Se a URL possuir qualquer detalhe diferente da URL que faz a requisição (porta, protocolo, etc) e não estiver especificado no servidor esse detalhe, a requisição não será processada pelo servidor.

- Para lidar com dados em JSON, podemos criar _records_ em que seus campos sejam idênticos ao que vem em um JSON de resposta. Em casos que um JSON tenha outro JSON aninhado, usa-se outro _record_ para se tratar dele.

- Sempre que precisarmos receber ou devolver dados da API, criaremos um DTO _(Data Transfer Object)_ - sendo um _record_ que contém apenas os campos que desejamos receber ou devolver da API. Esse tipo de classe se encaixa perfeitamente para representar classes DTO, já que seu objetivo é apenas representar dados que serão recebidos ou devolvidos pela API, sem nenhum tipo de comportamento.

- Para adicionar dependências novas a um projeto SpringBoot com Maven, podemos ir ao site do <a href="https://start.spring.io/">Spring Initializer</a>, apenas adicionar dependências buscando por elas e utilizar a opção de "Explorar", copiando do arquivo pom.xml apenas as dependências buscadas.

- Ao adicionar a dependência do Spring Data, ele irá tentar procurar um arquivo com dados para se conectar a um banco de dados. Caso não o encontre, ele não deixa nem iniciar o projeto.

- Uma classe **JPA** (Java Persistence API) representa um objeto da Tabela do Banco de dados dentro do código. Basicamente, ela é a classe que representa o objeto tanto no mundo real quanto no banco e na aplicação.

- A interface `JPArepository` (ou simplesmente _repository_) serve para executar as opereções de salvamento/recuperação de dados de uma entidade/objeto de uma tabela do Banco de dados. Para isso, se cria uma interface qualquer que HERDA de `JPARepository` e o tipo com Generics( usar o <\ClasseTal, tipoId>).

- Uma migração ou _migration_ é uma alteração que é feita no banco de dados pela aplicação. A cada nova modificação, salva-se um arquivo SQL que mostra quais foram as "novidades" implementadas no banco de dados pela aplicação. A biblioteca **FLYWAY** possui 2 dependências: um core e outra com o Banco de Dados específico (mysql, Postgres etc). As migrações por padrão ficam em _main->resources->db->migration_. **SEMPRE PARE O PROJETO AO MEXER COM MIGRAÇÔES!!!**. O padrão de nomenclatura é `VX__oqueamigrationfaz.sql`, sendo 'X' o número da versão da migração (se foi a primeira é 1 e por aí vai). Uma vez feita, o arquivo da migration **NÃO PODE SER MAIS MODIFICADO POSTRIORMENTE**, deve-se criar um novo arquivo para isso.

- O <a href="https://jakarta.ee/specifications/bean-validation/3.0/jakarta-bean-validation-spec-3.0.html#builtinconstraints">_Bean validation_</a> são annotations utilizados para colocar validações em campos das classes (records) DTO.
    - Natureza: Beans são instâncias de classes gerenciadas pelo Spring, enquanto anotações são metadados que configuram o comportamento dessas classes.
    - Função: Beans representam a lógica de negócios e a estrutura da aplicação, enquanto anotações são usadas para definir como essas classes devem ser tratadas pelo Spring.
    - Interdependência: Beans podem ser configurados e definidos usando anotações, mas anotações não são beans em si.

- O Spring Boot já possui parâmetros de URL (GET) que outras aplicações podem usar, como o 'sort'. Para usar mais parâmetros, basta utilizar o caracter '&' separando cada atributo. É possível criar novos parâmetros pelo arquivo _application.properties_. 

- Parâmetros de requisição (ou de URL) também podem ser passados na requisição (como o id de um registro). Ele seria acessado como um recurso da URL (no caso então, algumsite.com/itemdesejado/<\id>). Para usá-la, podemos basicamente 

- A **exclusão lógica** é uma exclusão "fake" de um registro no db, em que ele permanece cadastrado, mas não é mais mostrado nas consultas, como se estivesse inativo.

- 