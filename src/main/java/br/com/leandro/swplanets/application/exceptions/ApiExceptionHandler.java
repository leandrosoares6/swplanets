package br.com.leandro.swplanets.application.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.leandro.swplanets.domain.exceptions.DomainException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(DomainException.class)
	public ResponseEntity<Object> HandleDomainException(DomainException error, WebRequest request) {
		var status = HttpStatus.BAD_REQUEST;

		var appException = new AppException();
		appException.setStatus(status.value());
		appException.setTitle(error.getMessage());
		appException.setDateTime(LocalDateTime.now());

		return handleExceptionInternal(error, appException, new HttpHeaders(), status, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		var fields = new ArrayList<AppException.Field>();

		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String name = ((FieldError) error).getField();
			String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());

			fields.add(new AppException.Field(name, message));
		}

		var appException = new AppException();
		appException.setStatus(status.value());
		appException.setTitle("One or more fields are invalid");
		appException.setDateTime(LocalDateTime.now());
		appException.setFields(fields);

		return super.handleExceptionInternal(ex, appException, headers, status, request);
	}

}
