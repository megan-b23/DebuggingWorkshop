
import java.util.Scanner;

public class Num {
/********************************************************************
    Program should:
        - Take in any two numbers (op1, op2)
        - Have user select an operand (opr) ( + - * / )
        - Calculate the result as: op1 opr op2 = result
        - Print the equation with the result
        - Ask the user if they would like to print another equation
        - Continue loop if yes, end program if no

*********************************************************************/
/*
 * Bugs: 
 *  - User cannot input decimals (variables are declared as int instead of double)
 *  - Divide operand doesn't give decimal results (result is declared as an int instead of a double)
 *  - Cannot exit program (while loop has =true instead of ==true)
 *  - Does not output correct operand for subtract and multiply; outputs division instead (break statements for sub and mult are missing)
 *  - The equation method is reading the operator and operands out of order ((op1, op2, opt) instead of (op1, opt, op2))
 */
/*
 * Test Inputs:
 *    2 + 4 = 6
 *    10 / 5 = 2
 *    3.14 + 2 = 5.14
 *    5 / 3 = 1.67
 *    2 + 10 = 12, then select N to exit the program
 *    4 - 1 = 3
 *    2 * 8 = 16
 */
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int opt;
        double op1, op2; // made this an int (test 5/3)
        String eq;
        String input = " ";
        boolean running = true;

        System.out.println("\nDisplay an Equation");

        while(running == true) {  // make this '=' instead of '=='
            System.out.print("\nEnter first operand: ");
            op1 = scan.nextDouble();

            System.out.println("\nEnter number of desired operation: ");
            System.out.println("1) Add \n2) Subtract \n3) Multiply \n4) Divide ");
            opt = scan.nextInt();

            System.out.print("\nEnter second operand: ");
            op2 = scan.nextDouble();

            eq = equation(op1, opt, op2); // switched to (op1, op2, opt)

            System.out.print("\nEquation: " + eq);
            
            System.out.println("\nWould you like to print another equation? [Y/N]");
            input = scan.next();
            if(input.equalsIgnoreCase("N")) {
                running = false;
            } 
        }
        System.out.println("\nGoodbye\n");
        scan.close(); 
    }

    static String equation(double op1, int opt, double op2) { // changed doubles to ints
        String opr;
        String eq;
        double result; // changed to int

        switch(opt) { // break statements are missing
            case 1:
                opr = "+";
                result = op1 + op2;
                break;
            case 2:
                opr = "-";
                result = op1 - op2;
                break;
            case 3:
                opr = "*";
                result = op1 * op2;
                break;
            case 4:
                opr = "/";
                if(op2 == 0) {
                    return "Cannot divide by zero.";
                } else {
                    result = op1 / op2;
                }
                break;
            default:
                return "Please enter a number 1-4";
        }

        eq = String.format("%.2f %s %.2f = %.2f\n", op1, opr, op2, result); // change %.2f -> %.2d to match the ints
        return eq;
    }
}