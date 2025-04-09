package med.voll.api.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    // Adiciona um método (query) específica já com filtros pré estabelecidos, só precisa da assinatura dado que sta é uma interface
    // O nome do método já define o que deve ser feito, o Spring Boot faz isso automaticamente
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);     // Usa a Classe Medico e o tipo do seu identificador (ID) é Long

}

// A classe JPARepository já possui métodos CRUD implementada em si.