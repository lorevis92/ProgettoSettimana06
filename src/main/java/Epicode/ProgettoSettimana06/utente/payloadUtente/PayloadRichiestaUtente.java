package Epicode.ProgettoSettimana06.utente.payloadUtente;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PayloadRichiestaUtente {
	private String nome;
	private String cognome;
	private String email;
}


