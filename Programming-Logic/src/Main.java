import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        int n;


        System.out.println("\nHello, my program have two algorithms! Choose: \n0 to DIVISIBLE\n1 to SUM");
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

        main(args);
    }

}

