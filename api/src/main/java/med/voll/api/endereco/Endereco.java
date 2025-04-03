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
}
