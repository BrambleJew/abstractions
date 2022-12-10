package org.example.abtractions;

import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

//todo реализовать
@Slf4j
@Data
public class Calculator {
    private static final Set<String> OPERATION_TYPES = Set.of("+","-","*","/");

    private final @NonNull String model;

    public void setResult(@NonNull Operation op) {

        var result = switch (op.getType()) {
            case "+" -> op.getA() + op.getB();
            case "-" -> op.getA() - op.getB();
            case "/" -> op.getA() / op.getB();
            case "*" -> op.getA() * op.getB();
            default -> throw new IllegalArgumentException("unknown operation type = %s".formatted(op.getType()));
        };
        log.info("Ответ: {}", result);
        op.setResult(result);
    }
    public boolean isSupported(String type){
        return OPERATION_TYPES.contains(type);
    }
    public Set<String> getOperationTypes(){
        return OPERATION_TYPES;
    }
}
