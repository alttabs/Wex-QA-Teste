import java.util.Scanner;

public class Divisible {

    public Divisible() {

    }

    public void letsDivide() {
        int n;

        Scanner scan = new Scanner(System.in);
        System.out.println("Please, enter a number");

        n = scan.nextInt();
        String s = Integer.toString(n);

        if (n % 3 == 0) {
            System.out.print("Cira");
        }
        if (s.contains("5")) {
            System.out.print("Dinha");
        } else {
            System.out.print("Not divisible \n");
        }
    }
}
