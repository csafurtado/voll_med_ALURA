package med.voll.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
    
    @NotBlank       // Não permite que o campo seja nulo nem que esteja em branco
    String logradouro, 

    @NotBlank
    String bairro,

    @NotBlank
    @Pattern(regexp = "\\d{8}")
    String cep, 

    @NotBlank
    String cidade,
    
    @NotBlank
    String uf, 
    String complemento, 
    String numero) {
}
