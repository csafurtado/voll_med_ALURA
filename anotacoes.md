- Um projeto Maven tem as pastas 'src' para os arquivos principais, 'test' que tem os arquivos com os testes das classes em 'src'.

- As dependências do projeto ficam no arquivo `pom.xml`. O `pom.xml` de um projeto de Spring Boot 'herda' de outro mini-`pom.xml` dentro de sua tag `<parent>`

- O projeto de Spring Boot também tem a pasta **resources** dentro de 'src/main'. Na _static_ temos os arquivos estáticos (.css por exemplo) e na _templates_ temos os arquivos HTML da página. Não se usa estas pastas para um projeto API REST. Se usará bastante o arquivo **application.properties**.

- O projeto já possui um servidor embutido (Tomcat) para rodar a aplicação. A classe Main irá rodar o projeto.

- O <a href="https://youtu.be/4KHiSt0oLJ0?si=kRX3aHPuU2Bf6oGp">CORS</a> é um mecanismo utilizado para adicionar cabeçalhos HTTP que informam aos navegadores para permitir que uma aplicação Web seja executada em uma origem e acesse recursos de outra origem diferente. Esse tipo de ação é chamada de requisição cross-origin HTTP. Na prática, então, ele informa aos navegadores se um determinado recurso pode ou não ser acessado. Se a URL possuir qualquer detalhe diferente da URL que faz a requisição (porta, protocolo, etc) e não estiver especificado no servidor esse detalhe, a requisição não será processada pelo servidor.

- Para lidar com dados em JSON, podemos criar _records_ em que seus campos sejam idênticos ao que vem em um JSON de resposta. Em casos que um JSON tenha outro JSON aninhado, usa-se outro _record_ para se tratar dele.

- Sempre que precisarmos receber ou devolver dados da API, criaremos um DTO _(Data Transfer Object)_ - sendo uma classe ou record que contém apenas os campos que desejamos receber ou devolver da API.