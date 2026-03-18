package data.repository;

import data.models.GatePass;
import data.repositeries.GatePassRepository;
import data.repositeries.GatePassRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class GatePassRepositoryTest {
    List<GatePass> gatePasses;
    GatePassRepository gatePass;

    GatePass passOne = new GatePass("Odili", "07046731194");
    GatePass passTwo = new GatePass("Flash", "07154436768");
    GatePass passThree = new GatePass("Barry", "0787775757");


    @BeforeEach
    public void setup(){
        gatePasses = new ArrayList<>();
        gatePass = new GatePassRepositoryImpl(gatePasses);
    }

    @Test
    public void testThatNumberOfGatePasses_IsAtInitialState_0() {
        assertEquals(0, gatePass.count());
    }

    @Test
    public void testThatIfISaveGatePass_NumberOfPassesIncreases(){
        assertEquals(0, gatePass.count());

        gatePass.save(passOne);
        gatePass.save(passTwo);
        assertEquals(2, gatePass.count());
    }


    @Test
    public void testThatIfISaveAGatePass_WithAnIdThatIAlreadyExists_NumberOfPasseRemainsTheSame(){
        assertEquals(0, gatePass.count());

        GatePass gatePassOne = new GatePass("Odili", "07046731194");
        gatePass.save(gatePassOne);
        gatePass.save(passOne);
        gatePass.save(passTwo);
        gatePass.save(passThree);
        assertEquals(3, gatePass.count());
    }


    @Test
    public void testThatICanDeleteGatePass_AndNumberOfPassesDecreases(){
        assertEquals(0, gatePass.count());

        gatePass.save(passOne);
        gatePass.save(passTwo);
        gatePass.save(passThree);
        assertEquals(3, gatePass.count());

        gatePass.delete(2);
        assertEquals(2, gatePass.count());

    }


    @Test
    public void testThatICanFindGatePassWithItsId(){
        assertEquals(0, gatePass.count());

        gatePass.save(passOne);
        gatePass.save(passTwo);
        gatePass.save(passThree);
        assertEquals(3, gatePass.count());

        assertEquals(passOne, gatePass.findById(1));
        assertEquals(3, gatePass.count());
    }


    @Test
    public void testThatICanFindGatePassUsingItsObject(){
        assertEquals(0, gatePass.count());

        gatePass.save(passOne);
        gatePass.save(passTwo);
        gatePass.save(passThree);
        assertEquals(3, gatePass.count());

        assertEquals(passOne, gatePass.findByObject(passOne));
    }


    @Test
    public void testThatICanDeleteGatePassWithItsObject(){
        assertEquals(0, gatePass.count());

        gatePass.save(passOne);
        gatePass.save(passTwo);
        gatePass.save(passThree);
        assertEquals(3, gatePass.count());

        gatePass.deleteByObject(passOne);
        assertEquals(2, gatePass.count());

    }
}
