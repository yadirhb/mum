package school;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {
    List<Teacher> teacherList;

    public School(List<Teacher> teacherList) {
        this.teacherList = teacherList == null ? new LinkedList<Teacher>() : teacherList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public static void main(String[] args) {

        BiFunction<School, Long, Stream<Map.Entry<Student, Integer>>> getGroupStudentsAndScore = (s, score) -> s.getTeacherList().stream()
                .flatMap(teacher -> teacher.getGrades().stream())
                .filter(grade -> grade.getEvaluation() == Evaluation.A || grade.getEvaluation() == Evaluation.B)
                .collect(Collectors.groupingBy(Grade::getStudent, Collectors.summingInt(g -> g.getCourse().getScore()))).entrySet().stream()
                .filter(studentListEntry -> studentListEntry.getValue() > score);

        BiFunction<School, Long, List<Student>> getScoredStudents = (s, score) -> getGroupStudentsAndScore.apply(s, score)
                .map(e -> e.getKey()).collect(Collectors.toList());

        BiFunction<School, Long, List<Student>> getTop10 = (s, score) -> getGroupStudentsAndScore.apply(s, score)
                .sorted((s1, s2) -> s2.getValue() - s1.getValue())
                .limit(10).map(e -> e.getKey()).collect(Collectors.toList());
    }
}
