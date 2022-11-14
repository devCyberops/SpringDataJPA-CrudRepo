package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OperateurServiceImplTest {
    @Mock
    OperateurRepository operateurRepositoryMock;
    @InjectMocks
    OperateurServiceImpl operateurService;


    Operateur op = Operateur.builder().nom("test").prenom("insaf").password("root").build();
    List<Operateur> listOperateurs = new ArrayList<Operateur>(){
        {
            add(Operateur.builder().nom("test").prenom("insaf").password("root").build());
        }

    };

    @Test
    void testretrieveOperateur(){
        Mockito.when(operateurRepositoryMock.findById(Mockito.anyLong())).thenReturn(Optional.of(op)); //find all
        Operateur op1 = operateurService.retrieveOperateur(2L);
        Assertions.assertNotNull(op1);

    }
    @Test
    void testaddOperateur() {
        Mockito.when(operateurRepositoryMock.save(op)).thenReturn(op);
        Operateur op1 = operateurService.addOperateur(op);
        Assertions.assertNotNull(op1);

    }




}