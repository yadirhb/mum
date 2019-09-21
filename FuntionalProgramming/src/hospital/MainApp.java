package hospital;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
interface HexaFunction<U, V, W, X, Y, Z, R> {
    R apply(U u, V v, W w, X x, Y y, Z z);
}

@FunctionalInterface
interface TetraFunction<V, W, X, Y, R> {
    R apply(V v, W w, X x, Y y);
}

class Patient {
    String id;
    String name;

    public String getName() {
        return name;
    }
}

class Medication {
    String id;
    String drugName;

    public String getDrugName() {
        return drugName;
    }

    public String getId() {
        return id;
    }
}

class Diagnosis {
    String icd9Code;
    String name;

    public String getIcd9Code() {
        return icd9Code;
    }

    public String getName() {
        return name;
    }
}

class Lab {
    String labId;
    String labName;

    public String getLabId() {
        return labId;
    }

    public String getLabName() {
        return labName;
    }
}

class PatientRecord<T> {
    private T record;
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public T getRecord() {
        return record;
    }
}

public class MainApp {
    public static TetraFunction<List<PatientRecord<Medication>>, List<PatientRecord<Lab>>, List<PatientRecord<Diagnosis>>, Patient, Stream<PatientRecord>> getPatientRecords = (medications, labs, diagnosis, target) ->
            Stream.concat(
                    Stream.concat(
                            medications.stream().filter(patientRecord -> patientRecord.getPatient().equals(target)),
                            labs.stream().filter(patientRecord -> patientRecord.getPatient().equals(target))
                    ),
                    diagnosis.stream().filter(patientRecord -> patientRecord.getPatient().equals(target))
            );

    public static BiFunction<Stream<PatientRecord>, Stream<PatientRecord>, Stream<PatientRecord>> intersect = (set1, set2) ->
            set1.filter(
                    patientRecord -> set2.anyMatch(patientRecord2 -> patientRecord.getRecord().equals(patientRecord.getRecord()))
            );

    public static BiFunction<Stream<PatientRecord>, Stream<PatientRecord>, Float> jaccardSimilarity = (set1, set2) ->
            intersect.apply(set1, set2).count() / (float) (set1.count() + set2.count() - intersect.apply(set1, set2).count());

    public static HexaFunction<List<Patient>, List<PatientRecord<Medication>>, List<PatientRecord<Lab>>, List<PatientRecord<Diagnosis>>, Integer, Patient, List<String>> topKMostSimilarPatients = (patients, medications, labs, diags, k, target) ->
            patients.stream().filter(patient -> jaccardSimilarity.apply(getPatientRecords.apply(medications, labs, diags, patient), getPatientRecords.apply(medications, labs, diags, target)) > k )
            .map(patient -> patient.getName()).collect(Collectors.toList());
}