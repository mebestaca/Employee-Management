package management.utility;

import management.exception.InvalidInputException;
import management.interfaces.Rule;

public class Validator {
	@SafeVarargs
	public static <T> T validate(T value, Rule<T>... rules)
            throws InvalidInputException {

        for (Rule<T> rule : rules) {
            rule.check(value);
        }
        return value;
    }
}

