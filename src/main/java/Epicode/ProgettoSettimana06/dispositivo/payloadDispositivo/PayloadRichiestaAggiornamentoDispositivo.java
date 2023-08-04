package Epicode.ProgettoSettimana06.dispositivo.payloadDispositivo;

import Epicode.ProgettoSettimana06.dispositivo.enu.Stato;
import Epicode.ProgettoSettimana06.utente.Utente;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PayloadRichiestaAggiornamentoDispositivo {
	private Utente utente;
	private Stato stato;
}
