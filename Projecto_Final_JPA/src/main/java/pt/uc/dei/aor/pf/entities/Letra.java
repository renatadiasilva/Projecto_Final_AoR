package pt.uc.dei.aor.pf.entities;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table
public class Letra implements Serializable {

	private static final long serialVersionUID = -6049771237646688177L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty
	@Column(name = "letra", nullable = false, length = 20000)
	private String letra;
	
	@ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(nullable = true)
	private Utilizador dono;
	
	@ManyToOne
	@JoinColumn
	private Musica musica;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Utilizador getDono() {
		return dono;
	}

	public void setDono(Utilizador dono) {
		this.dono = dono;
	}
	
	public String getLetra() {
		return letra;
	}
	
	public void setLetra(String titulo) {
		this.letra = titulo;
	}

	public Musica getMusica() {
		return musica;
	}

	public void setMusica(Musica musica) {
		this.musica = musica;
	}

	public Letra() {
		
	}

	

}

