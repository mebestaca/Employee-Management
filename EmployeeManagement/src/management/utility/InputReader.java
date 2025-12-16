package management.utility;

import java.util.Scanner;

import management.exception.InvalidInputException;
import management.interfaces.Rule;

public class InputReader {
	private static final Scanner scanner = new Scanner(System.in);
	
	
	@SafeVarargs
	public static int readInt(String prompt, Rule<String>... rules) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
            	Validator.validate(input, rules);
                return Integer.parseInt(input);
            } catch (InvalidInputException e) {
                System.err.println(e.getMessage());
            } 
        }
    }

    
	@SafeVarargs
	public static String readString(String prompt, Rule<String>... rules) {
    	while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
            	Validator.validate(input, rules);
                return input;
            } catch (InvalidInputException e) {
                System.err.println(e.getMessage());
            } 
        }
    }
}
