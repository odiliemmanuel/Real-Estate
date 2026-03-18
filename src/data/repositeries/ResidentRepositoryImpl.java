package data.repositeries;

import data.models.Resident;

import java.util.ArrayList;
import java.util.List;

public class ResidentRepositoryImpl implements ResidentRepository {

    private List<Resident> residents;
    private int id = 1;
    private int numberOfResidents = 0;


    public ResidentRepositoryImpl(List<Resident> residents) {
        this.residents = residents;
    }


    @Override
    public int count() {
        return numberOfResidents;
    }

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
    public Resident save(Resident repository) {
        if(repository.getId() == 0){
            repository.setId(this.id ++);
            residents.add(repository);
            numberOfResidents += 1;
        }

        else{
            for(int count = 0; count < residents.size(); count++ ){
                if(residents.get(count).getId() == repository.getId()) {
                    delete(residents.get(count).getId());
                    residents.add(repository);

                }
            }
            numberOfResidents += 1;

        }


        return repository;
    }

    @Override
    public Resident findByObject(Resident repository) {
        for(Resident resident : residents){
            if(resident.getId() == repository.getId()){
                return resident;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        Resident resident = findById(id);
        residents.remove(resident);
        numberOfResidents -= 1;
    }




    @Override
    public void deleteAll() {
      for(int index = 0; index < residents.size(); index ++){
          residents.remove(index);
      }
        numberOfResidents = 0;
    }


    @Override
    public void deleteByObject(Resident repository) {
        for(int index = 0; index < residents.size(); index++){
            if(residents.get(index).getId() == id){
                residents.remove(index);

            }

        }
        numberOfResidents -= 1;
    }


    @Override
    public List<Resident> findAll() {
        return new ArrayList<>(residents);
    }
}
