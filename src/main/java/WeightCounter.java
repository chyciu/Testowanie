import java.util.Scanner;

public class WeightCounter {

    double age, height, mass;
    boolean on;


    public void sleep (boolean on) {

        if (on == false) {
            System.out.println("WeightCounter is OFF.");
        } else
            System.out.println("WeightCounter is ON.");
    }

    public void feed () {

            Scanner scan = new Scanner(System.in);
            System.out.println("Read age: ");
            age = scan.nextDouble();
            System.out.println("Read height: ");
            height = scan.nextDouble();
            System.out.println("Read mass: ");
            mass = scan.nextDouble();
            double bmi = mass / Math.pow(height, 2);
            System.out.println("Your BMI factor is: " + bmi + ".");
    }


    public static void main(String[] args) {

        WeightCounter weightCounter = new WeightCounter();


        weightCounter.sleep(false);
        weightCounter.feed();

    }
}
