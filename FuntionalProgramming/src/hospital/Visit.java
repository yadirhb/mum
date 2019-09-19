package hospital;

import java.util.List;

public class Visit {
    Doctor doctor;
    Patient patient;
    List<VisitResult> results;

    public Visit(Doctor d, Patient p) {
        this.doctor = d;
        this.patient = p;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public List<VisitResult> getResults() {
        return results;
    }
}
