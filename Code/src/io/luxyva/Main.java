package io.luxyva;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toSet;

public class Main {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("s6", "xs6", "One Class", 13, GenderEnum.MALE, StudentType.PASS, 6),
                new Student("s5", "xs5", "Two Class", 12, GenderEnum.MALE, StudentType.GOOD, 5),
                //new Student("s9", "xs9", "One Class", 14, GenderEnum.FEMALE, StudentType.PASS, 9),
                new Student("s8", "xs8", "One Class", 15, GenderEnum.MALE, StudentType.FAIL, 8),
                new Student("s2", "xs2", "Two Class", 11, GenderEnum.FEMALE, StudentType.EXCELLENT, 2),
                new Student("s3", "xs3", "One Class", 13, GenderEnum.MALE, StudentType.GOOD, 3),
                new Student("s7", "xs7", "Two Class", 14, GenderEnum.FEMALE, StudentType.EXCELLENT, 7),
                new Student("s4", "xs4", "Two Class", 10, GenderEnum.FEMALE, StudentType.FAIL, 4),
                new Student("s1", "xs1", "One Class", 14, GenderEnum.MALE, StudentType.GOOD, 1),
                new Student("s9", "xs9", "One Class", 14, GenderEnum.FEMALE, StudentType.PASS, 9)
        );

        List<String> words = Arrays.asList("oneone", "twotwo", "threethree", "four", "five");
        Map<String, List<Student>> map = new HashMap<>();
        for (Student s : students) {
            map.computeIfAbsent(s.getClassName(), t -> new ArrayList<>()).add(s);
        }
        List<Student> ageEq14 = students.stream().filter(t->t.getAge() == 14).collect(Collectors.toList());
        List<Student> goodStudent = students.stream().filter(t -> t.getAge() > 10).skip(2).collect(Collectors.toList());
        List<String> classNames = students.stream().map(Student::getClassName).collect(Collectors.toList());
        List<Integer> nameLength = students.stream().map(Student::getClassName).map(String::length).collect(Collectors.toList());
        List<String> distinctClassNames = students.stream().map(Student::getClassName).distinct().collect(Collectors.toList());
        List<String> limit3StudentName = students.stream().map(Student::getName).limit(3).collect(Collectors.toList());
        List<Student> sortStudent = students.stream().sorted(Comparator.comparing(Student::getSort).reversed()).collect(Collectors.toList());
        List<String> distinctWord = words.stream().map(s->s.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        boolean anyMatchGoodStudent = students.stream().anyMatch(Student::isGoodStudent);
        boolean allMatchGoodStudent = students.stream().allMatch(Student::isGoodStudent);
        boolean noneMatchAgeEq14 = students.stream().noneMatch(t -> t.getAge() == 14);
        Optional<Student> findAnyOfMaleStudent = students.stream().filter(t -> t.getGender() == GenderEnum.MALE).findAny();
        students.stream().filter(t -> t.getGender() == GenderEnum.MALE).findFirst().ifPresent(d -> System.out.println(d.getName()));
        int totalAge = students.stream().mapToInt(Student::getAge).reduce(0, (a, b) -> a + b);
        int totalAgeWithSum = students.stream().mapToInt(Student::getAge).reduce(0, Integer::sum);
        Optional<Integer> totalAgeNoValue = students.stream().map(Student::getAge).reduce((a, b) -> a + b);
        Optional<Integer> maxAge = students.stream().map(Student::getAge).reduce(Integer::max);
        Optional<Integer> minAge = students.stream().map(Student::getAge).reduce(Integer::min);
        Optional<Student> maxAgeStudent = students.stream().max(Comparator.comparing(Student::getAge));
        Optional<Student> minAgeStudent = students.stream().min(Comparator.comparing(Student::getAge));
        Set<Student> setOfStudent = students.stream().sorted(Comparator.comparing(Student::getSort)).collect(toSet());
        List<Student> listOfStudent = students.stream().sorted(Comparator.comparing(Student::getSort)).collect(Collectors.toList());
        Map<String, String> mapString = students.stream().collect(Collectors.toMap(Student::getId, Student::getName));
        Map<String, String> sortMap = students.stream().sorted(Comparator.comparing(Student::getSort)).collect(Collectors.toMap(Student::getId, Student::getName, (k1, k2) -> k1, LinkedHashMap::new));
        Map<String, Student> mapOfStudent = students.stream().sorted(Comparator.comparing(Student::getSort)).collect(Collectors.toMap(Student::getName, Function.identity(), (k1, k2) -> k1));
        Map<String, Object> nameMapOfSort = mapOfStudent.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> newValue, LinkedHashMap::new));
        String studentName = students.stream().sorted(Comparator.comparing(Student::getSort)).map(Student::getName).collect(Collectors.joining(","));
        Map<GenderEnum, List<Student>> groupStudentByGender = students.stream().collect(Collectors.groupingBy(Student::getGender));
        long countStudent1 = students.stream().count();
        long countStudent2 = students.stream().collect(Collectors.counting());
        Optional<Student> maxByAgeStudent = students.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getAge)));
        Optional<Student> minByByAgeStudent = students.stream().collect(Collectors.minBy(Comparator.comparing(Student::getAge)));
        int totalAgeBySumming = students.stream().collect(Collectors.summingInt(Student::getAge));
        Double averageAge = students.stream().collect(Collectors.averagingInt(Student::getAge));
        IntSummaryStatistics intSummaryStatistics = students.stream().collect(Collectors.summarizingInt(Student::getAge));
        int totalAgeByReduceing = students.stream().collect(Collectors.reducing(0, Student::getAge, (i, j) -> i + j));
        Map<String, List<Student>> groupStudentAndTwo = students.stream().collect(Collectors.groupingBy(student -> {
            if (student.getAge() < 11) return "le11";
            else if (student.getAge() == 11) return "eq11";
            else return "gt11";
        }));
        Map<String, Map<GenderEnum, List<Student>>> groupByClassNameAndGender = students.stream()
                .collect(Collectors.groupingBy(Student::getClassName, Collectors.groupingBy(Student::getGender)));

        Map<String, Long> countStudentByClass = students.stream().collect(Collectors.groupingBy(Student::getClassName, Collectors.counting()));
        Map<GenderEnum, Optional<Student>> maxAgeByGender = students.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.maxBy(Comparator.comparing(Student::getAge))));
        Map<GenderEnum, Student> maxAgeByGenderTwo = students.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getAge)), Optional::get)));
    }
}
