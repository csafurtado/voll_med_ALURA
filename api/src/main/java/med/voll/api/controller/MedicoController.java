package med.voll.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.medico.DadosCadastroMedico;


@RestController
@RequestMapping("/medicos")     // Pode ou não ter barra
public class MedicoController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico json) {   // Anotação diz que o argumento virá do corpo da requisição
        System.out.println(json);
    }
    
}
