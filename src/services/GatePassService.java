package services;

import data.models.GatePass;

import java.util.List;

public interface GatePassService {

    void issueGatePass(GatePass passOne);
    GatePass getGatePass(int id);
    List<GatePass> getAllGatePasses();
    int getNumberOfGatePasses();
    void removeGatePass(int id);
}
