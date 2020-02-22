import java.util.Scanner;

public class Sum {

    public Sum() {

    }

    public void letsSum() {

        int n;
        int sum = 0;

        Scanner scan = new Scanner(System.in);
        System.out.println("Please, enter a number");

        n = scan.nextInt();

        while (n > 0) {
            sum = sum + n % 10;
            n = n / 10;
        }

        System.out.println("The sum result is: " + sum);

    }
}
