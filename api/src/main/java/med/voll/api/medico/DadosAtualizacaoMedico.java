package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;


public record DadosAtualizacaoMedico(
    @NotNull        // Não usa NotBlank pq o id não é uma String
    Long id, 
    String nome,
    String telefone,
    DadosEndereco endereco) {
}
