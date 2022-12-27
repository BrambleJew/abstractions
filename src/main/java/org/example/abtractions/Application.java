package org.example.abtractions;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Scanner;

//модификатор_доступа(public, private, package)
// возвращаемое_значение(void Если метод помечен как void, он может ничего не возвращать. Такой метод просто выполняет набор действий и все.)
// имяМетода(принимаемыеПараметры)
// Тело метода
@Slf4j

public class Application {
    public static void main(String[] args) {
        var filepath = args[0];
        var parser = new BasicExpressionParser();
        String task;
        try {
            task = getTask(filepath);
        } catch (IOException e) {
            log.error("Не могу прочитать файл с выражением", e);
            return;
        }
        var splitted = parser.split(task);
        log.info("{}",splitted);
        var expression = parser.parse(task);
        var result = expression.getResult();
        log.info("   ={}", result);
        try {
            appendResult(result, filepath);
        } catch (IOException e) {
            log.error("Не могу записать результат в файл", e);

        }
    }

    private static void appendResult(int result, String filepath) throws IOException {
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(filepath, true));
        ) {
            bw.newLine();
            bw.write(String.valueOf(result));
        }
    }

    private static String getTask(String filepath) throws IOException {
        try (var stream = Files.lines(Path.of(filepath))) {
            return stream.reduce((first, second) -> second).orElseThrow();
        }
    }
}



