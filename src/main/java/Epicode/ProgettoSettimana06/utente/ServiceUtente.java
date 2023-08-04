package Epicode.ProgettoSettimana06.utente;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Epicode.ProgettoSettimana06.exceptions.BadRequestException;
import Epicode.ProgettoSettimana06.exceptions.NotFoundException;
import Epicode.ProgettoSettimana06.utente.payloadUtente.PayloadRichiestaUtente;

@Service
public class ServiceUtente {
	private final RepositoryUtente repoUtente;

	@Autowired
	public ServiceUtente(RepositoryUtente repoUtente) {
		this.repoUtente = repoUtente;
	}

	public Utente create(PayloadRichiestaUtente body) {
		// check if email already in use
		repoUtente.findByEmail(body.getEmail()).ifPresent(user -> {
			throw new BadRequestException("L'email è già stata utilizzata");
		});
		Utente nuovoUtente = new Utente(body.getNome(), body.getCognome(), body.getEmail());
		return repoUtente.save(nuovoUtente);
	}

	public Page<Utente> find(int page, int size, String sort) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sort)); // (numero di pagina, numero di elementi per
																		// pagina, nome del campo per cui sortare)
		return repoUtente.findAll(pageable);
	}

	public Utente findById(UUID id) throws NotFoundException {
		return repoUtente.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	public Utente findByIdAndUpdate(UUID id, PayloadRichiestaUtente body) throws NotFoundException {
		Utente found = this.findById(id);
		found.setEmail(body.getEmail());
		found.setNome(body.getNome());
		found.setCognome(body.getCognome());

		return repoUtente.save(found);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Utente found = this.findById(id);
		repoUtente.delete(found);
	}
}
