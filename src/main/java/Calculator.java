/**
 * Klasa do wykonywania działań matematycznych
 */
public final class Calculator {
    /**
     * @param numberA Pierwsza liczba wchodząca w skład działania
     * @param numberB Druga liczba wchodząca w skład działania
     * @return Suma dwóch liczb
     */
    public static double sum(double numberA, double numberB){
        return numberA + numberB;
    }

    /**
     * @param numberA Pierwsza liczba wchodząca w skład działania
     * @param numberB Druga liczba wchodząca w skład działania
     * @return Różnica dwóch liczb
     */

    public static int sum (int numberA, int numberB) {
        return numberA + numberB;
    }

    public static double substraction(double numberA, double numberB){
        return numberA - numberB;
    }

    /**
     * @param multiplicand Mnożna
     * @param multiplier Mnożnik
     * @return Iloczyn dwóch liczb
     */
    public static double multiply(double multiplicand, double multiplier){
        return multiplicand * multiplier;
    }

    /**
     * @param dividend Dzielna
     * @param divider Dzielnik
     * @return Iloraz dwóch liczb
     */
    public static double divide(double dividend, double divider){
        if(divider == 0.0){
            throw new IllegalArgumentException("Ty cholero nie dziel przez 0");
        }

        return dividend / divider;
    }

    public static double log (double a, double x) {

        if (a <=0.0) {
            throw new IllegalArgumentException("Podstawa log musi być większa od zera");
        }

        if (x <=0.0) {
            throw new IllegalArgumentException("Liczba logarytmowana musi być większa od zera");
        }

        if (a == 1.0) {
            throw new IllegalArgumentException("Podstawa logarytmu musi być różna od jeden");
        }

        return Math.log(x) / Math.log(a); //logax
    }

    /**
     * @param n Identyfikator liczby fibonaciego
     * @return Liczba fibonaciego
     */
    public static int getFibonaciNumber(int n)
    {
        if(n < 0){
            throw new IllegalArgumentException("Liczby fibonaciego mozna obliczyć tylko z liczb dodatnich");
        }

        if(n <= 1)
        {
            return n;
        }

        return getFibonaciNumber(n-1) + getFibonaciNumber(n-2);
    }

    public static double powerTwo (double a) {

        return Math.pow(a, 2);
    }

    public static double powerN (double a, double power) {

        return Math.pow(a, power);
    }

    public static double squart (double base) {

        return Math.sqrt(base);
    }

    public static double rootN (double base, double n) {

        return Math.pow(base, 1/n);
    }
}
