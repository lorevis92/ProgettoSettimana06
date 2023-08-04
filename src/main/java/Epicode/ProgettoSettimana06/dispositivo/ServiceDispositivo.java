package Epicode.ProgettoSettimana06.dispositivo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Epicode.ProgettoSettimana06.dispositivo.payloadDispositivo.PayloadRichiestaAggiornamentoDispositivo;
import Epicode.ProgettoSettimana06.dispositivo.payloadDispositivo.PayloadRichiestaCreazioneDispositivo;
import Epicode.ProgettoSettimana06.exceptions.NotFoundException;
import Epicode.ProgettoSettimana06.utente.ServiceUtente;

@Service
public class ServiceDispositivo {
	private final RepositoryDispositivo repoDispositivo;
	@Autowired
	private ServiceUtente serviceUtente;

	@Autowired
	public ServiceDispositivo(RepositoryDispositivo repoDispositivo) {
		this.repoDispositivo = repoDispositivo;
	}



	// Quando registro un dispositivo voglio che abbia solo la tipologia
	public Dispositivo create(PayloadRichiestaCreazioneDispositivo body) {
		Dispositivo nuovoDispositivo = new Dispositivo(body.getTipologia());
		System.out.println(nuovoDispositivo);
		return repoDispositivo.save(nuovoDispositivo);
	}

	public Page<Dispositivo> find(int page, int size, String sort) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sort)); // (numero di pagina, numero di elementi per
																		// pagina, nome del campo per cui sortare)
		return repoDispositivo.findAll(pageable);
	}

	public Dispositivo findById(UUID id) throws NotFoundException {
		return repoDispositivo.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	public Dispositivo findByIdAndUpdate(UUID id, PayloadRichiestaAggiornamentoDispositivo body)
			throws NotFoundException {
		Dispositivo found = this.findById(id);
		found.setUtente(serviceUtente.findById(body.getUtente_id()));
		found.setStato(body.getStato());

		return repoDispositivo.save(found);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Dispositivo found = this.findById(id);
		repoDispositivo.delete(found);
	}
}
