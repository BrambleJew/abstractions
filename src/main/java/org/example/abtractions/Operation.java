package org.example.abtractions;

import lombok.NonNull;

import java.util.Objects;

//@Data
public class Operation {
    private final int a;
    private final int b;
    private final @NonNull String type;
    private Integer result;

    public Operation(int a, int b, @NonNull String type) {
        this(a, b, type, null);
    }

    public Operation(int a, int b, @NonNull String type, Integer result) {
        this.a = a;
        this.b = b;
        this.type = type;
        this.result = result;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public String getType() {
        return type;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return a == operation.a && b == operation.b && type.equals(operation.type) && Objects.equals(result, operation.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, type, result);
    }

    @Override
    public String toString() {
        return "{" +
                "a=" + a +
                ", b=" + b +
                ", type='" + type + '\'' +
                ", result=" + result +
                '}';
    }
}
