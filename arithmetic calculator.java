import java.util.Scanner;

public class Main{
    public static void main((String[] args) {

        Scanner sc=new Scanner(System.in);
        Calculator cal=new Calculator();
        char choice;

        do{
            system.out.println(s:"Enter 1st number");
            int n1=sc.nextInt();
            system.out.println(s:"Enter 2nd number");
            int n2=sc.nextInt();
            system.out.println(s:"Enter operation (+, -, *, /)");
            char op=sc.next().charAt(index:0);

            switch (op){
                case '+':
                    system.out.println(s:"Result: " + cal.add(n1, n2));
                    break;
                case '-':
                    system.out.println(s:"Result: " + cal.subtract(n1, n2));
                    break;
                case '*':
                    system.out.println(s:"Result: " + cal.multiply(n1, n2));
                    break;
                case '/':
                    system.out.println(s:"Result: " + cal.divide(n1, n2));
                    break;
                case '%':
                    system.out.println(s:"Result: " + cal.modulus(n1, n2));
                    break;
                default:
                    system.out.println(x:"Invalid operation");
            }
            system.out.println(s:"Do you want to continue (y/n):");
            choice=sc.next().charAt(index:0);
        }while (choice=='y' || choice=='Y');
        sc.close();
        ststem.out.println(x:"Program ended.");
    }
}