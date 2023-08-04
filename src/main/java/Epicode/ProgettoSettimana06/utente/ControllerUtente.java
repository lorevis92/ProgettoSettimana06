package Epicode.ProgettoSettimana06.utente;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Epicode.ProgettoSettimana06.utente.payloadUtente.PayloadRichiestaUtente;

@RestController
@RequestMapping("/utenti")
public class ControllerUtente {
	private final ServiceUtente serviceUtente;

	@Autowired
	public ControllerUtente(ServiceUtente serviceUtente) {
		this.serviceUtente = serviceUtente;

	}

	@GetMapping
	public Page<Utente> getUsers(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "id") String sortBy) {
		return serviceUtente.find(page, size, sortBy);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Utente saveUser(@RequestBody PayloadRichiestaUtente body) {
		Utente created = serviceUtente.create(body);

		return created;
	}

	@GetMapping("/{idUtente}")
	public Utente findById(@PathVariable UUID idUtente) {
		return serviceUtente.findById(idUtente);

	}

	@PutMapping("/{idUtente}")
	public Utente updateUser(@PathVariable UUID idUtente, @RequestBody PayloadRichiestaUtente body) {
		return serviceUtente.findByIdAndUpdate(idUtente, body);
	}

	@DeleteMapping("/{idUtente}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable UUID idUtente) {
		serviceUtente.findByIdAndDelete(idUtente);
	}

}
