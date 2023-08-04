package Epicode.ProgettoSettimana06.dispositivo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryDispositivo extends JpaRepository<Dispositivo, UUID> {

}
