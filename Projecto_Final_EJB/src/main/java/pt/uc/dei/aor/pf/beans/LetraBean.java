package pt.uc.dei.aor.pf.beans;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.uc.dei.aor.pf.dao.LetraDao;
import pt.uc.dei.aor.pf.entities.Letra;
import pt.uc.dei.aor.pf.entities.Musica;
import pt.uc.dei.aor.pf.entities.Utilizador;

@Stateless
public class LetraBean implements LetraInterface {
	
	private static final Logger log = LoggerFactory.getLogger(LetraBean.class);
	
	@EJB
	private LetraDao letraDao;

	@Override
	public void save(Letra letra) {
		log.info("Persistência da letra feita.");
		letraDao.save(letra);		
	}

	@Override
	public void update(Letra letra) {
		log.info("Update/Persistência da letra feita.");
		letraDao.update(letra);
	}

	@Override
	public Letra find(Musica musica, Utilizador user) {
		log.info("Feita pesquisa de letra por Música e Utilizador.");
		return letraDao.find(musica, user);
	}

}
