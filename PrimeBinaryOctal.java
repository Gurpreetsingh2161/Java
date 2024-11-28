import java.util.Scanner;

public class PrimeBinaryOctal {

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String toBinary(int n) {
        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            binary.append(n % 2);
            n = n / 2;
        }
        return binary.reverse().toString();
    }

    public static String toOctal(int n) {
        StringBuilder octal = new StringBuilder();
        while (n > 0) {
            octal.append(n % 8); 
            n = n / 8;
        }
        return octal.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = sc.nextInt();

        if (isPrime(number)) {
            System.out.println("The number is prime.");
            System.out.println("Binary representation: " + toBinary(number));
        } else {
            System.out.println("The number is not prime.");
            System.out.println("Octal representation: " + toOctal(number));
        }
    }
}
