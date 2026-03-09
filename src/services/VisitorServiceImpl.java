package services;

import data.models.Resident;
import data.models.Visitor;
import data.repositeries.ResidentRepositoryImpl;
import data.repositeries.VisitorRepositoryImpl;

import java.util.List;

public class VisitorServiceImpl implements VisitorService {

    private VisitorRepositoryImpl repository;
    private ResidentRepositoryImpl residentRepository;

    public VisitorServiceImpl(VisitorRepositoryImpl repository) {
        this.repository = repository;
    }


    @Override
    public Visitor registerVisitor(Visitor visitor) {
        if(repository.findByObject(visitor) != null){
            throw new IllegalArgumentException("Visitor already exists");
        }
        return repository.save(visitor);
    }

    @Override
    public Visitor getVisitor(int id) {
        if(repository.findById(id) == null){
            throw new IllegalArgumentException("Visitor not found");
        }
        return repository.findById(id);
    }

    @Override
    public void removeVisitor(int id) {
        if(repository.findById(id) == null){
            throw new IllegalArgumentException("Visitor not found");
        }
        repository.delete(id);
    }


    @Override
    public List<Visitor> getAllVisitors() {
        return repository.findAll();
    }

    @Override
    public Resident getVisitorUsingResidentId(int id) {
        List<Resident> repository = residentRepository.findAll();
        for(Resident resident : repository){
            if(residentRepository.findById(id) == null){
                throw new IllegalArgumentException("Visitor not found");
            }
        }
        return residentRepository.findById(id);
    }

    @Override
    public void removeVisitorUsingResidentId(int id) {
        List<Resident> repository = residentRepository.findAll();
        for(Resident resident : repository){
            if(residentRepository.findById(id) == null){
                throw new IllegalArgumentException("Visitor not found");
            }
        }

        residentRepository.delete(id);
    }
}
