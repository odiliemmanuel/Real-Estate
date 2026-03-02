package data.repositeries;


import data.models.Visitor;

import java.util.List;

public class Visitors implements VisitorRepo {
    private List<Visitor> visitors;


    public Visitors(List<Visitor> visitors) {
        this.visitors = visitors;
    }


    @Override
    public void save(Visitor newVisitor) {
        for(Visitor visitor : visitors) {
            if(visitor.getId() == newVisitor.getId()){
                visitors.remove(visitor);
            }
            visitors.add(newVisitor);

        }

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



}
