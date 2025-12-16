package management.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import management.exception.InvalidInputException;
import management.interfaces.Rule;

public class RuleFactory {
	private RuleFactory() {}
	
    public static Rule<String> notEmpty(String field) {
        return value -> {
            if (value == null || value.trim().isEmpty())
                throw new InvalidInputException("Error: " + field + " cannot be empty.");
        };
    }
    
    public static Rule<String> lengthCheck(String field, int min, int max) {
        return value -> {
            if (value.length() < min)
                throw new InvalidInputException("Error: " + field + " must be at least " + min + " characters long.");
            if (value.length() > max)
                throw new InvalidInputException("Error: " + field + " cannot exceed " + max + " characters long.");
        };
    }

    public static Rule<String> isInt(String field) {
        return value -> {
            try {
                Integer.parseInt(value.trim());
            } catch (NumberFormatException e) {
                throw new InvalidInputException("Error: " + field + " must be an integer.");
            }
        };
    }
    
    public static Rule<String> isLong(String field) {
        return value -> {
            try {
                Long.parseLong(value.trim());
            } catch (NumberFormatException e) {
                throw new InvalidInputException("Error: " + field + " must be a long.");
            }
        };
    }

    public static Rule<String> inRange(int min, int max, String field) {
        return value -> {
            try {
                int n = Integer.parseInt(value.trim());
                if (n < min || n > max)
                    throw new InvalidInputException("Error: " + field + " must be between " + min + " and " + max);
            } catch (NumberFormatException e) {
                throw new InvalidInputException("Error: " + field + " must be an integer.");
            }
        };
    }
    
    public static Rule<String> isDate(String field, String pattern) {
    	return value -> {
    	    SimpleDateFormat format = new SimpleDateFormat(pattern);
    		format.setLenient(false); 
    		try {
    			format.parse(value.trim());
    		} catch (ParseException e) {
    			throw new InvalidInputException("Error: " + field + " must be a valid date in format " + pattern);
    		}
    	};
    }
    
    public static Rule<String> isEmail(String field) {
    	return value -> {
        
	        String emailRegex = "^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$";
	        Pattern pattern = Pattern.compile(emailRegex);
	        
	        if (!pattern.matcher(value).matches())
	        	throw new InvalidInputException("Error: " + field + " must be a valid email.");
    	};
    }
    
    public static Rule<String> responseYN(String field) {
    	 return value -> {
             if (value.trim().toLowerCase().equals("n") || value.trim().toLowerCase().equals("y"))
            	 return;
             else
                 throw new InvalidInputException("Error: " + field + " can only be Y or N.");
         };
    }
}
