import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            Float.valueOf(intersect.apply(set1, set2).count() / (set1.count() + set2.count() - intersect.apply(set1, set2).count()));

    public static HexaFunction<List<Patient>, List<PatientRecord<Medication>>, List<PatientRecord<Lab>>, List<PatientRecord<Diagnosis>>, Integer, Patient, List<String>> topKMostSimilarPatients = (patients, medications, labs, diags, k, target) ->
            patients.stream()
                    .sorted((patient1, patient2) ->
                            jaccardSimilarity.apply(
                                    getPatientRecords.apply(medications, labs, diags, patient2),
                                    getPatientRecords.apply(medications, labs, diags, target)).intValue()
                                    -
                                    jaccardSimilarity.apply(
                                            getPatientRecords.apply(medications, labs, diags, patient1),
                                            getPatientRecords.apply(medications, labs, diags, target)).intValue()
                    )
                    .limit(k)
                    .map(patient -> patient.getName()).collect(Collectors.toList()
            );
}