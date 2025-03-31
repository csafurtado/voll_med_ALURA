package med.voll.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.lang.NonNull;


@Configuration      // Anotação para classes de configuração para o Spring usar
public class CorsConfiguration implements WebMvcConfigurer {    // Implementa a interface para configurar o MVC do Spring

    @Override   // Implementa o método addCorsMappings() da interface e pega a Classe de configuração do CORS atual para editá-la dentro da função
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/**")  // Aplica a configuração para todos os endpoints de apis
            .allowedOrigins("http://localhost:3000")    // Adiciona as origens de requisições que serão aceitas
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT"); // Adiciona os métodos aceitos feitos nesta origens
    }
}