package Epicode.ProgettoSettimana06.utente;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "utente")
@Data
@NoArgsConstructor
public class Utente {
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String cognome;
	@Column(nullable = false, unique = true)
	private String email;

	public Utente(String nome, String cognome, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
	}
}
