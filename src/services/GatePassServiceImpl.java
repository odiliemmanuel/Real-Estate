package services;

import data.models.GatePass;

import java.util.List;

public interface GatePassServiceImpl {

    void removeGatePass(int id);
    GatePass getGatePass(int id);
    List<GatePass> getAllGatePasses();

}
