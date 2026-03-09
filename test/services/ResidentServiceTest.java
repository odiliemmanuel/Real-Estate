package services;

import data.models.Resident;
import data.repositeries.ResidentRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResidentServiceTest {
    List<Resident> repositories;
    ResidentRepositoryImpl repository;
    ResidentService services;

    Resident repoOne = new Resident("Odili", "3212", "07046731195");
    Resident repoTwo = new Resident("Kamsi", "2323", "07046731194");
    Resident repoThree = new Resident("Fechi", "4323", "0906577843");


    @BeforeEach
    public void setup(){
        repositories = new ArrayList<>();
        repository = new ResidentRepositoryImpl(repositories);
        services = new ResidentServiceImpl(repository);
    }

    @Test
    public void testThatIRegisterResident_NumberOfResidentsIncreases(){
        assertEquals(0, services.getNumberOfResidents());

        services.registerResident(repoOne);
        services.registerResident(repoTwo);
        assertEquals(2, services.getNumberOfResidents());
    }


    @Test
    public void testThatWhileRegisteringResidents_IfResidentTOBeRegisteredAlreadyExist_ErrorIsThrown(){
        assertEquals(0, services.getNumberOfResidents());

        services.registerResident(repoOne);
        services.registerResident(repoTwo);
        assertEquals(2, services.getNumberOfResidents());

        assertThrows(IllegalArgumentException.class,
                ()->  services.registerResident(repoOne));

    }


    @Test
    public void testThatIRemoveAResident_NumberOfResidentsReduces(){
        assertEquals(0, services.getNumberOfResidents());

        services.registerResident(repoOne);
        services.registerResident(repoTwo);
        services.registerResident(repoThree);
        assertEquals(3, services.getNumberOfResidents());

        services.removeResident(3);
        assertEquals(2, services.getNumberOfResidents());
    }


    @Test
    public void testThatWhileRemovingResidents_IfResidentToBeRemovedDoesNotExist_ErrorIsThrown(){
        assertEquals(0, services.getNumberOfResidents());

        services.registerResident(repoOne);
        services.registerResident(repoTwo);
        services.registerResident(repoThree);
        assertEquals(3, services.getNumberOfResidents());

        assertThrows(IllegalArgumentException.class,
                () -> services.removeResident(4));

        assertEquals(3, services.getNumberOfResidents());
    }


    @Test
    public void testThatICanFindResidentById(){
        assertEquals(0, services.getNumberOfResidents());

        services.registerResident(repoOne);
        services.registerResident(repoTwo);
        services.registerResident(repoThree);
        assertEquals(3, services.getNumberOfResidents());

        assertEquals("Kamsi", services.getResident(2).getName());

    }


    @Test
    public void testThatWhileSearchingForResident_IfResidentToBeSearchedDoesNotExist_ErrorIsThrown(){
        assertEquals(0, services.getNumberOfResidents());

        services.registerResident(repoOne);
        services.registerResident(repoTwo);
        services.registerResident(repoThree);
        assertEquals(3, services.getNumberOfResidents());

        assertThrows(IllegalArgumentException.class,
                () -> services.getResident(5));

    }
}
