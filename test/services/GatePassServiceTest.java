package services;

import data.models.GatePass;
import data.repositeries.GatePassRepository;
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

    GatePass passOne = new GatePass(1, 3, 6);
    GatePass passTwo = new GatePass(3, 7, 9);
    GatePass passThree = new GatePass(4, 8, 10);

    @BeforeEach
    public void setup(){
        gatePasses = new ArrayList<>();
        repository = new GatePassRepository(gatePasses);
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

        services.removeGatePass(4);
        assertEquals(2, services.getNumberOfGatePasses());
    }


    @Test
    public void testThatWhileRemovingGatePasses_IfGatePassToBeRemovedDoesnt_ErrorIsThrown() {
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

        assertEquals(7, services.getGatePass(3).getResidentId());
    }

    @Test
    public void testThatWhileFindingGatePass_IfGatePassDoesntExist_ErrorIsThrown(){
        assertEquals(0, services.getNumberOfGatePasses());

        services.issueGatePass(passOne);
        services.issueGatePass(passTwo);
        services.issueGatePass(passThree);
        assertEquals(3, services.getNumberOfGatePasses());

        assertThrows(IllegalArgumentException.class,
                () -> services.getGatePass(2));
    }

}
