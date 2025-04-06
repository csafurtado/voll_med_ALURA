package med.voll.api.medico;

public record DadosListagemMedico(String nome, String email, String crm, Especialidade especialidade) {

    // Pelo visto um record pode ter um construtor padrãeo né?
    // Essa estrutura é o que irá ser devolvida à aplicação
    public DadosListagemMedico(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
