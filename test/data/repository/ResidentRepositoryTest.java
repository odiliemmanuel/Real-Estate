package data.repository;


import data.models.Resident;
import data.repositeries.ResidentRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResidentRepositoryTest {
    List<Resident> repositories;
    ResidentRepositoryImpl repository;

    Resident repoOne = new Resident("Odili", "3212", "07046731195");
    Resident repoTwo = new Resident("Kamsi", "2323", "07046731194");
    Resident repoThree = new Resident("Fechi", "4323", "0906577843");


    @BeforeEach
    public void setup(){
        repositories = new ArrayList<>();
        repository = new ResidentRepositoryImpl(repositories);
    }

    @Test
    public void testThatNumberOfGatePasses_IsAtInitialState_0() {
        assertEquals(0, repository.count());
    }


    @Test
    public void testThatIfISaveGatePass_NumberOfPassesIncreases(){
        assertEquals(0, repository.count());

        repository.save(repoOne);
        repository.save(repoTwo);
        assertEquals(2, repository.count());
    }


    @Test
    public void testThatIfISaveAGatePass_WithAnIdThatIAlreadyExists_NumberOfPassesRemainsTheSame(){
        assertEquals(0, repository.count());

        Resident newRepoOne = new Resident("Odili", "3212", "07046731195");
        repository.save(newRepoOne);
        repository.save(repoOne);
        repository.save(repoTwo);
        repository.save(repoThree);
        assertEquals(3, repository.count());
    }


    @Test
    public void testThatICanDeleteGatePass_AndNumberOfPassesDecreases(){
        assertEquals(0, repository.count());

        repository.save(repoOne);
        repository.save(repoTwo);
        repository.save(repoThree);
        assertEquals(3, repository.count());

        repository.delete(1);
        assertEquals(2, repository.count());

    }


    @Test
    public void testThatICanFindGatePassWithItsId(){
        assertEquals(0, repository.count());

        repository.save(repoOne);
        repository.save(repoTwo);
        repository.save(repoThree);
        assertEquals(3, repository.count());

        assertEquals(repoOne, repository.findById(1));
        assertEquals(3, repository.count());
    }


    @Test
    public void testThatICanFindGatePassUsingItsObject(){
        assertEquals(0, repository.count());

        repository.save(repoOne);
        repository.save(repoTwo);
        repository.save(repoThree);
        assertEquals(3, repository.count());

        assertEquals(repoOne, repository.findByObject(repoOne));
    }


    @Test
    public void testThatICanDeleteGatePassWithItsObject(){
        assertEquals(0, repository.count());

        repository.save(repoOne);
        repository.save(repoTwo);
        repository.save(repoThree);
        assertEquals(3, repository.count());

        repository.deleteByObject(repoOne);
        assertEquals(2, repository.count());

    }

    @Test
    public void testThatICanDeleteAllResidentsInListOfResidents(){
        assertEquals(0, repository.count());

        repository.save(repoOne);
        repository.save(repoTwo);
        repository.save(repoThree);
        assertEquals(3, repository.count());

        repository.deleteAll();
        assertEquals(0, repository.count());
    }
}
