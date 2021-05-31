package br.com.leandro.swplanets.domain.valueobjects;

import br.com.leandro.swplanets.domain.exceptions.DomainException;

public class Name implements Comparable<Name> {

	private String value;

	private int minSize;

	private int maxSize;

	private String validationErrorMessage;

	Name() {
	}

	public Name(String value) {
		this(value, 3, 50);
	}

	public Name(String value, int minSize, int maxSize) {
		this.minSize = minSize;
		this.maxSize = maxSize;

		if (value != null) {
			this.value = value.trim();
		}

		if (isInvalid()) {
			throw new DomainException(validationErrorMessage);
		}
	}

	public String getValue() {
		return value;
	}

	public boolean isInvalid() {
		if (value == null) {
			return true;
		}

		boolean hasMinSize = value.length() >= minSize;
		boolean hasMaxSize = value.length() <= maxSize;

		if (!hasMinSize)
			validationErrorMessage = String.format("the name must be at least %d characters.", minSize);
		if (!hasMaxSize)
			validationErrorMessage = String.format("the name should be no longer than %d characters.", maxSize);

		return !hasMinSize || !hasMaxSize;
	}

	@Override
	public int compareTo(Name o) {
		return value.compareTo(o.value);
	}

	@Override
	public String toString() {
		return value;
	}

}
