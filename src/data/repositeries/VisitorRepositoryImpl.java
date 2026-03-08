package data.repositeries;


import data.models.Resident;
import data.models.Visitor;

import java.util.List;

public interface VisitorRepositoryImpl {

    Visitor save(Visitor visitor);
    Visitor findById(int id);
    Visitor findByObject(Visitor visitor);
    Resident findByResidentId(int id);
    void delete(int id);
    void deleteByObject(Visitor visitor);
    List<Visitor> findAll();
    int count();
    void deleteByResidentId(int id);


}
