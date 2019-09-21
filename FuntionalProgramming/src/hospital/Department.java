package hospital;

import java.util.LinkedList;
import java.util.List;

public class Department {
    private List<Doctor> doctorList;

    public Department(List<Doctor> doctorList){
        this.doctorList = doctorList == null ? new LinkedList<Doctor>() : doctorList;
    }

    public List<Doctor> getDoctorList(){
        return this.doctorList;
    }
}
