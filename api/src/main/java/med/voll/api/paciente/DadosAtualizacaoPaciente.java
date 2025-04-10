package med.voll.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;


public record DadosAtualizacaoPaciente(
    @NotNull
    Long id,

    // Não há validações nestes campos pq não são todos que serão modificados
    String nome,
    String telefone,
    DadosEndereco endereco      
) {

}
