package pt.uc.dei.aor.pf.dao;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.uc.dei.aor.pf.entities.Letra;
import pt.uc.dei.aor.pf.entities.Musica;
import pt.uc.dei.aor.pf.entities.Utilizador;

@Stateless
public class LetraDao extends GenericDao<Letra> {
	
	private static final Logger log = LoggerFactory.getLogger(LetraDao.class);

	public LetraDao() {
		super(Letra.class);
	}
	
	public Letra find(Musica musica, Utilizador user){
		Letra letra;

		Query q;
		
		if(user==null){
			q=em.createQuery("SELECT l FROM Letra l WHERE l.dono.id IS NULL AND l.musica.id = :musicaId");
		}else{
			q=em.createQuery("SELECT l FROM Letra l WHERE l.dono.id = :userId AND l.musica.id = :musicaId");
			q.setParameter("userId", user.getId());
		}
		
		q.setParameter("musicaId", musica.getId());
		
		try{
			letra=(Letra) q.getSingleResult();
			log.info("Retorna a letra com os parâmetros dados.");
		}catch (NoResultException e){
			log.error("Não existe a letra com os parâmetros dados.");
			return null;
		}
		return letra;
	}

}
