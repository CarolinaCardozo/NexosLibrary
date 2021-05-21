package com.credibanco.assessment.library.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.credibanco.assessment.library.dto.ErrorDTO;
import com.credibanco.assessment.library.error.ErrorEnum;

import lombok.extern.java.Log;

@Log
@RestControllerAdvice()
public class GlobalExceptionHandler {
	
	@ResponseBody
	@ExceptionHandler(value = CustomException.class)
	public ResponseEntity<ErrorDTO> handlerException(CustomException exception) {
		log.warning(String.format("Ocurrio un error controlado, codigo error: %s, descripcion error: %s",
				exception.getErrorEnum().code,
				String.format(exception.getErrorEnum().description, exception.getParamsError())));

		return new ResponseEntity<>(
				new ErrorDTO(exception.getErrorEnum().code,
						String.format(exception.getErrorEnum().description, exception.getParamsError())),
				exception.getHttpStatus());
	}
	@ResponseBody
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDTO> handlerException(MethodArgumentNotValidException exception) {
		log.info("Ocurrio un error por data ingresada no valida :" + exception.getLocalizedMessage());

		return new ResponseEntity<>(
				new ErrorDTO(ErrorEnum.INPUT_REQUEST_VALIDATION.code,
						String.format(ErrorEnum.INPUT_REQUEST_VALIDATION.description,
								exception.getBindingResult().getAllErrors().get(0).getDefaultMessage())),
				HttpStatus.BAD_REQUEST);

	}
	
	@ResponseBody
	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<ErrorDTO> handlerException(NotFoundException exception) {
		log.warning(String.format(
				"Ocurrio un error controlado, recurso no encontrado, codigo error: %s, descripcion error: %s",
				exception.getErrorEnum().code, exception.getErrorEnum().description));
		return new ResponseEntity<>(new ErrorDTO(exception.getErrorEnum().code, String
				.format(exception.getErrorEnum().description, exception.getResourceName(), exception.getParams())),
				exception.getHttpStatus());

	}
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorDTO> handlerException(Exception exception) {
		log.info("Ocurrio un error  general: " + exception.getLocalizedMessage());
		return new ResponseEntity<>(
				new ErrorDTO(ErrorEnum.DEFAULT_EXCEPTION.code, ErrorEnum.DEFAULT_EXCEPTION.description),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	



}
