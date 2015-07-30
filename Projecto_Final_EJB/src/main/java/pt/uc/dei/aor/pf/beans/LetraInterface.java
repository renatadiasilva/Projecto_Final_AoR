package pt.uc.dei.aor.pf.beans;

import javax.ejb.Local;

import pt.uc.dei.aor.pf.entities.Letra;
import pt.uc.dei.aor.pf.entities.Musica;
import pt.uc.dei.aor.pf.entities.Utilizador;

@Local
public interface LetraInterface {
	
	public abstract void save(Letra letra);
	public abstract void update(Letra letra);
	public abstract Letra find(Musica musica, Utilizador user);

}
