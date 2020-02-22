import java.util.Scanner;

public class Divisible {

    public Divisible() {

    }

    public void letsDivide() {
        int n;

        Scanner scan = new Scanner(System.in);
        System.out.println("Please, enter a number");

        n = scan.nextInt();

        if (n % 3 == 0) {
            System.out.print("Cira");
        }
        if (n % 5 == 0) {
            System.out.print("Dinha");
        }
    }
}
