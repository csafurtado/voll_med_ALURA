package med.voll.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosAtualizacaoMedico;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/medicos")     // Pode ou não ter barra
public class MedicoController {

    @Autowired      // Injeta a dependência, ou seja, ao ser criado o objeto MedicoController, já se cria uma instância MedicoRepository que será usada por esta classe, sem a necessidade de instanciá-la dentro de seus métodods 
    private MedicoRepository repository;

    @PostMapping        // Para requisições POST chamar esta função
    @Transactional      // Define que esta função executará uma transação no banco de dados e em caso de falha, não deve ser executada.
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico json) {   // Anotação diz que o argumento virá do corpo da requisição e que precisa ser validado pelas validações presentes nas DTOs
        System.out.println(json);
        repository.save(new Medico(json));
    }

    // Esta versão da função agora pagina os resultados conforme for definido pela requisição
    // É a forma padrão para retorno de informações
    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao) {      // Define um padrão para retorno de registros
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }
    
    // @GetMapping("")
    // // public List<DadosListagemMedico> listar() {
    // //     /* Essa linha faz uma consulta (select) para retornar todos os registros da tabela de Medico,
    // //        mapeando os resultados com base na DTO 'DadosListagemMedico', retornando para a aplicaçao
    // //        os dados no formato desta DTO e em lista.
    // //     */
    // //     return repository.findAll().stream().map(DadosListagemMedico::new).toList();
    // // }
    
    @PutMapping
    @Transactional  // Mexe com atualização do BD, então precisa desse Bean
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) { // Necessário outro DTO para atualização de dados no DB  
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")  // Define que um DELETE para um id especificado na URL
    @Transactional
    public void excluir(@PathVariable Long id){ // Define que o {id} no bean @DeleteMapping seria um Long que representaria um id
        var medico = repository.getReferenceById(id);
        medico.excluir();
        // repository.deleteById(id);      // Apaaga o registro no bd
        
    }

    @PatchMapping("/{id}")  // Define que um DELETE para um id especificado na URL
    @Transactional
    public void ativar(@PathVariable Long id){ // Define que o {id} no bean @DeleteMapping seria um Long que representaria um id
        Medico medico = repository.getReferenceById(id);
        medico.ativar();
    }

}
