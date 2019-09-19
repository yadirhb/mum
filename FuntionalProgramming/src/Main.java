import hospital.*;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        TernaryFunction<Integer, Integer, Integer, Integer> sumSquares = (x, y, z) -> x * x + y * y + z * z;
        NonTernaryFunction<Integer, Integer, Integer, Integer> sumSquares2 = (x, y, z) -> x * x + y * y + z * z;
        Function<Hospital, Optional<Doctor>> getTopVisited = (h) -> h.getDepartments().stream()
                .flatMap(d -> d.getDoctorList().stream())
                .sorted((d1, d2) -> d2.getVisitList().size() - d1.getVisitList().size())
                .findFirst();

        BiFunction<Hospital, String, Long> docNameStartWith = (h, c) -> h.getDepartments().stream()
                .flatMap(department -> department.getDoctorList().stream())
                .filter(doctor -> doctor.getName().startsWith(c))
                .count();

        TernaryFunction<Stream, Integer, Integer, Stream> slice = (stream, s, l) -> stream.skip(s).limit(l);

        TernaryFunction<Hospital, String, Integer, List<String>> topThreeByAge = (h, c, k) -> h.getDepartments().stream()
                .flatMap(department -> department.getDoctorList().stream())
                .filter(doctor -> doctor.getName().startsWith(c))
                .sorted((doc1, doc2) -> doc2.getAge() - doc1.getAge()).limit(k)
                .map(doctor -> doctor.getName().toUpperCase()).collect(Collectors.toList());

        BiFunction<Hospital, Patient, Optional<Doctor>> oldestDocWhoAttendedPatient = (h, p) -> h.getDepartments().stream()
                .flatMap(department -> department.getDoctorList().stream())
                .filter(doctor -> doctor.getVisitList().stream().filter(visit -> visit.getPatient().equals(p)).count() > 0)
                .sorted((doc1, doc2) -> doc2.getAge() - doc1.getAge())
                .findFirst();


        Function<Hospital, Optional<Long>> getMostVisited = (h) -> h.getDepartments().stream()
                .flatMap(department -> department.getDoctorList().stream())
                .flatMap(doctor -> doctor.getVisitList().stream())
                .flatMap(visit -> visit.getResults().stream())
                .filter(visitResult -> visitResult.getType() == ResultType.Lab)
                .collect(Collectors.groupingBy(o -> ((Lab) o).getId(),  Collectors.counting()))
                .entrySet().stream()
                .max((e1, e2) -> e2.getValue().intValue() - e1.getValue().intValue())
                .map(e -> e.getKey());

        BiFunction<Hospital, Long, Long> amountOfDoctors = (h, med) -> h.getDepartments().stream()
                .flatMap(department -> department.getDoctorList().stream())
                .filter(doctor -> doctor.getVisitList().stream().anyMatch(visit -> visit.getResults().stream().anyMatch(visitResult -> visitResult.getType() == ResultType.Medication && ((Medication) visitResult).getId() == med )))
                .count();

        int r = sumSquares.process(1, 2, 3);
        int r2 = sumSquares2.process(1, 2, 3);

        System.out.println(r);
        System.out.println(r2);
    }
}
