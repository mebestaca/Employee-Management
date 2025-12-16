package management.interfaces;

import management.exception.InvalidInputException;

public interface Rule<T> {
	void check(T value) throws InvalidInputException;
}
