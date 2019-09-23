package hospital;

import java.util.LinkedList;
import java.util.List;

public class Doctor extends Person {
    protected List<Visit> visitList;
    protected Doctor(String name) {
        super(name);

        visitList = new LinkedList<>();
    }


    public void setVisitList(List<Visit> visitList) {
        if(visitList != null) {
            this.visitList = visitList;
        }
    }

    public List<Visit> getVisitList() {
        return visitList;
    }
}
