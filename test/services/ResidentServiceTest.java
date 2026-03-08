package services;

import data.models.Resident;
import data.repositeries.ResidentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResidentServiceTest {
    List<Resident> repositories;
    ResidentRepository repository;
    ResidentServiceImpl services;

    Resident repoOne = new Resident("Odili", "3212", "07046731195");
    Resident repoTwo = new Resident("Kamsi", "2323", "07046731194");
    Resident repoThree = new Resident("Fechi", "4323", "0906577843");


    @BeforeEach
    public void setup(){
        repositories = new ArrayList<>();
        repository = new ResidentRepository(repositories);
        services = new ResidentService(repository);
    }

    @Test
    public void testThatIRegisterResident_NumberOfResidentsIncreases(){
        services.registerResident(repoOne);
        services.registerResident(repoTwo);
        assertEquals(2, services.getNumberOfResidents());
    }


    @Test
    public void testThatWhileRegisteringResidents_IfResidentTOBeRegisteredAlreadyExist_ErrorIsThrown(){
        services.registerResident(repoOne);
        services.registerResident(repoTwo);
        assertThrows(IllegalArgumentException.class,
                ()->  services.registerResident(repoOne));

    }


    @Test
    public void testThatIRemoveAResident_NumberOfResidentsReduces(){
        services.registerResident(repoOne);
        services.registerResident(repoTwo);
        services.registerResident(repoThree);
        assertEquals(3, services.getNumberOfResidents());

        services.removeResident(3);
        assertEquals(2, services.getNumberOfResidents());
    }


    @Test
    public void testThatWhileRemovingResidents_IfResidentToBeRemovedDoesNotExist_ErrorIsThrown(){
        services.registerResident(repoOne);
        services.registerResident(repoTwo);
        services.registerResident(repoThree);
        assertEquals(3, services.getNumberOfResidents());

        assertThrows(IllegalArgumentException.class,
                () -> services.removeResident(4));

        assertEquals(3, services.getNumberOfResidents());
    }
}
