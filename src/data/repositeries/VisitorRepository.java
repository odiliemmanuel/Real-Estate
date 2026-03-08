package data.repositeries;


import data.models.Resident;
import data.models.Visitor;
import java.util.ArrayList;
import java.util.List;

public class VisitorRepository implements VisitorRepositoryImpl {
    private List<Visitor> visitors;
    private int id = 1;
    private int numberOfVisitors = 0;
    private ResidentRepository resident;


    public VisitorRepository(List<Visitor> visitors) {
        this.visitors = visitors;
    }


    @Override
    public Visitor save(Visitor newVisitor) {
       if(newVisitor.getId() == 0){
           newVisitor.setId(id ++);
           visitors.add(newVisitor);
           numberOfVisitors += 1;
       }

       for(int count = 0; count < visitors.size(); count++){
           if(visitors.get(count).getId() == newVisitor.getId()){
               visitors.remove(count);
               visitors.add(newVisitor);

           }
           numberOfVisitors += 1;
       }

       return newVisitor;
    }

    @Override
    public Visitor findById(int id) {
        for(Visitor visitor : visitors) {
            if(visitor.getId() == id){
                return visitor;
            }
        }
        return null;
    }

    @Override
    public Visitor findByObject(Visitor newVisitor) {
        for(Visitor visitor : visitors){
            if(visitor.getId() == newVisitor.getId()){
                return visitor;
            }
        }
        return null;
    }

    @Override
    public Resident findByResidentId(int id) {
        for(Resident residents : resident.findAll()){
            if(residents.getId() == id){
                return residents;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        Visitor visitor = findById(id);
        visitors.remove(visitor);
        numberOfVisitors -= 1;
    }

    @Override
    public void deleteByObject(Visitor newVisitor) {
        for(Visitor visitor : visitors){
            if(visitor.getId() == newVisitor.getId()){
                visitors.remove(visitor);
            }
            numberOfVisitors -= 1;
        }
    }

    @Override
    public List<Visitor> findAll() {

        return new ArrayList<>(visitors);
    }

    @Override
    public int count() {
        return numberOfVisitors;
    }

    @Override
    public void deleteByResidentId(int id) {
        for(Resident residents : resident.findAll()){
            if(residents.getId() == id){
                visitors.remove(residents);
            }
        }
    }


}
