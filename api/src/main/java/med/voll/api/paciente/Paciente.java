package med.voll.api.paciente;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import med.voll.api.endereco.Endereco;


@Table(name="pacientes")      // Refere-se a tabela "medicos" no banco de dados
@Entity(name="Paciente")   
@Getter                     // LOMBOK: Gera os getters para esta classe
@NoArgsConstructor          // LOMBOK: Gera um constutor sem argumentos para esta classe (OBRIGATÓRIO)
@AllArgsConstructor         // LOMBOK: Gera um construtor com todos os argumentos para os atributos desta classe
@EqualsAndHashCode(of="id") // LOMBOK: Gera a hash do objeto com base no atributo "id" da tabela
public class Paciente {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private Boolean ativo;

    @Embedded
    private Endereco endereco;

    public Paciente(DadosCadastroPaciente dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

	public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        
        if (dados.endereco() != null) {
            this.endereco = new Endereco(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }

    public void ativar() {
        this.ativo = true;
    }
}
