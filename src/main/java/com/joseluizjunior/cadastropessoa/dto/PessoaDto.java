package com.joseluizjunior.cadastropessoa.dto;

import com.joseluizjunior.cadastropessoa.model.Pessoa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@NoArgsConstructor
public class PessoaDto {
    private Long id;

    @NotNull(message = "Nome é obrigatório")
    private String nome;

    @Email(message = "Formato do email é inválido")
    private String email;

    @PastOrPresent(message = "Data de nascimento inválida")
    @NotNull(message = "Data de nascimento é obrigatória")
    private LocalDate dataNascimento;

    private MunicipioDto naturalidade;

    private PaisDto nacionalidade;

    @CPF(message = "CPF inválido")
    private String cpf;

    private LocalDateTime createdIn = LocalDateTime.now();

    private LocalDateTime updatedIn;

    public PessoaDto(Pessoa pessoa) {
        if (Objects.isNull(pessoa)) {
            return;
        }
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.email = pessoa.getEmail();
        this.dataNascimento = pessoa.getDataNascimento();
        this.naturalidade = pessoa.getNaturalidade() != null ? new MunicipioDto(pessoa.getNaturalidade()) : null;
        this.nacionalidade = pessoa.getNacionalidade() != null ? new PaisDto(pessoa.getNacionalidade()) : null;
        this.cpf = pessoa.getCpf();
        this.createdIn = pessoa.getCreatedIn();
        this.updatedIn = pessoa.getUpdatedIn();
    }

    public static Pessoa dtoToEntity(PessoaDto dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        return Pessoa.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .dataNascimento(dto.getDataNascimento())
                .email(dto.getEmail())
                .nacionalidade(Objects.isNull(dto.getNacionalidade()) ? null : PaisDto.dtoToEntity(dto.getNacionalidade()))
                .naturalidade(Objects.isNull(dto.getNaturalidade()) ? null : MunicipioDto.dtoToEntity(dto.getNaturalidade()))
                .build();
    }
}
