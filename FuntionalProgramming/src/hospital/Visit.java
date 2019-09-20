package hospital;

import java.util.List;

public class Visit {
    Doctor doctor;
    PatientO patient;
    List<VisitResult> results;

    public Visit(Doctor d, PatientO p) {
        this.doctor = d;
        this.patient = p;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public PatientO getPatient() {
        return patient;
    }

    public List<VisitResult> getResults() {
        return results;
    }
}
