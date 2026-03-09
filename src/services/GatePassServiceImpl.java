package services;

import data.models.GatePass;
import data.repositeries.GatePassRepository;

import java.util.List;

public class GatePassServiceImpl implements GatePassService {

    private GatePassRepository repository;

    public GatePassServiceImpl(GatePassRepository repository) {
        this.repository = repository;
    }

    @Override
    public void removeGatePass(int id) {
      if(repository.findById(id) == null){
          throw new IllegalArgumentException("GatePass Not Found");
      }
      repository.delete(id);
    }


    @Override
    public void issueGatePass(GatePass gatePass) {
        if(repository.findByObject(gatePass) != null){
            throw new IllegalArgumentException("GatePass already exists");
        }
        repository.save(gatePass);
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

    @Override
    public int getNumberOfGatePasses() {
        return repository.count();
    }
}
