package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;


@RestController
@RequestMapping("/medicos")     // Pode ou não ter barra
public class MedicoController {

    @Autowired      // Injeta a dependência, ou seja, ao ser criado o objeto MedicoController, já se cria uma instância MedicoRepository que será usada por esta classe, sem a necessidade de instanciá-la dentro de seus métodods 
    private MedicoRepository repository;

    @PostMapping        // Para requisições POST chamar esta função
    @Transactional      // Define que esta função executará uma transação no banco de dados
    public void cadastrar(@RequestBody DadosCadastroMedico json) {   // Anotação diz que o argumento virá do corpo da requisição
        System.out.println(json);
        repository.save(new Medico(json));
    }
    
}
