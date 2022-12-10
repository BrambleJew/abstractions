package org.example.abtractions;

import lombok.NonNull;

import java.util.List;

public interface ExpressionParser {
    @NonNull Expression parse(@NonNull String s);


}
