package med.voll.api.medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;


@Table(name="medicos")      // Refere-se a tabela "medicos" no banco de dados
@Entity(name="Medico")      // No código, esta classe será um objeto de nome "Medico"
@Getter                     // LOMBOK: Gera os getters para esta classe
@NoArgsConstructor          // LOMBOK: Gera um constutor sem argumentos para esta classe (OBRIGATÓRIO)
@AllArgsConstructor         // LOMBOK: Gera um construtor com todos os argumentos para os atributos desta classe
@EqualsAndHashCode(of="id") // LOMBOK: Gera a hash do objeto com base no atributo "id" da tabela
public class Medico {       

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)   // Identifica este atributo como o que será o ID (chave primária) da tabela do DB, tendo a estratégia de auto-incremento a cada novo registro
    private Long id;

    private String nome;
    private String email;
    private String crm;
    
    @Enumerated(EnumType.STRING)        // Define que este atributo é um ENUM de Strings
    private Especialidade especialidade;
    
    @Embedded                           // Define que a classe Endereço está 'embutida' dentro da tabela 'medicos', não sendo necessário criar outra tabela no DB que referencie o Endereço
    private Endereco endereco;

    // Construtor que recebe o DTO de médico e já cria o objeto Medico
    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }
}
