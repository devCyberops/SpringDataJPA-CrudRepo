package tn.esprit.rh.achat;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.rh.achat.dto.ConverterSecteur;
import tn.esprit.rh.achat.dto.SecteurDTO;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;
@ExtendWith(MockitoExtension.class)
class SectrueTest {
	@InjectMocks SecteurActiviteServiceImpl s;
	@Mock SecteurActiviteRepository r;
	private SecteurActivite secteur2;

	//logging
	SecteurActivite secteur= new SecteurActivite(null,"libelle","code");
	List<SecteurActivite> list = new ArrayList<SecteurActivite>() {
		
		{
			add(new SecteurActivite(null,"libelle1","code1"));
			add(new SecteurActivite(null,"libelle2","code2"));
			
		}
	};
	@Test
	void all() {
		
		when(r.findAll()).thenReturn(new ArrayList());
		List<SecteurActivite> response= s.retrieveAllSecteurActivite();
		assertEquals(0, response.size());
	}
	@Test
	void add() {
		SecteurActivite df = new SecteurActivite();
		df.setIdSecteurActivite(1L);
		when(r.save(any())).thenReturn(df);
		s.updateADDSecteurActivite(new SecteurActivite());
		assertEquals(1L, df.getIdSecteurActivite());
	}

	@Test
	public void selectOne(){
	//Mockito.when(r.findById(Mockito.anyLong())).thenReturn(Optional.of(secteur));
	//SecteurActivite sec = s.retrieveSecteurActivite((long) 2 );
	//Assertions.assertNotNull(sec);
		Long Id = 1L;
		//mock
		when(r.findById(Id)).thenReturn(Optional.ofNullable(secteur2));
		//call function
		SecteurActivite sec2 = s.retrieveSecteurActivite(Id);
		//assert
		assertEquals(null,sec2);
	}
	@Test
	public void delete() {
 	
		//SecteurActivite e = r.findById(1L).get();
		 //r.delete(e);
		 //s.deleteSecteurActivite(null);
		Long Id = 1L;
		//mock
		doNothing().when(r).deleteById(Id);
		//call function
		s.deleteSecteurActivite(Id);
		//assert
		verify(r, times(1)).deleteById(Id);
		
	}
	@Test
	public void modifier(){
		//SecteurDTO se= new SecteurDTO();
		//se.setIdSecteurActivite(null);;
		//mock
		//when(r.save(any())).thenReturn(s);
		//call function 
		//s.updateADDSecteurActivite(new SecteurActivite());
		//assert
		//assertEquals(1L,se.getIdSecteurActivite());
		SecteurActivite df = new SecteurActivite();
		df.setIdSecteurActivite(1L);
		when(r.save(any())).thenReturn(df);
		s.updateADDSecteurActivite(new SecteurActivite());
		assertEquals(1L, df.getIdSecteurActivite());
}

}
