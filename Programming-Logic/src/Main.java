import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        int n;


        System.out.println("Hello, my program have two algorithms! Choose 0 to DIVISIBLE or 1 to SUM");
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();

        if (n == 0) {

            Divisible divisible = new Divisible();
            divisible.letsDivide();

        }
        if (n == 1) {

            Sum sum = new Sum();
            sum.letsSum();
        }

    }

}

