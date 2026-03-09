package services;

import data.models.Resident;
import data.repositeries.ResidentRepositoryImpl;


import java.util.List;

public class ResidentServiceImpl implements ResidentService {
    private ResidentRepositoryImpl repository;


    public ResidentServiceImpl(ResidentRepositoryImpl repository) {
        this.repository = repository;
    }


    @Override
    public Resident registerResident(Resident residents) {
        if(repository.findByObject(residents) != null){
            throw new IllegalArgumentException("Resident already exists");
        }
        return repository.save(residents);
    }

    @Override
    public Resident getResident(int id) {
        if(repository.findById(id) == null){
            throw new IllegalArgumentException("Resident not found");
        }

        return repository.findById(id);
    }

    @Override
    public void removeResident(int id) {
        if(repository.findById(id) == null){
            throw new IllegalArgumentException("Resident not found");
        }
        repository.delete(id);
    }



    @Override
    public List<Resident> getAllResidents() {
        return repository.findAll();
    }


    @Override
    public int getNumberOfResidents() {
        return repository.count();
    }
}
