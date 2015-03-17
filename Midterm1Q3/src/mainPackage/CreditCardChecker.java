package mainPackage;

import java.util.Scanner;

public class CreditCardChecker {


	public static boolean validateCard() {
		Scanner in = new Scanner(System.in);

		System.out.print("Please enter your 16-digit credit card number: ");
		String creditCard = in.nextLine();
		String[] cardNum = creditCard.split(""); // turns the given string into an array of Strings

		in.close(); // close the scanner
		
		int sum1 = 0, grandTotal = 0;
		
		//iterates through every other number, starting from the right
		for( int i = cardNum.length-2; i >= 0; i -= 2) { 
			int nbr =  Integer.parseInt(cardNum[i]);
			
			
			if (nbr < 5) {
				sum1 += nbr*2; 
			}
			
			else {
				sum1 += ((nbr*2) % 10) + 1;	
				} // if nbr >= 5, then nbr*2 would be greater than 9, so we must sum up the digits
			
			
		}
		
		for( int i = cardNum.length-3; i > -1; i -= 2) {
			grandTotal += Integer.parseInt(cardNum[i]);
		}
		
		grandTotal += sum1;

		if(grandTotal % 10 == 0){ 
			System.out.println("The credit card number you entered is valid");
			return true;
		}
		else {
			System.out.println("Sorry, the credit card number you entered is invalid");
			return false;
		}
		
	}
	
}
