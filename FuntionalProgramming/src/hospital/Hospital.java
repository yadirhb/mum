package hospital;

import java.util.LinkedList;
import java.util.List;

public class Hospital {
    List<Department> departments;

    public Hospital(List<Department> departments){
        this.departments = departments == null ? new LinkedList<Department>() : departments;
    }

    public List<Department> getDepartments(){
        return this.departments;
    }
}
