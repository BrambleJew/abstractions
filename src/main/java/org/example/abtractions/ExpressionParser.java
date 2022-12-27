package org.example.abtractions;

import lombok.NonNull;

import java.util.List;

public interface ExpressionParser {
    @NonNull List<String> split(@NonNull String s);
    @NonNull Expression parse(@NonNull String s);


}

