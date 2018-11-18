# Java-X-Snippets

## filter

``` java
List<Student> ageEq14 = students.stream().filter(t->t.getAge() == 14).collect(Collectors.toList());
```

## map

```java
List<String> classNames = students.stream().map(Student::getClassName).collect(Collectors.toList());

List<Integer> nameLength = students.stream().map(Student::getClassName).map(String::length).collect(Collectors.toList());
```

## distinct

```java
List<String> distinctClassNames = students.stream().map(Student::getClassName).distinct().collect(Collectors.toList());
```

## limit

```java
List<String> limit3StudentName = students.stream().map(Student::getName).limit(3).collect(Collectors.toList());
```

## sorted

```java
List<Student> sortStudent = students.stream().sorted(Comparator.comparing(Student::getSort)).collect(Collectors.toList());
```

## reversed

```java
List<Student> sortStudent = students.stream().sorted(Comparator.comparing(Student::getSort)).collect(Collectors.toList());
```

## skip

```java
List<Student> goodStudent = students.stream().filter(t -> t.getAge() > 10).skip(2).collect(Collectors.toList());
```

## flatMap

```java
List<String> words = Arrays.asList("oneone", "twotwo", "threethree", "four", "five");

List<String> distinctWord = words.stream().map(s->s.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
```

## anyMatch

```java
boolean hasGoodStudent = students.stream().anyMatch(Student::isGoodStudent);
```

## noneMatch

```java
boolean noneMatchAgeEq14 = students.stream().noneMatch(t -> t.getAge() == 14);
```

## allMatch

```java
boolean allMatchGoodStudent = students.stream().allMatch(Student::isGoodStudent);
```

## findAny

```java
Optional<Student> findAnyOfMaleStudent = students.stream().filter(t -> t.getGender() == GenderEnum.MALE).findAny();
```

## findFirst

```java
students.stream().filter(t -> t.getGender(==GenderEnum.MALE).findFirst().ifPresent(d -> System.out.println(d.getName()));
```

## reduce

```java
int totalAge = students.stream().mapToInt(Student::getAge).reduce(0, (a, b) -> a + b);

int totalAgeWithSum = students.stream().mapToInt(Student::getAge).reduce(0, Integer::sum);

Optional<Integer> totalAgeNoValue = students.stream().map(Student::getAge).reduce((a, b) -> a + b);

Optional<Integer> maxAge = students.stream().map(Student::getAge).reduce(Integer::max);

Optional<Integer> minAge = students.stream().map(Student::getAge).reduce(Integer::min);
```

## max

```java
Optional<Student> maxAgeStudent = students.stream().max(Comparator.comparing(Student::getAge));
```

## maxBy

```java
Optional<Student> maxByAgeStudent = students.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getAge)));
```

## min

```java
Optional<Student> minAgeStudent = students.stream().min(Comparator.comparing(Student::getAge));
```

## minBy

```java
Optional<Student> minByByAgeStudent = students.stream().collect(Collectors.minBy(Comparator.comparing(Student::getAge)));
```

## joining

```java
String studentName = students.stream().sorted(Comparator.comparing(Student::getSort)).map(Student::getName).collect(Collectors.joining(","));
```

## collect

```java
Set<Student> setOfStudent = students.stream().sorted(Comparator.comparing(Student::getSort)).collect(Collectors.toSet());

List<Student> listOfStudent = students.stream().sorted(Comparator.comparing(Student::getSort)).collect(Collectors.toList());
```

## toMap

```java
Map<String, Student> mapOfStudent = students.stream().sorted(Comparator.comparing(Student::getSort)).collect(Collectors.toMap(Student::getName, Function.identity()));

Map<String, Student> mapOfStudent = students.stream().sorted(Comparator.comparing(Student::getSort)).collect(Collectors.toMap(Student::getName, Function.identity(), (k1, k2) -> k1));

Map<String, String> mapString = students.stream().collect(Collectors.toMap(Student::getId, Student::getName));

Map<String, String> sortMap = students.stream().sorted(Comparator.comparing(Student::getSort)).collect(Collectors.toMap(Student::getId, Student::getName, (k1, k2) -> k1, LinkedHashMap::new));

Map<String, Object> nameMapOfSort = mapOfStudent.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> newValue, LinkedHashMap::new));

 Map<String, Long> countStudentByClass = students.stream().collect(Collectors.groupingBy(Student::getClassName, Collectors.counting()));

Map<GenderEnum, Optional<Student>> maxAgeByGender = students.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.maxBy(Comparator.comparing(Student::getAge))));
```

## computeIfAbsent

```java
Map<String, List<Student>> map = new HashMap<>();
for (Student s : students) {
    map.computeIfAbsent(s.getClassName(), t -> new ArrayList<>()).add(s);
}
```

## groupingBy

```java
Map<GenderEnum, List<Student>> groupStudentByGender = students.stream().collect(Collectors.groupingBy(Student::getGender));

 Map<String, List<Student>> groupStudentAndTwo = students.stream().collect(Collectors.groupingBy(student -> {
            if (student.getAge() < 11) return "le11";
            else if (student.getAge() == 11) return "eq11";
            else return "gt11";
}));

Map<String, Map<GenderEnum, List<Student>>> groupByClassNameAndGender = students.stream()
                .collect(Collectors.groupingBy(Student::getClassName, Collectors.groupingBy(Student::getGender)));
```

## count

```java
long countStudent1 = students.stream().count();

long countStudent2 = students.stream().collect(Collectors.counting());
```

## summingInt

```java
int totalAgeBySumming = students.stream().collect(Collectors.summingInt(Student::getAge));
```

## averagingInt

```java
Double averageAge = students.stream().collect(Collectors.averagingInt(Student::getAge));
```

## summarizingInt

```java
IntSummaryStatistics intSummaryStatistics = students.stream().collect(Collectors.summarizingInt(Student::getAge));
```

## reducing

```java
int totalAgeByReduceing = students.stream().collect(Collectors.reducing(0, Student::getAge, (i, j) -> i + j));
```

## collectingAndThen

```java
Map<GenderEnum, Student> maxAgeByGenderTwo = students.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getAge)), Optional::get)));

```