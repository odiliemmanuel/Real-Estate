package data.repository;

import data.models.GatePass;
import data.repositeries.GatePasses;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class GatePassTest {
    List<GatePass> gatePasses;
    GatePasses gatePass;

    GatePass passOne = new GatePass(1, 3, 6);
    GatePass passTwo = new GatePass(3, 7, 9);
    GatePass passThree = new GatePass(4, 8, 10);


    @BeforeEach
    public void setup(){
         gatePasses = new ArrayList<>();
         gatePass = new GatePasses(gatePasses);
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

        GatePass gatePassOne = new GatePass(1, 3, 6);
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

        gatePass.delete(1);
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
