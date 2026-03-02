package data.repositeries;


import data.models.Visitor;

public interface VisitorRepo {

    void save(Visitor visitor);
    Visitor findById(int id);


}
