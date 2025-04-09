package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;

@Getter                     // LOMBOK: Gera os getters para esta classe
@NoArgsConstructor          // LOMBOK: Gera um constutor sem argumentos para esta classe (OBRIGATÓRIO)
@AllArgsConstructor         // LOMBOK: Gera um construtor com todos os argumentos para os atributos desta classe
@Embeddable     // Permite que a classe seja "embutível" em outra
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

        // Construtor que recebe o DTO de médico e já cria o objeto Medico
    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
    }

    // É um setter que condiz com as regras de negócios
    public void atualizarInformacoes(DadosEndereco dados) {
        if (dados.logradouro() != null)
            this.logradouro = dados.logradouro();

        if (dados.bairro() != null)
            this.bairro = dados.bairro();

        if (dados.cep() != null)
            this.cep = dados.cep();

        if (dados.numero() != null)
            this.numero = dados.numero();

        if (dados.complemento() != null)
            this.complemento = dados.complemento();

        if (dados.cidade() != null)
            this.cidade = dados.cidade();

        if (dados.uf() != null)
            this.uf = dados.uf();
    }
}
