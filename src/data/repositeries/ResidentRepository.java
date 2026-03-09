package data.repositeries;

import data.models.Resident;

import java.util.List;

public interface ResidentRepository {

    int count();
    Resident findById(int id);
    Resident findByObject(Resident repository);
    Resident save(Resident repository);
    void deleteAll();
    void deleteByObject(Resident repository);
    void delete(int id);
    List<Resident> findAll();


}
