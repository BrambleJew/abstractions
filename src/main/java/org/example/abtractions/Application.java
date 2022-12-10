package org.example.abtractions;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Scanner;

//модификатор_доступа(public, private, package)
// возвращаемое_значение(void Если метод помечен как void, он может ничего не возвращать. Такой метод просто выполняет набор действий и все.)
// имяМетода(принимаемыеПараметры)
// Тело метода
@Slf4j

public class Application {
    public static void main(String[] args) {
        var parser = new BasicExpressionParser();
        var scanner = new Scanner(System.in);
        for (; ; ) {
            log.info("Вводите");
            var s = scanner.next();
            if (s.trim().equalsIgnoreCase("exit")) {
                break;
            }
            var expression = parser.parse(s);
            var result = expression.getResult();
            log.info("{}",result);
        }
    }
}