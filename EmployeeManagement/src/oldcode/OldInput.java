package oldcode;

//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Scanner;
//
//import management.interfaces.Rule;
//import management.utility.InvalidInputException;
//import management.utility.Validator;

public class OldInput {
//	private static Scanner scanner = new Scanner(System.in); 
//
//	public static class MainMenu{
//
//		public static int read() {
//			int choice = -1;
//			do {
//				choice = rangeValidator(1,3,  "Enter your choice: ");
//			}
//			while(choice == -1);
//			
//			return choice;
//		}
//		
//		public static class EmployeeMenu {
//			public static int read() {
//				int choice = -1;
//				do {
//					choice = rangeValidator(1,5,  "Enter your choice: ");
//					
//				}
//				while(choice == -1);
//				
//				return choice;
//			}
//			
//			public static class Operation {
//				public static String readString(String field) {
//					String choice = null;
//					do {
//						choice = stringValidator(field);
//					}
//					while(choice == null);
//					
//					return choice;
//				}
//				
//				public static Date readDate(String field) {
//					Date choice = null;
//					do {
//						choice = dateValidator(field, "yyyy-MM-dd");
//					}
//					while(choice == null);
//					
//					return choice;
//				}
//				
//				public static String readEmail(String field) {
//					String choice = null;
//					do {
//						choice = emailValidator(field);
//					}
//					while(choice == null);
//					
//					return choice;
//				}
//				
//				public static long readPhoneNumber(String field) {
//					long choice = -1;
//					do {
//						choice = phoneValidator(field);
//					}
//					while(choice == -1);
//					
//					return choice;
//				}
				
//				public static int readDepartment(List<Department> department) {
//					int choice = -1;
//					do {
//						choice = stringValidator(field);
//					}
//					while(choice == -1);
//					
//					return choice;
//				}
//			}
//		}
//		
//		public static class DepartmentMenu {
//			public static int read() {
//				int choice = -1;
//				do {
//					choice = rangeValidator(1,5,  "Enter your choice: ");
//				}
//				while(choice == -1);
//				
//				return choice;
//			}
//		}
//	}
	
//	private static int rangeValidator(int start, int end, String prompt) {
//		try {
//			System.out.print(prompt);
//			String input = scanner.nextLine();
//			
//			Validator.validate(input, i -> i != null, "Error: Choice cannot be null.");
//			Validator.validate(input.trim(), i -> !i.isEmpty(), "Error: Choice cannot be empty.");
//			Validator.validate(input, Rule.isInt(), "Error: Choice must be an integer.");
//			
//			int parsed = Integer.parseInt(input);
//			Validator.validate(parsed, c -> c>=start && c<=end, "Error: Choice must be between 1 and 2");
//			
//			return parsed;
//			
//		}
//		catch(InvalidInputException e) {
//			System.err.println(e.getMessage());
//		}
//		
//		return -1;
//	}
	
//	private static String stringValidator(String field) {
//		try {
//			String input = scanner.nextLine();
//			
//			Validator.validate(input, i -> i != null, "Error: " + field + " cannot be null.");
//			Validator.validate(input.trim(), i -> !i.isEmpty(), "Error: " + field + " cannot be empty.");
//			Validator.validate(input.trim(), i -> i.length() > 3, "Error: " + field + " must be longer than 3 characters.");
//			Validator.validate(input.trim(), i -> i.length() < 100, "Error: " + field + " cannot be longer than 100 characters.");
//
//			return input;
//			
//		}
//		catch(InvalidInputException e) {
//			System.err.println(e.getMessage());
//		}
//		
//		return null;
//	}
//	
//	private static String emailValidator(String field) {
//		try {
//			String input = scanner.nextLine();
//			
//			Validator.validate(input, i -> i != null, "Error: " + field + " cannot be null.");
//			Validator.validate(input.trim(), i -> !i.isEmpty(), "Error: " + field + " cannot be empty.");
//			Validator.validate(input.trim(), Rule.isEmail(), "Error: invalid email format");
//
//			return input;
//			
//		}
//		catch(InvalidInputException e) {
//			System.err.println(e.getMessage());
//		}
//		
//		return null;
//	}
//	
//	private static Date dateValidator(String field, String pattern) {
//		try {
//			String input = scanner.nextLine();
//			
//			Validator.validate(input, i -> i != null, "Error: " + field + " cannot be null.");
//			Validator.validate(input.trim(), i -> !i.isEmpty(), "Error: " + field + " cannot be empty.");
//			Validator.validate(input, Rule.isDate(pattern), "Error: invalid date format.");
//			
//			SimpleDateFormat format = new SimpleDateFormat(pattern);
//			format.setLenient(false); 
//			Date parsed = null;
//			try {
//				parsed = format.parse(input);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//			return parsed;
//			
//		}
//		catch(InvalidInputException e) {
//			System.err.println(e.getMessage());
//		}
//		
//		return null;
//	}
//	
//	private static long phoneValidator(String field) {
//		try {
//			String input = scanner.nextLine();
//			
//			Validator.validate(input, i -> i != null, "Error: " + field + " cannot be null.");
//			Validator.validate(input.trim(), i -> !i.isEmpty(), "Error: " + field + " cannot be empty.");
//			Validator.validate(input.trim(), i -> i.length() == 10, "Error: " + field +" must be 10 characters long.");
//			Validator.validate(input, Rule.isLong(), "Error: invalid format");
//			long parsed = Long.parseLong(input);
//
//			return parsed;
//			
//		}
//		catch(InvalidInputException e) {
//			System.err.println(e.getMessage());
//		}
//		
//		return -1;
//	}
	
//	private static int listValidator(List<Department> departments, String field) {
//		try {
//			String input = scanner.nextLine();
//			Validator.validate(input, i -> i != null, "Error: " + field + " cannot be null.");
//			
//			
//		}
//		catch(InvalidInputException e) {
//			System.err.println(e.getMessage());
//		}
//		return -1;
//	}
}
