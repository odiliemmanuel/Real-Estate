package data.repositeries;

import data.models.Resident;
import data.models.Visitor;

import java.util.List;

public interface ResidentRepo {

    Resident findById(int id);
    Resident save(Resident repository);
    void deleteAll();
    void deleteByObject(Resident repository);
    void delete(int id);
    List<Resident> findAll();


}
