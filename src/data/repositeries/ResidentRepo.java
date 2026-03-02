package data.repositeries;

import data.models.Resident;

public interface ResidentRepo {

    void findById(int id);
    void delete(int id);
    void save(Resident repository);
    void deleteAll();

}
