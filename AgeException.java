import java.util.Scanner;
class AgeException{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your age:");
        int Age=sc.nextInt();
        if(Age>18){
            System.out.println("Elligible to vote.");
        }
        else{
            System.out.println("Not egilible to vote.");
        }
    }
}