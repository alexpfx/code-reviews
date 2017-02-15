package reviews.calculator_with_history;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class SolverTest {

    Solver solver;

    @Before
    public void setUp() {
        solver = new Solver();
    }

    @Test
    public void testSolveExpressionAllOperations() {
        Optional<Double> result;

        result = solver.solveExpression(buildDefaultExpressionWithOperation('+'));
        assertTrue(result.isPresent());
        assertEquals(30.0, result.get(), 0.01);

        result = solver.solveExpression(buildDefaultExpressionWithOperation('-'));
        assertEquals(10.0, result.get(), 0.01);

        result = solver.solveExpression(buildDefaultExpressionWithOperation('*'));
        assertEquals(200.0, result.get(), 0.01);

        result = solver.solveExpression(buildDefaultExpressionWithOperation('/'));
        assertEquals(2.0, result.get(), 0.01);

        result = solver.solveExpression(buildDefaultExpressionWithOperation('%'));
        assertEquals(0.0, result.get(), 0.01);

        result = solver.solveExpression(buildDefaultExpressionWithOperation('^'));
        assertEquals(10240000000000.0, result.get(), 0.01);

    }

    @Test
    public void testSolveWrongOperation() {
        Optional<Double> result = solver.solveExpression(buildDefaultExpressionWithOperation('&'));
        assertFalse(result.isPresent());
    }

    private Expression buildDefaultExpressionWithOperation(char operation) {
        return Expression.Builder.anExpression().firstNumber(20).secondNumber(10).operator(operation).build();
    }


    @After
    public void tearDown() {
        solver = null;

    }


}