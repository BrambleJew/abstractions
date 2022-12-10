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
        var ops = new ArrayList<Operation>();
        var calculator = new Calculator("Top404");
        log.info("Colculator= {}", calculator);
        var scanner = new Scanner(System.in);
        for (; ; ) {
            log.info("Выберите операцию {}", calculator.getOperationTypes());
            var type = scanner.next();
            if (type.trim().equalsIgnoreCase("exit")) {
                break;
            }
            if (!calculator.isSupported(type)){
                log.info("Операция '{}' не поддерживается",type);
                continue;
            }
            log.info("введите число а");
            var a = scanner.nextInt();
            log.info("введите число б");
            var b = scanner.nextInt();


            var op = new Operation(a, b, type);

            calculator.setResult(op);
            log.info("operation = {}", op);
            ops.add(op);

        }
        log.info("Выполенные операции: {}", ops);

    }
}