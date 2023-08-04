package Epicode.ProgettoSettimana06.dispositivo;

import java.util.UUID;

import Epicode.ProgettoSettimana06.dispositivo.enu.Stato;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dispositivo")
@Data
@NoArgsConstructor
public class Dispositivo {
	@Id
	@GeneratedValue
	private UUID id;
//	@ManyToOne
//	private Utente utente;
//	@Enumerated(jakarta.persistence.EnumType.STRING)
//	private Tipologia tipologia;
	private String tipologia;
	@Enumerated(EnumType.STRING)
	private Stato stato = Stato.DISPONIBILE;

	public Dispositivo(String tipologia) {
		this.tipologia = tipologia;
	}

}
