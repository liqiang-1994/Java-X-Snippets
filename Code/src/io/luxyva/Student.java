package io.luxyva;

import java.util.Objects;

public class Student {
    private String id;

    private String name;

    private String className;

    private Integer age;

    private GenderEnum gender;

    private StudentType type;

    private Integer sort;

    public Student(String id, String name, String className, Integer age, GenderEnum gender, StudentType type, Integer sort) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.age = age;
        this.gender = gender;
        this.type = type;
        this.sort = sort;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public StudentType getType() {
        return type;
    }

    public void setType(StudentType type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public boolean isGoodStudent() {
        return type == StudentType.GOOD || type == StudentType.EXCELLENT || type == StudentType.PASS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(className, student.className) &&
                Objects.equals(age, student.age) &&
                gender == student.gender &&
                type == student.type &&
                Objects.equals(sort, student.sort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, className, age, gender, type, sort);
    }
}
