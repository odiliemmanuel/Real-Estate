package data.repositeries;

import data.models.GatePass;

import java.util.List;

public interface GatePassRepositoryImpl {

    int count();
    GatePass save(GatePass gatePass);
    GatePass findById(int id);
    void delete(int id);
    void deleteByObject(GatePass gatePass);
    GatePass findByObject(GatePass gatePass);
    List<GatePass> findAll();
}
