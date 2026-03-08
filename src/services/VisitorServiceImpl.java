package services;

import data.models.Resident;
import data.models.Visitor;

import java.util.List;

public interface VisitorServiceImpl {

    Visitor registerVisitor(Visitor visitor);
    Visitor getVisitor(int id);
    void removeVisitor(int id);
    List<Visitor> getAllVisitors();
    Resident getVisitorUsingResidentId(int id);
    void removeVisitorUsingResidentId(int id);





}
