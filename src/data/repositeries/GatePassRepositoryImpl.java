package data.repositeries;

import data.models.GatePass;

import java.util.ArrayList;
import java.util.List;

public class GatePassRepositoryImpl implements GatePassRepository {
    private List<GatePass> gatePasses;
    private int id = 1;
    private int numberOfGatePasses = 0;


    public GatePassRepositoryImpl(List<GatePass> gatePasses) {

        this.gatePasses = gatePasses;
    }


    @Override
    public int count() {
        return numberOfGatePasses;
    }

    @Override
    public GatePass save(GatePass gatePass) {
        if(gatePass.getId() == 0){
            gatePass.setId(this.id ++);
            gatePasses.add(gatePass);
            numberOfGatePasses += 1;
        }
        else{
            delete(gatePass.getId());
            gatePasses.add(gatePass);
            numberOfGatePasses += 1;
        }

        return gatePass;
    }

        @Override
    public void delete(int id) {
        for(int index = 0; index < gatePasses.size(); index++){
            if(gatePasses.get(index).getId() == id){
                gatePasses.remove(index);
                numberOfGatePasses -= 1;
            }
        }
    }

    @Override
    public void deleteByObject(GatePass newGatePass) {
        for(int index = 0; index < gatePasses.size(); index++){
            if(gatePasses.get(index).getId() == id){
                gatePasses.remove(index);
                numberOfGatePasses -= 1;
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
