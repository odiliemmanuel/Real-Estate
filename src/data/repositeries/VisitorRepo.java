package data.repositeries;


import data.models.Visitor;

import java.util.List;

public interface VisitorRepo {

    Visitor save(Visitor visitor);
    Visitor findById(int id);
    void delete(int id);
    void deleteByObject(Visitor visitor);
    List<Visitor> findAll();
    int count();


}
