package org.example.abtractions;

import lombok.NonNull;
import org.example.abtractions.operations.Divide;
import org.example.abtractions.operations.Minus;
import org.example.abtractions.operations.Multiply;
import org.example.abtractions.operations.Plus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ExpressionParserTest {

    @Test
    void split() {
        var s = "2+2";
        var parser = new BasicExpressionParser();
        var expected = List.of("2","+","2");
        var actual = parser.split(s);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void parse_Plus() {
        var str = "10+10";
        var parser = new BasicExpressionParser();
        var expected = new Plus(10,10);
        var actual = parser.parse(str);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void parse_Minus() {
        var str = "10-10";
        var parser = new BasicExpressionParser();
        var expected = new Minus(10,10);
        var actual = parser.parse(str);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void parse_Multiply() {
        var str = "10*10";
        var parser = new BasicExpressionParser();
        var expected = new Multiply(10,10);
        var actual = parser.parse(str);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void parse_Divide() {
        var str = "10/10";
        var parser = new BasicExpressionParser();
        var expected = new Divide(10,10);
        var actual = parser.parse(str);
        Assertions.assertEquals(expected,actual);
    }
}
