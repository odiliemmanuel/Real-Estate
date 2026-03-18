package services;

import data.models.GatePass;
import data.repositeries.GatePassRepository;
import data.repositeries.GatePassRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class GatePassServiceTest {
    List<GatePass> gatePasses;
    GatePassRepository repository;
    GatePassService services;

    GatePass passOne = new GatePass("Odili", "000879");
    GatePass passTwo = new GatePass("Barry", "980766");
    GatePass passThree = new GatePass("Allen", "787879");

    @BeforeEach
    public void setup(){
        gatePasses = new ArrayList<>();
        repository = new GatePassRepositoryImpl(gatePasses);
        services = new GatePassServiceImpl(repository);
    }


    @Test
    public void testThatIIssueGatePass_NumberOfGatePassesIncreases() {
        assertEquals(0, services.getNumberOfGatePasses());

        services.issueGatePass(passOne);
        services.issueGatePass(passTwo);
        services.issueGatePass(passThree);
        assertEquals(3, services.getNumberOfGatePasses());
    }


    @Test
    public void testThatWhileIssuingGatePasses_IfGatePassToBeIssuedAlreadyExists_ErrorIsThrown() {
        assertEquals(0, services.getNumberOfGatePasses());

        services.issueGatePass(passOne);
        services.issueGatePass(passTwo);

        assertThrows(IllegalArgumentException.class,
                () -> services.issueGatePass(passOne));
    }


    @Test
    public void testThatIRemoveGatePass_NumberOfGatePassesReduces(){
        assertEquals(0, services.getNumberOfGatePasses());

        services.issueGatePass(passOne);
        services.issueGatePass(passTwo);
        services.issueGatePass(passThree);
        assertEquals(3, services.getNumberOfGatePasses());

        services.removeGatePass(3);
        assertEquals(2, services.getNumberOfGatePasses());
    }


    @Test
    public void testThatWhileRemovingGatePasses_IfGatePassToBeRemovedDoesntExist_ErrorIsThrown() {
        assertEquals(0, services.getNumberOfGatePasses());

        services.issueGatePass(passOne);
        services.issueGatePass(passTwo);
        services.issueGatePass(passThree);
        assertEquals(3, services.getNumberOfGatePasses());

        assertThrows(IllegalArgumentException.class,
                () -> services.removeGatePass(2));
        assertEquals(3, services.getNumberOfGatePasses());
    }


    @Test
    public void testThatICanFindGatePass_UsingItsId(){
        assertEquals(0, services.getNumberOfGatePasses());

        services.issueGatePass(passOne);
        services.issueGatePass(passTwo);
        services.issueGatePass(passThree);
        assertEquals(3, services.getNumberOfGatePasses());

        assertEquals(services.getGatePass(3).getId(), passThree.getId());
    }

    @Test
    public void testThatWhileFindingGatePass_IfGatePassDoesntExist_ErrorIsThrown(){
        assertEquals(0, services.getNumberOfGatePasses());

        services.issueGatePass(passOne);
        services.issueGatePass(passTwo);
        services.issueGatePass(passThree);
        assertEquals(3, services.getNumberOfGatePasses());

        assertThrows(IllegalArgumentException.class,
                () -> services.getGatePass(5));
    }

}
