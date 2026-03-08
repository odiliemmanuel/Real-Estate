package services;

import data.models.Resident;

import java.util.List;

public interface ResidentServiceImpl {

    Resident registerResident(Resident residents);
    Resident getResident(int id);
    void removeResident(int id);
    List<Resident> getAllResidents();
    int getNumberOfResidents();
}
