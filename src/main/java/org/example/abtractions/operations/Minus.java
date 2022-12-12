package org.example.abtractions.operations;

import lombok.Data;
import org.example.abtractions.Expression;

@Data
public class Minus implements Expression {
    private final int a;
    private final int b;

    @Override
    public int getResult() {
        return a - b;
    }

}
