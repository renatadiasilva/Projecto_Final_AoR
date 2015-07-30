package pt.uc.dei.aor.pf.dao;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import pt.uc.dei.aor.pf.entities.Letra;
import pt.uc.dei.aor.pf.entities.Musica;
import pt.uc.dei.aor.pf.entities.Utilizador;

@RunWith(MockitoJUnitRunner.class)
public class LetraDaoTest {

	@Mock
	EntityManager em;

	@Mock
	Query mockedQuery;

	@Mock
	Utilizador utilizador;

	@Mock
	Musica musica;

	@InjectMocks
	LetraDao ejb;

	
	@Test
	public void findLetraDevolveApenasUmResultado(){
		@SuppressWarnings("unused")
		Letra letra;
		
		final String QUERY ="SELECT l FROM Letra l WHERE l.dono.id IS NULL AND l.musica.id = :musicaId";
        when(em.createQuery(QUERY)).thenReturn(mockedQuery);
        letra=ejb.find(musica,null);
		
		verify(mockedQuery).getSingleResult();
        verify(em).createQuery(QUERY);
	}

}
