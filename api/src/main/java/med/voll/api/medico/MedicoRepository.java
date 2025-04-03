package med.voll.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {     // Usa a Classe Medico e o tipo do seu identificador (ID) é Long

}
