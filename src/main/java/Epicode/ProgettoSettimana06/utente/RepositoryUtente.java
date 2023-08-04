package Epicode.ProgettoSettimana06.utente;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUtente extends JpaRepository<Utente, UUID> {
	Optional<Utente> findByEmail(String email);
}
