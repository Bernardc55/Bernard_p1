import java.util.*;

public class Encryption {

	public static void main(String[] args) {
		//Preparing all the variables and scanner
		String choice = "0", input, output;
		int ones, tens, hunds, thous;
		Scanner scnr = new Scanner(System.in);
		
		//loops as long as the user does not want to leave
		while(choice.compareTo("L") != 0) {
			
			//Asks the user if they would like to encrypt a number, decrypt a number or leave
			//They select these options with E, D, and L respectively
			System.out.println("Would you like to (E)ncrypt a number, (D)ecrypt a number\nor (L)eave?");
			choice = scnr.nextLine();
			
			//This choice activates if they want to encrypt a number
			if(choice.compareTo("E") == 0 || choice.compareTo("e") == 0) {
				//Prompts for and reads a 4 digit integer
				System.out.println("Input a 4 digit integer to encrypt: ");
				input = scnr.nextLine();
				
				//verifys the integer is 4 digits long, so as to not cause issues later
				if(verifyNum(input))
					continue;
				
				//sets the various variables to the respective number that the user input
				thous = Character.getNumericValue(input.charAt(0));
				hunds = Character.getNumericValue(input.charAt(1));
				tens = Character.getNumericValue(input.charAt(2));
				ones = Character.getNumericValue(input.charAt(3));
				
				//performs the encryption function on each of the numbers
				thous = (thous + 7) % 10;
				hunds = (hunds + 7) % 10;
				tens = (tens + 7) % 10;
				ones = (ones + 7) % 10;
				
				//prints the numbers in the encrypted order
				output = Integer.toString(tens) + Integer.toString(ones) + Integer.toString(thous) + Integer.toString(hunds);
			
				//outputs that encrypted number
				System.out.println("The encrypted integer is: " + output);
			}
			//This activates if the user wants to decrypt a number
			else if(choice.compareTo("D") == 0 || choice.compareTo("d") == 0) {
				//prompts and reads in a 4 digit integer to decrypt
				System.out.println("Input a 4 digit integer to decrypt: ");
				input = scnr.nextLine();
			
				//verifies that the number is 4 digits long
				if(verifyNum(input))
					continue;
				
				//sets the variables to the respective number that the user input
				thous = Character.getNumericValue(input.charAt(0));
				hunds = Character.getNumericValue(input.charAt(1));
				tens = Character.getNumericValue(input.charAt(2));
				ones = Character.getNumericValue(input.charAt(3));

				//performs the encryption function on each of the numbers
				thous = (thous + 3) % 10;
				hunds = (hunds + 3) % 10;
				tens = (tens + 3) % 10;
				ones = (ones + 3) % 10;
				
				//combines the numbers using the encryption into an output
				output = Integer.toString(tens) + Integer.toString(ones) + Integer.toString(thous) + Integer.toString(hunds);
			
				//displays the output to the user
				System.out.println("The encrypted integer is: " + output);
			}
			else if(choice.compareTo("L") != 0) {
				//this activates if the user does not input E, D, or L
				System.out.println("I don't understand the input, please try again.");
			}
		}
		scnr.close();
	}

	public static boolean verifyNum(String num) {
		if(num.length() > 4) {
			//prints that the number is too long and continues the loop from the beginning
			System.out.println("This number is too long, it must be 4 digits long.");
			return true;
		}
		else if(num.length() < 4) {
			//prints that the number is too short and continues the loop from the beginning
			System.out.println("This number is too short, it must be 4 digits long.");
			return true;
		}
		else {
			//does not print anything and continues the loop
			return false;
		}
	}


}
