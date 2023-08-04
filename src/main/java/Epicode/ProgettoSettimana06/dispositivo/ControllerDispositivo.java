package Epicode.ProgettoSettimana06.dispositivo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Epicode.ProgettoSettimana06.dispositivo.payloadDispositivo.PayloadRichiestaCreazioneDispositivo;

@RestController
@RequestMapping("/dispositivi")
public class ControllerDispositivo {
	private final ServiceDispositivo serviceDispositivo;

	@Autowired
	public ControllerDispositivo(ServiceDispositivo serviceDispositivo) {
		this.serviceDispositivo = serviceDispositivo;
	}

	@GetMapping
	public Page<Dispositivo> getDispositivi(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
		return serviceDispositivo.find(page, size, sortBy);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Dispositivo saveDispositivo(@RequestBody PayloadRichiestaCreazioneDispositivo body) {
		Dispositivo created = serviceDispositivo.create(body);

		return created;
	}

	@GetMapping("/{idUtente}")
	public Dispositivo findById(@PathVariable UUID idDispositivo) {
		return serviceDispositivo.findById(idDispositivo);

	}

//	@PutMapping("/{idDispositivo}")
//	public Dispositivo updateDispositivo(@PathVariable UUID idDispositivo,
//			@RequestBody PayloadRichiestaAggiornamentoDispositivo body) {
//		return serviceDispositivo.findByIdAndUpdate(idDispositivo, body);
//	}

	@DeleteMapping("/{idDispositivo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteDispositivo(@PathVariable UUID idDispositivo) {
		serviceDispositivo.findByIdAndDelete(idDispositivo);
	}

}
