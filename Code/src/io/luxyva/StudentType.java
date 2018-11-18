package io.luxyva;

public enum StudentType {

    EXCELLENT(1, "优秀"),
    GOOD(2, "良好"),
    PASS(3, "及格"),
    FAIL(4, "不及格");

    private Integer code;

    private String name;

    StudentType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
