package data.repositeries;

import data.models.GatePass;
import data.models.Visitor;

import java.util.List;

public interface GatePassRepo {

    GatePass save(GatePass gatePass);
    GatePass findById(int id);
    void delete(int id);
    void deleteByObject(GatePass gatePass);
    GatePass findByObject(GatePass gatePass);
    List<GatePass> findAll();
}
