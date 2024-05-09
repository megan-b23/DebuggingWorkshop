
import java.util.Scanner;

public class BugNum {
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
 * Test Inputs: 
 *    2 + 4 = 6
 *    10 / 5 = 2
 *    3.14 + 2 = 5.14
 *    5 / 3 = 1.67
 *    4 - 1 = 3
 *    2 * 8 = 16
 *    2 + 10 = 12, then select N to exit the program
 */
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int opt;   
        int op1, op2;    
        String eq;
        String input = " ";
        boolean running = true;

        System.out.println("\nDisplay an Equation");

        while(running = true) {
            System.out.print("\nEnter first operand: ");
            op1 = scan.nextInt();

            System.out.println("\nEnter number of desired operation: ");
            System.out.println("1) Add /n2) Subtract \n3) Multiply \n4) Divide ");
            opt = scan.nextInt();

            System.out.print("\nEnter second operand: ");
            op2 = scan.nextInt();

            eq = equation(op1, op2, opt);

            System.out.print("\nEquation: " + eq);

            System.out.println("\nWould you like to print another equation? [Y/N]");
            input = scan.next();
            if(input.equalsIgnoreCase("N")) {
                running = false;                
            } 
        } 
        System.out.println("\nGoodbye\n");
        
    }

    static String equation(int op1, int opt, int op2) {
        String opr;
        String eq;
        int result;

        switch(opt) {
            case 1:
                opr = "+";
                result = op1 + op2;
                break;
            case 2:
                opr = "-";
                result = op1 - op2;

            case 3:
                opr = "*";
                result = op1 * op2;
                
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

        eq = String.format("%d %s %d = %d\n", op1, opr, op2, result);
        return eq;
    }
}


/* Hint 1:
 *  - User cannot input decimals */
/* Hint 2:
 *  - Divide operand doesn't give decimal results */
/* Hint 3:
 *  - Cannot exit program  */
/* Hint 4:
 *  - Does not output correct operand for subtract and multiply; outputs division instead  */
/* Hint 5:
 *  - The equation method is reading the operator and operands out of order */