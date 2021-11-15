/**
 *
 * @author Jim Walton jw0018326@otc.edu
 */

package computecdvalue;

import java.util.Scanner;

public class ComputeCDValue {
    public static void main(String[] args) {
        
        // Create Scanner
        Scanner input = new Scanner(System.in);

        // User input
        System.out.print("Enter the amount of initial deposit: ");
        double amount = input.nextDouble();
        
        System.out.print("Enter the Annual Percentage Yield: ");
        double percentageYield = input.nextDouble();

        System.out.print("Enter maturity period in months: ");
        int months = input.nextInt();

        // Display header labels
        System.out.println("Month  CD Value");

        // Calculate and show CD worth for the number of months
        for (int m = 1; m<= months; m++) {
            amount += amount * (percentageYield / 1200);
            System.out.printf("-7d%.2f\n", m, amount);
        }

    }   
    
}