package Epicode.ProgettoSettimana06.dispositivo.payloadDispositivo;

import java.util.UUID;

import Epicode.ProgettoSettimana06.dispositivo.enu.Stato;
import lombok.Getter;

@Getter
public class PayloadRichiestaAggiornamentoDispositivo {
	private UUID utente_id;
	private Stato stato;
}
