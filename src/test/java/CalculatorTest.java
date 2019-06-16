import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.data.Offset;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {

    @Test
    public void sum_a2b5_7 () {

        double expected =7;
        double actual = Calculator.sum(2,5);
        Assert.assertEquals(expected, actual, 0.001);

    }

    @Test
    public void sum_a5b6_11 () {

        int expected = 11;
        int actual = Calculator.sum(5, 6);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sum_a0_2b0_1_expected0_3 () {

        double expected = 0.3;
        double actual = Calculator.sum(0.2, 0.1);
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void substraction_a10_02b8_02_expected2_00 () {

        double expected = 2.00;
        double actual = Calculator.substraction(10.02, 8.02);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void multiply_a3b4_12 () {

        double expected = 12;
        double acrtual = Calculator.multiply(3, 4);
        Assert.assertEquals(expected, acrtual, 0.1);

    }

    @Test
    public void divide_a12b2_6 () {

        double expected = 6;
        double actual = Calculator.divide(12, 2);
        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void divide_a10b0_IllegalArgumentException () {
        try {

            Calculator.divide(10,0);

        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
            return;
        }
        Assert.fail();
    }

    @Test (expected = IllegalArgumentException.class)
    public void divide_a10b0_IllegalArgumentExeptionExpected () {

        Calculator.divide(10, 0);
    }


    @Rule
    public ExpectedException rule = ExpectedException.none();

    @Test
    public void divide_a10b0_IllegalArgumentExeptionRule () {

        rule.expect(IllegalArgumentException.class);
        Calculator.divide(10, 0);
    }

    @Test
    public void log_a2x4_2 () {

        double expected = 2;
        double actual = Calculator.log(2, 4);
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test (expected = IllegalArgumentException.class)
    public void log_a0x4_IllegalArgumentExeptionExpected () {

        Calculator.log(0,4);
    }

    @Test
    public void log_a_1x4_IllegalArgumentExeptionRule () {

        rule.expect(IllegalArgumentException.class);
        Calculator.log(-1, 4);

    }

    @Test (expected = IllegalArgumentException.class)
    public void log_a2x0_IllegalArgumentExeptionExpected () {

        Calculator.log(2,0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void log_a1x10_IllegalArgumentExeptionExpected () {

        Calculator.log(1,10);
    }

    @Test
    public void log_a_3x10_IllegalArgumentExeptionMessageBaseOfLogarithmShouldBeGraterThan0 () {

        assertThatThrownBy( ()->{
            Calculator.log(-3, 10 );
        } ).hasMessage("Podstawa log musi być większa od zera");
    }

    @Test
    public void log_a2x_4_IllegalArgumentExeptionMessageLogarithmNumberShouldBeGraterThan0 () {

        assertThatThrownBy( ()->{
            Calculator.log(2, -4 );
        } ).hasMessage("Liczba logarytmowana musi być większa od zera");
    }

    @Test
    public void log_a1x4_IllegalArgumentExeptionMessageBaseOfLogarithmShouldNotBeOne () {

        assertThatThrownBy( ()-> {
            Calculator.log(1, 4);
        }).hasMessage("Podstawa logarytmu musi być różna od jeden");
    }

    @Test
    public void logx_a2x4_2 () {

        double expected = 2;
        double actual = Calculator.log(2,4);

        assertThat(expected).isEqualTo(actual, Offset.strictOffset(0.01));
    }

    @Test
    public void sum_a4b4_8 () {

        double expected = 8;
        double actual = Calculator.sum(4, 4);

        assertThat(expected).isEqualTo(actual, Offset.strictOffset(0.01));
    }

    @Test
    public void divide_a10b5_2 () {
        double expected = 2;
        double actual = Calculator.divide(10, 5);

        assertThat(expected).isEqualTo(actual, Offset.strictOffset(0.01));
    }


    @Test
    @Parameters ({"1,2,3","23,17,40"})
    public void sum_parametrized (double a, double b, double expected) {

        double actual = Calculator.sum(a,b);
        assertThat(expected).isEqualTo(actual, Offset.strictOffset(0.01));
    }

    @Test
    @Parameters( {"10, 3, 7", "12, 2, 10"})
    public void substruction_parametrized (double a, double b, double expected) {

        double actual = Calculator.substraction(a, b);
        assertThat (expected).isEqualTo(actual, Offset.strictOffset(0.01));
    }

    @Test
    @Parameters ( {"12,4,3", "20,5,4"})
    public void divide_parameters (double a, double b, double expected) {

        double actual = Calculator.divide(a,b);
        assertThat(expected).isEqualTo(actual, Offset.strictOffset(0.01));
    }

    @Test
    @Parameters ( {"0,0", "1,1", "2,1", "3,2", "4,3", "5,5", "6,8", "7,13", "8,21", "9,34", "10,55"})
    public void fibonacciNumber_parameters (int n, int expected) {

        int actual = Calculator.getFibonaciNumber(n);
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void fibonaciNumber_n_1_IllegalArgumentExeptionMessageFibonacciNumberCanNotBeLessThan0 () {

        assertThatThrownBy( ()->{
            Calculator.getFibonaciNumber(-1 );
        } ).hasMessage("Liczby fibonaciego mozna obliczyć tylko z liczb dodatnich");
    }

    @Test
    @Parameters (method = "getFibonacciData")
    public void getFibonacciNumber_parametrizedByMethod (int n, int expected) {
        int actual = Calculator.getFibonaciNumber(n);
        assertThat (expected).isEqualTo(actual);
    }

    private Object [] getFibonacciData () {
        return new Object[] {
                new Object [] {0,0},
                new Object [] {1,1},
                new Object [] {2,1},
                new Object [] {3,3},
                new Object [] {4,3},
                new Object [] {5,5},
                new Object [] {6,8},
                new Object [] {7,13},
                new Object [] {8,21},
                new Object [] {9,34},
                new Object [] {10,55}
        };
    }

    @Test
    @Parameters (method = "sumData")
    public void sum_parametrizedByMethod (double a, double b, double expected) {
        double actual = Calculator.sum (a, b);
        assertThat (expected).isEqualTo(actual, Offset.strictOffset(0.01));
    }

    private Object [] sumData () {
        return new Object[] {
                new Object [] {2, 3, 5},
                new Object [] {5, 5, 10},
                new Object [] {100, 2, 102}
        };
    }

    @Test
    @Parameters (source = DiffferenceDataProvide.class)
    public void substraction_parametrizedByClass (double a, double b, double expected) {

        double actual = Calculator.substraction(a,b);
        assertThat (expected).isEqualTo(actual, Offset.strictOffset(0.01));
    }

    @Test
    @Parameters (source = MultiplyDataProvider.class)
    public void multiply_parametrizedByClass (double a, double b, double expected) {

        double actual = Calculator.multiply(a, b);
        assertThat (expected).isEqualTo(actual, Offset.strictOffset(0.01));
    }

}
