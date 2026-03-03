package data.repositeries;

import data.models.GatePass;

import java.util.ArrayList;
import java.util.List;

public class GatePasses implements GatePassRepo {
    private List<GatePass> gatePasses;
    private int id = 1;


    public GatePasses(List<GatePass> gatePasses) {

        this.gatePasses = gatePasses;
    }

    
    @Override
    public GatePass save(GatePass gatePass) {
        if(gatePass.getId() == 0){
            gatePass.setId(this.id ++);
            gatePasses.add(gatePass);
        }
        else{
            delete(gatePass.getId());
            gatePasses.add(gatePass);
        }

        return gatePass;
    }

        @Override
    public void delete(int id) {
        for(GatePass gatePass : gatePasses){
            if(gatePass.getId() == id){
                gatePasses.remove(gatePass);
            }
        }
    }

    @Override
    public void deleteByObject(GatePass newGatePass) {
        for(GatePass gatePass : gatePasses){
            if(gatePass.getId() == newGatePass.getId()){
                gatePasses.remove(newGatePass);
            }
        }
    }

    @Override
    public GatePass findByObject(GatePass newGatePass) {
        for(GatePass gatePass : gatePasses){
            if(gatePass.getId() == newGatePass.getId()){
                return gatePass;
            }
        }
        return null;
    }

    @Override
    public GatePass findById(int id) {
        for(GatePass gatePass : gatePasses) {
            if(gatePass.getId() == id) {
                return gatePass;
            }
        }
        return null;
    }



    @Override
    public List<GatePass> findAll() {
        return new ArrayList<>(gatePasses);
    }
}
