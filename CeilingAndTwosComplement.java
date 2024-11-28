import java.util.Scanner;
public class CeilingAndTwosComplement {

    public static int ceiling(double x) {
        int intPart = (int) x;
        if (x > intPart) {
            return intPart + 1; 
        }
        return intPart;
    }

    public static String twosComplement(int y) {
        if (y >= 0) {
            return String.format("%32s", Integer.toBinaryString(y)).replace(' ', '0');
        } else {
            y = -y;
            String binary = Integer.toBinaryString(y); 
            StringBuilder onesComplement = new StringBuilder();

            for (int i = 0; i < binary.length(); i++) {
                onesComplement.append(binary.charAt(i) == '0' ? '1' : '0');
            }

            int twosComp = Integer.parseInt(onesComplement.toString(), 2) + 1;
            return Integer.toBinaryString(twosComp);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a double value x: ");
        double x = sc.nextDouble();

        int y = ceiling(x);
        System.out.println("Ceiling of x is: " + y);

        String twosComp = twosComplement(y);
        System.out.println("2's complement of y is: " + twosComp);
    }
}
