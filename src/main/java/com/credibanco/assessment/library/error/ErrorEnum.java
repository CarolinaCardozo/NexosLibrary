package com.credibanco.assessment.library.error;

public enum ErrorEnum {

	DEFAULT_EXCEPTION(1, "Ocurrio un error interno, por favor inténtelo más tarde o comuníquese con soporte técnico"),
	INPUT_REQUEST_VALIDATION(2, "El json ingresado no contiene los campos mínimos para realizar la operación, error: %s "),
	AUTHOR_NOT_FOUND(3, "El autor no está registrado"),
	EDITORIAL_NOT_FOUND(4, "La editorial no está registrada"),
	MAXIMUM_ALLOWED(5, "No es posible registrar el libro, se alcanzó el máximo permitido"),
	

	;

	public final int code;
	public final String description;

	private ErrorEnum(int code, String description) {
		this.code = code;
		this.description = description;
	}

}
