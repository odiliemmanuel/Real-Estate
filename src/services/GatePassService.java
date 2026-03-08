package services;

import data.models.GatePass;
import data.repositeries.GatePassRepository;

import java.util.List;

public class GatePassService implements GatePassServiceImpl{

    private GatePassRepository repository;

    public GatePassService(GatePassRepository repository) {
        this.repository = repository;
    }

    @Override
    public void removeGatePass(int id) {
        if(repository.findById(id) == null){
            throw new IllegalArgumentException("GatePass not found");
        }
        repository.delete(id);
    }


    @Override
    public GatePass getGatePass(int id) {
        if(repository.findById(id) == null){
            throw new IllegalArgumentException("GatePass not found");
        }
        return repository.findById(id);
    }

    @Override
    public List<GatePass> getAllGatePasses() {
        return repository.findAll();
    }
}
