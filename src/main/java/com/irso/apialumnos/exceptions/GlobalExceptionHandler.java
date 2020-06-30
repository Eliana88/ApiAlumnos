package com.irso.apialumnos.exceptions;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	private Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	private String error500 = "Ha ocurrido un error inesperado.";

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ResourceNotFoundException.class,
		org.springframework.security.core.userdetails.UsernameNotFoundException.class})
	@ResponseBody
	public ErrorDetails notFound(HttpServletRequest request, Exception exception) {
		return new ErrorDetails(new Date(), exception.getMessage(), request.getRequestURI());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ BadRequestException.class, ValidationException.class,
			org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class, 
			org.springframework.web.bind.MethodArgumentNotValidException.class,
			org.springframework.dao.DuplicateKeyException.class,
			org.springframework.web.bind.MissingRequestHeaderException.class,
			org.springframework.web.bind.MissingServletRequestParameterException.class,
			org.springframework.http.converter.HttpMessageNotReadableException.class})
	@ResponseBody
	public ErrorDetails badRequest(HttpServletRequest request, Exception exception) {		 
		return new ErrorDetails(new Date(), exception.getMessage(), request.getRequestURI());
	}

	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler({ org.springframework.web.HttpRequestMethodNotSupportedException.class})
	@ResponseBody
	public ErrorDetails methodNotAllowed(HttpServletRequest request, Exception exception) {
		return new ErrorDetails(new Date(), exception.getMessage(), request.getRequestURI());
	}

	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(ConflictException.class)
	@ResponseBody
	public ErrorDetails conflict(HttpServletRequest request, Exception exception) {
		return new ErrorDetails(new Date(), exception.getMessage(), request.getRequestURI());
	}
	
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler(ForbiddenException.class)
	@ResponseBody
	public ErrorDetails forbidden(HttpServletRequest request, Exception exception) {
		return new ErrorDetails(new Date(), exception.getMessage(), request.getRequestURI());
	}
	
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler({UnauthorizedException.class,
                       AccessDeniedException.class})
	public void unauthorized() {
        //empty. Nothing to do
    }
	

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ErrorDetails internalError(HttpServletRequest request, Exception exception) {
		log.error("Error: " + exception.getMessage());
		return new ErrorDetails(new Date(), error500, request.getRequestURI());
		
	}

}
