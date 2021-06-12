package com.joseluizjunior.cadastropessoa.config.validacao;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorValidationDto {
    private String campo;
    private String erro;
}
