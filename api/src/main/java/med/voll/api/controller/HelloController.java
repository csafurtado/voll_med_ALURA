package med.voll.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController     // Diz que é um controller. Específico do Spring Boot
@RequestMapping("/hello")     // Diz qual é a URL que esta classe irá responder
public class HelloController {

    @GetMapping         // Se vier uma requisição GET para a URL definida, chama esta função 
    public String olaMundo() {
        return "Hello Uordi Spring!!";
    }
}
