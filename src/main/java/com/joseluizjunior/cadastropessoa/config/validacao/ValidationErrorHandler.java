package com.joseluizjunior.cadastropessoa.config.validacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ValidationErrorHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorValidationDto> handle(MethodArgumentNotValidException exception) {
        List<ErrorValidationDto> dto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(error -> {
            String msg = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            ErrorValidationDto erro = new ErrorValidationDto(error.getField(), msg);
            dto.add(erro);
        });
        return dto;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public List<ErrorValidationDto> handle(DataIntegrityViolationException exception) {
        List<ErrorValidationDto> dto = new ArrayList<>();
        ErrorValidationDto erro = new ErrorValidationDto(null, exception.getMostSpecificCause().getMessage());
        dto.add(erro);
        return dto;
    }
}
