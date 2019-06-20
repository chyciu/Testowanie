import java.util.Scanner;

public class WeightCounter {

    double age, height, mass;
    boolean on;

    public WeightCounter() {
        this.age = age;
        this.height = height;
        this.mass = mass;
        this.on = on;

    }


    public void sleep () {

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

    }


     public void bmiFactor () {

             double bmi = mass / Math.pow(height, 2);
             System.out.println("Your BMI factor is: " + bmi + ".");

     }


    public static void main(String[] args) {

        WeightCounter weightCounter = new WeightCounter();

        weightCounter.sleep();
        weightCounter.feed();
        weightCounter.bmiFactor();

    }
}
