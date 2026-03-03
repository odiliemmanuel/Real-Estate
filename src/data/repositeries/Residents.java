package data.repositeries;

import data.models.Resident;

import java.util.ArrayList;
import java.util.List;

public class Residents implements ResidentRepo {

    private List<Resident> residents;
    private int id = 1;

    @Override
    public Resident findById(int id) {
        for(Resident resident : residents){
            if(resident.getId() == id){
                return resident;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        Resident resident = findById(id);
        residents.remove(resident);
    }


    @Override
    public Resident save(Resident repository) {
        if(repository.getId() == 0){
            repository.setId(id ++);
            residents.add(repository);
        }

        for(int count = 0; count < residents.size(); count++){
            if(residents.get(count).getId() == repository.getId()){
                residents.remove(count);
                residents.add(repository);
            }
        }
        return repository;
    }



    @Override
    public void deleteAll() {
        for(Resident resident : residents){
            residents.remove(resident);
        }
    }

    @Override
    public void deleteByObject(Resident repository) {
        for(Resident resident : residents){
            if(resident.getId() == repository.getId()){
                residents.remove(repository);
            }
        }
    }


    @Override
    public List<Resident> findAll() {
        return new ArrayList<>(residents);
    }
}
