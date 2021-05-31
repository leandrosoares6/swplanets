package br.com.leandro.swplanets.domain.exceptions;

public class EntityExistsException extends DomainException {

	private static final long serialVersionUID = 1L;

	public EntityExistsException(String message) {
		super(message);
	}

}
