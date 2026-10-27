package org.example;

//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;

import static org.junit.jupiter.api.Assertions.*;

class ScientificCalculatorTest {

    private ScientificCalculator calculator;

    /*
    @BeforeAll
    void setUpAll() {
    }
    */

    @BeforeEach
    void setUp() {
        // Setup: instancia o objeto antes de cada teste.
        calculator = new ScientificCalculator();
    }

    // =========================
    // Testes de operações aritméticas
    // =========================

    @Test
    @DisplayName("Validando a soma da calculadora científica")
    void testAdd() {
        double result = calculator.add(5, 2);
        assertEquals(7.0, result);
    }

    @Test
    @DisplayName("Validando a subtração da calculadora científica")
    void testSubtract() {
        // Setup: define os valores de entrada.
        double a = 12;
        double b = 5;

        // Execution: executa a subtração.
        double result = calculator.subtract(a, b);

        // Assertion: verifica o resultado esperado.
        assertEquals(7.0, result);
    }

    // =========================
    // Testes de raiz quadrada
    // =========================
    @Test
    @DisplayName("Validando a raiz quadrada de um número positivo da calculadora científica")
    void testSquareRoot() {
        double result = calculator.squareRoot(9);
        assertEquals(3.0, result);
    }

    // =========================
    // Testes inválidos ou de exceção de erros
    // =========================
    @Test
    @DisplayName("Validando a raiz quadrada de um número negativo da calculadora científica")
    void testSquareRootNegative() {
        double result = calculator.squareRoot(-9);
        assertEquals(3.0, result);
    }

    @Test
    @DisplayName("Validando se o método squareRoot lança uma exceção apropriada ao receber um número negativo")
    void testSquareRootNegative_Exception() {
        // Verifica se a exceção lançada é do tipo IllegalArgumentException
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.squareRoot(-9)
        );

        // Verifica se a mensagem da exceção está correta
        assertEquals("Negative number", exception.getMessage());
    }

    @Test
    @DisplayName("Validando a divisão por zero da calculadora científica")
    void testDivideByZero() {
        double result = calculator.divide(12, 0);
        assertEquals(0.0, result);
    }

    @Test
    @DisplayName("Validando se o método divide lança uma exceção apropriada ao receber uma divisão por zero")
    void testDivideByZero_Exception() {
        // Verifica se a exceção lançada é do tipo IllegalArgumentException
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(10, 0)
        );

        // Verifica se a mensagem da exceção está correta
        assertEquals("Division by zero", exception.getMessage());
    }

    // =========================
    // Testes de funções logarítmicas
    // =========================
    @Test
    @DisplayName("Validando o logaritmo um número positivo comum da calculadora científica")
    void testLog() {
        double result = calculator.log(70);
        assertEquals(Math.log(70), result);
    }

    // =========================
    // Testes de funções trigonométricas
    // =========================
    @Test
    @DisplayName("Validando o seno um número positivo comum da calculadora científica")
    void testSin() {
        double result = calculator.sin(70);
        assertEquals(Math.sin(Math.toRadians(70)), result);
    }

    @AfterEach
    void tearDown() {
        // Teardown: libera a referência após o teste, se necessário.
        calculator = null;
    }

    /*
    @BeforeAll
    void tearDownAll() {
    }
    */
}
