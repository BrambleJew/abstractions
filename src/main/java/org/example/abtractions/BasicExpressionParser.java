package org.example.abtractions;

import lombok.NonNull;
import org.example.abtractions.operations.Divide;
import org.example.abtractions.operations.Minus;
import org.example.abtractions.operations.Multiply;
import org.example.abtractions.operations.Plus;

import java.util.List;

public class BasicExpressionParser implements ExpressionParser {
    private static final List<String> OPERATIONS = List.of("+", "-", "*", "/");

    @Override
    public @NonNull Expression parse(@NonNull String s) {
        for (String op : OPERATIONS) {

            var idx = s.indexOf(op);
            if (idx < 0) {
                continue;
            }
            var a = Integer.parseInt(s.substring(0, idx));
            var b = Integer.parseInt(s.substring(idx + 1));

            return switch (op){
                case "+" -> new Plus(a,b);
                case "-" -> new Minus(a,b);
                case "/" -> new Divide(a,b);
                case "*" -> new Multiply(a,b);
                default -> throw new IllegalArgumentException("Unknown operation. Cannot parse expression: %s".formatted(s));

            };

        }
        throw new IllegalArgumentException("Unknown operation. Cannot parse expression: %s".formatted(s));
    }
}

