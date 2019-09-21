import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainApp {
    public static TetraFunction<List<PatientRecord<Medication>>, List<PatientRecord<Lab>>, List<PatientRecord<Diagnosis>>, Patient, Stream<PatientRecord>> getPatientRecords = (medications, labs, diagnosis, target) ->
            Stream.concat(
                    Stream.concat(
                            medications.stream().collect(Collectors.groupingBy(PatientRecord::getPatient)).get(target).stream(),
                            labs.stream().collect(Collectors.groupingBy(PatientRecord::getPatient)).get(target).stream()
                    ),
                    diagnosis.stream().collect(Collectors.groupingBy(PatientRecord::getPatient)).get(target).stream()
            );

    public static BiFunction<Stream<PatientRecord>, Stream<PatientRecord>, Stream<PatientRecord>> intersect = (set1, set2) ->
            Sets.intersection(new HashSet<>(set1.collect(Collectors.toList())),new HashSet<>(set2.collect(Collectors.toList()))).stream();

    public static BiFunction<Stream<PatientRecord>, Stream<PatientRecord>, Float> jaccardSimilarity = (set1, set2) ->
            Float.valueOf(intersect.apply(set1, set2).count() / (set1.count() + set2.count() - intersect.apply(set1, set2).count()));

    public static HexaFunction<List<Patient>, List<PatientRecord<Medication>>, List<PatientRecord<Lab>>, List<PatientRecord<Diagnosis>>, Integer, Patient, List<String>> topKMostSimilarPatients = (patients, medications, labs, diags, k, target) ->
            patients.stream()
                    .filter(patient -> !patient.equals(target))
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